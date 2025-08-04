package fr.kenlek.j4p.awt;

import fr.kenlek.j4p.JNIEnv;
import fr.kenlek.jpgen.api.dynload.DowncallTransformer;
import fr.kenlek.jpgen.api.dynload.Ignore;
import fr.kenlek.jpgen.api.dynload.Layout;
import fr.kenlek.jpgen.api.dynload.LinkingDowncallDispatcher;
import fr.kenlek.jpgen.api.dynload.NativeProxies;
import fr.kenlek.jpgen.api.dynload.Redirect;
import fr.kenlek.jpgen.api.dynload.Unbound;

import java.lang.foreign.Arena;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandles;
import java.nio.file.Path;

import static fr.kenlek.jpgen.api.ForeignUtils.SYSTEM_LINKER;
import static fr.kenlek.jpgen.api.dynload.DowncallTransformer.PUBLIC_GROUP_TRANSFORMER;
import static java.lang.foreign.SymbolLookup.libraryLookup;
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
    int JAWT_LOCK_ERROR = 0x00000001;
    int JAWT_LOCK_CLIP_CHANGED = 0x00000002;
    int JAWT_LOCK_BOUNDS_CHANGED = 0x00000004;
    int JAWT_LOCK_SURFACE_CHANGED = 0x00000008;

    int JAWT_VERSION_1_3 = 0x00010003;
    int JAWT_VERSION_1_4 = 0x00010004;
    int JAWT_VERSION_1_7 = 0x00010007;
    int JAWT_VERSION_9 = 0x00090000;

    static AWTNativeInterface load(SymbolLookup lookup, Linker linker)
    {
        return NativeProxies.instantiate(AWTNativeInterface.class, new LinkingDowncallDispatcher(lookup, linker).compose(
            makeCallArranger(JAWTDrawingSurface.class).and(makeCallArranger(JAWT.class)).and(makeCallArranger(JAWTX11DrawingSurfaceInfo.class)).and(PUBLIC_GROUP_TRANSFORMER)
        ));
    }

    static AWTNativeInterface load(Arena arena)
    {
        String javaHome = requireNonNull(System.getProperty("java.home"), "Unable to resolve java.home system property.");
        Path libraryPath = Path.of(javaHome).resolve("lib", System.mapLibraryName("jawt"));
        return load(libraryLookup(libraryPath, arena), SYSTEM_LINKER);
    }

    private static DowncallTransformer makeCallArranger(Class<?> handleType)
    {
        return DowncallTransformer.matching(
            method -> method.isAnnotationPresent(Unbound.class) && method.getParameterCount() > 0 && method.getParameterTypes()[0].equals(handleType),
            (method, handle) ->
            {
                try
                {
                    MethodHandles.Lookup lookup = MethodHandles.publicLookup();
                    handle = MethodHandles.filterArguments(handle, 0, lookup.findVirtual(handleType, method.getName(), methodType(MemorySegment.class)));
                    if (!method.getParameters()[0].isAnnotationPresent(Ignore.class))
                    {
                        handle = MethodHandles.filterArguments(handle, 1, NativeProxies.findGroupUnwrapper(lookup, handleType));
                        handle = MethodHandles.foldArguments(handle, MethodHandles.identity(handleType));
                    }

                    return handle;
                }
                catch (NoSuchMethodException | IllegalAccessException e)
                {
                    throw new RuntimeException(e);
                }
            }
        );
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

    @Unbound
    MemorySegment GetComponent(@Ignore JAWT awt, JNIEnv env, MemorySegment platformInfo);

    @Unbound
    MemorySegment CreateEmbeddedFrame(@Ignore JAWT awt, JNIEnv env, MemorySegment platformInfo);

    @Unbound
    void SetBounds(@Ignore JAWT awt, JNIEnv env, MemorySegment embeddedFrame, int x, int y, int w, int h);

    @Unbound
    void SynthesizeWindowActivation(@Ignore JAWT awt, JNIEnv env, MemorySegment embeddedFrame, boolean doActivate);

    @Unbound
    int GetAWTColor(@Ignore JAWTX11DrawingSurfaceInfo dsi, JAWTDrawingSurface ds, int r, int g, int b);
}
