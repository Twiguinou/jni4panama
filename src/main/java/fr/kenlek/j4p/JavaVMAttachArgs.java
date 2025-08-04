package fr.kenlek.j4p;

import fr.kenlek.jpgen.api.Addressable;
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
        UNBOUNDED_POINTER.withName("name"),
        ADDRESS.withName("group")
    ).withName("JavaVMAttachArgs");
    public static final long MEMBER_OFFSET__version = LAYOUT.byteOffset(PathElement.groupElement("version"));
    public static final long MEMBER_OFFSET__name = LAYOUT.byteOffset(PathElement.groupElement("name"));
    public static final long MEMBER_OFFSET__group = LAYOUT.byteOffset(PathElement.groupElement("group"));

    public JavaVMAttachArgs(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
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
        return this.pointer().get(JAVA_INT, MEMBER_OFFSET__version);
    }

    public void version(int value)
    {
        this.pointer().set(JAVA_INT, MEMBER_OFFSET__version, value);
    }

    public MemorySegment $version()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__version, JAVA_INT);
    }

    public MemorySegment name()
    {
        return this.pointer().get(UNBOUNDED_POINTER, MEMBER_OFFSET__name);
    }

    public void name(MemorySegment value)
    {
        this.pointer().set(UNBOUNDED_POINTER, MEMBER_OFFSET__name, value);
    }

    public MemorySegment $name()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__name, UNBOUNDED_POINTER);
    }

    public MemorySegment group()
    {
        return this.pointer().get(ADDRESS, MEMBER_OFFSET__group);
    }

    public void group(MemorySegment value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__group, value);
    }

    public MemorySegment $group()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__group, ADDRESS);
    }
}
