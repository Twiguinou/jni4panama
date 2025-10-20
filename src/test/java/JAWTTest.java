import module java.base;

import fr.kenlek.j4p.JNIEnv;
import fr.kenlek.j4p.JavaNativeInterface;
import fr.kenlek.j4p.Reference;
import fr.kenlek.j4p.awt.AWTNativeInterface;
import fr.kenlek.j4p.awt.JAWT;
import fr.kenlek.j4p.awt.JAWTDrawingSurface;
import java.awt.Canvas;

import static fr.kenlek.j4p.JavaNativeInterface.*;
import static fr.kenlek.j4p.awt.AWTNativeInterface.*;

public final class JAWTTest
{private JAWTTest() {}

    static void main() throws IOException
    {
        try (Arena arena = Arena.ofConfined())
        {
            SymbolLookup j4pLookup = j4pLookup(arena);
            JavaNativeInterface jni = JavaNativeInterface.load(jvmLookup(arena), j4pLookup);
            AWTNativeInterface awt = AWTNativeInterface.load(jawtLookup(arena), j4pLookup);

            JNIEnv env = jni.getCurrentJNIEnv(JNI_VERSION_1_1);
            JAWT jawt = new JAWT(arena);
            jawt.version(JAWT_VERSION_1_3);
            if (!awt.GetAWT(env, jawt))
            {
                throw new RuntimeException("Unable to get JAWT structure.");
            }

            Canvas canvas = new Canvas();
            try (Reference canvasRef = jni.getNativeObject(env, canvas))
            {
                JAWTDrawingSurface ds = awt.GetDrawingSurface(jawt, env, canvasRef.value);
                System.out.println(ds.env() + "   " + env);
            }
        }
    }
}
