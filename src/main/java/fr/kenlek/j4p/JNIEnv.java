package fr.kenlek.j4p;

import module fr.kenlek.jpgen.api;
import module java.base;

import fr.kenlek.jpgen.api.data.Buffer;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;
import static java.lang.foreign.ValueLayout.ADDRESS;

@Layout.Container("LAYOUT")
public record JNIEnv(MemorySegment pointer) implements Addressable
{
    public static final StructLayout LAYOUT = makeStructLayout(
        ADDRESS.withName("functions")
    ).withName("JNIEnv_");
    public static final long OFFSET_functions = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("functions"));

    public JNIEnv
    {
        Addressable.checkLayoutConstraints(pointer, LAYOUT);
    }

    public JNIEnv(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JNIEnv> buffer(MemorySegment data)
    {
        return Buffer.slices(data, LAYOUT, JNIEnv::new);
    }

    public static Buffer<JNIEnv> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocateSlices(allocator, LAYOUT, size, JNIEnv::new);
    }

    public static JNIEnv getAtIndex(MemorySegment buffer, long offset, long index)
    {
        return new JNIEnv(buffer.asSlice(LAYOUT.scale(offset, index), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long offset, long index, JNIEnv value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, LAYOUT.scale(offset, index), LAYOUT.byteSize());
    }

    public void copyFrom(JNIEnv other)
    {
        MemorySegment.copy(other.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public JNINativeInterface functions()
    {
        return new JNINativeInterface(this.pointer().get(ADDRESS.withTargetLayout(JNINativeInterface.LAYOUT), OFFSET_functions));
    }

    public void functions(JNINativeInterface value)
    {
        this.pointer().set(ADDRESS, OFFSET_functions, value.pointer());
    }

    public MemorySegment $functions()
    {
        return this.pointer().asSlice(OFFSET_functions, ADDRESS);
    }
}
