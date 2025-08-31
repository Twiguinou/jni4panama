package fr.kenlek.j4p;

import fr.kenlek.jpgen.api.Addressable;
import fr.kenlek.jpgen.api.Buffer;
import fr.kenlek.jpgen.api.dynload.Layout;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.UnionLayout;

import static java.lang.foreign.ValueLayout.*;

import static java.lang.foreign.MemoryLayout.unionLayout;

public record JValue(MemorySegment pointer) implements Addressable
{
    @Layout.Value("LAYOUT")
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
    public static final long OFFSET__z = LAYOUT.byteOffset(PathElement.groupElement("z"));
    public static final long OFFSET__b = LAYOUT.byteOffset(PathElement.groupElement("b"));
    public static final long OFFSET__c = LAYOUT.byteOffset(PathElement.groupElement("c"));
    public static final long OFFSET__s = LAYOUT.byteOffset(PathElement.groupElement("s"));
    public static final long OFFSET__i = LAYOUT.byteOffset(PathElement.groupElement("i"));
    public static final long OFFSET__j = LAYOUT.byteOffset(PathElement.groupElement("j"));
    public static final long OFFSET__f = LAYOUT.byteOffset(PathElement.groupElement("f"));
    public static final long OFFSET__d = LAYOUT.byteOffset(PathElement.groupElement("d"));
    public static final long OFFSET__l = LAYOUT.byteOffset(PathElement.groupElement("l"));

    public JValue
    {
        if (pointer.maxByteAlignment() < LAYOUT.byteAlignment() || pointer.byteSize() != LAYOUT.byteSize())
        {
            throw new IllegalArgumentException("Memory slice does not follow layout constraints.");
        }
    }

    public JValue(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JValue> buffer(MemorySegment data)
    {
        return Buffer.of(data, LAYOUT, JValue::new);
    }

    public static Buffer<JValue> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocate(allocator, LAYOUT, size, JValue::new);
    }

    public static void setAtIndex(MemorySegment buffer, long index, JValue value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, index * LAYOUT.byteSize(), LAYOUT.byteSize());
    }

    public void copyFrom(JValue value)
    {
        MemorySegment.copy(value.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public boolean z()
    {
        return this.pointer().get(JAVA_BOOLEAN, OFFSET__z);
    }

    public void z(boolean value)
    {
        this.pointer().set(JAVA_BOOLEAN, OFFSET__z, value);
    }

    public MemorySegment $z()
    {
        return this.pointer().asSlice(OFFSET__z, JAVA_BOOLEAN);
    }

    public byte b()
    {
        return this.pointer().get(JAVA_BYTE, OFFSET__b);
    }

    public void b(byte value)
    {
        this.pointer().set(JAVA_BYTE, OFFSET__b, value);
    }

    public MemorySegment $b()
    {
        return this.pointer().asSlice(OFFSET__b, JAVA_BYTE);
    }

    public char c()
    {
        return this.pointer().get(JAVA_CHAR, OFFSET__c);
    }

    public void c(char value)
    {
        this.pointer().set(JAVA_CHAR, OFFSET__c, value);
    }

    public MemorySegment $c()
    {
        return this.pointer().asSlice(OFFSET__c, JAVA_CHAR);
    }

    public short s()
    {
        return this.pointer().get(JAVA_SHORT, OFFSET__s);
    }

    public void s(short value)
    {
        this.pointer().set(JAVA_SHORT, OFFSET__s, value);
    }

    public MemorySegment $s()
    {
        return this.pointer().asSlice(OFFSET__s, JAVA_SHORT);
    }

    public int i()
    {
        return this.pointer().get(JAVA_INT, OFFSET__i);
    }

    public void i(int value)
    {
        this.pointer().set(JAVA_INT, OFFSET__i, value);
    }

    public MemorySegment $i()
    {
        return this.pointer().asSlice(OFFSET__i, JAVA_INT);
    }

    public long j()
    {
        return this.pointer().get(JAVA_LONG, OFFSET__j);
    }

    public void j(long value)
    {
        this.pointer().set(JAVA_LONG, OFFSET__j, value);
    }

    public MemorySegment $j()
    {
        return this.pointer().asSlice(OFFSET__j, JAVA_LONG);
    }

    public float f()
    {
        return this.pointer().get(JAVA_FLOAT, OFFSET__f);
    }

    public void f(float value)
    {
        this.pointer().set(JAVA_FLOAT, OFFSET__f, value);
    }

    public MemorySegment $f()
    {
        return this.pointer().asSlice(OFFSET__f, JAVA_FLOAT);
    }

    public double d()
    {
        return this.pointer().get(JAVA_DOUBLE, OFFSET__d);
    }

    public void d(double value)
    {
        this.pointer().set(JAVA_DOUBLE, OFFSET__d, value);
    }

    public MemorySegment $d()
    {
        return this.pointer().asSlice(OFFSET__d, JAVA_DOUBLE);
    }

    public MemorySegment l()
    {
        return this.pointer().get(ADDRESS, OFFSET__l);
    }

    public void l(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__l, value);
    }

    public MemorySegment $l()
    {
        return this.pointer().asSlice(OFFSET__l, ADDRESS);
    }
}
