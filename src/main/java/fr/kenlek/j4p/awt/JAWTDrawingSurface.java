package fr.kenlek.j4p.awt;

import module fr.kenlek.jpgen.api;
import module java.base;

import fr.kenlek.j4p.JNIEnv;
import fr.kenlek.jpgen.api.data.Buffer;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;
import static java.lang.foreign.ValueLayout.*;

@Layout.Container("LAYOUT")
public record JAWTDrawingSurface(MemorySegment pointer) implements Addressable
{
    public static final StructLayout LAYOUT = makeStructLayout(
        ADDRESS.withName("env"),
        ADDRESS.withName("target"),
        ADDRESS.withName("Lock"),
        ADDRESS.withName("GetDrawingSurfaceInfo"),
        ADDRESS.withName("FreeDrawingSurfaceInfo"),
        ADDRESS.withName("Unlock")
    ).withName("JAWT_DrawingSurface");
    public static final long OFFSET_env = LAYOUT.byteOffset(PathElement.groupElement("env"));
    public static final long OFFSET_target = LAYOUT.byteOffset(PathElement.groupElement("target"));
    public static final long OFFSET_Lock = LAYOUT.byteOffset(PathElement.groupElement("Lock"));
    public static final long OFFSET_GetDrawingSurfaceInfo = LAYOUT.byteOffset(PathElement.groupElement("GetDrawingSurfaceInfo"));
    public static final long OFFSET_FreeDrawingSurfaceInfo = LAYOUT.byteOffset(PathElement.groupElement("FreeDrawingSurfaceInfo"));
    public static final long OFFSET_Unlock = LAYOUT.byteOffset(PathElement.groupElement("Unlock"));

    public JAWTDrawingSurface
    {
        Addressable.checkLayoutConstraints(pointer, LAYOUT);
    }

    public JAWTDrawingSurface(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JAWTDrawingSurface> buffer(MemorySegment data)
    {
        return Buffer.slices(data, LAYOUT, JAWTDrawingSurface::new);
    }

    public static Buffer<JAWTDrawingSurface> buffer(SegmentAllocator allocator, long size)
    {
        return Buffer.slices(allocator, LAYOUT, size, JAWTDrawingSurface::new);
    }

    @Override
    public StructLayout layout()
    {
        return LAYOUT;
    }

    public void copyFrom(JAWTDrawingSurface other)
    {
        MemorySegment.copy(other.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public JNIEnv env()
    {
        return new JNIEnv(this.pointer().get(ADDRESS.withTargetLayout(JNIEnv.LAYOUT), OFFSET_env));
    }

    public void env(JNIEnv value)
    {
        this.pointer().set(ADDRESS, OFFSET_env, value.pointer());
    }

    public MemorySegment $env()
    {
        return this.pointer().asSlice(OFFSET_env, ADDRESS);
    }

    public MemorySegment target()
    {
        return this.pointer().get(ADDRESS, OFFSET_target);
    }

    public void target(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_target, value);
    }

    public MemorySegment $target()
    {
        return this.pointer().asSlice(OFFSET_target, ADDRESS);
    }

    public MemorySegment Lock()
    {
        return this.pointer().get(ADDRESS, OFFSET_Lock);
    }

    public void Lock(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_Lock, value);
    }

    public MemorySegment $Lock()
    {
        return this.pointer().asSlice(OFFSET_Lock, ADDRESS);
    }

    public MemorySegment GetDrawingSurfaceInfo()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetDrawingSurfaceInfo);
    }

    public void GetDrawingSurfaceInfo(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetDrawingSurfaceInfo, value);
    }

    public MemorySegment $GetDrawingSurfaceInfo()
    {
        return this.pointer().asSlice(OFFSET_GetDrawingSurfaceInfo, ADDRESS);
    }

    public MemorySegment FreeDrawingSurfaceInfo()
    {
        return this.pointer().get(ADDRESS, OFFSET_FreeDrawingSurfaceInfo);
    }

    public void FreeDrawingSurfaceInfo(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_FreeDrawingSurfaceInfo, value);
    }

    public MemorySegment $FreeDrawingSurfaceInfo()
    {
        return this.pointer().asSlice(OFFSET_FreeDrawingSurfaceInfo, ADDRESS);
    }

    public MemorySegment Unlock()
    {
        return this.pointer().get(ADDRESS, OFFSET_Unlock);
    }

    public void Unlock(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_Unlock, value);
    }

    public MemorySegment $Unlock()
    {
        return this.pointer().asSlice(OFFSET_Unlock, ADDRESS);
    }
}
