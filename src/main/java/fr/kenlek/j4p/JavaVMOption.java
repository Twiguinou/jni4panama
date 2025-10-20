package fr.kenlek.j4p;

import module fr.kenlek.jpgen.api;
import module java.base;

import fr.kenlek.jpgen.api.Buffer;

import static fr.kenlek.jpgen.api.ForeignUtils.*;
import static java.lang.foreign.ValueLayout.*;

@Layout.Container("LAYOUT")
public record JavaVMOption(MemorySegment pointer) implements Addressable
{
    public static final StructLayout LAYOUT = makeStructLayout(
        ADDRESS.withName("optionString"),
        ADDRESS.withName("extraInfo")
    ).withName("JavaVMOption");
    public static final long OFFSET_optionString = LAYOUT.byteOffset(PathElement.groupElement("optionString"));
    public static final long OFFSET_extraInfo = LAYOUT.byteOffset(PathElement.groupElement("extraInfo"));

    public JavaVMOption
    {
        Addressable.checkLayoutConstraints(pointer, LAYOUT);
    }

    public JavaVMOption(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JavaVMOption> buffer(MemorySegment data)
    {
        return Buffer.slices(data, LAYOUT, JavaVMOption::new);
    }

    public static Buffer<JavaVMOption> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocateSlices(allocator, LAYOUT, size, JavaVMOption::new);
    }

    public static JavaVMOption getAtIndex(MemorySegment buffer, long offset, long index)
    {
        return new JavaVMOption(buffer.asSlice(LAYOUT.scale(offset, index), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long offset, long index, JavaVMOption value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, LAYOUT.scale(offset, index), LAYOUT.byteSize());
    }

    public void copyFrom(JavaVMOption other)
    {
        MemorySegment.copy(other.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public MemorySegment optionString()
    {
        return this.pointer().get(UNBOUNDED_POINTER, OFFSET_optionString);
    }

    public void optionString(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_optionString, value);
    }

    public MemorySegment $optionString()
    {
        return this.pointer().asSlice(OFFSET_optionString, ADDRESS);
    }

    public MemorySegment extraInfo()
    {
        return this.pointer().get(ADDRESS, OFFSET_extraInfo);
    }

    public void extraInfo(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_extraInfo, value);
    }

    public MemorySegment $extraInfo()
    {
        return this.pointer().asSlice(OFFSET_extraInfo, ADDRESS);
    }
}
