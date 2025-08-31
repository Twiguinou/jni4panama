package fr.kenlek.j4p;

import fr.kenlek.jpgen.api.Addressable;
import fr.kenlek.jpgen.api.Buffer;
import fr.kenlek.jpgen.api.dynload.Layout;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;

import static java.lang.foreign.ValueLayout.*;

import static fr.kenlek.jpgen.api.ForeignUtils.*;

public record JavaVMOption(MemorySegment pointer) implements Addressable
{
    @Layout.Value("LAYOUT")
    public static final StructLayout LAYOUT = makeStructLayout(
        ADDRESS.withName("optionString"),
        ADDRESS.withName("extraInfo")
    ).withName("JavaVMOption");
    public static final long OFFSET__optionString = LAYOUT.byteOffset(PathElement.groupElement("optionString"));
    public static final long OFFSET__extraInfo = LAYOUT.byteOffset(PathElement.groupElement("extraInfo"));

    public JavaVMOption
    {
        if (pointer.maxByteAlignment() < LAYOUT.byteAlignment() || pointer.byteSize() != LAYOUT.byteSize())
        {
            throw new IllegalArgumentException("Memory slice does not follow layout constraints.");
        }
    }

    public JavaVMOption(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JavaVMOption> buffer(MemorySegment data)
    {
        return Buffer.of(data, LAYOUT, JavaVMOption::new);
    }

    public static Buffer<JavaVMOption> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocate(allocator, LAYOUT, size, JavaVMOption::new);
    }

    public static JavaVMOption getAtIndex(MemorySegment buffer, long index)
    {
        return new JavaVMOption(buffer.asSlice(index * LAYOUT.byteSize(), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long index, JavaVMOption value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, index * LAYOUT.byteSize(), LAYOUT.byteSize());
    }

    public void copyFrom(JavaVMOption value)
    {
        MemorySegment.copy(value.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public MemorySegment optionString()
    {
        return this.pointer().get(UNBOUNDED_POINTER, OFFSET__optionString);
    }

    public void optionString(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__optionString, value);
    }

    public MemorySegment $optionString()
    {
        return this.pointer().asSlice(OFFSET__optionString, ADDRESS);
    }

    public MemorySegment extraInfo()
    {
        return this.pointer().get(ADDRESS, OFFSET__extraInfo);
    }

    public void extraInfo(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__extraInfo, value);
    }

    public MemorySegment $extraInfo()
    {
        return this.pointer().asSlice(OFFSET__extraInfo, ADDRESS);
    }
}
