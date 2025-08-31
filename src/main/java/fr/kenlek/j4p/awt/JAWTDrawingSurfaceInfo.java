package fr.kenlek.j4p.awt;

import fr.kenlek.j4p.JavaVMOption;
import fr.kenlek.jpgen.api.Addressable;
import fr.kenlek.jpgen.api.Buffer;
import fr.kenlek.jpgen.api.dynload.Layout;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.util.function.Consumer;

import static java.lang.foreign.ValueLayout.*;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;
import static java.lang.foreign.MemoryLayout.sequenceLayout;

public record JAWTDrawingSurfaceInfo(MemorySegment pointer) implements Addressable
{
    @Layout.Value("LAYOUT")
    public static final StructLayout LAYOUT = makeStructLayout(
        ADDRESS.withName("platformInfo"),
        ADDRESS.withName("ds"),
        JAWTRectangle.LAYOUT.withName("bounds"),
        JAVA_INT.withName("clipSize"),
        ADDRESS.withName("clip")
    ).withName("JAWT_DrawingSurfaceInfo");
    public static final long OFFSET__platformInfo = LAYOUT.byteOffset(PathElement.groupElement("platformInfo"));
    public static final long OFFSET__ds = LAYOUT.byteOffset(PathElement.groupElement("ds"));
    public static final long OFFSET__bounds = LAYOUT.byteOffset(PathElement.groupElement("bounds"));
    public static final long OFFSET__clipSize = LAYOUT.byteOffset(PathElement.groupElement("clipSize"));
    public static final long OFFSET__clip = LAYOUT.byteOffset(PathElement.groupElement("clip"));

    public JAWTDrawingSurfaceInfo
    {
        if (pointer.maxByteAlignment() < LAYOUT.byteAlignment() || pointer.byteSize() != LAYOUT.byteSize())
        {
            throw new IllegalArgumentException("Memory slice does not follow layout constraints.");
        }
    }

    public JAWTDrawingSurfaceInfo(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JAWTDrawingSurfaceInfo> buffer(MemorySegment data)
    {
        return Buffer.of(data, LAYOUT, JAWTDrawingSurfaceInfo::new);
    }

    public static Buffer<JAWTDrawingSurfaceInfo> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocate(allocator, LAYOUT, size, JAWTDrawingSurfaceInfo::new);
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
        return this.pointer().get(ADDRESS, OFFSET__platformInfo);
    }

    public void platformInfo(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__platformInfo, value);
    }

    public MemorySegment $platformInfo()
    {
        return this.pointer().asSlice(OFFSET__platformInfo, ADDRESS);
    }

    public JAWTDrawingSurface ds()
    {
        return new JAWTDrawingSurface(this.pointer().get(ADDRESS.withTargetLayout(JAWTDrawingSurface.LAYOUT), OFFSET__ds));
    }

    public void ds(JAWTDrawingSurface value)
    {
        this.pointer().set(ADDRESS, OFFSET__ds, value.pointer());
    }

    public MemorySegment $ds()
    {
        return this.pointer().asSlice(OFFSET__ds, ADDRESS);
    }

    public JAWTRectangle bounds()
    {
        return new JAWTRectangle(this.pointer().asSlice(OFFSET__bounds, JAWTRectangle.LAYOUT));
    }

    public void bounds(Consumer<JAWTRectangle> consumer)
    {
        consumer.accept(this.bounds());
    }

    public int clipSize()
    {
        return this.pointer().get(JAVA_INT, OFFSET__clipSize);
    }

    public void clipSize(int value)
    {
        this.pointer().set(JAVA_INT, OFFSET__clipSize, value);
    }

    public MemorySegment $clipSize()
    {
        return this.pointer().asSlice(OFFSET__clipSize, JAVA_INT);
    }

    public Buffer<JavaVMOption> clip()
    {
        return JavaVMOption.buffer(this.pointer().get(
            ADDRESS.withTargetLayout(sequenceLayout(this.clipSize(), JavaVMOption.LAYOUT)),
            OFFSET__clip
        ));
    }

    public void clip(Consumer<Buffer<JavaVMOption>> consumer)
    {
        consumer.accept(this.clip());
    }

    public void clip(Buffer<JavaVMOption> value)
    {
        this.pointer().set(ADDRESS, OFFSET__clip, value.pointer());
    }

    public MemorySegment $clip()
    {
        return this.pointer().asSlice(OFFSET__clip, ADDRESS);
    }
}
