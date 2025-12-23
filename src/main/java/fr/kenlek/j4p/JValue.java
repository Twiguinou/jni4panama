package fr.kenlek.j4p;

import module fr.kenlek.jpgen.api;
import module java.base;

import fr.kenlek.jpgen.api.data.Buffer;

import static java.lang.foreign.MemoryLayout.unionLayout;
import static java.lang.foreign.ValueLayout.*;

@Layout.Container("LAYOUT")
public record JValue(MemorySegment pointer) implements Addressable
{
    public static final UnionLayout LAYOUT = unionLayout(
        JAVA_BOOLEAN.withName("z"),
        JAVA_BYTE.withName("b"),
        JAVA_CHAR.withName("c"),
        JAVA_SHORT.withName("s"),
        JAVA_INT.withName("i"),
        JAVA_LONG.withName("j"),
        JAVA_FLOAT.withName("f"),
        JAVA_DOUBLE.withName("d"),
        ADDRESS.withName("l")
    ).withName("jvalue");
    public static final long OFFSET_z = LAYOUT.byteOffset(PathElement.groupElement("z"));
    public static final long OFFSET_b = LAYOUT.byteOffset(PathElement.groupElement("b"));
    public static final long OFFSET_c = LAYOUT.byteOffset(PathElement.groupElement("c"));
    public static final long OFFSET_s = LAYOUT.byteOffset(PathElement.groupElement("s"));
    public static final long OFFSET_i = LAYOUT.byteOffset(PathElement.groupElement("i"));
    public static final long OFFSET_j = LAYOUT.byteOffset(PathElement.groupElement("j"));
    public static final long OFFSET_f = LAYOUT.byteOffset(PathElement.groupElement("f"));
    public static final long OFFSET_d = LAYOUT.byteOffset(PathElement.groupElement("d"));
    public static final long OFFSET_l = LAYOUT.byteOffset(PathElement.groupElement("l"));

    public JValue
    {
        Addressable.checkLayoutConstraints(pointer, LAYOUT);
    }

    public JValue(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JValue> buffer(MemorySegment data)
    {
        return Buffer.slices(data, LAYOUT, JValue::new);
    }

    public static Buffer<JValue> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocateSlices(allocator, LAYOUT, size, JValue::new);
    }

    public static JValue getAtIndex(MemorySegment buffer, long offset, long index)
    {
        return new JValue(buffer.asSlice(LAYOUT.scale(offset, index), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long offset, long index, JValue value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, LAYOUT.scale(offset, index), LAYOUT.byteSize());
    }

    public void copyFrom(JValue other)
    {
        MemorySegment.copy(other.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public boolean z()
    {
        return this.pointer().get(JAVA_BOOLEAN, OFFSET_z);
    }

    public void z(boolean value)
    {
        this.pointer().set(JAVA_BOOLEAN, OFFSET_z, value);
    }

    public MemorySegment $z()
    {
        return this.pointer().asSlice(OFFSET_z, JAVA_BOOLEAN);
    }

    public byte b()
    {
        return this.pointer().get(JAVA_BYTE, OFFSET_b);
    }

    public void b(byte value)
    {
        this.pointer().set(JAVA_BYTE, OFFSET_b, value);
    }

    public MemorySegment $b()
    {
        return this.pointer().asSlice(OFFSET_b, JAVA_BYTE);
    }

    public char c()
    {
        return this.pointer().get(JAVA_CHAR, OFFSET_c);
    }

    public void c(char value)
    {
        this.pointer().set(JAVA_CHAR, OFFSET_c, value);
    }

    public MemorySegment $c()
    {
        return this.pointer().asSlice(OFFSET_c, JAVA_CHAR);
    }

    public short s()
    {
        return this.pointer().get(JAVA_SHORT, OFFSET_s);
    }

    public void s(short value)
    {
        this.pointer().set(JAVA_SHORT, OFFSET_s, value);
    }

    public MemorySegment $s()
    {
        return this.pointer().asSlice(OFFSET_s, JAVA_SHORT);
    }

    public int i()
    {
        return this.pointer().get(JAVA_INT, OFFSET_i);
    }

    public void i(int value)
    {
        this.pointer().set(JAVA_INT, OFFSET_i, value);
    }

    public MemorySegment $i()
    {
        return this.pointer().asSlice(OFFSET_i, JAVA_INT);
    }

    public long j()
    {
        return this.pointer().get(JAVA_LONG, OFFSET_j);
    }

    public void j(long value)
    {
        this.pointer().set(JAVA_LONG, OFFSET_j, value);
    }

    public MemorySegment $j()
    {
        return this.pointer().asSlice(OFFSET_j, JAVA_LONG);
    }

    public float f()
    {
        return this.pointer().get(JAVA_FLOAT, OFFSET_f);
    }

    public void f(float value)
    {
        this.pointer().set(JAVA_FLOAT, OFFSET_f, value);
    }

    public MemorySegment $f()
    {
        return this.pointer().asSlice(OFFSET_f, JAVA_FLOAT);
    }

    public double d()
    {
        return this.pointer().get(JAVA_DOUBLE, OFFSET_d);
    }

    public void d(double value)
    {
        this.pointer().set(JAVA_DOUBLE, OFFSET_d, value);
    }

    public MemorySegment $d()
    {
        return this.pointer().asSlice(OFFSET_d, JAVA_DOUBLE);
    }

    public MemorySegment l()
    {
        return this.pointer().get(ADDRESS, OFFSET_l);
    }

    public void l(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_l, value);
    }

    public MemorySegment $l()
    {
        return this.pointer().asSlice(OFFSET_l, ADDRESS);
    }
}
