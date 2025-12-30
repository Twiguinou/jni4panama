package fr.kenlek.j4p;

import module fr.kenlek.jpgen.api;
import module java.base;

import fr.kenlek.jpgen.api.data.Buffer;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;
import static java.lang.foreign.ValueLayout.ADDRESS;

@Layout.Container("LAYOUT")
public record JNIInvokeInterface(MemorySegment pointer) implements Addressable
{
    public static final StructLayout LAYOUT = makeStructLayout(
        ADDRESS.withName("reserved0"),
        ADDRESS.withName("reserved1"),
        ADDRESS.withName("reserved2"),
        ADDRESS.withName("DestroyJavaVM"),
        ADDRESS.withName("AttachCurrentThread"),
        ADDRESS.withName("DetachCurrentThread"),
        ADDRESS.withName("GetEnv"),
        ADDRESS.withName("AttachCurrentThreadAsDaemon")
    ).withName("JNIInvokeInterface_");
    public static final long OFFSET_reserved0 = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("reserved0"));
    public static final long OFFSET_reserved1 = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("reserved1"));
    public static final long OFFSET_reserved2 = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("reserved2"));
    public static final long OFFSET_DestroyJavaVM = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("DestroyJavaVM"));
    public static final long OFFSET_AttachCurrentThread = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("AttachCurrentThread"));
    public static final long OFFSET_DetachCurrentThread = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("DetachCurrentThread"));
    public static final long OFFSET_GetEnv = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("GetEnv"));
    public static final long OFFSET_AttachCurrentThreadAsDaemon = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("AttachCurrentThreadAsDaemon"));

    public JNIInvokeInterface
    {
        Addressable.checkLayoutConstraints(pointer, LAYOUT);
    }

    public JNIInvokeInterface(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JNIInvokeInterface> buffer(MemorySegment data)
    {
        return Buffer.slices(data, LAYOUT, JNIInvokeInterface::new);
    }

    public static Buffer<JNIInvokeInterface> buffer(SegmentAllocator allocator, long size)
    {
        return Buffer.slices(allocator, LAYOUT, size, JNIInvokeInterface::new);
    }

    @Override
    public StructLayout layout()
    {
        return LAYOUT;
    }

    public void copyFrom(JNIInvokeInterface other)
    {
        MemorySegment.copy(other.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public MemorySegment reserved0()
    {
        return this.pointer().get(ADDRESS, OFFSET_reserved0);
    }

    public void reserved0(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_reserved0, value);
    }

    public MemorySegment $reserved0()
    {
        return this.pointer().asSlice(OFFSET_reserved0, ADDRESS);
    }

    public MemorySegment reserved1()
    {
        return this.pointer().get(ADDRESS, OFFSET_reserved1);
    }

    public void reserved1(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_reserved1, value);
    }

    public MemorySegment $reserved1()
    {
        return this.pointer().asSlice(OFFSET_reserved1, ADDRESS);
    }

    public MemorySegment reserved2()
    {
        return this.pointer().get(ADDRESS, OFFSET_reserved2);
    }

    public void reserved2(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_reserved2, value);
    }

    public MemorySegment $reserved2()
    {
        return this.pointer().asSlice(OFFSET_reserved2, ADDRESS);
    }

    public MemorySegment DestroyJavaVM()
    {
        return this.pointer().get(ADDRESS, OFFSET_DestroyJavaVM);
    }

    public void DestroyJavaVM(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_DestroyJavaVM, value);
    }

    public MemorySegment $DestroyJavaVM()
    {
        return this.pointer().asSlice(OFFSET_DestroyJavaVM, ADDRESS);
    }

    public MemorySegment AttachCurrentThread()
    {
        return this.pointer().get(ADDRESS, OFFSET_AttachCurrentThread);
    }

    public void AttachCurrentThread(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_AttachCurrentThread, value);
    }

    public MemorySegment $AttachCurrentThread()
    {
        return this.pointer().asSlice(OFFSET_AttachCurrentThread, ADDRESS);
    }

    public MemorySegment DetachCurrentThread()
    {
        return this.pointer().get(ADDRESS, OFFSET_DetachCurrentThread);
    }

    public void DetachCurrentThread(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_DetachCurrentThread, value);
    }

    public MemorySegment $DetachCurrentThread()
    {
        return this.pointer().asSlice(OFFSET_DetachCurrentThread, ADDRESS);
    }

    public MemorySegment GetEnv()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetEnv);
    }

    public void GetEnv(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetEnv, value);
    }

    public MemorySegment $GetEnv()
    {
        return this.pointer().asSlice(OFFSET_GetEnv, ADDRESS);
    }

    public MemorySegment AttachCurrentThreadAsDaemon()
    {
        return this.pointer().get(ADDRESS, OFFSET_AttachCurrentThreadAsDaemon);
    }

    public void AttachCurrentThreadAsDaemon(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_AttachCurrentThreadAsDaemon, value);
    }

    public MemorySegment $AttachCurrentThreadAsDaemon()
    {
        return this.pointer().asSlice(OFFSET_AttachCurrentThreadAsDaemon, ADDRESS);
    }
}
