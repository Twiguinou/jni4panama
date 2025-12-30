import module java.base;

import fr.kenlek.j4p.*;

import static fr.kenlek.j4p.JavaNativeInterface.*;
import static java.lang.invoke.MethodType.methodType;

public final class BaseTest
{private BaseTest() {}

    static void main() throws IOException
    {
        try (Arena arena = Arena.ofConfined())
        {
            JavaNativeInterface jni = JavaNativeInterface.load(jvmLookup(arena), j4pLookup(arena));

            JNIEnv env = jni.getCurrentJNIEnv(JNI_VERSION_1_1);
            IO.println("Found JNIEnv: " + env);
            IO.println("Environment function table: " + env.functions());
            IO.println("JNIEnv->GetVersion() = " + Integer.toHexString(jni.GetVersion(env)));

            IO.println();
            try (
                Reference ioClass = jni.findClass(env, IO.class);
                Reference text = jni.NewStringUTF(env, arena.allocateFrom("Hello JNI world!"))
            )
            {
                JValue arg = new JValue(arena);
                arg.l(text.value);
                jni.CallStaticVoidMethodA(env, ioClass.value, jni.getStaticMethodID(env, ioClass.value, "println", methodType(void.class, Object.class)), arg.pointer());
            }
        }
    }
}
