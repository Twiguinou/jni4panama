package fr.kenlek.j4p.awt;

import module fr.kenlek.jpgen.api;
import module java.base;

import fr.kenlek.jpgen.api.Buffer;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;
import static java.lang.foreign.ValueLayout.*;

@Layout.Container("LAYOUT")
public record JAWT(MemorySegment pointer) implements Addressable
{
    public static final StructLayout LAYOUT = makeStructLayout(
        JAVA_INT.withName("version"),
        ADDRESS.withName("GetDrawingSurface"),
        ADDRESS.withName("FreeDrawingSurface"),
        ADDRESS.withName("Lock"),
        ADDRESS.withName("Unlock"),
        ADDRESS.withName("GetComponent"),
        ADDRESS.withName("CreateEmbeddedFrame"),
        ADDRESS.withName("SetBounds"),
        ADDRESS.withName("SynthesizeWindowActivation")
    ).withName("JAWT");
    public static final long OFFSET_version = LAYOUT.byteOffset(PathElement.groupElement("version"));
    public static final long OFFSET_GetDrawingSurface = LAYOUT.byteOffset(PathElement.groupElement("GetDrawingSurface"));
    public static final long OFFSET_FreeDrawingSurface = LAYOUT.byteOffset(PathElement.groupElement("FreeDrawingSurface"));
    public static final long OFFSET_Lock = LAYOUT.byteOffset(PathElement.groupElement("Lock"));
    public static final long OFFSET_Unlock = LAYOUT.byteOffset(PathElement.groupElement("Unlock"));
    public static final long OFFSET_GetComponent = LAYOUT.byteOffset(PathElement.groupElement("GetComponent"));
    public static final long OFFSET_CreateEmbeddedFrame = LAYOUT.byteOffset(PathElement.groupElement("CreateEmbeddedFrame"));
    public static final long OFFSET_SetBounds = LAYOUT.byteOffset(PathElement.groupElement("SetBounds"));
    public static final long OFFSET_SynthesizeWindowActivation = LAYOUT.byteOffset(PathElement.groupElement("SynthesizeWindowActivation"));

    public JAWT
    {
        Addressable.checkLayoutConstraints(pointer, LAYOUT);
    }

    public JAWT(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JAWT> buffer(MemorySegment data)
    {
        return Buffer.slices(data, LAYOUT, JAWT::new);
    }

    public static Buffer<JAWT> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocateSlices(allocator, LAYOUT, size, JAWT::new);
    }

    public static JAWT getAtIndex(MemorySegment buffer, long offset, long index)
    {
        return new JAWT(buffer.asSlice(LAYOUT.scale(offset, index), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long offset, long index, JAWT value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, LAYOUT.scale(offset, index), LAYOUT.byteSize());
    }

    public void copyFrom(JAWT other)
    {
        MemorySegment.copy(other.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public int version()
    {
        return this.pointer().get(JAVA_INT, OFFSET_version);
    }

    public void version(int value)
    {
        this.pointer().set(JAVA_INT, OFFSET_version, value);
    }

    public MemorySegment $version()
    {
        return this.pointer().asSlice(OFFSET_version, JAVA_INT);
    }

    public MemorySegment GetDrawingSurface()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetDrawingSurface);
    }

    public void GetDrawingSurface(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetDrawingSurface, value);
    }

    public MemorySegment $GetDrawingSurface()
    {
        return this.pointer().asSlice(OFFSET_GetDrawingSurface, ADDRESS);
    }

    public MemorySegment FreeDrawingSurface()
    {
        return this.pointer().get(ADDRESS, OFFSET_FreeDrawingSurface);
    }

    public void FreeDrawingSurface(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_FreeDrawingSurface, value);
    }

    public MemorySegment $FreeDrawingSurface()
    {
        return this.pointer().asSlice(OFFSET_FreeDrawingSurface, ADDRESS);
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

    public MemorySegment GetComponent()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetComponent);
    }

    public void GetComponent(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetComponent, value);
    }

    public MemorySegment $GetComponent()
    {
        return this.pointer().asSlice(OFFSET_GetComponent, ADDRESS);
    }

    public MemorySegment CreateEmbeddedFrame()
    {
        return this.pointer().get(ADDRESS, OFFSET_CreateEmbeddedFrame);
    }

    public void CreateEmbeddedFrame(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CreateEmbeddedFrame, value);
    }

    public MemorySegment $CreateEmbeddedFrame()
    {
        return this.pointer().asSlice(OFFSET_CreateEmbeddedFrame, ADDRESS);
    }

    public MemorySegment SetBounds()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetBounds);
    }

    public void SetBounds(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetBounds, value);
    }

    public MemorySegment $SetBounds()
    {
        return this.pointer().asSlice(OFFSET_SetBounds, ADDRESS);
    }

    public MemorySegment SynthesizeWindowActivation()
    {
        return this.pointer().get(ADDRESS, OFFSET_SynthesizeWindowActivation);
    }

    public void SynthesizeWindowActivation(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SynthesizeWindowActivation, value);
    }

    public MemorySegment $SynthesizeWindowActivation()
    {
        return this.pointer().asSlice(OFFSET_SynthesizeWindowActivation, ADDRESS);
    }
}
