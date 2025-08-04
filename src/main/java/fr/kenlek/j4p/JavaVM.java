package fr.kenlek.j4p;

import fr.kenlek.jpgen.api.Addressable;
import fr.kenlek.jpgen.api.dynload.Layout;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;

import static java.lang.foreign.ValueLayout.ADDRESS;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;

public record JavaVM(MemorySegment pointer) implements Addressable
{
    @Layout.Value("LAYOUT")
    public static final StructLayout LAYOUT = makeStructLayout(
        ADDRESS.withName("functions")
    ).withName("JavaVM_");
    public static final long MEMBER_OFFSET__functions = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("functions"));

    public JavaVM(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static JavaVM getAtIndex(MemorySegment buffer, long index)
    {
        return new JavaVM(buffer.asSlice(index * LAYOUT.byteSize(), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long index, JavaVM value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, index * LAYOUT.byteSize(), LAYOUT.byteSize());
    }

    public void copyFrom(JavaVM value)
    {
        MemorySegment.copy(value.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public JNIInvokeInterface functions()
    {
        return new JNIInvokeInterface(this.pointer().get(ADDRESS, MEMBER_OFFSET__functions).reinterpret(JNIInvokeInterface.LAYOUT.byteSize()));
    }

    public void functions(JNIInvokeInterface value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__functions, value.pointer());
    }

    public MemorySegment $functions()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__functions, ADDRESS);
    }
}
