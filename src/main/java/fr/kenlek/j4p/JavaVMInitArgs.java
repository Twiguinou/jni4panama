package fr.kenlek.j4p;

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

public record JavaVMInitArgs(MemorySegment pointer) implements Addressable
{
    @Layout.Value("LAYOUT")
    public static final StructLayout LAYOUT = makeStructLayout(
        JAVA_INT.withName("version"),
        JAVA_INT.withName("nOptions"),
        ADDRESS.withName("options"),
        JAVA_BOOLEAN.withName("ignoreUnrecognized")
    ).withName("JavaVMInitArgs");
    public static final long OFFSET__version = LAYOUT.byteOffset(PathElement.groupElement("version"));
    public static final long OFFSET__nOptions = LAYOUT.byteOffset(PathElement.groupElement("nOptions"));
    public static final long OFFSET__options = LAYOUT.byteOffset(PathElement.groupElement("options"));
    public static final long OFFSET__ignoreUnrecognized = LAYOUT.byteOffset(PathElement.groupElement("ignoreUnrecognized"));

    public JavaVMInitArgs
    {
        if (pointer.maxByteAlignment() < LAYOUT.byteAlignment() || pointer.byteSize() != LAYOUT.byteSize())
        {
            throw new IllegalArgumentException("Memory slice does not follow layout constraints.");
        }
    }

    public JavaVMInitArgs(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JavaVMInitArgs> buffer(MemorySegment data)
    {
        return Buffer.of(data, LAYOUT, JavaVMInitArgs::new);
    }

    public static Buffer<JavaVMInitArgs> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocate(allocator, LAYOUT, size, JavaVMInitArgs::new);
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

    public int nOptions()
    {
        return this.pointer().get(JAVA_INT, OFFSET__nOptions);
    }

    public void nOptions(int value)
    {
        this.pointer().set(JAVA_INT, OFFSET__nOptions, value);
    }

    public MemorySegment $nOptions()
    {
        return this.pointer().asSlice(OFFSET__nOptions, JAVA_INT);
    }

    public Buffer<JavaVMOption> options()
    {
        return JavaVMOption.buffer(this.pointer().get(
            ADDRESS.withTargetLayout(sequenceLayout(this.nOptions(), JavaVMOption.LAYOUT)),
            OFFSET__options
        ));
    }

    public void options(Consumer<Buffer<JavaVMOption>> consumer)
    {
        consumer.accept(this.options());
    }

    public void options(Buffer<JavaVMOption> value)
    {
        this.pointer().set(ADDRESS, OFFSET__options, value.pointer());
    }

    public MemorySegment $options()
    {
        return this.pointer().asSlice(OFFSET__options, ADDRESS);
    }

    public boolean ignoreUnrecognized()
    {
        return this.pointer().get(JAVA_BOOLEAN, OFFSET__ignoreUnrecognized);
    }

    public void ignoreUnrecognized(boolean value)
    {
        this.pointer().set(JAVA_BOOLEAN, OFFSET__ignoreUnrecognized, value);
    }

    public MemorySegment $ignoreUnrecognized()
    {
        return this.pointer().asSlice(OFFSET__ignoreUnrecognized, JAVA_BOOLEAN);
    }
}
