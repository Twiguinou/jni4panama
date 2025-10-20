package fr.kenlek.j4p.awt;

import module fr.kenlek.jpgen.api;
import module java.base;

import fr.kenlek.j4p.JavaVMOption;
import fr.kenlek.jpgen.api.Buffer;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;
import static java.lang.foreign.MemoryLayout.sequenceLayout;
import static java.lang.foreign.ValueLayout.*;

@Layout.Container("LAYOUT")
public record JAWTDrawingSurfaceInfo(MemorySegment pointer) implements Addressable
{
    public static final StructLayout LAYOUT = makeStructLayout(
        ADDRESS.withName("platformInfo"),
        ADDRESS.withName("ds"),
        JAWTRectangle.LAYOUT.withName("bounds"),
        JAVA_INT.withName("clipSize"),
        ADDRESS.withName("clip")
    ).withName("JAWT_DrawingSurfaceInfo");
    public static final long OFFSET_platformInfo = LAYOUT.byteOffset(PathElement.groupElement("platformInfo"));
    public static final long OFFSET_ds = LAYOUT.byteOffset(PathElement.groupElement("ds"));
    public static final long OFFSET_bounds = LAYOUT.byteOffset(PathElement.groupElement("bounds"));
    public static final long OFFSET_clipSize = LAYOUT.byteOffset(PathElement.groupElement("clipSize"));
    public static final long OFFSET_clip = LAYOUT.byteOffset(PathElement.groupElement("clip"));

    public JAWTDrawingSurfaceInfo
    {
        Addressable.checkLayoutConstraints(pointer, LAYOUT);
    }

    public JAWTDrawingSurfaceInfo(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JAWTDrawingSurfaceInfo> buffer(MemorySegment data)
    {
        return Buffer.slices(data, LAYOUT, JAWTDrawingSurfaceInfo::new);
    }

    public static Buffer<JAWTDrawingSurfaceInfo> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocateSlices(allocator, LAYOUT, size, JAWTDrawingSurfaceInfo::new);
    }

    public static JAWTDrawingSurfaceInfo getAtIndex(MemorySegment buffer, long offset, long index)
    {
        return new JAWTDrawingSurfaceInfo(buffer.asSlice(LAYOUT.scale(offset, index), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long offset, long index, JAWTDrawingSurfaceInfo value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, LAYOUT.scale(offset, index), LAYOUT.byteSize());
    }

    public void copyFrom(JAWTDrawingSurfaceInfo other)
    {
        MemorySegment.copy(other.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public MemorySegment platformInfo()
    {
        return this.pointer().get(ADDRESS, OFFSET_platformInfo);
    }

    public void platformInfo(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_platformInfo, value);
    }

    public MemorySegment $platformInfo()
    {
        return this.pointer().asSlice(OFFSET_platformInfo, ADDRESS);
    }

    public JAWTDrawingSurface ds()
    {
        return new JAWTDrawingSurface(this.pointer().get(ADDRESS.withTargetLayout(JAWTDrawingSurface.LAYOUT), OFFSET_ds));
    }

    public void ds(JAWTDrawingSurface value)
    {
        this.pointer().set(ADDRESS, OFFSET_ds, value.pointer());
    }

    public MemorySegment $ds()
    {
        return this.pointer().asSlice(OFFSET_ds, ADDRESS);
    }

    public JAWTRectangle bounds()
    {
        return new JAWTRectangle(this.pointer().asSlice(OFFSET_bounds, JAWTRectangle.LAYOUT));
    }

    public void bounds(Consumer<JAWTRectangle> consumer)
    {
        consumer.accept(this.bounds());
    }

    public int clipSize()
    {
        return this.pointer().get(JAVA_INT, OFFSET_clipSize);
    }

    public void clipSize(int value)
    {
        this.pointer().set(JAVA_INT, OFFSET_clipSize, value);
    }

    public MemorySegment $clipSize()
    {
        return this.pointer().asSlice(OFFSET_clipSize, JAVA_INT);
    }

    public Buffer<JavaVMOption> clip()
    {
        return JavaVMOption.buffer(this.pointer().get(
            ADDRESS.withTargetLayout(sequenceLayout(this.clipSize(), JavaVMOption.LAYOUT)),
            OFFSET_clip
        ));
    }

    public void clip(Consumer<Buffer<JavaVMOption>> consumer)
    {
        consumer.accept(this.clip());
    }

    public void clip(Buffer<JavaVMOption> value)
    {
        this.pointer().set(ADDRESS, OFFSET_clip, value.pointer());
    }

    public MemorySegment $clip()
    {
        return this.pointer().asSlice(OFFSET_clip, ADDRESS);
    }
}
