package fr.kenlek.j4p.awt;

import module fr.kenlek.jpgen.api;
import module java.base;

import fr.kenlek.jpgen.api.Buffer;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;
import static java.lang.foreign.MemoryLayout.unionLayout;
import static java.lang.foreign.ValueLayout.*;

@Layout.Container("LAYOUT")
public record JAWTWin32DrawingSurfaceInfo(MemorySegment pointer) implements Addressable
{
    public static final StructLayout LAYOUT = makeStructLayout(
        unionLayout(
            ADDRESS.withName("hwnd"),
            ADDRESS.withName("hbitmap"),
            ADDRESS.withName("pbits")
        ),
        ADDRESS.withName("hdc"),
        ADDRESS.withName("hpalette")
    ).withName("JAWT_Win32DrawingSurfaceInfo");
    public static final long OFFSET_hwnd = LAYOUT.byteOffset(PathElement.groupElement(0), PathElement.groupElement("hwnd"));
    public static final long OFFSET_hbitmap = LAYOUT.byteOffset(PathElement.groupElement(0), PathElement.groupElement("hbitmap"));
    public static final long OFFSET_pbits = LAYOUT.byteOffset(PathElement.groupElement(0), PathElement.groupElement("pbits"));
    public static final long OFFSET_hdc = LAYOUT.byteOffset(PathElement.groupElement("hdc"));
    public static final long OFFSET_hpalette = LAYOUT.byteOffset(PathElement.groupElement("hpalette"));

    public JAWTWin32DrawingSurfaceInfo
    {
        Addressable.checkLayoutConstraints(pointer, LAYOUT);
    }

    public JAWTWin32DrawingSurfaceInfo(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JAWTWin32DrawingSurfaceInfo> buffer(MemorySegment data)
    {
        return Buffer.slices(data, LAYOUT, JAWTWin32DrawingSurfaceInfo::new);
    }

    public static Buffer<JAWTWin32DrawingSurfaceInfo> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocateSlices(allocator, LAYOUT, size, JAWTWin32DrawingSurfaceInfo::new);
    }

    public static JAWTWin32DrawingSurfaceInfo getAtIndex(MemorySegment buffer, long offset, long index)
    {
        return new JAWTWin32DrawingSurfaceInfo(buffer.asSlice(LAYOUT.scale(offset, index), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long offset, long index, JAWTWin32DrawingSurfaceInfo value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, LAYOUT.scale(offset, index), LAYOUT.byteSize());
    }

    public void copyFrom(JAWTWin32DrawingSurfaceInfo other)
    {
        MemorySegment.copy(other.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public MemorySegment hwnd()
    {
        return this.pointer().get(ADDRESS, OFFSET_hwnd);
    }

    public void hwnd(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_hwnd, value);
    }

    public MemorySegment $hwnd()
    {
        return this.pointer().asSlice(OFFSET_hwnd, ADDRESS);
    }

    public MemorySegment hbitmap()
    {
        return this.pointer().get(ADDRESS, OFFSET_hbitmap);
    }

    public void hbitmap(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_hbitmap, value);
    }

    public MemorySegment $hbitmap()
    {
        return this.pointer().asSlice(OFFSET_hbitmap, ADDRESS);
    }

    public MemorySegment pbits()
    {
        return this.pointer().get(ADDRESS, OFFSET_pbits);
    }

    public void pbits(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_pbits, value);
    }

    public MemorySegment $pbits()
    {
        return this.pointer().asSlice(OFFSET_pbits, ADDRESS);
    }

    public MemorySegment hdc()
    {
        return this.pointer().get(ADDRESS, OFFSET_hdc);
    }

    public void hdc(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_hdc, value);
    }

    public MemorySegment $hdc()
    {
        return this.pointer().asSlice(OFFSET_hdc, ADDRESS);
    }

    public MemorySegment hpalette()
    {
        return this.pointer().get(ADDRESS, OFFSET_hpalette);
    }

    public void hpalette(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_hpalette, value);
    }

    public MemorySegment $hpalette()
    {
        return this.pointer().asSlice(OFFSET_hpalette, ADDRESS);
    }
}
