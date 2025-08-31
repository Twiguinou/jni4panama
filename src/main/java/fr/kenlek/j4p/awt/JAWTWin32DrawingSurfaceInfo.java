package fr.kenlek.j4p.awt;

import fr.kenlek.jpgen.api.Addressable;
import fr.kenlek.jpgen.api.Buffer;
import fr.kenlek.jpgen.api.dynload.Layout;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;

import static java.lang.foreign.ValueLayout.*;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;
import static java.lang.foreign.MemoryLayout.unionLayout;

public record JAWTWin32DrawingSurfaceInfo(MemorySegment pointer) implements Addressable
{
    @Layout.Value("LAYOUT")
    public static final StructLayout LAYOUT = makeStructLayout(
        unionLayout(
            ADDRESS.withName("hwnd"),
            ADDRESS.withName("hbitmap"),
            ADDRESS.withName("pbits")
        ),
        ADDRESS.withName("hdc"),
        ADDRESS.withName("hpalette")
    ).withName("JAWT_Win32DrawingSurfaceInfo");
    public static final long OFFSET__hwnd = LAYOUT.byteOffset(PathElement.groupElement(0), PathElement.groupElement("hwnd"));
    public static final long OFFSET__hbitmap = LAYOUT.byteOffset(PathElement.groupElement(0), PathElement.groupElement("hbitmap"));
    public static final long OFFSET__pbits = LAYOUT.byteOffset(PathElement.groupElement(0), PathElement.groupElement("pbits"));
    public static final long OFFSET__hdc = LAYOUT.byteOffset(PathElement.groupElement("hdc"));
    public static final long OFFSET__hpalette = LAYOUT.byteOffset(PathElement.groupElement("hpalette"));

    public JAWTWin32DrawingSurfaceInfo
    {
        if (pointer.maxByteAlignment() < LAYOUT.byteAlignment() || pointer.byteSize() != LAYOUT.byteSize())
        {
            throw new IllegalArgumentException("Memory slice does not follow layout constraints.");
        }
    }

    public JAWTWin32DrawingSurfaceInfo(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JAWTWin32DrawingSurfaceInfo> buffer(MemorySegment data)
    {
        return Buffer.of(data, LAYOUT, JAWTWin32DrawingSurfaceInfo::new);
    }

    public static Buffer<JAWTWin32DrawingSurfaceInfo> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocate(allocator, LAYOUT, size, JAWTWin32DrawingSurfaceInfo::new);
    }

    public static JAWTWin32DrawingSurfaceInfo getAtIndex(MemorySegment buffer, long index)
    {
        return new JAWTWin32DrawingSurfaceInfo(buffer.asSlice(index * LAYOUT.byteSize(), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long index, JAWTWin32DrawingSurfaceInfo value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, index * LAYOUT.byteSize(), LAYOUT.byteSize());
    }

    public void copyFrom(JAWTWin32DrawingSurfaceInfo value)
    {
        MemorySegment.copy(value.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public MemorySegment hwnd()
    {
        return this.pointer().get(ADDRESS, OFFSET__hwnd);
    }

    public void hwnd(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__hwnd, value);
    }

    public MemorySegment $hwnd()
    {
        return this.pointer().asSlice(OFFSET__hwnd, ADDRESS);
    }

    public MemorySegment hbitmap()
    {
        return this.pointer().get(ADDRESS, OFFSET__hbitmap);
    }

    public void hbitmap(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__hbitmap, value);
    }

    public MemorySegment $hbitmap()
    {
        return this.pointer().asSlice(OFFSET__hbitmap, ADDRESS);
    }

    public MemorySegment pbits()
    {
        return this.pointer().get(ADDRESS, OFFSET__pbits);
    }

    public void pbits(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__pbits, value);
    }

    public MemorySegment $pbits()
    {
        return this.pointer().asSlice(OFFSET__pbits, ADDRESS);
    }

    public MemorySegment hdc()
    {
        return this.pointer().get(ADDRESS, OFFSET__hdc);
    }

    public void hdc(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__hdc, value);
    }

    public MemorySegment $hdc()
    {
        return this.pointer().asSlice(OFFSET__hdc, ADDRESS);
    }

    public MemorySegment hpalette()
    {
        return this.pointer().get(ADDRESS, OFFSET__hpalette);
    }

    public void hpalette(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__hpalette, value);
    }

    public MemorySegment $hpalette()
    {
        return this.pointer().asSlice(OFFSET__hpalette, ADDRESS);
    }
}
