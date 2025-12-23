package fr.kenlek.j4p;

import module fr.kenlek.jpgen.api;
import module java.base;

import fr.kenlek.jpgen.api.data.Buffer;

import static fr.kenlek.jpgen.api.ForeignUtils.*;
import static java.lang.foreign.ValueLayout.*;

@Layout.Container("LAYOUT")
public record JNINativeMethod(MemorySegment pointer) implements Addressable
{
    public static final StructLayout LAYOUT = makeStructLayout(
        ADDRESS.withName("name"),
        ADDRESS.withName("signature"),
        ADDRESS.withName("fnPtr")
    ).withName("JNINativeMethod");
    public static final long OFFSET_name = LAYOUT.byteOffset(PathElement.groupElement("name"));
    public static final long OFFSET_signature = LAYOUT.byteOffset(PathElement.groupElement("signature"));
    public static final long OFFSET_fnPtr = LAYOUT.byteOffset(PathElement.groupElement("fnPtr"));

    public JNINativeMethod
    {
        Addressable.checkLayoutConstraints(pointer, LAYOUT);
    }

    public JNINativeMethod(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JNINativeMethod> buffer(MemorySegment data)
    {
        return Buffer.slices(data, LAYOUT, JNINativeMethod::new);
    }

    public static Buffer<JNINativeMethod> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocateSlices(allocator, LAYOUT, size, JNINativeMethod::new);
    }

    public static JNINativeMethod getAtIndex(MemorySegment buffer, long offset, long index)
    {
        return new JNINativeMethod(buffer.asSlice(LAYOUT.scale(offset, index), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long offset, long index, JNINativeMethod value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, LAYOUT.scale(offset, index), LAYOUT.byteSize());
    }

    public void copyFrom(JNINativeMethod other)
    {
        MemorySegment.copy(other.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
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

    public MemorySegment signature()
    {
        return this.pointer().get(UNBOUNDED_POINTER, OFFSET_signature);
    }

    public void signature(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_signature, value);
    }

    public MemorySegment $signature()
    {
        return this.pointer().asSlice(OFFSET_signature, ADDRESS);
    }

    public MemorySegment fnPtr()
    {
        return this.pointer().get(ADDRESS, OFFSET_fnPtr);
    }

    public void fnPtr(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_fnPtr, value);
    }

    public MemorySegment $fnPtr()
    {
        return this.pointer().asSlice(OFFSET_fnPtr, ADDRESS);
    }
}
