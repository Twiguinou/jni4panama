package fr.kenlek.j4p;

import fr.kenlek.jpgen.api.Addressable;
import fr.kenlek.jpgen.api.dynload.Layout;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;

import static java.lang.foreign.ValueLayout.*;

import static fr.kenlek.jpgen.api.ForeignUtils.*;

public record JavaVMOption(MemorySegment pointer) implements Addressable
{
    @Layout.Value("LAYOUT")
    public static final StructLayout LAYOUT = makeStructLayout(
        UNBOUNDED_POINTER.withName("optionString"),
        ADDRESS.withName("extraInfo")
    ).withName("JavaVMOption");
    public static final long MEMBER_OFFSET__optionString = LAYOUT.byteOffset(PathElement.groupElement("optionString"));
    public static final long MEMBER_OFFSET__extraInfo = LAYOUT.byteOffset(PathElement.groupElement("extraInfo"));

    public JavaVMOption(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static JavaVMOption getAtIndex(MemorySegment buffer, long index)
    {
        return new JavaVMOption(buffer.asSlice(index * LAYOUT.byteSize(), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long index, JavaVMOption value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, index * LAYOUT.byteSize(), LAYOUT.byteSize());
    }

    public void copyFrom(JavaVMOption value)
    {
        MemorySegment.copy(value.pointer(), 0, this.pointer(), 0, LAYOUT.byteSize());
    }

    public MemorySegment optionString()
    {
        return this.pointer().get(UNBOUNDED_POINTER, MEMBER_OFFSET__optionString);
    }

    public void optionString(MemorySegment value)
    {
        this.pointer().set(UNBOUNDED_POINTER, MEMBER_OFFSET__optionString, value);
    }

    public MemorySegment $optionString()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__optionString, UNBOUNDED_POINTER);
    }

    public MemorySegment extraInfo()
    {
        return this.pointer().get(ADDRESS, MEMBER_OFFSET__extraInfo);
    }

    public void extraInfo(MemorySegment value)
    {
        this.pointer().set(ADDRESS, MEMBER_OFFSET__extraInfo, value);
    }

    public MemorySegment $extraInfo()
    {
        return this.pointer().asSlice(MEMBER_OFFSET__extraInfo, ADDRESS);
    }
}
