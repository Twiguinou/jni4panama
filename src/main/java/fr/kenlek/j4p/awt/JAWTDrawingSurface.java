package fr.kenlek.j4p.awt;

import fr.kenlek.j4p.JNIEnv;
import fr.kenlek.jpgen.api.Addressable;
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
    public static final long MEMBER_OFFSET__env = LAYOUT.byteOffset(PathElement.groupElement("env"));
    public static final long MEMBER_OFFSET__target = LAYOUT.byteOffset(PathElement.groupElement("target"));
    public static final long MEMBER_OFFSET__Lock = LAYOUT.byteOffset(PathElement.groupElement("Lock"));
    public static final long MEMBER_OFFSET__GetDrawingSurfaceInfo = LAYOUT.byteOffset(PathElement.groupElement("GetDrawingSurfaceInfo"));
    public static final long MEMBER_OFFSET__FreeDrawingSurfaceInfo = LAYOUT.byteOffset(PathElement.groupElement("FreeDrawingSurfaceInfo"));
    public static final long MEMBER_OFFSET__Unlock = LAYOUT.byteOffset(PathElement.groupElement("Unlock"));

    public JAWTDrawingSurface(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
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
        return new JNIEnv(this.pointer().get(ADDRESS, MEMBER_OFFSET__env).reinterpret(JNIEnv.LAYOUT.byteSize()));
    }

    public void env(JNIEnv value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__env, value.pointer());
    }

    public MemorySegment $env()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__env, ADDRESS);
    }

    public MemorySegment target()
    {
        return this.pointer().get(ADDRESS, MEMBER_OFFSET__target);
    }

    public void target(MemorySegment value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__target, value);
    }

    public MemorySegment $target()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__target, ADDRESS);
    }

    public MemorySegment Lock()
    {
        return this.pointer().get(ADDRESS, MEMBER_OFFSET__Lock);
    }

    public void Lock(MemorySegment value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__Lock, value);
    }

    public MemorySegment $Lock()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__Lock, ADDRESS);
    }

    public MemorySegment GetDrawingSurfaceInfo()
    {
        return this.pointer().get(ADDRESS, MEMBER_OFFSET__GetDrawingSurfaceInfo);
    }

    public void GetDrawingSurfaceInfo(MemorySegment value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__GetDrawingSurfaceInfo, value);
    }

    public MemorySegment $GetDrawingSurfaceInfo()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__GetDrawingSurfaceInfo, ADDRESS);
    }

    public MemorySegment FreeDrawingSurfaceInfo()
    {
        return this.pointer().get(ADDRESS, MEMBER_OFFSET__FreeDrawingSurfaceInfo);
    }

    public void FreeDrawingSurfaceInfo(MemorySegment value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__FreeDrawingSurfaceInfo, value);
    }

    public MemorySegment $FreeDrawingSurfaceInfo()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__FreeDrawingSurfaceInfo, ADDRESS);
    }

    public MemorySegment Unlock()
    {
        return this.pointer().get(ADDRESS, MEMBER_OFFSET__Unlock);
    }

    public void Unlock(MemorySegment value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__Unlock, value);
    }

    public MemorySegment $Unlock()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__Unlock, ADDRESS);
    }
}
