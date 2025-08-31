package fr.kenlek.j4p.awt;

import fr.kenlek.j4p.JNIEnv;
import fr.kenlek.jpgen.api.Addressable;
import fr.kenlek.jpgen.api.Buffer;
import fr.kenlek.jpgen.api.dynload.Layout;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;

import static java.lang.foreign.ValueLayout.*;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;

public record JAWTDrawingSurface(MemorySegment pointer) implements Addressable
{
    @Layout.Value("LAYOUT")
    public static final StructLayout LAYOUT = makeStructLayout(
        ADDRESS.withName("env"),
        ADDRESS.withName("target"),
        ADDRESS.withName("Lock"),
        ADDRESS.withName("GetDrawingSurfaceInfo"),
        ADDRESS.withName("FreeDrawingSurfaceInfo"),
        ADDRESS.withName("Unlock")
    ).withName("JAWT_DrawingSurface");
    public static final long OFFSET__env = LAYOUT.byteOffset(PathElement.groupElement("env"));
    public static final long OFFSET__target = LAYOUT.byteOffset(PathElement.groupElement("target"));
    public static final long OFFSET__Lock = LAYOUT.byteOffset(PathElement.groupElement("Lock"));
    public static final long OFFSET__GetDrawingSurfaceInfo = LAYOUT.byteOffset(PathElement.groupElement("GetDrawingSurfaceInfo"));
    public static final long OFFSET__FreeDrawingSurfaceInfo = LAYOUT.byteOffset(PathElement.groupElement("FreeDrawingSurfaceInfo"));
    public static final long OFFSET__Unlock = LAYOUT.byteOffset(PathElement.groupElement("Unlock"));

    public JAWTDrawingSurface
    {
        if (pointer.maxByteAlignment() < LAYOUT.byteAlignment() || pointer.byteSize() != LAYOUT.byteSize())
        {
            throw new IllegalArgumentException("Memory slice does not follow layout constraints.");
        }
    }

    public JAWTDrawingSurface(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JAWTDrawingSurface> buffer(MemorySegment data)
    {
        return Buffer.of(data, LAYOUT, JAWTDrawingSurface::new);
    }

    public static Buffer<JAWTDrawingSurface> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocate(allocator, LAYOUT, size, JAWTDrawingSurface::new);
    }

    public static JAWTDrawingSurface getAtIndex(MemorySegment buffer, long index)
    {
        return new JAWTDrawingSurface(buffer.asSlice(index * LAYOUT.byteSize(), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long index, JAWTDrawingSurface value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, index * LAYOUT.byteSize(), LAYOUT.byteSize());
    }

    public void copyFrom(JAWTDrawingSurface value)
    {
        MemorySegment.copy(value.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public JNIEnv env()
    {
        return new JNIEnv(this.pointer().get(ADDRESS.withTargetLayout(JNIEnv.LAYOUT), OFFSET__env));
    }

    public void env(JNIEnv value)
    {
        this.pointer().set(ADDRESS, OFFSET__env, value.pointer());
    }

    public MemorySegment $env()
    {
        return this.pointer().asSlice(OFFSET__env, ADDRESS);
    }

    public MemorySegment target()
    {
        return this.pointer().get(ADDRESS, OFFSET__target);
    }

    public void target(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__target, value);
    }

    public MemorySegment $target()
    {
        return this.pointer().asSlice(OFFSET__target, ADDRESS);
    }

    public MemorySegment Lock()
    {
        return this.pointer().get(ADDRESS, OFFSET__Lock);
    }

    public void Lock(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__Lock, value);
    }

    public MemorySegment $Lock()
    {
        return this.pointer().asSlice(OFFSET__Lock, ADDRESS);
    }

    public MemorySegment GetDrawingSurfaceInfo()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetDrawingSurfaceInfo);
    }

    public void GetDrawingSurfaceInfo(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetDrawingSurfaceInfo, value);
    }

    public MemorySegment $GetDrawingSurfaceInfo()
    {
        return this.pointer().asSlice(OFFSET__GetDrawingSurfaceInfo, ADDRESS);
    }

    public MemorySegment FreeDrawingSurfaceInfo()
    {
        return this.pointer().get(ADDRESS, OFFSET__FreeDrawingSurfaceInfo);
    }

    public void FreeDrawingSurfaceInfo(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__FreeDrawingSurfaceInfo, value);
    }

    public MemorySegment $FreeDrawingSurfaceInfo()
    {
        return this.pointer().asSlice(OFFSET__FreeDrawingSurfaceInfo, ADDRESS);
    }

    public MemorySegment Unlock()
    {
        return this.pointer().get(ADDRESS, OFFSET__Unlock);
    }

    public void Unlock(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__Unlock, value);
    }

    public MemorySegment $Unlock()
    {
        return this.pointer().asSlice(OFFSET__Unlock, ADDRESS);
    }
}
