package fr.kenlek.j4p.awt;

import fr.kenlek.jpgen.api.Addressable;
import fr.kenlek.jpgen.api.Buffer;
import fr.kenlek.jpgen.api.dynload.Layout;
import fr.kenlek.jpgen.api.types.CUnsignedLong;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;

import static java.lang.foreign.ValueLayout.*;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;

public record JAWTX11DrawingSurfaceInfo(MemorySegment pointer) implements Addressable
{
    @Layout.Value("LAYOUT")
    public static final StructLayout LAYOUT = makeStructLayout(
        CUnsignedLong.LAYOUT.withName("drawable"),
        ADDRESS.withName("display"),
        CUnsignedLong.LAYOUT.withName("visualID"),
        CUnsignedLong.LAYOUT.withName("colormapID"),
        JAVA_INT.withName("depth"),
        ADDRESS.withName("GetAWTColor")
    ).withName("JAWT_X11DrawingSurfaceInfo");
    public static final long OFFSET__drawable = LAYOUT.byteOffset(PathElement.groupElement("drawable"));
    public static final long OFFSET__display = LAYOUT.byteOffset(PathElement.groupElement("display"));
    public static final long OFFSET__visualID = LAYOUT.byteOffset(PathElement.groupElement("visualID"));
    public static final long OFFSET__colormapID = LAYOUT.byteOffset(PathElement.groupElement("colormapID"));
    public static final long OFFSET__depth = LAYOUT.byteOffset(PathElement.groupElement("depth"));
    public static final long OFFSET__GetAWTColor = LAYOUT.byteOffset(PathElement.groupElement("GetAWTColor"));

    public JAWTX11DrawingSurfaceInfo
    {
        if (pointer.maxByteAlignment() < LAYOUT.byteAlignment() || pointer.byteSize() != LAYOUT.byteSize())
        {
            throw new IllegalArgumentException("Memory slice does not follow layout constraints.");
        }
    }

    public JAWTX11DrawingSurfaceInfo(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JAWTX11DrawingSurfaceInfo> buffer(MemorySegment data)
    {
        return Buffer.of(data, LAYOUT, JAWTX11DrawingSurfaceInfo::new);
    }

    public static Buffer<JAWTX11DrawingSurfaceInfo> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocate(allocator, LAYOUT, size, JAWTX11DrawingSurfaceInfo::new);
    }

    public static JAWTX11DrawingSurfaceInfo getAtIndex(MemorySegment buffer, long index)
    {
        return new JAWTX11DrawingSurfaceInfo(buffer.asSlice(index * LAYOUT.byteSize(), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long index, JAWTX11DrawingSurfaceInfo value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, index * LAYOUT.byteSize(), LAYOUT.byteSize());
    }

    public void copyFrom(JAWTX11DrawingSurfaceInfo value)
    {
        MemorySegment.copy(value.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public MemorySegment $drawable()
    {
        return this.pointer().asSlice(OFFSET__drawable, CUnsignedLong.LAYOUT);
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
        return this.pointer().get(ADDRESS, OFFSET__display);
    }

    public void display(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__display, value);
    }

    public MemorySegment $display()
    {
        return this.pointer().asSlice(OFFSET__display, ADDRESS);
    }

    public MemorySegment $visualID()
    {
        return this.pointer().asSlice(OFFSET__visualID, CUnsignedLong.LAYOUT);
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
        return this.pointer().asSlice(OFFSET__colormapID, CUnsignedLong.LAYOUT);
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
        return this.pointer().get(JAVA_INT, OFFSET__depth);
    }

    public void depth(int value)
    {
        this.pointer().set(JAVA_INT, OFFSET__depth, value);
    }

    public MemorySegment $depth()
    {
        return this.pointer().asSlice(OFFSET__depth, JAVA_INT);
    }

    public MemorySegment GetAWTColor()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetAWTColor);
    }

    public void GetAWTColor(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetAWTColor, value);
    }

    public MemorySegment $GetAWTColor()
    {
        return this.pointer().asSlice(OFFSET__GetAWTColor, ADDRESS);
    }
}
