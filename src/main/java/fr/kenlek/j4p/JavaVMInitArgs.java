package fr.kenlek.j4p;

import fr.kenlek.jpgen.api.Addressable;
import fr.kenlek.jpgen.api.dynload.Layout;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.util.function.Consumer;

import static java.lang.foreign.ValueLayout.*;

import static fr.kenlek.jpgen.api.ForeignUtils.*;

public record JavaVMInitArgs(MemorySegment pointer) implements Addressable
{
    @Layout.Value("LAYOUT")
    public static final StructLayout LAYOUT = makeStructLayout(
        JAVA_INT.withName("version"),
        JAVA_INT.withName("nOptions"),
        UNBOUNDED_POINTER.withName("options"),
        JAVA_BOOLEAN.withName("ignoreUnrecognized")
    ).withName("JavaVMInitArgs");
    public static final long MEMBER_OFFSET__version = LAYOUT.byteOffset(PathElement.groupElement("version"));
    public static final long MEMBER_OFFSET__nOptions = LAYOUT.byteOffset(PathElement.groupElement("nOptions"));
    public static final long MEMBER_OFFSET__options = LAYOUT.byteOffset(PathElement.groupElement("options"));
    public static final long MEMBER_OFFSET__ignoreUnrecognized = LAYOUT.byteOffset(PathElement.groupElement("ignoreUnrecognized"));

    public JavaVMInitArgs(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static JavaVMInitArgs getAtIndex(MemorySegment buffer, long index)
    {
        return new JavaVMInitArgs(buffer.asSlice(index * LAYOUT.byteSize(), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long index, JavaVMInitArgs value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, index * LAYOUT.byteSize(), LAYOUT.byteSize());
    }

    public void copyFrom(JavaVMInitArgs value)
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

    public int nOptions()
    {
        return this.pointer().get(JAVA_INT, MEMBER_OFFSET__nOptions);
    }

    public void nOptions(int value)
    {
        this.pointer().set(JAVA_INT, MEMBER_OFFSET__nOptions, value);
    }

    public MemorySegment $nOptions()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__nOptions, JAVA_INT);
    }

    public MemorySegment options()
    {
        return this.pointer().get(UNBOUNDED_POINTER, MEMBER_OFFSET__options);
    }

    public JavaVMOption options(long index)
    {
        return JavaVMOption.getAtIndex(this.options(), index);
    }

    public void options(long index, Consumer<JavaVMOption> consumer)
    {
        consumer.accept(this.options(index));
    }

    public void options(MemorySegment value)
    {
        this.pointer().set(UNBOUNDED_POINTER, MEMBER_OFFSET__options, value);
    }

    public void options(long index, JavaVMOption value)
    {
        JavaVMOption.setAtIndex(this.options(), index, value);
    }

    public MemorySegment $options()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__options, UNBOUNDED_POINTER);
    }

    public boolean ignoreUnrecognized()
    {
        return this.pointer().get(JAVA_BOOLEAN, MEMBER_OFFSET__ignoreUnrecognized);
    }

    public void ignoreUnrecognized(boolean value)
    {
        this.pointer().set(JAVA_BOOLEAN, MEMBER_OFFSET__ignoreUnrecognized, value);
    }

    public MemorySegment $ignoreUnrecognized()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__ignoreUnrecognized, JAVA_BOOLEAN);
    }
}
