package fr.kenlek.j4p.awt;

import module fr.kenlek.jpgen.api;
import module java.base;

import fr.kenlek.jpgen.api.data.Buffer;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;
import static java.lang.foreign.ValueLayout.*;

@Layout.Container("LAYOUT")
public record JAWTX11DrawingSurfaceInfo(MemorySegment pointer) implements Addressable
{
    public static final StructLayout LAYOUT = makeStructLayout(
        CLong.LAYOUT.withName("drawable"),
        ADDRESS.withName("display"),
        CLong.LAYOUT.withName("visualID"),
        CLong.LAYOUT.withName("colormapID"),
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

    public static Buffer<JAWTX11DrawingSurfaceInfo> buffer(SegmentAllocator allocator, long size)
    {
        return Buffer.slices(allocator, LAYOUT, size, JAWTX11DrawingSurfaceInfo::new);
    }

    @Override
    public StructLayout layout()
    {
        return LAYOUT;
    }

    public void copyFrom(JAWTX11DrawingSurfaceInfo other)
    {
        MemorySegment.copy(other.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public MemorySegment $drawable()
    {
        return this.pointer().asSlice(OFFSET_drawable, CLong.LAYOUT);
    }

    public CLong drawable()
    {
        return CLong.wrap(this.$drawable());
    }

    public void drawable(CLong value)
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
        return this.pointer().asSlice(OFFSET_visualID, CLong.LAYOUT);
    }

    public CLong visualID()
    {
        return CLong.wrap(this.$visualID());
    }

    public void visualID(CLong value)
    {
        value.unwrap(this.$visualID());
    }

    public MemorySegment $colormapID()
    {
        return this.pointer().asSlice(OFFSET_colormapID, CLong.LAYOUT);
    }

    public CLong colormapID()
    {
        return CLong.wrap(this.$colormapID());
    }

    public void colormapID(CLong value)
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
