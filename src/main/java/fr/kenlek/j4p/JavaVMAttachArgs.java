package fr.kenlek.j4p;

import fr.kenlek.jpgen.api.Addressable;
import fr.kenlek.jpgen.api.Buffer;
import fr.kenlek.jpgen.api.dynload.Layout;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;

import static java.lang.foreign.ValueLayout.*;

import static fr.kenlek.jpgen.api.ForeignUtils.*;

public record JavaVMAttachArgs(MemorySegment pointer) implements Addressable
{
    @Layout.Value("LAYOUT")
    public static final StructLayout LAYOUT = makeStructLayout(
        JAVA_INT.withName("version"),
        ADDRESS.withName("name"),
        ADDRESS.withName("group")
    ).withName("JavaVMAttachArgs");
    public static final long OFFSET__version = LAYOUT.byteOffset(PathElement.groupElement("version"));
    public static final long OFFSET__name = LAYOUT.byteOffset(PathElement.groupElement("name"));
    public static final long OFFSET__group = LAYOUT.byteOffset(PathElement.groupElement("group"));

    public JavaVMAttachArgs
    {
        if (pointer.maxByteAlignment() < LAYOUT.byteAlignment() || pointer.byteSize() != LAYOUT.byteSize())
        {
            throw new IllegalArgumentException("Memory slice does not follow layout constraints.");
        }
    }

    public JavaVMAttachArgs(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JavaVMAttachArgs> buffer(MemorySegment data)
    {
        return Buffer.of(data, LAYOUT, JavaVMAttachArgs::new);
    }

    public static Buffer<JavaVMAttachArgs> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocate(allocator, LAYOUT, size, JavaVMAttachArgs::new);
    }

    public static JavaVMAttachArgs getAtIndex(MemorySegment buffer, long index)
    {
        return new JavaVMAttachArgs(buffer.asSlice(index * LAYOUT.byteSize(), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long index, JavaVMAttachArgs value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, index * LAYOUT.byteSize(), LAYOUT.byteSize());
    }

    public void copyFrom(JavaVMAttachArgs value)
    {
        MemorySegment.copy(value.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public int version()
    {
        return this.pointer().get(JAVA_INT, OFFSET__version);
    }

    public void version(int value)
    {
        this.pointer().set(JAVA_INT, OFFSET__version, value);
    }

    public MemorySegment $version()
    {
        return this.pointer().asSlice(OFFSET__version, JAVA_INT);
    }

    public MemorySegment name()
    {
        return this.pointer().get(UNBOUNDED_POINTER, OFFSET__name);
    }

    public void name(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__name, value);
    }

    public MemorySegment $name()
    {
        return this.pointer().asSlice(OFFSET__name, ADDRESS);
    }

    public MemorySegment group()
    {
        return this.pointer().get(ADDRESS, OFFSET__group);
    }

    public void group(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__group, value);
    }

    public MemorySegment $group()
    {
        return this.pointer().asSlice(OFFSET__group, ADDRESS);
    }
}
