package fr.kenlek.j4p.awt;

import module fr.kenlek.jpgen.api;
import module java.base;

import fr.kenlek.jpgen.api.Buffer;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;
import static java.lang.foreign.ValueLayout.*;

@Layout.Container("LAYOUT")
public record JAWTX11DrawingSurfaceInfo(MemorySegment pointer) implements Addressable
{
    public static final StructLayout LAYOUT = makeStructLayout(
        CUnsignedLong.LAYOUT.withName("drawable"),
        ADDRESS.withName("display"),
        CUnsignedLong.LAYOUT.withName("visualID"),
        CUnsignedLong.LAYOUT.withName("colormapID"),
        JAVA_INT.withName("depth"),
        ADDRESS.withName("GetAWTColor")
    ).withName("JAWT_X11DrawingSurfaceInfo");
    public static final long OFFSET_drawable = LAYOUT.byteOffset(PathElement.groupElement("drawable"));
    public static final long OFFSET_display = LAYOUT.byteOffset(PathElement.groupElement("display"));
    public static final long OFFSET_visualID = LAYOUT.byteOffset(PathElement.groupElement("visualID"));
    public static final long OFFSET_colormapID = LAYOUT.byteOffset(PathElement.groupElement("colormapID"));
    public static final long OFFSET_depth = LAYOUT.byteOffset(PathElement.groupElement("depth"));
    public static final long OFFSET_GetAWTColor = LAYOUT.byteOffset(PathElement.groupElement("GetAWTColor"));

    public JAWTX11DrawingSurfaceInfo
    {
        Addressable.checkLayoutConstraints(pointer, LAYOUT);
    }

    public JAWTX11DrawingSurfaceInfo(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JAWTX11DrawingSurfaceInfo> buffer(MemorySegment data)
    {
        return Buffer.slices(data, LAYOUT, JAWTX11DrawingSurfaceInfo::new);
    }

    public static Buffer<JAWTX11DrawingSurfaceInfo> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocateSlices(allocator, LAYOUT, size, JAWTX11DrawingSurfaceInfo::new);
    }

    public static JAWTX11DrawingSurfaceInfo getAtIndex(MemorySegment buffer, long offset, long index)
    {
        return new JAWTX11DrawingSurfaceInfo(buffer.asSlice(LAYOUT.scale(offset, index), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long offset, long index, JAWTX11DrawingSurfaceInfo value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, LAYOUT.scale(offset, index), LAYOUT.byteSize());
    }

    public void copyFrom(JAWTX11DrawingSurfaceInfo other)
    {
        MemorySegment.copy(other.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public MemorySegment $drawable()
    {
        return this.pointer().asSlice(OFFSET_drawable, CUnsignedLong.LAYOUT);
    }

    public CUnsignedLong drawable()
    {
        return CUnsignedLong.wrap(this.$drawable());
    }

    public void drawable(CUnsignedLong value)
    {
        value.unwrap(this.$drawable());
    }

    public MemorySegment display()
    {
        return this.pointer().get(ADDRESS, OFFSET_display);
    }

    public void display(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_display, value);
    }

    public MemorySegment $display()
    {
        return this.pointer().asSlice(OFFSET_display, ADDRESS);
    }

    public MemorySegment $visualID()
    {
        return this.pointer().asSlice(OFFSET_visualID, CUnsignedLong.LAYOUT);
    }

    public CUnsignedLong visualID()
    {
        return CUnsignedLong.wrap(this.$visualID());
    }

    public void visualID(CUnsignedLong value)
    {
        value.unwrap(this.$visualID());
    }

    public MemorySegment $colormapID()
    {
        return this.pointer().asSlice(OFFSET_colormapID, CUnsignedLong.LAYOUT);
    }

    public CUnsignedLong colormapID()
    {
        return CUnsignedLong.wrap(this.$colormapID());
    }

    public void colormapID(CUnsignedLong value)
    {
        value.unwrap(this.$colormapID());
    }

    public int depth()
    {
        return this.pointer().get(JAVA_INT, OFFSET_depth);
    }

    public void depth(int value)
    {
        this.pointer().set(JAVA_INT, OFFSET_depth, value);
    }

    public MemorySegment $depth()
    {
        return this.pointer().asSlice(OFFSET_depth, JAVA_INT);
    }

    public MemorySegment GetAWTColor()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetAWTColor);
    }

    public void GetAWTColor(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetAWTColor, value);
    }

    public MemorySegment $GetAWTColor()
    {
        return this.pointer().asSlice(OFFSET_GetAWTColor, ADDRESS);
    }
}
