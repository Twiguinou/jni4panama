package fr.kenlek.j4p.awt;

import module fr.kenlek.jpgen.api;
import module java.base;

import fr.kenlek.jpgen.api.data.Buffer;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;
import static java.lang.foreign.ValueLayout.*;

@Layout.Container("LAYOUT")
public record JAWTRectangle(MemorySegment pointer) implements Addressable
{
    public static final StructLayout LAYOUT = makeStructLayout(
        JAVA_INT.withName("x"),
        JAVA_INT.withName("y"),
        JAVA_INT.withName("width"),
        JAVA_INT.withName("height")
    ).withName("JAWT_Rectangle");
    public static final long OFFSET_x = LAYOUT.byteOffset(PathElement.groupElement("x"));
    public static final long OFFSET_y = LAYOUT.byteOffset(PathElement.groupElement("y"));
    public static final long OFFSET_width = LAYOUT.byteOffset(PathElement.groupElement("width"));
    public static final long OFFSET_height = LAYOUT.byteOffset(PathElement.groupElement("height"));

    public JAWTRectangle
    {
        Addressable.checkLayoutConstraints(pointer, LAYOUT);
    }

    public JAWTRectangle(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JAWTRectangle> buffer(MemorySegment data)
    {
        return Buffer.slices(data, LAYOUT, JAWTRectangle::new);
    }

    public static Buffer<JAWTRectangle> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocateSlices(allocator, LAYOUT, size, JAWTRectangle::new);
    }

    public static JAWTRectangle getAtIndex(MemorySegment buffer, long offset, long index)
    {
        return new JAWTRectangle(buffer.asSlice(LAYOUT.scale(offset, index), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long offset, long index, JAWTRectangle value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, LAYOUT.scale(offset, index), LAYOUT.byteSize());
    }

    public void copyFrom(JAWTRectangle other)
    {
        MemorySegment.copy(other.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public int x()
    {
        return this.pointer().get(JAVA_INT, OFFSET_x);
    }

    public void x(int value)
    {
        this.pointer().set(JAVA_INT, OFFSET_x, value);
    }

    public MemorySegment $x()
    {
        return this.pointer().asSlice(OFFSET_x, JAVA_INT);
    }

    public int y()
    {
        return this.pointer().get(JAVA_INT, OFFSET_y);
    }

    public void y(int value)
    {
        this.pointer().set(JAVA_INT, OFFSET_y, value);
    }

    public MemorySegment $y()
    {
        return this.pointer().asSlice(OFFSET_y, JAVA_INT);
    }

    public int width()
    {
        return this.pointer().get(JAVA_INT, OFFSET_width);
    }

    public void width(int value)
    {
        this.pointer().set(JAVA_INT, OFFSET_width, value);
    }

    public MemorySegment $width()
    {
        return this.pointer().asSlice(OFFSET_width, JAVA_INT);
    }

    public int height()
    {
        return this.pointer().get(JAVA_INT, OFFSET_height);
    }

    public void height(int value)
    {
        this.pointer().set(JAVA_INT, OFFSET_height, value);
    }

    public MemorySegment $height()
    {
        return this.pointer().asSlice(OFFSET_height, JAVA_INT);
    }
}
