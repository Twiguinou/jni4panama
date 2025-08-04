package fr.kenlek.j4p.awt;

import fr.kenlek.jpgen.api.Addressable;
import fr.kenlek.jpgen.api.dynload.Layout;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;

import static java.lang.foreign.ValueLayout.*;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;

public record JAWT(MemorySegment pointer) implements Addressable
{
    @Layout.Value("LAYOUT")
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
    public static final long MEMBER_OFFSET__version = LAYOUT.byteOffset(PathElement.groupElement("version"));
    public static final long MEMBER_OFFSET__GetDrawingSurface = LAYOUT.byteOffset(PathElement.groupElement("GetDrawingSurface"));
    public static final long MEMBER_OFFSET__FreeDrawingSurface = LAYOUT.byteOffset(PathElement.groupElement("FreeDrawingSurface"));
    public static final long MEMBER_OFFSET__Lock = LAYOUT.byteOffset(PathElement.groupElement("Lock"));
    public static final long MEMBER_OFFSET__Unlock = LAYOUT.byteOffset(PathElement.groupElement("Unlock"));
    public static final long MEMBER_OFFSET__GetComponent = LAYOUT.byteOffset(PathElement.groupElement("GetComponent"));
    public static final long MEMBER_OFFSET__CreateEmbeddedFrame = LAYOUT.byteOffset(PathElement.groupElement("CreateEmbeddedFrame"));
    public static final long MEMBER_OFFSET__SetBounds = LAYOUT.byteOffset(PathElement.groupElement("SetBounds"));
    public static final long MEMBER_OFFSET__SynthesizeWindowActivation = LAYOUT.byteOffset(PathElement.groupElement("SynthesizeWindowActivation"));

    public JAWT(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static JAWT getAtIndex(MemorySegment buffer, long index)
    {
        return new JAWT(buffer.asSlice(index * LAYOUT.byteSize(), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long index, JAWT value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, index * LAYOUT.byteSize(), LAYOUT.byteSize());
    }

    public void copyFrom(JAWT value)
    {
        MemorySegment.copy(value.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public int version()
    {
        return this.pointer().get(JAVA_INT, MEMBER_OFFSET__version);
    }

    public void version(int value)
    {
        this.pointer().set(JAVA_INT, MEMBER_OFFSET__version, value);
    }

    public MemorySegment $version()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__version, JAVA_INT);
    }

    public MemorySegment GetDrawingSurface()
    {
        return this.pointer().get(ADDRESS, MEMBER_OFFSET__GetDrawingSurface);
    }

    public void GetDrawingSurface(MemorySegment value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__GetDrawingSurface, value);
    }

    public MemorySegment $GetDrawingSurface()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__GetDrawingSurface, ADDRESS);
    }

    public MemorySegment FreeDrawingSurface()
    {
        return this.pointer().get(ADDRESS, MEMBER_OFFSET__FreeDrawingSurface);
    }

    public void FreeDrawingSurface(MemorySegment value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__FreeDrawingSurface, value);
    }

    public MemorySegment $FreeDrawingSurface()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__FreeDrawingSurface, ADDRESS);
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

    public MemorySegment GetComponent()
    {
        return this.pointer().get(ADDRESS, MEMBER_OFFSET__GetComponent);
    }

    public void GetComponent(MemorySegment value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__GetComponent, value);
    }

    public MemorySegment $GetComponent()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__GetComponent, ADDRESS);
    }

    public MemorySegment CreateEmbeddedFrame()
    {
        return this.pointer().get(ADDRESS, MEMBER_OFFSET__CreateEmbeddedFrame);
    }

    public void CreateEmbeddedFrame(MemorySegment value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__CreateEmbeddedFrame, value);
    }

    public MemorySegment $CreateEmbeddedFrame()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__CreateEmbeddedFrame, ADDRESS);
    }

    public MemorySegment SetBounds()
    {
        return this.pointer().get(ADDRESS, MEMBER_OFFSET__SetBounds);
    }

    public void SetBounds(MemorySegment value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__SetBounds, value);
    }

    public MemorySegment $SetBounds()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__SetBounds, ADDRESS);
    }

    public MemorySegment SynthesizeWindowActivation()
    {
        return this.pointer().get(ADDRESS, MEMBER_OFFSET__SynthesizeWindowActivation);
    }

    public void SynthesizeWindowActivation(MemorySegment value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__SynthesizeWindowActivation, value);
    }

    public MemorySegment $SynthesizeWindowActivation()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__SynthesizeWindowActivation, ADDRESS);
    }
}
