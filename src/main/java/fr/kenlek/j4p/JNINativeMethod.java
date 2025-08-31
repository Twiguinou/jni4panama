package fr.kenlek.j4p;

import fr.kenlek.jpgen.api.Addressable;
import fr.kenlek.jpgen.api.Buffer;
import fr.kenlek.jpgen.api.dynload.Layout;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;

import static java.lang.foreign.ValueLayout.*;

import static fr.kenlek.jpgen.api.ForeignUtils.*;

public record JNINativeMethod(MemorySegment pointer) implements Addressable
{
    @Layout.Value("LAYOUT")
    public static final StructLayout LAYOUT = makeStructLayout(
        ADDRESS.withName("name"),
        ADDRESS.withName("signature"),
        ADDRESS.withName("fnPtr")
    ).withName("JNINativeMethod");
    public static final long OFFSET__name = LAYOUT.byteOffset(PathElement.groupElement("name"));
    public static final long OFFSET__signature = LAYOUT.byteOffset(PathElement.groupElement("signature"));
    public static final long OFFSET__fnPtr = LAYOUT.byteOffset(PathElement.groupElement("fnPtr"));

    public JNINativeMethod
    {
        if (pointer.maxByteAlignment() < LAYOUT.byteAlignment() || pointer.byteSize() != LAYOUT.byteSize())
        {
            throw new IllegalArgumentException("Memory slice does not follow layout constraints.");
        }
    }

    public JNINativeMethod(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JNINativeMethod> buffer(MemorySegment data)
    {
        return Buffer.of(data, LAYOUT, JNINativeMethod::new);
    }

    public static Buffer<JNINativeMethod> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocate(allocator, LAYOUT, size, JNINativeMethod::new);
    }

    public static JNINativeMethod getAtIndex(MemorySegment buffer, long index)
    {
        return new JNINativeMethod(buffer.asSlice(index * LAYOUT.byteSize(), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long index, JNINativeMethod value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, index * LAYOUT.byteSize(), LAYOUT.byteSize());
    }

    public void copyFrom(JNINativeMethod value)
    {
        MemorySegment.copy(value.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
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

    public MemorySegment signature()
    {
        return this.pointer().get(UNBOUNDED_POINTER, OFFSET__signature);
    }

    public void signature(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__signature, value);
    }

    public MemorySegment $signature()
    {
        return this.pointer().asSlice(OFFSET__signature, ADDRESS);
    }

    public MemorySegment fnPtr()
    {
        return this.pointer().get(ADDRESS, OFFSET__fnPtr);
    }

    public void fnPtr(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__fnPtr, value);
    }

    public MemorySegment $fnPtr()
    {
        return this.pointer().asSlice(OFFSET__fnPtr, ADDRESS);
    }
}
