package fr.kenlek.j4p;

import module fr.kenlek.jpgen.api;
import module java.base;

import fr.kenlek.jpgen.api.data.Buffer;

import static fr.kenlek.jpgen.api.ForeignUtils.*;
import static java.lang.foreign.ValueLayout.*;

@Layout.Container("LAYOUT")
public record JavaVMAttachArgs(MemorySegment pointer) implements Addressable
{
    public static final StructLayout LAYOUT = makeStructLayout(
        JAVA_INT.withName("version"),
        ADDRESS.withName("name"),
        ADDRESS.withName("group")
    ).withName("JavaVMAttachArgs");
    public static final long OFFSET_version = LAYOUT.byteOffset(PathElement.groupElement("version"));
    public static final long OFFSET_name = LAYOUT.byteOffset(PathElement.groupElement("name"));
    public static final long OFFSET_group = LAYOUT.byteOffset(PathElement.groupElement("group"));

    public JavaVMAttachArgs
    {
        Addressable.checkLayoutConstraints(pointer, LAYOUT);
    }

    public JavaVMAttachArgs(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JavaVMAttachArgs> buffer(MemorySegment data)
    {
        return Buffer.slices(data, LAYOUT, JavaVMAttachArgs::new);
    }

    public static Buffer<JavaVMAttachArgs> buffer(SegmentAllocator allocator, long size)
    {
        return Buffer.slices(allocator, LAYOUT, size, JavaVMAttachArgs::new);
    }

    @Override
    public StructLayout layout()
    {
        return LAYOUT;
    }

    public void copyFrom(JavaVMAttachArgs other)
    {
        MemorySegment.copy(other.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public int version()
    {
        return this.pointer().get(JAVA_INT, OFFSET_version);
    }

    public void version(int value)
    {
        this.pointer().set(JAVA_INT, OFFSET_version, value);
    }

    public MemorySegment $version()
    {
        return this.pointer().asSlice(OFFSET_version, JAVA_INT);
    }

    public MemorySegment name()
    {
        return this.pointer().get(UNBOUNDED_POINTER, OFFSET_name);
    }

    public void name(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_name, value);
    }

    public MemorySegment $name()
    {
        return this.pointer().asSlice(OFFSET_name, ADDRESS);
    }

    public MemorySegment group()
    {
        return this.pointer().get(ADDRESS, OFFSET_group);
    }

    public void group(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_group, value);
    }

    public MemorySegment $group()
    {
        return this.pointer().asSlice(OFFSET_group, ADDRESS);
    }
}
