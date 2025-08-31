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

public record JNIInvokeInterface(MemorySegment pointer) implements Addressable
{
    @Layout.Value("LAYOUT")
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
    public static final long OFFSET__reserved0 = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("reserved0"));
    public static final long OFFSET__reserved1 = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("reserved1"));
    public static final long OFFSET__reserved2 = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("reserved2"));
    public static final long OFFSET__DestroyJavaVM = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("DestroyJavaVM"));
    public static final long OFFSET__AttachCurrentThread = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("AttachCurrentThread"));
    public static final long OFFSET__DetachCurrentThread = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("DetachCurrentThread"));
    public static final long OFFSET__GetEnv = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("GetEnv"));
    public static final long OFFSET__AttachCurrentThreadAsDaemon = LAYOUT.byteOffset(MemoryLayout.PathElement.groupElement("AttachCurrentThreadAsDaemon"));

    public JNIInvokeInterface
    {
        if (pointer.maxByteAlignment() < LAYOUT.byteAlignment() || pointer.byteSize() != LAYOUT.byteSize())
        {
            throw new IllegalArgumentException("Memory slice does not follow layout constraints.");
        }
    }

    public JNIInvokeInterface(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JNIInvokeInterface> buffer(MemorySegment data)
    {
        return Buffer.of(data, LAYOUT, JNIInvokeInterface::new);
    }

    public static Buffer<JNIInvokeInterface> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocate(allocator, LAYOUT, size, JNIInvokeInterface::new);
    }

    public static JNIInvokeInterface getAtIndex(MemorySegment buffer, long index)
    {
        return new JNIInvokeInterface(buffer.asSlice(index * LAYOUT.byteSize(), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long index, JNIInvokeInterface value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, index * LAYOUT.byteSize(), LAYOUT.byteSize());
    }

    public void copyFrom(JNIInvokeInterface value)
    {
        MemorySegment.copy(value.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public MemorySegment reserved0()
    {
        return this.pointer().get(ADDRESS, OFFSET__reserved0);
    }

    public void reserved0(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__reserved0, value);
    }

    public MemorySegment $reserved0()
    {
        return this.pointer().asSlice(OFFSET__reserved0, ADDRESS);
    }

    public MemorySegment reserved1()
    {
        return this.pointer().get(ADDRESS, OFFSET__reserved1);
    }

    public void reserved1(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__reserved1, value);
    }

    public MemorySegment $reserved1()
    {
        return this.pointer().asSlice(OFFSET__reserved1, ADDRESS);
    }

    public MemorySegment reserved2()
    {
        return this.pointer().get(ADDRESS, OFFSET__reserved2);
    }

    public void reserved2(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__reserved2, value);
    }

    public MemorySegment $reserved2()
    {
        return this.pointer().asSlice(OFFSET__reserved2, ADDRESS);
    }

    public MemorySegment DestroyJavaVM()
    {
        return this.pointer().get(ADDRESS, OFFSET__DestroyJavaVM);
    }

    public void DestroyJavaVM(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__DestroyJavaVM, value);
    }

    public MemorySegment $DestroyJavaVM()
    {
        return this.pointer().asSlice(OFFSET__DestroyJavaVM, ADDRESS);
    }

    public MemorySegment AttachCurrentThread()
    {
        return this.pointer().get(ADDRESS, OFFSET__AttachCurrentThread);
    }

    public void AttachCurrentThread(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__AttachCurrentThread, value);
    }

    public MemorySegment $AttachCurrentThread()
    {
        return this.pointer().asSlice(OFFSET__AttachCurrentThread, ADDRESS);
    }

    public MemorySegment DetachCurrentThread()
    {
        return this.pointer().get(ADDRESS, OFFSET__DetachCurrentThread);
    }

    public void DetachCurrentThread(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__DetachCurrentThread, value);
    }

    public MemorySegment $DetachCurrentThread()
    {
        return this.pointer().asSlice(OFFSET__DetachCurrentThread, ADDRESS);
    }

    public MemorySegment GetEnv()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetEnv);
    }

    public void GetEnv(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetEnv, value);
    }

    public MemorySegment $GetEnv()
    {
        return this.pointer().asSlice(OFFSET__GetEnv, ADDRESS);
    }

    public MemorySegment AttachCurrentThreadAsDaemon()
    {
        return this.pointer().get(ADDRESS, OFFSET__AttachCurrentThreadAsDaemon);
    }

    public void AttachCurrentThreadAsDaemon(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__AttachCurrentThreadAsDaemon, value);
    }

    public MemorySegment $AttachCurrentThreadAsDaemon()
    {
        return this.pointer().asSlice(OFFSET__AttachCurrentThreadAsDaemon, ADDRESS);
    }
}
