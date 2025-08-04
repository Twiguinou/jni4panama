package fr.kenlek.j4p.awt;

import fr.kenlek.jpgen.api.Addressable;
import fr.kenlek.jpgen.api.dynload.Layout;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.foreign.ValueLayout;

import static java.lang.foreign.ValueLayout.*;

import static fr.kenlek.jpgen.api.ForeignUtils.*;
import static java.util.Objects.requireNonNull;

public record JAWTX11DrawingSurfaceInfo(MemorySegment pointer) implements Addressable
{
    private static final ValueLayout XLIB_ID_LAYOUT = (ValueLayout) requireNonNull(
        SYSTEM_LINKER.canonicalLayouts().get("long"),
        "Unable to resolve xlib identifier memory layout."
    );
    @Layout.Value("LAYOUT")
    public static final StructLayout LAYOUT = makeStructLayout(
        XLIB_ID_LAYOUT.withName("drawable"),
        ADDRESS.withName("display"),
        XLIB_ID_LAYOUT.withName("visualID"),
        XLIB_ID_LAYOUT.withName("colormapID"),
        JAVA_INT.withName("depth"),
        ADDRESS.withName("GetAWTColor")
    ).withName("JAWT_X11DrawingSurfaceInfo");
    public static final long MEMBER_OFFSET__drawable = LAYOUT.byteOffset(PathElement.groupElement("drawable"));
    public static final long MEMBER_OFFSET__display = LAYOUT.byteOffset(PathElement.groupElement("display"));
    public static final long MEMBER_OFFSET__visualID = LAYOUT.byteOffset(PathElement.groupElement("visualID"));
    public static final long MEMBER_OFFSET__colormapID = LAYOUT.byteOffset(PathElement.groupElement("colormapID"));
    public static final long MEMBER_OFFSET__depth = LAYOUT.byteOffset(PathElement.groupElement("depth"));
    public static final long MEMBER_OFFSET__GetAWTColor = LAYOUT.byteOffset(PathElement.groupElement("GetAWTColor"));

    public JAWTX11DrawingSurfaceInfo(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static JAWTX11DrawingSurfaceInfo getAtIndex(MemorySegment buffer, long index)
    {
        return new JAWTX11DrawingSurfaceInfo(buffer.asSlice(index * LAYOUT.byteSize(), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long index, JAWTX11DrawingSurfaceInfo value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, index * LAYOUT.byteSize(), LAYOUT.byteSize());
    }

    public void copyFrom(JAWTX11DrawingSurfaceInfo value)
    {
        MemorySegment.copy(value.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public MemorySegment $drawable()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__drawable, XLIB_ID_LAYOUT);
    }

    public MemorySegment display()
    {
        return this.pointer().get(ADDRESS, MEMBER_OFFSET__display);
    }

    public void display(MemorySegment value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__display, value);
    }

    public MemorySegment $display()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__display, ADDRESS);
    }

    public MemorySegment $visualID()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__visualID, XLIB_ID_LAYOUT);
    }

    public MemorySegment $colormapID()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__colormapID, XLIB_ID_LAYOUT);
    }

    public int depth()
    {
        return this.pointer().get(JAVA_INT, MEMBER_OFFSET__depth);
    }

    public void depth(int value)
    {
        this.pointer().set(JAVA_INT, MEMBER_OFFSET__depth, value);
    }

    public MemorySegment $depth()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__depth, JAVA_INT);
    }

    public MemorySegment GetAWTColor()
    {
        return this.pointer().get(ADDRESS, MEMBER_OFFSET__GetAWTColor);
    }

    public void GetAWTColor(MemorySegment value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__GetAWTColor, value);
    }

    public MemorySegment $GetAWTColor()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__GetAWTColor, ADDRESS);
    }
}
