import fr.kenlek.j4p.JNIEnv;
import fr.kenlek.j4p.JavaNativeInterface;
import fr.kenlek.j4p.Reference;

import java.awt.Canvas;
import java.lang.foreign.Arena;

import static java.lang.foreign.MemorySegment.NULL;

import static fr.kenlek.j4p.JavaNativeInterface.JNI_VERSION_1_1;
import static java.lang.invoke.MethodType.methodType;

public final class StaticCallTest
{private StaticCallTest() {}

    public static void main(String... args)
    {
        JavaNativeInterface jni = JavaNativeInterface.load(Arena.ofAuto());

        JNIEnv env = jni.getCurrentJNIEnv(JNI_VERSION_1_1);
        System.out.println("Found JNIEnv: " + env);
        System.out.println("Environment function table: " + env.functions());
        System.out.println("JNIEnv->GetVersion() = " + Integer.toHexString(jni.GetVersion(env)));

        System.out.println();
        try (
            Reference canvasClass = jni.findClass(env, Canvas.class);
            Reference canvas = jni.globalReference(env, jni.NewObjectA(env, canvasClass.value, jni.getMethodID(env, canvasClass.value, "<init>", methodType(void.class)), NULL))
        )
        {
            System.out.println(canvas.value);
        }
    }
}
