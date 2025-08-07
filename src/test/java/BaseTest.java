import fr.kenlek.j4p.JNIEnv;
import fr.kenlek.j4p.JValue;
import fr.kenlek.j4p.JavaNativeInterface;
import fr.kenlek.j4p.Reference;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.foreign.Arena;

import static fr.kenlek.j4p.JavaNativeInterface.*;
import static java.lang.invoke.MethodType.methodType;

public final class BaseTest
{private BaseTest() {}

    public static void main(String... args) throws IOException
    {
        try (Arena arena = Arena.ofConfined())
        {
            JavaNativeInterface jni = JavaNativeInterface.load(jvmLookup(arena), j4pLookup(arena));

            JNIEnv env = jni.getCurrentJNIEnv(JNI_VERSION_1_1);
            System.out.println("Found JNIEnv: " + env);
            System.out.println("Environment function table: " + env.functions());
            System.out.println("JNIEnv->GetVersion() = " + Integer.toHexString(jni.GetVersion(env)));

            System.out.println();
            try (
                Reference systemClass = jni.findClass(env, System.class);
                Reference printStreamClass = jni.findClass(env, PrintStream.class);
                Reference out = jni.GetStaticObjectField(env, systemClass.value, jni.getStaticFieldID(env, systemClass.value, "out", PrintStream.class));
                Reference text = jni.NewStringUTF(env, arena.allocateFrom("Hello world!"))
            )
            {
                JValue arg = new JValue(arena);
                arg.l(text.value);
                jni.CallVoidMethodA(env, out.value, jni.getMethodID(env, printStreamClass.value, "println", methodType(void.class, String.class)), arg.pointer());
            }
        }
    }
}
