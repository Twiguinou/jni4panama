package fr.kenlek.j4p.awt;

import fr.kenlek.jpgen.api.Addressable;
import fr.kenlek.jpgen.api.dynload.Layout;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;

import static java.lang.foreign.ValueLayout.*;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;

public record JAWTRectangle(MemorySegment pointer) implements Addressable
{
    @Layout.Value("LAYOUT")
    public static final StructLayout LAYOUT = makeStructLayout(
        JAVA_INT.withName("x"),
        JAVA_INT.withName("y"),
        JAVA_INT.withName("width"),
        JAVA_INT.withName("height")
    ).withName("JAWT_Rectangle");
    public static final long MEMBER_OFFSET__x = LAYOUT.byteOffset(PathElement.groupElement("x"));
    public static final long MEMBER_OFFSET__y = LAYOUT.byteOffset(PathElement.groupElement("y"));
    public static final long MEMBER_OFFSET__width = LAYOUT.byteOffset(PathElement.groupElement("width"));
    public static final long MEMBER_OFFSET__height = LAYOUT.byteOffset(PathElement.groupElement("height"));

    public JAWTRectangle(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static JAWTRectangle getAtIndex(MemorySegment buffer, long index)
    {
        return new JAWTRectangle(buffer.asSlice(index * LAYOUT.byteSize(), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long index, JAWTRectangle value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, index * LAYOUT.byteSize(), LAYOUT.byteSize());
    }

    public void copyFrom(JAWTRectangle value)
    {
        MemorySegment.copy(value.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public int x()
    {
        return this.pointer().get(JAVA_INT, MEMBER_OFFSET__x);
    }

    public void x(int value)
    {
        this.pointer().set(JAVA_INT, MEMBER_OFFSET__x, value);
    }

    public MemorySegment $x()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__x, JAVA_INT);
    }

    public int y()
    {
        return this.pointer().get(JAVA_INT, MEMBER_OFFSET__y);
    }

    public void y(int value)
    {
        this.pointer().set(JAVA_INT, MEMBER_OFFSET__y, value);
    }

    public MemorySegment $y()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__y, JAVA_INT);
    }

    public int width()
    {
        return this.pointer().get(JAVA_INT, MEMBER_OFFSET__width);
    }

    public void width(int value)
    {
        this.pointer().set(JAVA_INT, MEMBER_OFFSET__width, value);
    }

    public MemorySegment $width()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__width, JAVA_INT);
    }

    public int height()
    {
        return this.pointer().get(JAVA_INT, MEMBER_OFFSET__height);
    }

    public void height(int value)
    {
        this.pointer().set(JAVA_INT, MEMBER_OFFSET__height, value);
    }

    public MemorySegment $height()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__height, JAVA_INT);
    }
}
