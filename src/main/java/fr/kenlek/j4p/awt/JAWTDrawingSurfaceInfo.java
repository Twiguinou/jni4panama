package fr.kenlek.j4p.awt;

import fr.kenlek.jpgen.api.Addressable;
import fr.kenlek.jpgen.api.dynload.Layout;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.util.function.Consumer;

import static java.lang.foreign.ValueLayout.*;

import static fr.kenlek.jpgen.api.ForeignUtils.*;

public record JAWTDrawingSurfaceInfo(MemorySegment pointer) implements Addressable
{
    @Layout.Value("LAYOUT")
    public static final StructLayout LAYOUT = makeStructLayout(
        ADDRESS.withName("platformInfo"),
        ADDRESS.withName("ds"),
        JAWTRectangle.LAYOUT.withName("bounds"),
        JAVA_INT.withName("clipSize"),
        UNBOUNDED_POINTER.withName("clip")
    ).withName("JAWT_DrawingSurfaceInfo");
    public static final long MEMBER_OFFSET__platformInfo = LAYOUT.byteOffset(PathElement.groupElement("platformInfo"));
    public static final long MEMBER_OFFSET__ds = LAYOUT.byteOffset(PathElement.groupElement("ds"));
    public static final long MEMBER_OFFSET__bounds = LAYOUT.byteOffset(PathElement.groupElement("bounds"));
    public static final long MEMBER_OFFSET__clipSize = LAYOUT.byteOffset(PathElement.groupElement("clipSize"));
    public static final long MEMBER_OFFSET__clip = LAYOUT.byteOffset(PathElement.groupElement("clip"));

    public JAWTDrawingSurfaceInfo(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static JAWTDrawingSurfaceInfo getAtIndex(MemorySegment buffer, long index)
    {
        return new JAWTDrawingSurfaceInfo(buffer.asSlice(index * LAYOUT.byteSize(), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long index, JAWTDrawingSurfaceInfo value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, index * LAYOUT.byteSize(), LAYOUT.byteSize());
    }

    public void copyFrom(JAWTDrawingSurfaceInfo value)
    {
        MemorySegment.copy(value.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public MemorySegment platformInfo()
    {
        return this.pointer().get(ADDRESS, MEMBER_OFFSET__platformInfo);
    }

    public void platformInfo(MemorySegment value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__platformInfo, value);
    }

    public MemorySegment $platformInfo()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__platformInfo, ADDRESS);
    }

    public JAWTDrawingSurface ds()
    {
        return new JAWTDrawingSurface(this.pointer().get(ADDRESS, MEMBER_OFFSET__ds).reinterpret(JAWTDrawingSurface.LAYOUT.byteSize()));
    }

    public void ds(JAWTDrawingSurface value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__ds, value.pointer());
    }

    public MemorySegment $ds()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__ds, ADDRESS);
    }

    public JAWTRectangle bounds()
    {
        return new JAWTRectangle(this.pointer().asSlice(MEMBER_OFFSET__bounds, JAWTRectangle.LAYOUT));
    }

    public void bounds(Consumer<JAWTRectangle> consumer)
    {
        consumer.accept(this.bounds());
    }

    public void bounds(JAWTRectangle value)
    {
        MemorySegment.copy(value.pointer(), 0, this.pointer(), MEMBER_OFFSET__bounds, JAWTRectangle.LAYOUT.byteSize());
    }

    public int clipSize()
    {
        return this.pointer().get(JAVA_INT, MEMBER_OFFSET__clipSize);
    }

    public void clipSize(int value)
    {
        this.pointer().set(JAVA_INT, MEMBER_OFFSET__clipSize, value);
    }

    public MemorySegment $clipSize()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__clipSize, JAVA_INT);
    }

    public MemorySegment clip()
    {
        return this.pointer().get(UNBOUNDED_POINTER, MEMBER_OFFSET__clip);
    }

    public JAWTRectangle clip(long index)
    {
        return JAWTRectangle.getAtIndex(this.clip(), index);
    }

    public void clip(long index, Consumer<JAWTRectangle> consumer)
    {
        consumer.accept(this.clip(index));
    }

    public void clip(MemorySegment value)
    {
        this.pointer().set(UNBOUNDED_POINTER, MEMBER_OFFSET__clip, value);
    }

    public void clip(long index, JAWTRectangle value)
    {
        JAWTRectangle.setAtIndex(this.clip(), index, value);
    }

    public MemorySegment $clip()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__clip, UNBOUNDED_POINTER);
    }
}
