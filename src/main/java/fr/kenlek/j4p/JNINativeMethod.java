package fr.kenlek.j4p;

import fr.kenlek.jpgen.api.Addressable;
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
        UNBOUNDED_POINTER.withName("name"),
        UNBOUNDED_POINTER.withName("signature"),
        ADDRESS.withName("fnPtr")
    ).withName("JNINativeMethod");
    public static final long MEMBER_OFFSET__name = LAYOUT.byteOffset(PathElement.groupElement("name"));
    public static final long MEMBER_OFFSET__signature = LAYOUT.byteOffset(PathElement.groupElement("signature"));
    public static final long MEMBER_OFFSET__fnPtr = LAYOUT.byteOffset(PathElement.groupElement("fnPtr"));

    public JNINativeMethod(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
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

    public MemorySegment signature()
    {
        return this.pointer().get(UNBOUNDED_POINTER, MEMBER_OFFSET__signature);
    }

    public void signature(MemorySegment value)
    {
        this.pointer().set(UNBOUNDED_POINTER, MEMBER_OFFSET__signature, value);
    }

    public MemorySegment $signature()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__signature, UNBOUNDED_POINTER);
    }

    public MemorySegment fnPtr()
    {
        return this.pointer().get(ADDRESS, MEMBER_OFFSET__fnPtr);
    }

    public void fnPtr(MemorySegment value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__fnPtr, value);
    }

    public MemorySegment $fnPtr()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__fnPtr, ADDRESS);
    }
}
