package fr.kenlek.j4p;

import module fr.kenlek.jpgen.api;
import module java.base;

import fr.kenlek.jpgen.api.data.Buffer;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;
import static java.lang.foreign.ValueLayout.ADDRESS;

@Layout.Container("LAYOUT")
public record JavaVM(MemorySegment pointer) implements Addressable
{
    public static final StructLayout LAYOUT = makeStructLayout(
        ADDRESS.withName("functions")
    ).withName("JavaVM_");
    public static final long OFFSET_functions = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("functions"));

    public JavaVM
    {
        Addressable.checkLayoutConstraints(pointer, LAYOUT);
    }

    public JavaVM(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JavaVM> buffer(MemorySegment data)
    {
        return Buffer.slices(data, LAYOUT, JavaVM::new);
    }

    public static Buffer<JavaVM> buffer(SegmentAllocator allocator, long size)
    {
        return Buffer.slices(allocator, LAYOUT, size, JavaVM::new);
    }

    @Override
    public StructLayout layout()
    {
        return LAYOUT;
    }

    public void copyFrom(JavaVM other)
    {
        MemorySegment.copy(other.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public JNIInvokeInterface functions()
    {
        return new JNIInvokeInterface(this.pointer().get(ADDRESS.withTargetLayout(JNIInvokeInterface.LAYOUT), OFFSET_functions));
    }

    public void functions(JNIInvokeInterface value)
    {
        this.pointer().set(ADDRESS, OFFSET_functions, value.pointer());
    }

    public MemorySegment $functions()
    {
        return this.pointer().asSlice(OFFSET_functions, ADDRESS);
    }
}
