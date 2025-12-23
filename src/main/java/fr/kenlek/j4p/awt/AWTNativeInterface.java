package fr.kenlek.j4p.awt;

import module fr.kenlek.jpgen.api;
import module java.base;

import fr.kenlek.j4p.JNIEnv;
import fr.kenlek.j4p.JavaNativeInterface;
import fr.kenlek.j4p.Reference;

import static fr.kenlek.jpgen.api.dynload.DowncallTransformer.PUBLIC_GROUP_TRANSFORMER;
import static java.lang.foreign.SymbolLookup.libraryLookup;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.methodType;
import static java.util.Objects.requireNonNull;

@Layout.Generic({
    @Layout.Case(target = JNIEnv.class, layout = @Layout(value = "LAYOUT", container = JNIEnv.class, referenced = true)),
    @Layout.Case(target = JAWT.class, layout = @Layout(value = "LAYOUT", container = JAWT.class, referenced = true)),
    @Layout.Case(target = JAWTDrawingSurface.class, layout = @Layout(value = "LAYOUT", container = JAWTDrawingSurface.class, referenced = true)),
    @Layout.Case(target = JAWTDrawingSurfaceInfo.class, layout = @Layout(value = "LAYOUT", container = JAWTDrawingSurfaceInfo.class, referenced = true)),
    @Layout.Case(target = JAWTX11DrawingSurfaceInfo.class, layout = @Layout(value = "LAYOUT", container = JAWTX11DrawingSurfaceInfo.class, referenced = true))
})
public interface AWTNativeInterface
{
    DowncallTransformer DOWNCALL_TRANSFORMER = makeCallArranger(JAWTDrawingSurface.class)
        .and(makeCallArranger(JAWT.class))
        .and(makeCallArranger(JAWTX11DrawingSurfaceInfo.class))
        .and(PUBLIC_GROUP_TRANSFORMER);

    int JAWT_LOCK_ERROR = 0x00000001;
    int JAWT_LOCK_CLIP_CHANGED = 0x00000002;
    int JAWT_LOCK_BOUNDS_CHANGED = 0x00000004;
    int JAWT_LOCK_SURFACE_CHANGED = 0x00000008;

    int JAWT_VERSION_1_3 = 0x00010003;
    int JAWT_VERSION_1_4 = 0x00010004;
    int JAWT_VERSION_1_7 = 0x00010007;
    int JAWT_VERSION_9 = 0x00090000;

    int JAWT_MACOSX_USE_CALAYER = 0x80000000;

    static SymbolLookup jawtLookup(Arena arena)
    {
        String javaHome = requireNonNull(System.getProperty("java.home"), "Unable to resolve java.home system property.");
        return libraryLookup(Path.of(javaHome).resolve("lib", System.mapLibraryName("jawt")), arena);
    }

    static AWTNativeInterface load(SymbolLookup lookup)
    {
        return NativeProxies.make(AWTNativeInterface.class, new LinkingDowncallDispatcher(lookup).and(DOWNCALL_TRANSFORMER));
    }

    static AWTNativeInterface load(SymbolLookup jawtLookup, SymbolLookup j4pLookup)
    {
        return load(jawtLookup.or(j4pLookup));
    }

    private static DowncallTransformer makeCallArranger(Class<?> handleType)
    {
        return DowncallTransformer.filter((method, handle) ->
        {
            MethodHandles.Lookup lookup = publicLookup();
            MethodType MT_MemorySegment = methodType(MemorySegment.class);

            try
            {
                handle = filterArguments(handle, 0, lookup.findVirtual(handleType, method.getName(), MT_MemorySegment));
                if (!method.getParameters()[0].isAnnotationPresent(Ignore.class))
                {
                    handle = filterArguments(handle, 1, lookup.findVirtual(handleType, "pointer", MT_MemorySegment));
                    handle = foldArguments(handle, MethodHandles.identity(handleType));
                }

                return handle;
            }
            catch (NoSuchMethodException | IllegalAccessException e)
            {
                throw new RuntimeException(e);
            }
        }, method -> method.isAnnotationPresent(Unbound.class) && method.getParameterCount() > 0 && method.getParameterTypes()[0].equals(handleType));
    }

    @Redirect("JAWT_GetAWT")
    boolean GetAWT(JNIEnv env, JAWT awt);

    @Unbound
    int Lock(JAWTDrawingSurface ds);

    @Unbound
    JAWTDrawingSurfaceInfo GetDrawingSurfaceInfo(JAWTDrawingSurface ds);

    @Unbound
    void FreeDrawingSurfaceInfo(@Ignore JAWTDrawingSurface ds, JAWTDrawingSurfaceInfo dsi);

    @Unbound
    void Unlock(JAWTDrawingSurface ds);

    @Unbound
    JAWTDrawingSurface GetDrawingSurface(@Ignore JAWT awt, JNIEnv env, MemorySegment target);

    @Unbound
    void FreeDrawingSurface(@Ignore JAWT awt, JAWTDrawingSurface ds);

    @Unbound
    void Lock(@Ignore JAWT awt, JNIEnv env);

    @Unbound
    void Unlock(@Ignore JAWT awt, JNIEnv env);

    @Redirect("j4p_awt_GetComponent")
    MemorySegment _GetComponent(JAWT awt, JNIEnv env, MemorySegment platformInfo);

    default Reference GetComponent(JavaNativeInterface jni, JAWT awt, JNIEnv env, MemorySegment platformInfo)
    {
        return jni.reference(env, this._GetComponent(awt, env, platformInfo));
    }

    @Redirect("j4p_awt_CreateEmbeddedFrame")
    MemorySegment _CreateEmbeddedFrame(JAWT awt, JNIEnv env, MemorySegment platformInfo);

    default Reference CreateEmbeddedFrame(JavaNativeInterface jni, JAWT awt, JNIEnv env, MemorySegment platformInfo)
    {
        return jni.reference(env, this._CreateEmbeddedFrame(awt, env, platformInfo));
    }

    @Unbound
    void SetBounds(@Ignore JAWT awt, JNIEnv env, MemorySegment embeddedFrame, int x, int y, int w, int h);

    @Unbound
    void SynthesizeWindowActivation(@Ignore JAWT awt, JNIEnv env, MemorySegment embeddedFrame, boolean doActivate);

    @Unbound
    int GetAWTColor(@Ignore JAWTX11DrawingSurfaceInfo dsi, JAWTDrawingSurface ds, int r, int g, int b);
}
