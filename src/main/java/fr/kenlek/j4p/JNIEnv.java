package fr.kenlek.j4p;

import fr.kenlek.jpgen.api.Addressable;
import fr.kenlek.jpgen.api.Buffer;
import fr.kenlek.jpgen.api.dynload.Layout;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;

import static java.lang.foreign.ValueLayout.ADDRESS;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;

public record JNIEnv(MemorySegment pointer) implements Addressable
{
    @Layout.Value("LAYOUT")
    public static final StructLayout LAYOUT = makeStructLayout(
        ADDRESS.withName("functions")
    ).withName("JNIEnv_");
    public static final long OFFSET__functions = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("functions"));

    public JNIEnv
    {
        if (pointer.maxByteAlignment() < LAYOUT.byteAlignment() || pointer.byteSize() != LAYOUT.byteSize())
        {
            throw new IllegalArgumentException("Memory slice does not follow layout constraints.");
        }
    }

    public JNIEnv(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JNIEnv> buffer(MemorySegment data)
    {
        return Buffer.of(data, LAYOUT, JNIEnv::new);
    }

    public static Buffer<JNIEnv> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocate(allocator, LAYOUT, size, JNIEnv::new);
    }

    public static JNIEnv getAtIndex(MemorySegment buffer, long index)
    {
        return new JNIEnv(buffer.asSlice(index * LAYOUT.byteSize(), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long index, JNIEnv value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, index * LAYOUT.byteSize(), LAYOUT.byteSize());
    }

    public void copyFrom(JNIEnv value)
    {
        MemorySegment.copy(value.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public JNINativeInterface functions()
    {
        return new JNINativeInterface(this.pointer().get(ADDRESS.withTargetLayout(JNINativeInterface.LAYOUT), OFFSET__functions));
    }

    public void functions(JNINativeInterface value)
    {
        this.pointer().set(ADDRESS, OFFSET__functions, value.pointer());
    }

    public MemorySegment $functions()
    {
        return this.pointer().asSlice(OFFSET__functions, ADDRESS);
    }
}
