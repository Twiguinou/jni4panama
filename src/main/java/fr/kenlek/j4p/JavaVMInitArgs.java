package fr.kenlek.j4p;

import module fr.kenlek.jpgen.api;
import module java.base;

import fr.kenlek.jpgen.api.data.Buffer;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;
import static java.lang.foreign.MemoryLayout.sequenceLayout;
import static java.lang.foreign.ValueLayout.*;

@Layout.Container("LAYOUT")
public record JavaVMInitArgs(MemorySegment pointer) implements Addressable
{
    public static final StructLayout LAYOUT = makeStructLayout(
        JAVA_INT.withName("version"),
        JAVA_INT.withName("nOptions"),
        ADDRESS.withName("options"),
        JAVA_BOOLEAN.withName("ignoreUnrecognized")
    ).withName("JavaVMInitArgs");
    public static final long OFFSET_version = LAYOUT.byteOffset(PathElement.groupElement("version"));
    public static final long OFFSET_nOptions = LAYOUT.byteOffset(PathElement.groupElement("nOptions"));
    public static final long OFFSET_options = LAYOUT.byteOffset(PathElement.groupElement("options"));
    public static final long OFFSET_ignoreUnrecognized = LAYOUT.byteOffset(PathElement.groupElement("ignoreUnrecognized"));

    public JavaVMInitArgs
    {
        Addressable.checkLayoutConstraints(pointer, LAYOUT);
    }

    public JavaVMInitArgs(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JavaVMInitArgs> buffer(MemorySegment data)
    {
        return Buffer.slices(data, LAYOUT, JavaVMInitArgs::new);
    }

    public static Buffer<JavaVMInitArgs> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocateSlices(allocator, LAYOUT, size, JavaVMInitArgs::new);
    }

    public static JavaVMInitArgs getAtIndex(MemorySegment buffer, long offset, long index)
    {
        return new JavaVMInitArgs(buffer.asSlice(LAYOUT.scale(offset, index), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long offset, long index, JavaVMInitArgs value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, LAYOUT.scale(offset, index), LAYOUT.byteSize());
    }

    public void copyFrom(JavaVMInitArgs other)
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

    public int nOptions()
    {
        return this.pointer().get(JAVA_INT, OFFSET_nOptions);
    }

    public void nOptions(int value)
    {
        this.pointer().set(JAVA_INT, OFFSET_nOptions, value);
    }

    public MemorySegment $nOptions()
    {
        return this.pointer().asSlice(OFFSET_nOptions, JAVA_INT);
    }

    public Buffer<JavaVMOption> options()
    {
        return JavaVMOption.buffer(this.pointer().get(
            ADDRESS.withTargetLayout(sequenceLayout(this.nOptions(), JavaVMOption.LAYOUT)),
            OFFSET_options
        ));
    }

    public void options(Consumer<Buffer<JavaVMOption>> consumer)
    {
        consumer.accept(this.options());
    }

    public void options(Buffer<JavaVMOption> value)
    {
        this.pointer().set(ADDRESS, OFFSET_options, value.pointer());
    }

    public MemorySegment $options()
    {
        return this.pointer().asSlice(OFFSET_options, ADDRESS);
    }

    public boolean ignoreUnrecognized()
    {
        return this.pointer().get(JAVA_BOOLEAN, OFFSET_ignoreUnrecognized);
    }

    public void ignoreUnrecognized(boolean value)
    {
        this.pointer().set(JAVA_BOOLEAN, OFFSET_ignoreUnrecognized, value);
    }

    public MemorySegment $ignoreUnrecognized()
    {
        return this.pointer().asSlice(OFFSET_ignoreUnrecognized, JAVA_BOOLEAN);
    }
}
