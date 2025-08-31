package fr.kenlek.j4p;

import fr.kenlek.jpgen.api.Addressable;
import fr.kenlek.jpgen.api.Buffer;
import fr.kenlek.jpgen.api.dynload.Layout;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;

import static java.lang.foreign.ValueLayout.*;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;

public record JNINativeInterface(MemorySegment pointer) implements Addressable
{
    @Layout.Value("LAYOUT")
    public static final StructLayout LAYOUT = makeStructLayout(
        ADDRESS.withName("reserved0"),
        ADDRESS.withName("reserved1"),
        ADDRESS.withName("reserved2"),
        ADDRESS.withName("reserved3"),
        ADDRESS.withName("GetVersion"),
        ADDRESS.withName("DefineClass"),
        ADDRESS.withName("FindClass"),
        ADDRESS.withName("FromReflectedMethod"),
        ADDRESS.withName("FromReflectedField"),
        ADDRESS.withName("ToReflectedMethod"),
        ADDRESS.withName("GetSuperclass"),
        ADDRESS.withName("IsAssignableFrom"),
        ADDRESS.withName("ToReflectedField"),
        ADDRESS.withName("Throw"),
        ADDRESS.withName("ThrowNew"),
        ADDRESS.withName("ExceptionOccurred"),
        ADDRESS.withName("ExceptionDescribe"),
        ADDRESS.withName("ExceptionClear"),
        ADDRESS.withName("FatalError"),
        ADDRESS.withName("PushLocalFrame"),
        ADDRESS.withName("PopLocalFrame"),
        ADDRESS.withName("NewGlobalRef"),
        ADDRESS.withName("DeleteGlobalRef"),
        ADDRESS.withName("DeleteLocalRef"),
        ADDRESS.withName("IsSameObject"),
        ADDRESS.withName("NewLocalRef"),
        ADDRESS.withName("EnsureLocalCapacity"),
        ADDRESS.withName("AllocObject"),
        ADDRESS.withName("NewObject"),
        ADDRESS.withName("NewObjectV"),
        ADDRESS.withName("NewObjectA"),
        ADDRESS.withName("GetObjectClass"),
        ADDRESS.withName("IsInstanceOf"),
        ADDRESS.withName("GetMethodID"),
        ADDRESS.withName("CallObjectMethod"),
        ADDRESS.withName("CallObjectMethodV"),
        ADDRESS.withName("CallObjectMethodA"),
        ADDRESS.withName("CallBooleanMethod"),
        ADDRESS.withName("CallBooleanMethodV"),
        ADDRESS.withName("CallBooleanMethodA"),
        ADDRESS.withName("CallByteMethod"),
        ADDRESS.withName("CallByteMethodV"),
        ADDRESS.withName("CallByteMethodA"),
        ADDRESS.withName("CallCharMethod"),
        ADDRESS.withName("CallCharMethodV"),
        ADDRESS.withName("CallCharMethodA"),
        ADDRESS.withName("CallShortMethod"),
        ADDRESS.withName("CallShortMethodV"),
        ADDRESS.withName("CallShortMethodA"),
        ADDRESS.withName("CallIntMethod"),
        ADDRESS.withName("CallIntMethodV"),
        ADDRESS.withName("CallIntMethodA"),
        ADDRESS.withName("CallLongMethod"),
        ADDRESS.withName("CallLongMethodV"),
        ADDRESS.withName("CallLongMethodA"),
        ADDRESS.withName("CallFloatMethod"),
        ADDRESS.withName("CallFloatMethodV"),
        ADDRESS.withName("CallFloatMethodA"),
        ADDRESS.withName("CallDoubleMethod"),
        ADDRESS.withName("CallDoubleMethodV"),
        ADDRESS.withName("CallDoubleMethodA"),
        ADDRESS.withName("CallVoidMethod"),
        ADDRESS.withName("CallVoidMethodV"),
        ADDRESS.withName("CallVoidMethodA"),
        ADDRESS.withName("CallNonvirtualObjectMethod"),
        ADDRESS.withName("CallNonvirtualObjectMethodV"),
        ADDRESS.withName("CallNonvirtualObjectMethodA"),
        ADDRESS.withName("CallNonvirtualBooleanMethod"),
        ADDRESS.withName("CallNonvirtualBooleanMethodV"),
        ADDRESS.withName("CallNonvirtualBooleanMethodA"),
        ADDRESS.withName("CallNonvirtualByteMethod"),
        ADDRESS.withName("CallNonvirtualByteMethodV"),
        ADDRESS.withName("CallNonvirtualByteMethodA"),
        ADDRESS.withName("CallNonvirtualCharMethod"),
        ADDRESS.withName("CallNonvirtualCharMethodV"),
        ADDRESS.withName("CallNonvirtualCharMethodA"),
        ADDRESS.withName("CallNonvirtualShortMethod"),
        ADDRESS.withName("CallNonvirtualShortMethodV"),
        ADDRESS.withName("CallNonvirtualShortMethodA"),
        ADDRESS.withName("CallNonvirtualIntMethod"),
        ADDRESS.withName("CallNonvirtualIntMethodV"),
        ADDRESS.withName("CallNonvirtualIntMethodA"),
        ADDRESS.withName("CallNonvirtualLongMethod"),
        ADDRESS.withName("CallNonvirtualLongMethodV"),
        ADDRESS.withName("CallNonvirtualLongMethodA"),
        ADDRESS.withName("CallNonvirtualFloatMethod"),
        ADDRESS.withName("CallNonvirtualFloatMethodV"),
        ADDRESS.withName("CallNonvirtualFloatMethodA"),
        ADDRESS.withName("CallNonvirtualDoubleMethod"),
        ADDRESS.withName("CallNonvirtualDoubleMethodV"),
        ADDRESS.withName("CallNonvirtualDoubleMethodA"),
        ADDRESS.withName("CallNonvirtualVoidMethod"),
        ADDRESS.withName("CallNonvirtualVoidMethodV"),
        ADDRESS.withName("CallNonvirtualVoidMethodA"),
        ADDRESS.withName("GetFieldID"),
        ADDRESS.withName("GetObjectField"),
        ADDRESS.withName("GetBooleanField"),
        ADDRESS.withName("GetByteField"),
        ADDRESS.withName("GetCharField"),
        ADDRESS.withName("GetShortField"),
        ADDRESS.withName("GetIntField"),
        ADDRESS.withName("GetLongField"),
        ADDRESS.withName("GetFloatField"),
        ADDRESS.withName("GetDoubleField"),
        ADDRESS.withName("SetObjectField"),
        ADDRESS.withName("SetBooleanField"),
        ADDRESS.withName("SetByteField"),
        ADDRESS.withName("SetCharField"),
        ADDRESS.withName("SetShortField"),
        ADDRESS.withName("SetIntField"),
        ADDRESS.withName("SetLongField"),
        ADDRESS.withName("SetFloatField"),
        ADDRESS.withName("SetDoubleField"),
        ADDRESS.withName("GetStaticMethodID"),
        ADDRESS.withName("CallStaticObjectMethod"),
        ADDRESS.withName("CallStaticObjectMethodV"),
        ADDRESS.withName("CallStaticObjectMethodA"),
        ADDRESS.withName("CallStaticBooleanMethod"),
        ADDRESS.withName("CallStaticBooleanMethodV"),
        ADDRESS.withName("CallStaticBooleanMethodA"),
        ADDRESS.withName("CallStaticByteMethod"),
        ADDRESS.withName("CallStaticByteMethodV"),
        ADDRESS.withName("CallStaticByteMethodA"),
        ADDRESS.withName("CallStaticCharMethod"),
        ADDRESS.withName("CallStaticCharMethodV"),
        ADDRESS.withName("CallStaticCharMethodA"),
        ADDRESS.withName("CallStaticShortMethod"),
        ADDRESS.withName("CallStaticShortMethodV"),
        ADDRESS.withName("CallStaticShortMethodA"),
        ADDRESS.withName("CallStaticIntMethod"),
        ADDRESS.withName("CallStaticIntMethodV"),
        ADDRESS.withName("CallStaticIntMethodA"),
        ADDRESS.withName("CallStaticLongMethod"),
        ADDRESS.withName("CallStaticLongMethodV"),
        ADDRESS.withName("CallStaticLongMethodA"),
        ADDRESS.withName("CallStaticFloatMethod"),
        ADDRESS.withName("CallStaticFloatMethodV"),
        ADDRESS.withName("CallStaticFloatMethodA"),
        ADDRESS.withName("CallStaticDoubleMethod"),
        ADDRESS.withName("CallStaticDoubleMethodV"),
        ADDRESS.withName("CallStaticDoubleMethodA"),
        ADDRESS.withName("CallStaticVoidMethod"),
        ADDRESS.withName("CallStaticVoidMethodV"),
        ADDRESS.withName("CallStaticVoidMethodA"),
        ADDRESS.withName("GetStaticFieldID"),
        ADDRESS.withName("GetStaticObjectField"),
        ADDRESS.withName("GetStaticBooleanField"),
        ADDRESS.withName("GetStaticByteField"),
        ADDRESS.withName("GetStaticCharField"),
        ADDRESS.withName("GetStaticShortField"),
        ADDRESS.withName("GetStaticIntField"),
        ADDRESS.withName("GetStaticLongField"),
        ADDRESS.withName("GetStaticFloatField"),
        ADDRESS.withName("GetStaticDoubleField"),
        ADDRESS.withName("SetStaticObjectField"),
        ADDRESS.withName("SetStaticBooleanField"),
        ADDRESS.withName("SetStaticByteField"),
        ADDRESS.withName("SetStaticCharField"),
        ADDRESS.withName("SetStaticShortField"),
        ADDRESS.withName("SetStaticIntField"),
        ADDRESS.withName("SetStaticLongField"),
        ADDRESS.withName("SetStaticFloatField"),
        ADDRESS.withName("SetStaticDoubleField"),
        ADDRESS.withName("NewString"),
        ADDRESS.withName("GetStringLength"),
        ADDRESS.withName("GetStringChars"),
        ADDRESS.withName("ReleaseStringChars"),
        ADDRESS.withName("NewStringUTF"),
        ADDRESS.withName("GetStringUTFLength"),
        ADDRESS.withName("GetStringUTFChars"),
        ADDRESS.withName("ReleaseStringUTFChars"),
        ADDRESS.withName("GetArrayLength"),
        ADDRESS.withName("NewObjectArray"),
        ADDRESS.withName("GetObjectArrayElement"),
        ADDRESS.withName("SetObjectArrayElement"),
        ADDRESS.withName("NewBooleanArray"),
        ADDRESS.withName("NewByteArray"),
        ADDRESS.withName("NewCharArray"),
        ADDRESS.withName("NewShortArray"),
        ADDRESS.withName("NewIntArray"),
        ADDRESS.withName("NewLongArray"),
        ADDRESS.withName("NewFloatArray"),
        ADDRESS.withName("NewDoubleArray"),
        ADDRESS.withName("GetBooleanArrayElements"),
        ADDRESS.withName("GetByteArrayElements"),
        ADDRESS.withName("GetCharArrayElements"),
        ADDRESS.withName("GetShortArrayElements"),
        ADDRESS.withName("GetIntArrayElements"),
        ADDRESS.withName("GetLongArrayElements"),
        ADDRESS.withName("GetFloatArrayElements"),
        ADDRESS.withName("GetDoubleArrayElements"),
        ADDRESS.withName("ReleaseBooleanArrayElements"),
        ADDRESS.withName("ReleaseByteArrayElements"),
        ADDRESS.withName("ReleaseCharArrayElements"),
        ADDRESS.withName("ReleaseShortArrayElements"),
        ADDRESS.withName("ReleaseIntArrayElements"),
        ADDRESS.withName("ReleaseLongArrayElements"),
        ADDRESS.withName("ReleaseFloatArrayElements"),
        ADDRESS.withName("ReleaseDoubleArrayElements"),
        ADDRESS.withName("GetBooleanArrayRegion"),
        ADDRESS.withName("GetByteArrayRegion"),
        ADDRESS.withName("GetCharArrayRegion"),
        ADDRESS.withName("GetShortArrayRegion"),
        ADDRESS.withName("GetIntArrayRegion"),
        ADDRESS.withName("GetLongArrayRegion"),
        ADDRESS.withName("GetFloatArrayRegion"),
        ADDRESS.withName("GetDoubleArrayRegion"),
        ADDRESS.withName("SetBooleanArrayRegion"),
        ADDRESS.withName("SetByteArrayRegion"),
        ADDRESS.withName("SetCharArrayRegion"),
        ADDRESS.withName("SetShortArrayRegion"),
        ADDRESS.withName("SetIntArrayRegion"),
        ADDRESS.withName("SetLongArrayRegion"),
        ADDRESS.withName("SetFloatArrayRegion"),
        ADDRESS.withName("SetDoubleArrayRegion"),
        ADDRESS.withName("RegisterNatives"),
        ADDRESS.withName("UnregisterNatives"),
        ADDRESS.withName("MonitorEnter"),
        ADDRESS.withName("MonitorExit"),
        ADDRESS.withName("GetJavaVM"),
        ADDRESS.withName("GetStringRegion"),
        ADDRESS.withName("GetStringUTFRegion"),
        ADDRESS.withName("GetPrimitiveArrayCritical"),
        ADDRESS.withName("ReleasePrimitiveArrayCritical"),
        ADDRESS.withName("GetStringCritical"),
        ADDRESS.withName("ReleaseStringCritical"),
        ADDRESS.withName("NewWeakGlobalRef"),
        ADDRESS.withName("DeleteWeakGlobalRef"),
        ADDRESS.withName("ExceptionCheck"),
        ADDRESS.withName("NewDirectByteBuffer"),
        ADDRESS.withName("GetDirectBufferAddress"),
        ADDRESS.withName("GetDirectBufferCapacity"),
        ADDRESS.withName("GetObjectRefType"),
        ADDRESS.withName("GetModule"),
        ADDRESS.withName("IsVirtualThread"),
        ADDRESS.withName("GetStringUTFLengthAsLong")
    ).withName("JNINativeInterface_");
    public static final long OFFSET__reserved0 = LAYOUT.byteOffset(PathElement.groupElement("reserved0"));
    public static final long OFFSET__reserved1 = LAYOUT.byteOffset(PathElement.groupElement("reserved1"));
    public static final long OFFSET__reserved2 = LAYOUT.byteOffset(PathElement.groupElement("reserved2"));
    public static final long OFFSET__reserved3 = LAYOUT.byteOffset(PathElement.groupElement("reserved3"));
    public static final long OFFSET__GetVersion = LAYOUT.byteOffset(PathElement.groupElement("GetVersion"));
    public static final long OFFSET__DefineClass = LAYOUT.byteOffset(PathElement.groupElement("DefineClass"));
    public static final long OFFSET__FindClass = LAYOUT.byteOffset(PathElement.groupElement("FindClass"));
    public static final long OFFSET__FromReflectedMethod = LAYOUT.byteOffset(PathElement.groupElement("FromReflectedMethod"));
    public static final long OFFSET__FromReflectedField = LAYOUT.byteOffset(PathElement.groupElement("FromReflectedField"));
    public static final long OFFSET__ToReflectedMethod = LAYOUT.byteOffset(PathElement.groupElement("ToReflectedMethod"));
    public static final long OFFSET__GetSuperclass = LAYOUT.byteOffset(PathElement.groupElement("GetSuperclass"));
    public static final long OFFSET__IsAssignableFrom = LAYOUT.byteOffset(PathElement.groupElement("IsAssignableFrom"));
    public static final long OFFSET__ToReflectedField = LAYOUT.byteOffset(PathElement.groupElement("ToReflectedField"));
    public static final long OFFSET__Throw = LAYOUT.byteOffset(PathElement.groupElement("Throw"));
    public static final long OFFSET__ThrowNew = LAYOUT.byteOffset(PathElement.groupElement("ThrowNew"));
    public static final long OFFSET__ExceptionOccurred = LAYOUT.byteOffset(PathElement.groupElement("ExceptionOccurred"));
    public static final long OFFSET__ExceptionDescribe = LAYOUT.byteOffset(PathElement.groupElement("ExceptionDescribe"));
    public static final long OFFSET__ExceptionClear = LAYOUT.byteOffset(PathElement.groupElement("ExceptionClear"));
    public static final long OFFSET__FatalError = LAYOUT.byteOffset(PathElement.groupElement("FatalError"));
    public static final long OFFSET__PushLocalFrame = LAYOUT.byteOffset(PathElement.groupElement("PushLocalFrame"));
    public static final long OFFSET__PopLocalFrame = LAYOUT.byteOffset(PathElement.groupElement("PopLocalFrame"));
    public static final long OFFSET__NewGlobalRef = LAYOUT.byteOffset(PathElement.groupElement("NewGlobalRef"));
    public static final long OFFSET__DeleteGlobalRef = LAYOUT.byteOffset(PathElement.groupElement("DeleteGlobalRef"));
    public static final long OFFSET__DeleteLocalRef = LAYOUT.byteOffset(PathElement.groupElement("DeleteLocalRef"));
    public static final long OFFSET__IsSameObject = LAYOUT.byteOffset(PathElement.groupElement("IsSameObject"));
    public static final long OFFSET__NewLocalRef = LAYOUT.byteOffset(PathElement.groupElement("NewLocalRef"));
    public static final long OFFSET__EnsureLocalCapacity = LAYOUT.byteOffset(PathElement.groupElement("EnsureLocalCapacity"));
    public static final long OFFSET__AllocObject = LAYOUT.byteOffset(PathElement.groupElement("AllocObject"));
    public static final long OFFSET__NewObject = LAYOUT.byteOffset(PathElement.groupElement("NewObject"));
    public static final long OFFSET__NewObjectV = LAYOUT.byteOffset(PathElement.groupElement("NewObjectV"));
    public static final long OFFSET__NewObjectA = LAYOUT.byteOffset(PathElement.groupElement("NewObjectA"));
    public static final long OFFSET__GetObjectClass = LAYOUT.byteOffset(PathElement.groupElement("GetObjectClass"));
    public static final long OFFSET__IsInstanceOf = LAYOUT.byteOffset(PathElement.groupElement("IsInstanceOf"));
    public static final long OFFSET__GetMethodID = LAYOUT.byteOffset(PathElement.groupElement("GetMethodID"));
    public static final long OFFSET__CallObjectMethod = LAYOUT.byteOffset(PathElement.groupElement("CallObjectMethod"));
    public static final long OFFSET__CallObjectMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallObjectMethodV"));
    public static final long OFFSET__CallObjectMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallObjectMethodA"));
    public static final long OFFSET__CallBooleanMethod = LAYOUT.byteOffset(PathElement.groupElement("CallBooleanMethod"));
    public static final long OFFSET__CallBooleanMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallBooleanMethodV"));
    public static final long OFFSET__CallBooleanMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallBooleanMethodA"));
    public static final long OFFSET__CallByteMethod = LAYOUT.byteOffset(PathElement.groupElement("CallByteMethod"));
    public static final long OFFSET__CallByteMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallByteMethodV"));
    public static final long OFFSET__CallByteMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallByteMethodA"));
    public static final long OFFSET__CallCharMethod = LAYOUT.byteOffset(PathElement.groupElement("CallCharMethod"));
    public static final long OFFSET__CallCharMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallCharMethodV"));
    public static final long OFFSET__CallCharMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallCharMethodA"));
    public static final long OFFSET__CallShortMethod = LAYOUT.byteOffset(PathElement.groupElement("CallShortMethod"));
    public static final long OFFSET__CallShortMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallShortMethodV"));
    public static final long OFFSET__CallShortMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallShortMethodA"));
    public static final long OFFSET__CallIntMethod = LAYOUT.byteOffset(PathElement.groupElement("CallIntMethod"));
    public static final long OFFSET__CallIntMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallIntMethodV"));
    public static final long OFFSET__CallIntMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallIntMethodA"));
    public static final long OFFSET__CallLongMethod = LAYOUT.byteOffset(PathElement.groupElement("CallLongMethod"));
    public static final long OFFSET__CallLongMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallLongMethodV"));
    public static final long OFFSET__CallLongMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallLongMethodA"));
    public static final long OFFSET__CallFloatMethod = LAYOUT.byteOffset(PathElement.groupElement("CallFloatMethod"));
    public static final long OFFSET__CallFloatMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallFloatMethodV"));
    public static final long OFFSET__CallFloatMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallFloatMethodA"));
    public static final long OFFSET__CallDoubleMethod = LAYOUT.byteOffset(PathElement.groupElement("CallDoubleMethod"));
    public static final long OFFSET__CallDoubleMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallDoubleMethodV"));
    public static final long OFFSET__CallDoubleMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallDoubleMethodA"));
    public static final long OFFSET__CallVoidMethod = LAYOUT.byteOffset(PathElement.groupElement("CallVoidMethod"));
    public static final long OFFSET__CallVoidMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallVoidMethodV"));
    public static final long OFFSET__CallVoidMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallVoidMethodA"));
    public static final long OFFSET__CallNonvirtualObjectMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualObjectMethod"));
    public static final long OFFSET__CallNonvirtualObjectMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualObjectMethodV"));
    public static final long OFFSET__CallNonvirtualObjectMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualObjectMethodA"));
    public static final long OFFSET__CallNonvirtualBooleanMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualBooleanMethod"));
    public static final long OFFSET__CallNonvirtualBooleanMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualBooleanMethodV"));
    public static final long OFFSET__CallNonvirtualBooleanMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualBooleanMethodA"));
    public static final long OFFSET__CallNonvirtualByteMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualByteMethod"));
    public static final long OFFSET__CallNonvirtualByteMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualByteMethodV"));
    public static final long OFFSET__CallNonvirtualByteMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualByteMethodA"));
    public static final long OFFSET__CallNonvirtualCharMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualCharMethod"));
    public static final long OFFSET__CallNonvirtualCharMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualCharMethodV"));
    public static final long OFFSET__CallNonvirtualCharMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualCharMethodA"));
    public static final long OFFSET__CallNonvirtualShortMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualShortMethod"));
    public static final long OFFSET__CallNonvirtualShortMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualShortMethodV"));
    public static final long OFFSET__CallNonvirtualShortMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualShortMethodA"));
    public static final long OFFSET__CallNonvirtualIntMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualIntMethod"));
    public static final long OFFSET__CallNonvirtualIntMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualIntMethodV"));
    public static final long OFFSET__CallNonvirtualIntMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualIntMethodA"));
    public static final long OFFSET__CallNonvirtualLongMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualLongMethod"));
    public static final long OFFSET__CallNonvirtualLongMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualLongMethodV"));
    public static final long OFFSET__CallNonvirtualLongMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualLongMethodA"));
    public static final long OFFSET__CallNonvirtualFloatMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualFloatMethod"));
    public static final long OFFSET__CallNonvirtualFloatMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualFloatMethodV"));
    public static final long OFFSET__CallNonvirtualFloatMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualFloatMethodA"));
    public static final long OFFSET__CallNonvirtualDoubleMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualDoubleMethod"));
    public static final long OFFSET__CallNonvirtualDoubleMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualDoubleMethodV"));
    public static final long OFFSET__CallNonvirtualDoubleMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualDoubleMethodA"));
    public static final long OFFSET__CallNonvirtualVoidMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualVoidMethod"));
    public static final long OFFSET__CallNonvirtualVoidMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualVoidMethodV"));
    public static final long OFFSET__CallNonvirtualVoidMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualVoidMethodA"));
    public static final long OFFSET__GetFieldID = LAYOUT.byteOffset(PathElement.groupElement("GetFieldID"));
    public static final long OFFSET__GetObjectField = LAYOUT.byteOffset(PathElement.groupElement("GetObjectField"));
    public static final long OFFSET__GetBooleanField = LAYOUT.byteOffset(PathElement.groupElement("GetBooleanField"));
    public static final long OFFSET__GetByteField = LAYOUT.byteOffset(PathElement.groupElement("GetByteField"));
    public static final long OFFSET__GetCharField = LAYOUT.byteOffset(PathElement.groupElement("GetCharField"));
    public static final long OFFSET__GetShortField = LAYOUT.byteOffset(PathElement.groupElement("GetShortField"));
    public static final long OFFSET__GetIntField = LAYOUT.byteOffset(PathElement.groupElement("GetIntField"));
    public static final long OFFSET__GetLongField = LAYOUT.byteOffset(PathElement.groupElement("GetLongField"));
    public static final long OFFSET__GetFloatField = LAYOUT.byteOffset(PathElement.groupElement("GetFloatField"));
    public static final long OFFSET__GetDoubleField = LAYOUT.byteOffset(PathElement.groupElement("GetDoubleField"));
    public static final long OFFSET__SetObjectField = LAYOUT.byteOffset(PathElement.groupElement("SetObjectField"));
    public static final long OFFSET__SetBooleanField = LAYOUT.byteOffset(PathElement.groupElement("SetBooleanField"));
    public static final long OFFSET__SetByteField = LAYOUT.byteOffset(PathElement.groupElement("SetByteField"));
    public static final long OFFSET__SetCharField = LAYOUT.byteOffset(PathElement.groupElement("SetCharField"));
    public static final long OFFSET__SetShortField = LAYOUT.byteOffset(PathElement.groupElement("SetShortField"));
    public static final long OFFSET__SetIntField = LAYOUT.byteOffset(PathElement.groupElement("SetIntField"));
    public static final long OFFSET__SetLongField = LAYOUT.byteOffset(PathElement.groupElement("SetLongField"));
    public static final long OFFSET__SetFloatField = LAYOUT.byteOffset(PathElement.groupElement("SetFloatField"));
    public static final long OFFSET__SetDoubleField = LAYOUT.byteOffset(PathElement.groupElement("SetDoubleField"));
    public static final long OFFSET__GetStaticMethodID = LAYOUT.byteOffset(PathElement.groupElement("GetStaticMethodID"));
    public static final long OFFSET__CallStaticObjectMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticObjectMethod"));
    public static final long OFFSET__CallStaticObjectMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticObjectMethodV"));
    public static final long OFFSET__CallStaticObjectMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticObjectMethodA"));
    public static final long OFFSET__CallStaticBooleanMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticBooleanMethod"));
    public static final long OFFSET__CallStaticBooleanMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticBooleanMethodV"));
    public static final long OFFSET__CallStaticBooleanMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticBooleanMethodA"));
    public static final long OFFSET__CallStaticByteMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticByteMethod"));
    public static final long OFFSET__CallStaticByteMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticByteMethodV"));
    public static final long OFFSET__CallStaticByteMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticByteMethodA"));
    public static final long OFFSET__CallStaticCharMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticCharMethod"));
    public static final long OFFSET__CallStaticCharMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticCharMethodV"));
    public static final long OFFSET__CallStaticCharMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticCharMethodA"));
    public static final long OFFSET__CallStaticShortMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticShortMethod"));
    public static final long OFFSET__CallStaticShortMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticShortMethodV"));
    public static final long OFFSET__CallStaticShortMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticShortMethodA"));
    public static final long OFFSET__CallStaticIntMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticIntMethod"));
    public static final long OFFSET__CallStaticIntMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticIntMethodV"));
    public static final long OFFSET__CallStaticIntMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticIntMethodA"));
    public static final long OFFSET__CallStaticLongMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticLongMethod"));
    public static final long OFFSET__CallStaticLongMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticLongMethodV"));
    public static final long OFFSET__CallStaticLongMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticLongMethodA"));
    public static final long OFFSET__CallStaticFloatMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticFloatMethod"));
    public static final long OFFSET__CallStaticFloatMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticFloatMethodV"));
    public static final long OFFSET__CallStaticFloatMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticFloatMethodA"));
    public static final long OFFSET__CallStaticDoubleMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticDoubleMethod"));
    public static final long OFFSET__CallStaticDoubleMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticDoubleMethodV"));
    public static final long OFFSET__CallStaticDoubleMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticDoubleMethodA"));
    public static final long OFFSET__CallStaticVoidMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticVoidMethod"));
    public static final long OFFSET__CallStaticVoidMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticVoidMethodV"));
    public static final long OFFSET__CallStaticVoidMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticVoidMethodA"));
    public static final long OFFSET__GetStaticFieldID = LAYOUT.byteOffset(PathElement.groupElement("GetStaticFieldID"));
    public static final long OFFSET__GetStaticObjectField = LAYOUT.byteOffset(PathElement.groupElement("GetStaticObjectField"));
    public static final long OFFSET__GetStaticBooleanField = LAYOUT.byteOffset(PathElement.groupElement("GetStaticBooleanField"));
    public static final long OFFSET__GetStaticByteField = LAYOUT.byteOffset(PathElement.groupElement("GetStaticByteField"));
    public static final long OFFSET__GetStaticCharField = LAYOUT.byteOffset(PathElement.groupElement("GetStaticCharField"));
    public static final long OFFSET__GetStaticShortField = LAYOUT.byteOffset(PathElement.groupElement("GetStaticShortField"));
    public static final long OFFSET__GetStaticIntField = LAYOUT.byteOffset(PathElement.groupElement("GetStaticIntField"));
    public static final long OFFSET__GetStaticLongField = LAYOUT.byteOffset(PathElement.groupElement("GetStaticLongField"));
    public static final long OFFSET__GetStaticFloatField = LAYOUT.byteOffset(PathElement.groupElement("GetStaticFloatField"));
    public static final long OFFSET__GetStaticDoubleField = LAYOUT.byteOffset(PathElement.groupElement("GetStaticDoubleField"));
    public static final long OFFSET__SetStaticObjectField = LAYOUT.byteOffset(PathElement.groupElement("SetStaticObjectField"));
    public static final long OFFSET__SetStaticBooleanField = LAYOUT.byteOffset(PathElement.groupElement("SetStaticBooleanField"));
    public static final long OFFSET__SetStaticByteField = LAYOUT.byteOffset(PathElement.groupElement("SetStaticByteField"));
    public static final long OFFSET__SetStaticCharField = LAYOUT.byteOffset(PathElement.groupElement("SetStaticCharField"));
    public static final long OFFSET__SetStaticShortField = LAYOUT.byteOffset(PathElement.groupElement("SetStaticShortField"));
    public static final long OFFSET__SetStaticIntField = LAYOUT.byteOffset(PathElement.groupElement("SetStaticIntField"));
    public static final long OFFSET__SetStaticLongField = LAYOUT.byteOffset(PathElement.groupElement("SetStaticLongField"));
    public static final long OFFSET__SetStaticFloatField = LAYOUT.byteOffset(PathElement.groupElement("SetStaticFloatField"));
    public static final long OFFSET__SetStaticDoubleField = LAYOUT.byteOffset(PathElement.groupElement("SetStaticDoubleField"));
    public static final long OFFSET__NewString = LAYOUT.byteOffset(PathElement.groupElement("NewString"));
    public static final long OFFSET__GetStringLength = LAYOUT.byteOffset(PathElement.groupElement("GetStringLength"));
    public static final long OFFSET__GetStringChars = LAYOUT.byteOffset(PathElement.groupElement("GetStringChars"));
    public static final long OFFSET__ReleaseStringChars = LAYOUT.byteOffset(PathElement.groupElement("ReleaseStringChars"));
    public static final long OFFSET__NewStringUTF = LAYOUT.byteOffset(PathElement.groupElement("NewStringUTF"));
    public static final long OFFSET__GetStringUTFLength = LAYOUT.byteOffset(PathElement.groupElement("GetStringUTFLength"));
    public static final long OFFSET__GetStringUTFChars = LAYOUT.byteOffset(PathElement.groupElement("GetStringUTFChars"));
    public static final long OFFSET__ReleaseStringUTFChars = LAYOUT.byteOffset(PathElement.groupElement("ReleaseStringUTFChars"));
    public static final long OFFSET__GetArrayLength = LAYOUT.byteOffset(PathElement.groupElement("GetArrayLength"));
    public static final long OFFSET__NewObjectArray = LAYOUT.byteOffset(PathElement.groupElement("NewObjectArray"));
    public static final long OFFSET__GetObjectArrayElement = LAYOUT.byteOffset(PathElement.groupElement("GetObjectArrayElement"));
    public static final long OFFSET__SetObjectArrayElement = LAYOUT.byteOffset(PathElement.groupElement("SetObjectArrayElement"));
    public static final long OFFSET__NewBooleanArray = LAYOUT.byteOffset(PathElement.groupElement("NewBooleanArray"));
    public static final long OFFSET__NewByteArray = LAYOUT.byteOffset(PathElement.groupElement("NewByteArray"));
    public static final long OFFSET__NewCharArray = LAYOUT.byteOffset(PathElement.groupElement("NewCharArray"));
    public static final long OFFSET__NewShortArray = LAYOUT.byteOffset(PathElement.groupElement("NewShortArray"));
    public static final long OFFSET__NewIntArray = LAYOUT.byteOffset(PathElement.groupElement("NewIntArray"));
    public static final long OFFSET__NewLongArray = LAYOUT.byteOffset(PathElement.groupElement("NewLongArray"));
    public static final long OFFSET__NewFloatArray = LAYOUT.byteOffset(PathElement.groupElement("NewFloatArray"));
    public static final long OFFSET__NewDoubleArray = LAYOUT.byteOffset(PathElement.groupElement("NewDoubleArray"));
    public static final long OFFSET__GetBooleanArrayElements = LAYOUT.byteOffset(PathElement.groupElement("GetBooleanArrayElements"));
    public static final long OFFSET__GetByteArrayElements = LAYOUT.byteOffset(PathElement.groupElement("GetByteArrayElements"));
    public static final long OFFSET__GetCharArrayElements = LAYOUT.byteOffset(PathElement.groupElement("GetCharArrayElements"));
    public static final long OFFSET__GetShortArrayElements = LAYOUT.byteOffset(PathElement.groupElement("GetShortArrayElements"));
    public static final long OFFSET__GetIntArrayElements = LAYOUT.byteOffset(PathElement.groupElement("GetIntArrayElements"));
    public static final long OFFSET__GetLongArrayElements = LAYOUT.byteOffset(PathElement.groupElement("GetLongArrayElements"));
    public static final long OFFSET__GetFloatArrayElements = LAYOUT.byteOffset(PathElement.groupElement("GetFloatArrayElements"));
    public static final long OFFSET__GetDoubleArrayElements = LAYOUT.byteOffset(PathElement.groupElement("GetDoubleArrayElements"));
    public static final long OFFSET__ReleaseBooleanArrayElements = LAYOUT.byteOffset(PathElement.groupElement("ReleaseBooleanArrayElements"));
    public static final long OFFSET__ReleaseByteArrayElements = LAYOUT.byteOffset(PathElement.groupElement("ReleaseByteArrayElements"));
    public static final long OFFSET__ReleaseCharArrayElements = LAYOUT.byteOffset(PathElement.groupElement("ReleaseCharArrayElements"));
    public static final long OFFSET__ReleaseShortArrayElements = LAYOUT.byteOffset(PathElement.groupElement("ReleaseShortArrayElements"));
    public static final long OFFSET__ReleaseIntArrayElements = LAYOUT.byteOffset(PathElement.groupElement("ReleaseIntArrayElements"));
    public static final long OFFSET__ReleaseLongArrayElements = LAYOUT.byteOffset(PathElement.groupElement("ReleaseLongArrayElements"));
    public static final long OFFSET__ReleaseFloatArrayElements = LAYOUT.byteOffset(PathElement.groupElement("ReleaseFloatArrayElements"));
    public static final long OFFSET__ReleaseDoubleArrayElements = LAYOUT.byteOffset(PathElement.groupElement("ReleaseDoubleArrayElements"));
    public static final long OFFSET__GetBooleanArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("GetBooleanArrayRegion"));
    public static final long OFFSET__GetByteArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("GetByteArrayRegion"));
    public static final long OFFSET__GetCharArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("GetCharArrayRegion"));
    public static final long OFFSET__GetShortArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("GetShortArrayRegion"));
    public static final long OFFSET__GetIntArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("GetIntArrayRegion"));
    public static final long OFFSET__GetLongArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("GetLongArrayRegion"));
    public static final long OFFSET__GetFloatArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("GetFloatArrayRegion"));
    public static final long OFFSET__GetDoubleArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("GetDoubleArrayRegion"));
    public static final long OFFSET__SetBooleanArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("SetBooleanArrayRegion"));
    public static final long OFFSET__SetByteArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("SetByteArrayRegion"));
    public static final long OFFSET__SetCharArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("SetCharArrayRegion"));
    public static final long OFFSET__SetShortArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("SetShortArrayRegion"));
    public static final long OFFSET__SetIntArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("SetIntArrayRegion"));
    public static final long OFFSET__SetLongArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("SetLongArrayRegion"));
    public static final long OFFSET__SetFloatArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("SetFloatArrayRegion"));
    public static final long OFFSET__SetDoubleArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("SetDoubleArrayRegion"));
    public static final long OFFSET__RegisterNatives = LAYOUT.byteOffset(PathElement.groupElement("RegisterNatives"));
    public static final long OFFSET__UnregisterNatives = LAYOUT.byteOffset(PathElement.groupElement("UnregisterNatives"));
    public static final long OFFSET__MonitorEnter = LAYOUT.byteOffset(PathElement.groupElement("MonitorEnter"));
    public static final long OFFSET__MonitorExit = LAYOUT.byteOffset(PathElement.groupElement("MonitorExit"));
    public static final long OFFSET__GetJavaVM = LAYOUT.byteOffset(PathElement.groupElement("GetJavaVM"));
    public static final long OFFSET__GetStringRegion = LAYOUT.byteOffset(PathElement.groupElement("GetStringRegion"));
    public static final long OFFSET__GetStringUTFRegion = LAYOUT.byteOffset(PathElement.groupElement("GetStringUTFRegion"));
    public static final long OFFSET__GetPrimitiveArrayCritical = LAYOUT.byteOffset(PathElement.groupElement("GetPrimitiveArrayCritical"));
    public static final long OFFSET__ReleasePrimitiveArrayCritical = LAYOUT.byteOffset(PathElement.groupElement("ReleasePrimitiveArrayCritical"));
    public static final long OFFSET__GetStringCritical = LAYOUT.byteOffset(PathElement.groupElement("GetStringCritical"));
    public static final long OFFSET__ReleaseStringCritical = LAYOUT.byteOffset(PathElement.groupElement("ReleaseStringCritical"));
    public static final long OFFSET__NewWeakGlobalRef = LAYOUT.byteOffset(PathElement.groupElement("NewWeakGlobalRef"));
    public static final long OFFSET__DeleteWeakGlobalRef = LAYOUT.byteOffset(PathElement.groupElement("DeleteWeakGlobalRef"));
    public static final long OFFSET__ExceptionCheck = LAYOUT.byteOffset(PathElement.groupElement("ExceptionCheck"));
    public static final long OFFSET__NewDirectByteBuffer = LAYOUT.byteOffset(PathElement.groupElement("NewDirectByteBuffer"));
    public static final long OFFSET__GetDirectBufferAddress = LAYOUT.byteOffset(PathElement.groupElement("GetDirectBufferAddress"));
    public static final long OFFSET__GetDirectBufferCapacity = LAYOUT.byteOffset(PathElement.groupElement("GetDirectBufferCapacity"));
    public static final long OFFSET__GetObjectRefType = LAYOUT.byteOffset(PathElement.groupElement("GetObjectRefType"));
    public static final long OFFSET__GetModule = LAYOUT.byteOffset(PathElement.groupElement("GetModule"));
    public static final long OFFSET__IsVirtualThread = LAYOUT.byteOffset(PathElement.groupElement("IsVirtualThread"));
    public static final long OFFSET__GetStringUTFLengthAsLong = LAYOUT.byteOffset(PathElement.groupElement("GetStringUTFLengthAsLong"));

    public JNINativeInterface
    {
        if (pointer.maxByteAlignment() < LAYOUT.byteAlignment() || pointer.byteSize() != LAYOUT.byteSize())
        {
            throw new IllegalArgumentException("Memory slice does not follow layout constraints.");
        }
    }

    public JNINativeInterface(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JNINativeInterface> buffer(MemorySegment data)
    {
        return Buffer.of(data, LAYOUT, JNINativeInterface::new);
    }

    public static Buffer<JNINativeInterface> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocate(allocator, LAYOUT, size, JNINativeInterface::new);
    }

    public static JNINativeInterface getAtIndex(MemorySegment buffer, long index)
    {
        return new JNINativeInterface(buffer.asSlice(index * LAYOUT.byteSize(), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long index, JNINativeInterface value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, index * LAYOUT.byteSize(), LAYOUT.byteSize());
    }

    public void copyFrom(JNINativeInterface value)
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

    public MemorySegment reserved3()
    {
        return this.pointer().get(ADDRESS, OFFSET__reserved3);
    }

    public void reserved3(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__reserved3, value);
    }

    public MemorySegment $reserved3()
    {
        return this.pointer().asSlice(OFFSET__reserved3, ADDRESS);
    }

    public MemorySegment GetVersion()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetVersion);
    }

    public void GetVersion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetVersion, value);
    }

    public MemorySegment $GetVersion()
    {
        return this.pointer().asSlice(OFFSET__GetVersion, ADDRESS);
    }

    public MemorySegment DefineClass()
    {
        return this.pointer().get(ADDRESS, OFFSET__DefineClass);
    }

    public void DefineClass(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__DefineClass, value);
    }

    public MemorySegment $DefineClass()
    {
        return this.pointer().asSlice(OFFSET__DefineClass, ADDRESS);
    }

    public MemorySegment FindClass()
    {
        return this.pointer().get(ADDRESS, OFFSET__FindClass);
    }

    public void FindClass(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__FindClass, value);
    }

    public MemorySegment $FindClass()
    {
        return this.pointer().asSlice(OFFSET__FindClass, ADDRESS);
    }

    public MemorySegment FromReflectedMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__FromReflectedMethod);
    }

    public void FromReflectedMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__FromReflectedMethod, value);
    }

    public MemorySegment $FromReflectedMethod()
    {
        return this.pointer().asSlice(OFFSET__FromReflectedMethod, ADDRESS);
    }

    public MemorySegment FromReflectedField()
    {
        return this.pointer().get(ADDRESS, OFFSET__FromReflectedField);
    }

    public void FromReflectedField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__FromReflectedField, value);
    }

    public MemorySegment $FromReflectedField()
    {
        return this.pointer().asSlice(OFFSET__FromReflectedField, ADDRESS);
    }

    public MemorySegment ToReflectedMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__ToReflectedMethod);
    }

    public void ToReflectedMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__ToReflectedMethod, value);
    }

    public MemorySegment $ToReflectedMethod()
    {
        return this.pointer().asSlice(OFFSET__ToReflectedMethod, ADDRESS);
    }

    public MemorySegment GetSuperclass()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetSuperclass);
    }

    public void GetSuperclass(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetSuperclass, value);
    }

    public MemorySegment $GetSuperclass()
    {
        return this.pointer().asSlice(OFFSET__GetSuperclass, ADDRESS);
    }

    public MemorySegment IsAssignableFrom()
    {
        return this.pointer().get(ADDRESS, OFFSET__IsAssignableFrom);
    }

    public void IsAssignableFrom(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__IsAssignableFrom, value);
    }

    public MemorySegment $IsAssignableFrom()
    {
        return this.pointer().asSlice(OFFSET__IsAssignableFrom, ADDRESS);
    }

    public MemorySegment ToReflectedField()
    {
        return this.pointer().get(ADDRESS, OFFSET__ToReflectedField);
    }

    public void ToReflectedField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__ToReflectedField, value);
    }

    public MemorySegment $ToReflectedField()
    {
        return this.pointer().asSlice(OFFSET__ToReflectedField, ADDRESS);
    }

    public MemorySegment Throw()
    {
        return this.pointer().get(ADDRESS, OFFSET__Throw);
    }

    public void Throw(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__Throw, value);
    }

    public MemorySegment $Throw()
    {
        return this.pointer().asSlice(OFFSET__Throw, ADDRESS);
    }

    public MemorySegment ThrowNew()
    {
        return this.pointer().get(ADDRESS, OFFSET__ThrowNew);
    }

    public void ThrowNew(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__ThrowNew, value);
    }

    public MemorySegment $ThrowNew()
    {
        return this.pointer().asSlice(OFFSET__ThrowNew, ADDRESS);
    }

    public MemorySegment ExceptionOccurred()
    {
        return this.pointer().get(ADDRESS, OFFSET__ExceptionOccurred);
    }

    public void ExceptionOccurred(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__ExceptionOccurred, value);
    }

    public MemorySegment $ExceptionOccurred()
    {
        return this.pointer().asSlice(OFFSET__ExceptionOccurred, ADDRESS);
    }

    public MemorySegment ExceptionDescribe()
    {
        return this.pointer().get(ADDRESS, OFFSET__ExceptionDescribe);
    }

    public void ExceptionDescribe(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__ExceptionDescribe, value);
    }

    public MemorySegment $ExceptionDescribe()
    {
        return this.pointer().asSlice(OFFSET__ExceptionDescribe, ADDRESS);
    }

    public MemorySegment ExceptionClear()
    {
        return this.pointer().get(ADDRESS, OFFSET__ExceptionClear);
    }

    public void ExceptionClear(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__ExceptionClear, value);
    }

    public MemorySegment $ExceptionClear()
    {
        return this.pointer().asSlice(OFFSET__ExceptionClear, ADDRESS);
    }

    public MemorySegment FatalError()
    {
        return this.pointer().get(ADDRESS, OFFSET__FatalError);
    }

    public void FatalError(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__FatalError, value);
    }

    public MemorySegment $FatalError()
    {
        return this.pointer().asSlice(OFFSET__FatalError, ADDRESS);
    }

    public MemorySegment PushLocalFrame()
    {
        return this.pointer().get(ADDRESS, OFFSET__PushLocalFrame);
    }

    public void PushLocalFrame(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__PushLocalFrame, value);
    }

    public MemorySegment $PushLocalFrame()
    {
        return this.pointer().asSlice(OFFSET__PushLocalFrame, ADDRESS);
    }

    public MemorySegment PopLocalFrame()
    {
        return this.pointer().get(ADDRESS, OFFSET__PopLocalFrame);
    }

    public void PopLocalFrame(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__PopLocalFrame, value);
    }

    public MemorySegment $PopLocalFrame()
    {
        return this.pointer().asSlice(OFFSET__PopLocalFrame, ADDRESS);
    }

    public MemorySegment NewGlobalRef()
    {
        return this.pointer().get(ADDRESS, OFFSET__NewGlobalRef);
    }

    public void NewGlobalRef(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__NewGlobalRef, value);
    }

    public MemorySegment $NewGlobalRef()
    {
        return this.pointer().asSlice(OFFSET__NewGlobalRef, ADDRESS);
    }

    public MemorySegment DeleteGlobalRef()
    {
        return this.pointer().get(ADDRESS, OFFSET__DeleteGlobalRef);
    }

    public void DeleteGlobalRef(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__DeleteGlobalRef, value);
    }

    public MemorySegment $DeleteGlobalRef()
    {
        return this.pointer().asSlice(OFFSET__DeleteGlobalRef, ADDRESS);
    }

    public MemorySegment DeleteLocalRef()
    {
        return this.pointer().get(ADDRESS, OFFSET__DeleteLocalRef);
    }

    public void DeleteLocalRef(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__DeleteLocalRef, value);
    }

    public MemorySegment $DeleteLocalRef()
    {
        return this.pointer().asSlice(OFFSET__DeleteLocalRef, ADDRESS);
    }

    public MemorySegment IsSameObject()
    {
        return this.pointer().get(ADDRESS, OFFSET__IsSameObject);
    }

    public void IsSameObject(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__IsSameObject, value);
    }

    public MemorySegment $IsSameObject()
    {
        return this.pointer().asSlice(OFFSET__IsSameObject, ADDRESS);
    }

    public MemorySegment NewLocalRef()
    {
        return this.pointer().get(ADDRESS, OFFSET__NewLocalRef);
    }

    public void NewLocalRef(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__NewLocalRef, value);
    }

    public MemorySegment $NewLocalRef()
    {
        return this.pointer().asSlice(OFFSET__NewLocalRef, ADDRESS);
    }

    public MemorySegment EnsureLocalCapacity()
    {
        return this.pointer().get(ADDRESS, OFFSET__EnsureLocalCapacity);
    }

    public void EnsureLocalCapacity(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__EnsureLocalCapacity, value);
    }

    public MemorySegment $EnsureLocalCapacity()
    {
        return this.pointer().asSlice(OFFSET__EnsureLocalCapacity, ADDRESS);
    }

    public MemorySegment AllocObject()
    {
        return this.pointer().get(ADDRESS, OFFSET__AllocObject);
    }

    public void AllocObject(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__AllocObject, value);
    }

    public MemorySegment $AllocObject()
    {
        return this.pointer().asSlice(OFFSET__AllocObject, ADDRESS);
    }

    public MemorySegment NewObject()
    {
        return this.pointer().get(ADDRESS, OFFSET__NewObject);
    }

    public void NewObject(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__NewObject, value);
    }

    public MemorySegment $NewObject()
    {
        return this.pointer().asSlice(OFFSET__NewObject, ADDRESS);
    }

    public MemorySegment NewObjectV()
    {
        return this.pointer().get(ADDRESS, OFFSET__NewObjectV);
    }

    public void NewObjectV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__NewObjectV, value);
    }

    public MemorySegment $NewObjectV()
    {
        return this.pointer().asSlice(OFFSET__NewObjectV, ADDRESS);
    }

    public MemorySegment NewObjectA()
    {
        return this.pointer().get(ADDRESS, OFFSET__NewObjectA);
    }

    public void NewObjectA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__NewObjectA, value);
    }

    public MemorySegment $NewObjectA()
    {
        return this.pointer().asSlice(OFFSET__NewObjectA, ADDRESS);
    }

    public MemorySegment GetObjectClass()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetObjectClass);
    }

    public void GetObjectClass(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetObjectClass, value);
    }

    public MemorySegment $GetObjectClass()
    {
        return this.pointer().asSlice(OFFSET__GetObjectClass, ADDRESS);
    }

    public MemorySegment IsInstanceOf()
    {
        return this.pointer().get(ADDRESS, OFFSET__IsInstanceOf);
    }

    public void IsInstanceOf(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__IsInstanceOf, value);
    }

    public MemorySegment $IsInstanceOf()
    {
        return this.pointer().asSlice(OFFSET__IsInstanceOf, ADDRESS);
    }

    public MemorySegment GetMethodID()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetMethodID);
    }

    public void GetMethodID(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetMethodID, value);
    }

    public MemorySegment $GetMethodID()
    {
        return this.pointer().asSlice(OFFSET__GetMethodID, ADDRESS);
    }

    public MemorySegment CallObjectMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallObjectMethod);
    }

    public void CallObjectMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallObjectMethod, value);
    }

    public MemorySegment $CallObjectMethod()
    {
        return this.pointer().asSlice(OFFSET__CallObjectMethod, ADDRESS);
    }

    public MemorySegment CallObjectMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallObjectMethodV);
    }

    public void CallObjectMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallObjectMethodV, value);
    }

    public MemorySegment $CallObjectMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallObjectMethodV, ADDRESS);
    }

    public MemorySegment CallObjectMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallObjectMethodA);
    }

    public void CallObjectMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallObjectMethodA, value);
    }

    public MemorySegment $CallObjectMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallObjectMethodA, ADDRESS);
    }

    public MemorySegment CallBooleanMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallBooleanMethod);
    }

    public void CallBooleanMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallBooleanMethod, value);
    }

    public MemorySegment $CallBooleanMethod()
    {
        return this.pointer().asSlice(OFFSET__CallBooleanMethod, ADDRESS);
    }

    public MemorySegment CallBooleanMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallBooleanMethodV);
    }

    public void CallBooleanMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallBooleanMethodV, value);
    }

    public MemorySegment $CallBooleanMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallBooleanMethodV, ADDRESS);
    }

    public MemorySegment CallBooleanMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallBooleanMethodA);
    }

    public void CallBooleanMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallBooleanMethodA, value);
    }

    public MemorySegment $CallBooleanMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallBooleanMethodA, ADDRESS);
    }

    public MemorySegment CallByteMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallByteMethod);
    }

    public void CallByteMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallByteMethod, value);
    }

    public MemorySegment $CallByteMethod()
    {
        return this.pointer().asSlice(OFFSET__CallByteMethod, ADDRESS);
    }

    public MemorySegment CallByteMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallByteMethodV);
    }

    public void CallByteMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallByteMethodV, value);
    }

    public MemorySegment $CallByteMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallByteMethodV, ADDRESS);
    }

    public MemorySegment CallByteMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallByteMethodA);
    }

    public void CallByteMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallByteMethodA, value);
    }

    public MemorySegment $CallByteMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallByteMethodA, ADDRESS);
    }

    public MemorySegment CallCharMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallCharMethod);
    }

    public void CallCharMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallCharMethod, value);
    }

    public MemorySegment $CallCharMethod()
    {
        return this.pointer().asSlice(OFFSET__CallCharMethod, ADDRESS);
    }

    public MemorySegment CallCharMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallCharMethodV);
    }

    public void CallCharMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallCharMethodV, value);
    }

    public MemorySegment $CallCharMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallCharMethodV, ADDRESS);
    }

    public MemorySegment CallCharMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallCharMethodA);
    }

    public void CallCharMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallCharMethodA, value);
    }

    public MemorySegment $CallCharMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallCharMethodA, ADDRESS);
    }

    public MemorySegment CallShortMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallShortMethod);
    }

    public void CallShortMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallShortMethod, value);
    }

    public MemorySegment $CallShortMethod()
    {
        return this.pointer().asSlice(OFFSET__CallShortMethod, ADDRESS);
    }

    public MemorySegment CallShortMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallShortMethodV);
    }

    public void CallShortMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallShortMethodV, value);
    }

    public MemorySegment $CallShortMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallShortMethodV, ADDRESS);
    }

    public MemorySegment CallShortMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallShortMethodA);
    }

    public void CallShortMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallShortMethodA, value);
    }

    public MemorySegment $CallShortMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallShortMethodA, ADDRESS);
    }

    public MemorySegment CallIntMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallIntMethod);
    }

    public void CallIntMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallIntMethod, value);
    }

    public MemorySegment $CallIntMethod()
    {
        return this.pointer().asSlice(OFFSET__CallIntMethod, ADDRESS);
    }

    public MemorySegment CallIntMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallIntMethodV);
    }

    public void CallIntMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallIntMethodV, value);
    }

    public MemorySegment $CallIntMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallIntMethodV, ADDRESS);
    }

    public MemorySegment CallIntMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallIntMethodA);
    }

    public void CallIntMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallIntMethodA, value);
    }

    public MemorySegment $CallIntMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallIntMethodA, ADDRESS);
    }

    public MemorySegment CallLongMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallLongMethod);
    }

    public void CallLongMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallLongMethod, value);
    }

    public MemorySegment $CallLongMethod()
    {
        return this.pointer().asSlice(OFFSET__CallLongMethod, ADDRESS);
    }

    public MemorySegment CallLongMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallLongMethodV);
    }

    public void CallLongMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallLongMethodV, value);
    }

    public MemorySegment $CallLongMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallLongMethodV, ADDRESS);
    }

    public MemorySegment CallLongMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallLongMethodA);
    }

    public void CallLongMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallLongMethodA, value);
    }

    public MemorySegment $CallLongMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallLongMethodA, ADDRESS);
    }

    public MemorySegment CallFloatMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallFloatMethod);
    }

    public void CallFloatMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallFloatMethod, value);
    }

    public MemorySegment $CallFloatMethod()
    {
        return this.pointer().asSlice(OFFSET__CallFloatMethod, ADDRESS);
    }

    public MemorySegment CallFloatMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallFloatMethodV);
    }

    public void CallFloatMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallFloatMethodV, value);
    }

    public MemorySegment $CallFloatMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallFloatMethodV, ADDRESS);
    }

    public MemorySegment CallFloatMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallFloatMethodA);
    }

    public void CallFloatMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallFloatMethodA, value);
    }

    public MemorySegment $CallFloatMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallFloatMethodA, ADDRESS);
    }

    public MemorySegment CallDoubleMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallDoubleMethod);
    }

    public void CallDoubleMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallDoubleMethod, value);
    }

    public MemorySegment $CallDoubleMethod()
    {
        return this.pointer().asSlice(OFFSET__CallDoubleMethod, ADDRESS);
    }

    public MemorySegment CallDoubleMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallDoubleMethodV);
    }

    public void CallDoubleMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallDoubleMethodV, value);
    }

    public MemorySegment $CallDoubleMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallDoubleMethodV, ADDRESS);
    }

    public MemorySegment CallDoubleMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallDoubleMethodA);
    }

    public void CallDoubleMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallDoubleMethodA, value);
    }

    public MemorySegment $CallDoubleMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallDoubleMethodA, ADDRESS);
    }

    public MemorySegment CallVoidMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallVoidMethod);
    }

    public void CallVoidMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallVoidMethod, value);
    }

    public MemorySegment $CallVoidMethod()
    {
        return this.pointer().asSlice(OFFSET__CallVoidMethod, ADDRESS);
    }

    public MemorySegment CallVoidMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallVoidMethodV);
    }

    public void CallVoidMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallVoidMethodV, value);
    }

    public MemorySegment $CallVoidMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallVoidMethodV, ADDRESS);
    }

    public MemorySegment CallVoidMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallVoidMethodA);
    }

    public void CallVoidMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallVoidMethodA, value);
    }

    public MemorySegment $CallVoidMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallVoidMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualObjectMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualObjectMethod);
    }

    public void CallNonvirtualObjectMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualObjectMethod, value);
    }

    public MemorySegment $CallNonvirtualObjectMethod()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualObjectMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualObjectMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualObjectMethodV);
    }

    public void CallNonvirtualObjectMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualObjectMethodV, value);
    }

    public MemorySegment $CallNonvirtualObjectMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualObjectMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualObjectMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualObjectMethodA);
    }

    public void CallNonvirtualObjectMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualObjectMethodA, value);
    }

    public MemorySegment $CallNonvirtualObjectMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualObjectMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualBooleanMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualBooleanMethod);
    }

    public void CallNonvirtualBooleanMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualBooleanMethod, value);
    }

    public MemorySegment $CallNonvirtualBooleanMethod()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualBooleanMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualBooleanMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualBooleanMethodV);
    }

    public void CallNonvirtualBooleanMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualBooleanMethodV, value);
    }

    public MemorySegment $CallNonvirtualBooleanMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualBooleanMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualBooleanMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualBooleanMethodA);
    }

    public void CallNonvirtualBooleanMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualBooleanMethodA, value);
    }

    public MemorySegment $CallNonvirtualBooleanMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualBooleanMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualByteMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualByteMethod);
    }

    public void CallNonvirtualByteMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualByteMethod, value);
    }

    public MemorySegment $CallNonvirtualByteMethod()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualByteMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualByteMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualByteMethodV);
    }

    public void CallNonvirtualByteMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualByteMethodV, value);
    }

    public MemorySegment $CallNonvirtualByteMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualByteMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualByteMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualByteMethodA);
    }

    public void CallNonvirtualByteMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualByteMethodA, value);
    }

    public MemorySegment $CallNonvirtualByteMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualByteMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualCharMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualCharMethod);
    }

    public void CallNonvirtualCharMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualCharMethod, value);
    }

    public MemorySegment $CallNonvirtualCharMethod()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualCharMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualCharMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualCharMethodV);
    }

    public void CallNonvirtualCharMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualCharMethodV, value);
    }

    public MemorySegment $CallNonvirtualCharMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualCharMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualCharMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualCharMethodA);
    }

    public void CallNonvirtualCharMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualCharMethodA, value);
    }

    public MemorySegment $CallNonvirtualCharMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualCharMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualShortMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualShortMethod);
    }

    public void CallNonvirtualShortMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualShortMethod, value);
    }

    public MemorySegment $CallNonvirtualShortMethod()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualShortMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualShortMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualShortMethodV);
    }

    public void CallNonvirtualShortMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualShortMethodV, value);
    }

    public MemorySegment $CallNonvirtualShortMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualShortMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualShortMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualShortMethodA);
    }

    public void CallNonvirtualShortMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualShortMethodA, value);
    }

    public MemorySegment $CallNonvirtualShortMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualShortMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualIntMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualIntMethod);
    }

    public void CallNonvirtualIntMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualIntMethod, value);
    }

    public MemorySegment $CallNonvirtualIntMethod()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualIntMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualIntMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualIntMethodV);
    }

    public void CallNonvirtualIntMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualIntMethodV, value);
    }

    public MemorySegment $CallNonvirtualIntMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualIntMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualIntMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualIntMethodA);
    }

    public void CallNonvirtualIntMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualIntMethodA, value);
    }

    public MemorySegment $CallNonvirtualIntMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualIntMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualLongMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualLongMethod);
    }

    public void CallNonvirtualLongMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualLongMethod, value);
    }

    public MemorySegment $CallNonvirtualLongMethod()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualLongMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualLongMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualLongMethodV);
    }

    public void CallNonvirtualLongMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualLongMethodV, value);
    }

    public MemorySegment $CallNonvirtualLongMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualLongMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualLongMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualLongMethodA);
    }

    public void CallNonvirtualLongMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualLongMethodA, value);
    }

    public MemorySegment $CallNonvirtualLongMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualLongMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualFloatMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualFloatMethod);
    }

    public void CallNonvirtualFloatMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualFloatMethod, value);
    }

    public MemorySegment $CallNonvirtualFloatMethod()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualFloatMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualFloatMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualFloatMethodV);
    }

    public void CallNonvirtualFloatMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualFloatMethodV, value);
    }

    public MemorySegment $CallNonvirtualFloatMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualFloatMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualFloatMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualFloatMethodA);
    }

    public void CallNonvirtualFloatMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualFloatMethodA, value);
    }

    public MemorySegment $CallNonvirtualFloatMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualFloatMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualDoubleMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualDoubleMethod);
    }

    public void CallNonvirtualDoubleMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualDoubleMethod, value);
    }

    public MemorySegment $CallNonvirtualDoubleMethod()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualDoubleMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualDoubleMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualDoubleMethodV);
    }

    public void CallNonvirtualDoubleMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualDoubleMethodV, value);
    }

    public MemorySegment $CallNonvirtualDoubleMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualDoubleMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualDoubleMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualDoubleMethodA);
    }

    public void CallNonvirtualDoubleMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualDoubleMethodA, value);
    }

    public MemorySegment $CallNonvirtualDoubleMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualDoubleMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualVoidMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualVoidMethod);
    }

    public void CallNonvirtualVoidMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualVoidMethod, value);
    }

    public MemorySegment $CallNonvirtualVoidMethod()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualVoidMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualVoidMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualVoidMethodV);
    }

    public void CallNonvirtualVoidMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualVoidMethodV, value);
    }

    public MemorySegment $CallNonvirtualVoidMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualVoidMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualVoidMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallNonvirtualVoidMethodA);
    }

    public void CallNonvirtualVoidMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallNonvirtualVoidMethodA, value);
    }

    public MemorySegment $CallNonvirtualVoidMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallNonvirtualVoidMethodA, ADDRESS);
    }

    public MemorySegment GetFieldID()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetFieldID);
    }

    public void GetFieldID(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetFieldID, value);
    }

    public MemorySegment $GetFieldID()
    {
        return this.pointer().asSlice(OFFSET__GetFieldID, ADDRESS);
    }

    public MemorySegment GetObjectField()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetObjectField);
    }

    public void GetObjectField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetObjectField, value);
    }

    public MemorySegment $GetObjectField()
    {
        return this.pointer().asSlice(OFFSET__GetObjectField, ADDRESS);
    }

    public MemorySegment GetBooleanField()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetBooleanField);
    }

    public void GetBooleanField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetBooleanField, value);
    }

    public MemorySegment $GetBooleanField()
    {
        return this.pointer().asSlice(OFFSET__GetBooleanField, ADDRESS);
    }

    public MemorySegment GetByteField()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetByteField);
    }

    public void GetByteField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetByteField, value);
    }

    public MemorySegment $GetByteField()
    {
        return this.pointer().asSlice(OFFSET__GetByteField, ADDRESS);
    }

    public MemorySegment GetCharField()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetCharField);
    }

    public void GetCharField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetCharField, value);
    }

    public MemorySegment $GetCharField()
    {
        return this.pointer().asSlice(OFFSET__GetCharField, ADDRESS);
    }

    public MemorySegment GetShortField()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetShortField);
    }

    public void GetShortField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetShortField, value);
    }

    public MemorySegment $GetShortField()
    {
        return this.pointer().asSlice(OFFSET__GetShortField, ADDRESS);
    }

    public MemorySegment GetIntField()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetIntField);
    }

    public void GetIntField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetIntField, value);
    }

    public MemorySegment $GetIntField()
    {
        return this.pointer().asSlice(OFFSET__GetIntField, ADDRESS);
    }

    public MemorySegment GetLongField()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetLongField);
    }

    public void GetLongField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetLongField, value);
    }

    public MemorySegment $GetLongField()
    {
        return this.pointer().asSlice(OFFSET__GetLongField, ADDRESS);
    }

    public MemorySegment GetFloatField()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetFloatField);
    }

    public void GetFloatField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetFloatField, value);
    }

    public MemorySegment $GetFloatField()
    {
        return this.pointer().asSlice(OFFSET__GetFloatField, ADDRESS);
    }

    public MemorySegment GetDoubleField()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetDoubleField);
    }

    public void GetDoubleField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetDoubleField, value);
    }

    public MemorySegment $GetDoubleField()
    {
        return this.pointer().asSlice(OFFSET__GetDoubleField, ADDRESS);
    }

    public MemorySegment SetObjectField()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetObjectField);
    }

    public void SetObjectField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetObjectField, value);
    }

    public MemorySegment $SetObjectField()
    {
        return this.pointer().asSlice(OFFSET__SetObjectField, ADDRESS);
    }

    public MemorySegment SetBooleanField()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetBooleanField);
    }

    public void SetBooleanField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetBooleanField, value);
    }

    public MemorySegment $SetBooleanField()
    {
        return this.pointer().asSlice(OFFSET__SetBooleanField, ADDRESS);
    }

    public MemorySegment SetByteField()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetByteField);
    }

    public void SetByteField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetByteField, value);
    }

    public MemorySegment $SetByteField()
    {
        return this.pointer().asSlice(OFFSET__SetByteField, ADDRESS);
    }

    public MemorySegment SetCharField()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetCharField);
    }

    public void SetCharField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetCharField, value);
    }

    public MemorySegment $SetCharField()
    {
        return this.pointer().asSlice(OFFSET__SetCharField, ADDRESS);
    }

    public MemorySegment SetShortField()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetShortField);
    }

    public void SetShortField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetShortField, value);
    }

    public MemorySegment $SetShortField()
    {
        return this.pointer().asSlice(OFFSET__SetShortField, ADDRESS);
    }

    public MemorySegment SetIntField()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetIntField);
    }

    public void SetIntField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetIntField, value);
    }

    public MemorySegment $SetIntField()
    {
        return this.pointer().asSlice(OFFSET__SetIntField, ADDRESS);
    }

    public MemorySegment SetLongField()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetLongField);
    }

    public void SetLongField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetLongField, value);
    }

    public MemorySegment $SetLongField()
    {
        return this.pointer().asSlice(OFFSET__SetLongField, ADDRESS);
    }

    public MemorySegment SetFloatField()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetFloatField);
    }

    public void SetFloatField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetFloatField, value);
    }

    public MemorySegment $SetFloatField()
    {
        return this.pointer().asSlice(OFFSET__SetFloatField, ADDRESS);
    }

    public MemorySegment SetDoubleField()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetDoubleField);
    }

    public void SetDoubleField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetDoubleField, value);
    }

    public MemorySegment $SetDoubleField()
    {
        return this.pointer().asSlice(OFFSET__SetDoubleField, ADDRESS);
    }

    public MemorySegment GetStaticMethodID()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetStaticMethodID);
    }

    public void GetStaticMethodID(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetStaticMethodID, value);
    }

    public MemorySegment $GetStaticMethodID()
    {
        return this.pointer().asSlice(OFFSET__GetStaticMethodID, ADDRESS);
    }

    public MemorySegment CallStaticObjectMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticObjectMethod);
    }

    public void CallStaticObjectMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticObjectMethod, value);
    }

    public MemorySegment $CallStaticObjectMethod()
    {
        return this.pointer().asSlice(OFFSET__CallStaticObjectMethod, ADDRESS);
    }

    public MemorySegment CallStaticObjectMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticObjectMethodV);
    }

    public void CallStaticObjectMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticObjectMethodV, value);
    }

    public MemorySegment $CallStaticObjectMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallStaticObjectMethodV, ADDRESS);
    }

    public MemorySegment CallStaticObjectMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticObjectMethodA);
    }

    public void CallStaticObjectMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticObjectMethodA, value);
    }

    public MemorySegment $CallStaticObjectMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallStaticObjectMethodA, ADDRESS);
    }

    public MemorySegment CallStaticBooleanMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticBooleanMethod);
    }

    public void CallStaticBooleanMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticBooleanMethod, value);
    }

    public MemorySegment $CallStaticBooleanMethod()
    {
        return this.pointer().asSlice(OFFSET__CallStaticBooleanMethod, ADDRESS);
    }

    public MemorySegment CallStaticBooleanMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticBooleanMethodV);
    }

    public void CallStaticBooleanMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticBooleanMethodV, value);
    }

    public MemorySegment $CallStaticBooleanMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallStaticBooleanMethodV, ADDRESS);
    }

    public MemorySegment CallStaticBooleanMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticBooleanMethodA);
    }

    public void CallStaticBooleanMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticBooleanMethodA, value);
    }

    public MemorySegment $CallStaticBooleanMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallStaticBooleanMethodA, ADDRESS);
    }

    public MemorySegment CallStaticByteMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticByteMethod);
    }

    public void CallStaticByteMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticByteMethod, value);
    }

    public MemorySegment $CallStaticByteMethod()
    {
        return this.pointer().asSlice(OFFSET__CallStaticByteMethod, ADDRESS);
    }

    public MemorySegment CallStaticByteMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticByteMethodV);
    }

    public void CallStaticByteMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticByteMethodV, value);
    }

    public MemorySegment $CallStaticByteMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallStaticByteMethodV, ADDRESS);
    }

    public MemorySegment CallStaticByteMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticByteMethodA);
    }

    public void CallStaticByteMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticByteMethodA, value);
    }

    public MemorySegment $CallStaticByteMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallStaticByteMethodA, ADDRESS);
    }

    public MemorySegment CallStaticCharMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticCharMethod);
    }

    public void CallStaticCharMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticCharMethod, value);
    }

    public MemorySegment $CallStaticCharMethod()
    {
        return this.pointer().asSlice(OFFSET__CallStaticCharMethod, ADDRESS);
    }

    public MemorySegment CallStaticCharMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticCharMethodV);
    }

    public void CallStaticCharMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticCharMethodV, value);
    }

    public MemorySegment $CallStaticCharMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallStaticCharMethodV, ADDRESS);
    }

    public MemorySegment CallStaticCharMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticCharMethodA);
    }

    public void CallStaticCharMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticCharMethodA, value);
    }

    public MemorySegment $CallStaticCharMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallStaticCharMethodA, ADDRESS);
    }

    public MemorySegment CallStaticShortMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticShortMethod);
    }

    public void CallStaticShortMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticShortMethod, value);
    }

    public MemorySegment $CallStaticShortMethod()
    {
        return this.pointer().asSlice(OFFSET__CallStaticShortMethod, ADDRESS);
    }

    public MemorySegment CallStaticShortMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticShortMethodV);
    }

    public void CallStaticShortMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticShortMethodV, value);
    }

    public MemorySegment $CallStaticShortMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallStaticShortMethodV, ADDRESS);
    }

    public MemorySegment CallStaticShortMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticShortMethodA);
    }

    public void CallStaticShortMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticShortMethodA, value);
    }

    public MemorySegment $CallStaticShortMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallStaticShortMethodA, ADDRESS);
    }

    public MemorySegment CallStaticIntMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticIntMethod);
    }

    public void CallStaticIntMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticIntMethod, value);
    }

    public MemorySegment $CallStaticIntMethod()
    {
        return this.pointer().asSlice(OFFSET__CallStaticIntMethod, ADDRESS);
    }

    public MemorySegment CallStaticIntMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticIntMethodV);
    }

    public void CallStaticIntMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticIntMethodV, value);
    }

    public MemorySegment $CallStaticIntMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallStaticIntMethodV, ADDRESS);
    }

    public MemorySegment CallStaticIntMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticIntMethodA);
    }

    public void CallStaticIntMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticIntMethodA, value);
    }

    public MemorySegment $CallStaticIntMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallStaticIntMethodA, ADDRESS);
    }

    public MemorySegment CallStaticLongMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticLongMethod);
    }

    public void CallStaticLongMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticLongMethod, value);
    }

    public MemorySegment $CallStaticLongMethod()
    {
        return this.pointer().asSlice(OFFSET__CallStaticLongMethod, ADDRESS);
    }

    public MemorySegment CallStaticLongMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticLongMethodV);
    }

    public void CallStaticLongMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticLongMethodV, value);
    }

    public MemorySegment $CallStaticLongMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallStaticLongMethodV, ADDRESS);
    }

    public MemorySegment CallStaticLongMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticLongMethodA);
    }

    public void CallStaticLongMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticLongMethodA, value);
    }

    public MemorySegment $CallStaticLongMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallStaticLongMethodA, ADDRESS);
    }

    public MemorySegment CallStaticFloatMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticFloatMethod);
    }

    public void CallStaticFloatMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticFloatMethod, value);
    }

    public MemorySegment $CallStaticFloatMethod()
    {
        return this.pointer().asSlice(OFFSET__CallStaticFloatMethod, ADDRESS);
    }

    public MemorySegment CallStaticFloatMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticFloatMethodV);
    }

    public void CallStaticFloatMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticFloatMethodV, value);
    }

    public MemorySegment $CallStaticFloatMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallStaticFloatMethodV, ADDRESS);
    }

    public MemorySegment CallStaticFloatMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticFloatMethodA);
    }

    public void CallStaticFloatMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticFloatMethodA, value);
    }

    public MemorySegment $CallStaticFloatMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallStaticFloatMethodA, ADDRESS);
    }

    public MemorySegment CallStaticDoubleMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticDoubleMethod);
    }

    public void CallStaticDoubleMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticDoubleMethod, value);
    }

    public MemorySegment $CallStaticDoubleMethod()
    {
        return this.pointer().asSlice(OFFSET__CallStaticDoubleMethod, ADDRESS);
    }

    public MemorySegment CallStaticDoubleMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticDoubleMethodV);
    }

    public void CallStaticDoubleMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticDoubleMethodV, value);
    }

    public MemorySegment $CallStaticDoubleMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallStaticDoubleMethodV, ADDRESS);
    }

    public MemorySegment CallStaticDoubleMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticDoubleMethodA);
    }

    public void CallStaticDoubleMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticDoubleMethodA, value);
    }

    public MemorySegment $CallStaticDoubleMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallStaticDoubleMethodA, ADDRESS);
    }

    public MemorySegment CallStaticVoidMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticVoidMethod);
    }

    public void CallStaticVoidMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticVoidMethod, value);
    }

    public MemorySegment $CallStaticVoidMethod()
    {
        return this.pointer().asSlice(OFFSET__CallStaticVoidMethod, ADDRESS);
    }

    public MemorySegment CallStaticVoidMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticVoidMethodV);
    }

    public void CallStaticVoidMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticVoidMethodV, value);
    }

    public MemorySegment $CallStaticVoidMethodV()
    {
        return this.pointer().asSlice(OFFSET__CallStaticVoidMethodV, ADDRESS);
    }

    public MemorySegment CallStaticVoidMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET__CallStaticVoidMethodA);
    }

    public void CallStaticVoidMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__CallStaticVoidMethodA, value);
    }

    public MemorySegment $CallStaticVoidMethodA()
    {
        return this.pointer().asSlice(OFFSET__CallStaticVoidMethodA, ADDRESS);
    }

    public MemorySegment GetStaticFieldID()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetStaticFieldID);
    }

    public void GetStaticFieldID(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetStaticFieldID, value);
    }

    public MemorySegment $GetStaticFieldID()
    {
        return this.pointer().asSlice(OFFSET__GetStaticFieldID, ADDRESS);
    }

    public MemorySegment GetStaticObjectField()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetStaticObjectField);
    }

    public void GetStaticObjectField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetStaticObjectField, value);
    }

    public MemorySegment $GetStaticObjectField()
    {
        return this.pointer().asSlice(OFFSET__GetStaticObjectField, ADDRESS);
    }

    public MemorySegment GetStaticBooleanField()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetStaticBooleanField);
    }

    public void GetStaticBooleanField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetStaticBooleanField, value);
    }

    public MemorySegment $GetStaticBooleanField()
    {
        return this.pointer().asSlice(OFFSET__GetStaticBooleanField, ADDRESS);
    }

    public MemorySegment GetStaticByteField()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetStaticByteField);
    }

    public void GetStaticByteField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetStaticByteField, value);
    }

    public MemorySegment $GetStaticByteField()
    {
        return this.pointer().asSlice(OFFSET__GetStaticByteField, ADDRESS);
    }

    public MemorySegment GetStaticCharField()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetStaticCharField);
    }

    public void GetStaticCharField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetStaticCharField, value);
    }

    public MemorySegment $GetStaticCharField()
    {
        return this.pointer().asSlice(OFFSET__GetStaticCharField, ADDRESS);
    }

    public MemorySegment GetStaticShortField()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetStaticShortField);
    }

    public void GetStaticShortField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetStaticShortField, value);
    }

    public MemorySegment $GetStaticShortField()
    {
        return this.pointer().asSlice(OFFSET__GetStaticShortField, ADDRESS);
    }

    public MemorySegment GetStaticIntField()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetStaticIntField);
    }

    public void GetStaticIntField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetStaticIntField, value);
    }

    public MemorySegment $GetStaticIntField()
    {
        return this.pointer().asSlice(OFFSET__GetStaticIntField, ADDRESS);
    }

    public MemorySegment GetStaticLongField()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetStaticLongField);
    }

    public void GetStaticLongField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetStaticLongField, value);
    }

    public MemorySegment $GetStaticLongField()
    {
        return this.pointer().asSlice(OFFSET__GetStaticLongField, ADDRESS);
    }

    public MemorySegment GetStaticFloatField()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetStaticFloatField);
    }

    public void GetStaticFloatField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetStaticFloatField, value);
    }

    public MemorySegment $GetStaticFloatField()
    {
        return this.pointer().asSlice(OFFSET__GetStaticFloatField, ADDRESS);
    }

    public MemorySegment GetStaticDoubleField()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetStaticDoubleField);
    }

    public void GetStaticDoubleField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetStaticDoubleField, value);
    }

    public MemorySegment $GetStaticDoubleField()
    {
        return this.pointer().asSlice(OFFSET__GetStaticDoubleField, ADDRESS);
    }

    public MemorySegment SetStaticObjectField()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetStaticObjectField);
    }

    public void SetStaticObjectField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetStaticObjectField, value);
    }

    public MemorySegment $SetStaticObjectField()
    {
        return this.pointer().asSlice(OFFSET__SetStaticObjectField, ADDRESS);
    }

    public MemorySegment SetStaticBooleanField()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetStaticBooleanField);
    }

    public void SetStaticBooleanField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetStaticBooleanField, value);
    }

    public MemorySegment $SetStaticBooleanField()
    {
        return this.pointer().asSlice(OFFSET__SetStaticBooleanField, ADDRESS);
    }

    public MemorySegment SetStaticByteField()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetStaticByteField);
    }

    public void SetStaticByteField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetStaticByteField, value);
    }

    public MemorySegment $SetStaticByteField()
    {
        return this.pointer().asSlice(OFFSET__SetStaticByteField, ADDRESS);
    }

    public MemorySegment SetStaticCharField()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetStaticCharField);
    }

    public void SetStaticCharField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetStaticCharField, value);
    }

    public MemorySegment $SetStaticCharField()
    {
        return this.pointer().asSlice(OFFSET__SetStaticCharField, ADDRESS);
    }

    public MemorySegment SetStaticShortField()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetStaticShortField);
    }

    public void SetStaticShortField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetStaticShortField, value);
    }

    public MemorySegment $SetStaticShortField()
    {
        return this.pointer().asSlice(OFFSET__SetStaticShortField, ADDRESS);
    }

    public MemorySegment SetStaticIntField()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetStaticIntField);
    }

    public void SetStaticIntField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetStaticIntField, value);
    }

    public MemorySegment $SetStaticIntField()
    {
        return this.pointer().asSlice(OFFSET__SetStaticIntField, ADDRESS);
    }

    public MemorySegment SetStaticLongField()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetStaticLongField);
    }

    public void SetStaticLongField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetStaticLongField, value);
    }

    public MemorySegment $SetStaticLongField()
    {
        return this.pointer().asSlice(OFFSET__SetStaticLongField, ADDRESS);
    }

    public MemorySegment SetStaticFloatField()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetStaticFloatField);
    }

    public void SetStaticFloatField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetStaticFloatField, value);
    }

    public MemorySegment $SetStaticFloatField()
    {
        return this.pointer().asSlice(OFFSET__SetStaticFloatField, ADDRESS);
    }

    public MemorySegment SetStaticDoubleField()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetStaticDoubleField);
    }

    public void SetStaticDoubleField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetStaticDoubleField, value);
    }

    public MemorySegment $SetStaticDoubleField()
    {
        return this.pointer().asSlice(OFFSET__SetStaticDoubleField, ADDRESS);
    }

    public MemorySegment NewString()
    {
        return this.pointer().get(ADDRESS, OFFSET__NewString);
    }

    public void NewString(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__NewString, value);
    }

    public MemorySegment $NewString()
    {
        return this.pointer().asSlice(OFFSET__NewString, ADDRESS);
    }

    public MemorySegment GetStringLength()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetStringLength);
    }

    public void GetStringLength(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetStringLength, value);
    }

    public MemorySegment $GetStringLength()
    {
        return this.pointer().asSlice(OFFSET__GetStringLength, ADDRESS);
    }

    public MemorySegment GetStringChars()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetStringChars);
    }

    public void GetStringChars(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetStringChars, value);
    }

    public MemorySegment $GetStringChars()
    {
        return this.pointer().asSlice(OFFSET__GetStringChars, ADDRESS);
    }

    public MemorySegment ReleaseStringChars()
    {
        return this.pointer().get(ADDRESS, OFFSET__ReleaseStringChars);
    }

    public void ReleaseStringChars(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__ReleaseStringChars, value);
    }

    public MemorySegment $ReleaseStringChars()
    {
        return this.pointer().asSlice(OFFSET__ReleaseStringChars, ADDRESS);
    }

    public MemorySegment NewStringUTF()
    {
        return this.pointer().get(ADDRESS, OFFSET__NewStringUTF);
    }

    public void NewStringUTF(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__NewStringUTF, value);
    }

    public MemorySegment $NewStringUTF()
    {
        return this.pointer().asSlice(OFFSET__NewStringUTF, ADDRESS);
    }

    public MemorySegment GetStringUTFLength()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetStringUTFLength);
    }

    public void GetStringUTFLength(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetStringUTFLength, value);
    }

    public MemorySegment $GetStringUTFLength()
    {
        return this.pointer().asSlice(OFFSET__GetStringUTFLength, ADDRESS);
    }

    public MemorySegment GetStringUTFChars()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetStringUTFChars);
    }

    public void GetStringUTFChars(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetStringUTFChars, value);
    }

    public MemorySegment $GetStringUTFChars()
    {
        return this.pointer().asSlice(OFFSET__GetStringUTFChars, ADDRESS);
    }

    public MemorySegment ReleaseStringUTFChars()
    {
        return this.pointer().get(ADDRESS, OFFSET__ReleaseStringUTFChars);
    }

    public void ReleaseStringUTFChars(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__ReleaseStringUTFChars, value);
    }

    public MemorySegment $ReleaseStringUTFChars()
    {
        return this.pointer().asSlice(OFFSET__ReleaseStringUTFChars, ADDRESS);
    }

    public MemorySegment GetArrayLength()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetArrayLength);
    }

    public void GetArrayLength(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetArrayLength, value);
    }

    public MemorySegment $GetArrayLength()
    {
        return this.pointer().asSlice(OFFSET__GetArrayLength, ADDRESS);
    }

    public MemorySegment NewObjectArray()
    {
        return this.pointer().get(ADDRESS, OFFSET__NewObjectArray);
    }

    public void NewObjectArray(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__NewObjectArray, value);
    }

    public MemorySegment $NewObjectArray()
    {
        return this.pointer().asSlice(OFFSET__NewObjectArray, ADDRESS);
    }

    public MemorySegment GetObjectArrayElement()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetObjectArrayElement);
    }

    public void GetObjectArrayElement(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetObjectArrayElement, value);
    }

    public MemorySegment $GetObjectArrayElement()
    {
        return this.pointer().asSlice(OFFSET__GetObjectArrayElement, ADDRESS);
    }

    public MemorySegment SetObjectArrayElement()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetObjectArrayElement);
    }

    public void SetObjectArrayElement(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetObjectArrayElement, value);
    }

    public MemorySegment $SetObjectArrayElement()
    {
        return this.pointer().asSlice(OFFSET__SetObjectArrayElement, ADDRESS);
    }

    public MemorySegment NewBooleanArray()
    {
        return this.pointer().get(ADDRESS, OFFSET__NewBooleanArray);
    }

    public void NewBooleanArray(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__NewBooleanArray, value);
    }

    public MemorySegment $NewBooleanArray()
    {
        return this.pointer().asSlice(OFFSET__NewBooleanArray, ADDRESS);
    }

    public MemorySegment NewByteArray()
    {
        return this.pointer().get(ADDRESS, OFFSET__NewByteArray);
    }

    public void NewByteArray(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__NewByteArray, value);
    }

    public MemorySegment $NewByteArray()
    {
        return this.pointer().asSlice(OFFSET__NewByteArray, ADDRESS);
    }

    public MemorySegment NewCharArray()
    {
        return this.pointer().get(ADDRESS, OFFSET__NewCharArray);
    }

    public void NewCharArray(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__NewCharArray, value);
    }

    public MemorySegment $NewCharArray()
    {
        return this.pointer().asSlice(OFFSET__NewCharArray, ADDRESS);
    }

    public MemorySegment NewShortArray()
    {
        return this.pointer().get(ADDRESS, OFFSET__NewShortArray);
    }

    public void NewShortArray(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__NewShortArray, value);
    }

    public MemorySegment $NewShortArray()
    {
        return this.pointer().asSlice(OFFSET__NewShortArray, ADDRESS);
    }

    public MemorySegment NewIntArray()
    {
        return this.pointer().get(ADDRESS, OFFSET__NewIntArray);
    }

    public void NewIntArray(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__NewIntArray, value);
    }

    public MemorySegment $NewIntArray()
    {
        return this.pointer().asSlice(OFFSET__NewIntArray, ADDRESS);
    }

    public MemorySegment NewLongArray()
    {
        return this.pointer().get(ADDRESS, OFFSET__NewLongArray);
    }

    public void NewLongArray(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__NewLongArray, value);
    }

    public MemorySegment $NewLongArray()
    {
        return this.pointer().asSlice(OFFSET__NewLongArray, ADDRESS);
    }

    public MemorySegment NewFloatArray()
    {
        return this.pointer().get(ADDRESS, OFFSET__NewFloatArray);
    }

    public void NewFloatArray(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__NewFloatArray, value);
    }

    public MemorySegment $NewFloatArray()
    {
        return this.pointer().asSlice(OFFSET__NewFloatArray, ADDRESS);
    }

    public MemorySegment NewDoubleArray()
    {
        return this.pointer().get(ADDRESS, OFFSET__NewDoubleArray);
    }

    public void NewDoubleArray(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__NewDoubleArray, value);
    }

    public MemorySegment $NewDoubleArray()
    {
        return this.pointer().asSlice(OFFSET__NewDoubleArray, ADDRESS);
    }

    public MemorySegment GetBooleanArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetBooleanArrayElements);
    }

    public void GetBooleanArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetBooleanArrayElements, value);
    }

    public MemorySegment $GetBooleanArrayElements()
    {
        return this.pointer().asSlice(OFFSET__GetBooleanArrayElements, ADDRESS);
    }

    public MemorySegment GetByteArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetByteArrayElements);
    }

    public void GetByteArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetByteArrayElements, value);
    }

    public MemorySegment $GetByteArrayElements()
    {
        return this.pointer().asSlice(OFFSET__GetByteArrayElements, ADDRESS);
    }

    public MemorySegment GetCharArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetCharArrayElements);
    }

    public void GetCharArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetCharArrayElements, value);
    }

    public MemorySegment $GetCharArrayElements()
    {
        return this.pointer().asSlice(OFFSET__GetCharArrayElements, ADDRESS);
    }

    public MemorySegment GetShortArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetShortArrayElements);
    }

    public void GetShortArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetShortArrayElements, value);
    }

    public MemorySegment $GetShortArrayElements()
    {
        return this.pointer().asSlice(OFFSET__GetShortArrayElements, ADDRESS);
    }

    public MemorySegment GetIntArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetIntArrayElements);
    }

    public void GetIntArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetIntArrayElements, value);
    }

    public MemorySegment $GetIntArrayElements()
    {
        return this.pointer().asSlice(OFFSET__GetIntArrayElements, ADDRESS);
    }

    public MemorySegment GetLongArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetLongArrayElements);
    }

    public void GetLongArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetLongArrayElements, value);
    }

    public MemorySegment $GetLongArrayElements()
    {
        return this.pointer().asSlice(OFFSET__GetLongArrayElements, ADDRESS);
    }

    public MemorySegment GetFloatArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetFloatArrayElements);
    }

    public void GetFloatArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetFloatArrayElements, value);
    }

    public MemorySegment $GetFloatArrayElements()
    {
        return this.pointer().asSlice(OFFSET__GetFloatArrayElements, ADDRESS);
    }

    public MemorySegment GetDoubleArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetDoubleArrayElements);
    }

    public void GetDoubleArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetDoubleArrayElements, value);
    }

    public MemorySegment $GetDoubleArrayElements()
    {
        return this.pointer().asSlice(OFFSET__GetDoubleArrayElements, ADDRESS);
    }

    public MemorySegment ReleaseBooleanArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET__ReleaseBooleanArrayElements);
    }

    public void ReleaseBooleanArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__ReleaseBooleanArrayElements, value);
    }

    public MemorySegment $ReleaseBooleanArrayElements()
    {
        return this.pointer().asSlice(OFFSET__ReleaseBooleanArrayElements, ADDRESS);
    }

    public MemorySegment ReleaseByteArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET__ReleaseByteArrayElements);
    }

    public void ReleaseByteArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__ReleaseByteArrayElements, value);
    }

    public MemorySegment $ReleaseByteArrayElements()
    {
        return this.pointer().asSlice(OFFSET__ReleaseByteArrayElements, ADDRESS);
    }

    public MemorySegment ReleaseCharArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET__ReleaseCharArrayElements);
    }

    public void ReleaseCharArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__ReleaseCharArrayElements, value);
    }

    public MemorySegment $ReleaseCharArrayElements()
    {
        return this.pointer().asSlice(OFFSET__ReleaseCharArrayElements, ADDRESS);
    }

    public MemorySegment ReleaseShortArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET__ReleaseShortArrayElements);
    }

    public void ReleaseShortArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__ReleaseShortArrayElements, value);
    }

    public MemorySegment $ReleaseShortArrayElements()
    {
        return this.pointer().asSlice(OFFSET__ReleaseShortArrayElements, ADDRESS);
    }

    public MemorySegment ReleaseIntArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET__ReleaseIntArrayElements);
    }

    public void ReleaseIntArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__ReleaseIntArrayElements, value);
    }

    public MemorySegment $ReleaseIntArrayElements()
    {
        return this.pointer().asSlice(OFFSET__ReleaseIntArrayElements, ADDRESS);
    }

    public MemorySegment ReleaseLongArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET__ReleaseLongArrayElements);
    }

    public void ReleaseLongArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__ReleaseLongArrayElements, value);
    }

    public MemorySegment $ReleaseLongArrayElements()
    {
        return this.pointer().asSlice(OFFSET__ReleaseLongArrayElements, ADDRESS);
    }

    public MemorySegment ReleaseFloatArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET__ReleaseFloatArrayElements);
    }

    public void ReleaseFloatArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__ReleaseFloatArrayElements, value);
    }

    public MemorySegment $ReleaseFloatArrayElements()
    {
        return this.pointer().asSlice(OFFSET__ReleaseFloatArrayElements, ADDRESS);
    }

    public MemorySegment ReleaseDoubleArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET__ReleaseDoubleArrayElements);
    }

    public void ReleaseDoubleArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__ReleaseDoubleArrayElements, value);
    }

    public MemorySegment $ReleaseDoubleArrayElements()
    {
        return this.pointer().asSlice(OFFSET__ReleaseDoubleArrayElements, ADDRESS);
    }

    public MemorySegment GetBooleanArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetBooleanArrayRegion);
    }

    public void GetBooleanArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetBooleanArrayRegion, value);
    }

    public MemorySegment $GetBooleanArrayRegion()
    {
        return this.pointer().asSlice(OFFSET__GetBooleanArrayRegion, ADDRESS);
    }

    public MemorySegment GetByteArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetByteArrayRegion);
    }

    public void GetByteArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetByteArrayRegion, value);
    }

    public MemorySegment $GetByteArrayRegion()
    {
        return this.pointer().asSlice(OFFSET__GetByteArrayRegion, ADDRESS);
    }

    public MemorySegment GetCharArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetCharArrayRegion);
    }

    public void GetCharArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetCharArrayRegion, value);
    }

    public MemorySegment $GetCharArrayRegion()
    {
        return this.pointer().asSlice(OFFSET__GetCharArrayRegion, ADDRESS);
    }

    public MemorySegment GetShortArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetShortArrayRegion);
    }

    public void GetShortArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetShortArrayRegion, value);
    }

    public MemorySegment $GetShortArrayRegion()
    {
        return this.pointer().asSlice(OFFSET__GetShortArrayRegion, ADDRESS);
    }

    public MemorySegment GetIntArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetIntArrayRegion);
    }

    public void GetIntArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetIntArrayRegion, value);
    }

    public MemorySegment $GetIntArrayRegion()
    {
        return this.pointer().asSlice(OFFSET__GetIntArrayRegion, ADDRESS);
    }

    public MemorySegment GetLongArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetLongArrayRegion);
    }

    public void GetLongArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetLongArrayRegion, value);
    }

    public MemorySegment $GetLongArrayRegion()
    {
        return this.pointer().asSlice(OFFSET__GetLongArrayRegion, ADDRESS);
    }

    public MemorySegment GetFloatArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetFloatArrayRegion);
    }

    public void GetFloatArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetFloatArrayRegion, value);
    }

    public MemorySegment $GetFloatArrayRegion()
    {
        return this.pointer().asSlice(OFFSET__GetFloatArrayRegion, ADDRESS);
    }

    public MemorySegment GetDoubleArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetDoubleArrayRegion);
    }

    public void GetDoubleArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetDoubleArrayRegion, value);
    }

    public MemorySegment $GetDoubleArrayRegion()
    {
        return this.pointer().asSlice(OFFSET__GetDoubleArrayRegion, ADDRESS);
    }

    public MemorySegment SetBooleanArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetBooleanArrayRegion);
    }

    public void SetBooleanArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetBooleanArrayRegion, value);
    }

    public MemorySegment $SetBooleanArrayRegion()
    {
        return this.pointer().asSlice(OFFSET__SetBooleanArrayRegion, ADDRESS);
    }

    public MemorySegment SetByteArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetByteArrayRegion);
    }

    public void SetByteArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetByteArrayRegion, value);
    }

    public MemorySegment $SetByteArrayRegion()
    {
        return this.pointer().asSlice(OFFSET__SetByteArrayRegion, ADDRESS);
    }

    public MemorySegment SetCharArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetCharArrayRegion);
    }

    public void SetCharArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetCharArrayRegion, value);
    }

    public MemorySegment $SetCharArrayRegion()
    {
        return this.pointer().asSlice(OFFSET__SetCharArrayRegion, ADDRESS);
    }

    public MemorySegment SetShortArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetShortArrayRegion);
    }

    public void SetShortArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetShortArrayRegion, value);
    }

    public MemorySegment $SetShortArrayRegion()
    {
        return this.pointer().asSlice(OFFSET__SetShortArrayRegion, ADDRESS);
    }

    public MemorySegment SetIntArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetIntArrayRegion);
    }

    public void SetIntArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetIntArrayRegion, value);
    }

    public MemorySegment $SetIntArrayRegion()
    {
        return this.pointer().asSlice(OFFSET__SetIntArrayRegion, ADDRESS);
    }

    public MemorySegment SetLongArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetLongArrayRegion);
    }

    public void SetLongArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetLongArrayRegion, value);
    }

    public MemorySegment $SetLongArrayRegion()
    {
        return this.pointer().asSlice(OFFSET__SetLongArrayRegion, ADDRESS);
    }

    public MemorySegment SetFloatArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetFloatArrayRegion);
    }

    public void SetFloatArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetFloatArrayRegion, value);
    }

    public MemorySegment $SetFloatArrayRegion()
    {
        return this.pointer().asSlice(OFFSET__SetFloatArrayRegion, ADDRESS);
    }

    public MemorySegment SetDoubleArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET__SetDoubleArrayRegion);
    }

    public void SetDoubleArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__SetDoubleArrayRegion, value);
    }

    public MemorySegment $SetDoubleArrayRegion()
    {
        return this.pointer().asSlice(OFFSET__SetDoubleArrayRegion, ADDRESS);
    }

    public MemorySegment RegisterNatives()
    {
        return this.pointer().get(ADDRESS, OFFSET__RegisterNatives);
    }

    public void RegisterNatives(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__RegisterNatives, value);
    }

    public MemorySegment $RegisterNatives()
    {
        return this.pointer().asSlice(OFFSET__RegisterNatives, ADDRESS);
    }

    public MemorySegment UnregisterNatives()
    {
        return this.pointer().get(ADDRESS, OFFSET__UnregisterNatives);
    }

    public void UnregisterNatives(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__UnregisterNatives, value);
    }

    public MemorySegment $UnregisterNatives()
    {
        return this.pointer().asSlice(OFFSET__UnregisterNatives, ADDRESS);
    }

    public MemorySegment MonitorEnter()
    {
        return this.pointer().get(ADDRESS, OFFSET__MonitorEnter);
    }

    public void MonitorEnter(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__MonitorEnter, value);
    }

    public MemorySegment $MonitorEnter()
    {
        return this.pointer().asSlice(OFFSET__MonitorEnter, ADDRESS);
    }

    public MemorySegment MonitorExit()
    {
        return this.pointer().get(ADDRESS, OFFSET__MonitorExit);
    }

    public void MonitorExit(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__MonitorExit, value);
    }

    public MemorySegment $MonitorExit()
    {
        return this.pointer().asSlice(OFFSET__MonitorExit, ADDRESS);
    }

    public MemorySegment GetJavaVM()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetJavaVM);
    }

    public void GetJavaVM(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetJavaVM, value);
    }

    public MemorySegment $GetJavaVM()
    {
        return this.pointer().asSlice(OFFSET__GetJavaVM, ADDRESS);
    }

    public MemorySegment GetStringRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetStringRegion);
    }

    public void GetStringRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetStringRegion, value);
    }

    public MemorySegment $GetStringRegion()
    {
        return this.pointer().asSlice(OFFSET__GetStringRegion, ADDRESS);
    }

    public MemorySegment GetStringUTFRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetStringUTFRegion);
    }

    public void GetStringUTFRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetStringUTFRegion, value);
    }

    public MemorySegment $GetStringUTFRegion()
    {
        return this.pointer().asSlice(OFFSET__GetStringUTFRegion, ADDRESS);
    }

    public MemorySegment GetPrimitiveArrayCritical()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetPrimitiveArrayCritical);
    }

    public void GetPrimitiveArrayCritical(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetPrimitiveArrayCritical, value);
    }

    public MemorySegment $GetPrimitiveArrayCritical()
    {
        return this.pointer().asSlice(OFFSET__GetPrimitiveArrayCritical, ADDRESS);
    }

    public MemorySegment ReleasePrimitiveArrayCritical()
    {
        return this.pointer().get(ADDRESS, OFFSET__ReleasePrimitiveArrayCritical);
    }

    public void ReleasePrimitiveArrayCritical(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__ReleasePrimitiveArrayCritical, value);
    }

    public MemorySegment $ReleasePrimitiveArrayCritical()
    {
        return this.pointer().asSlice(OFFSET__ReleasePrimitiveArrayCritical, ADDRESS);
    }

    public MemorySegment GetStringCritical()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetStringCritical);
    }

    public void GetStringCritical(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetStringCritical, value);
    }

    public MemorySegment $GetStringCritical()
    {
        return this.pointer().asSlice(OFFSET__GetStringCritical, ADDRESS);
    }

    public MemorySegment ReleaseStringCritical()
    {
        return this.pointer().get(ADDRESS, OFFSET__ReleaseStringCritical);
    }

    public void ReleaseStringCritical(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__ReleaseStringCritical, value);
    }

    public MemorySegment $ReleaseStringCritical()
    {
        return this.pointer().asSlice(OFFSET__ReleaseStringCritical, ADDRESS);
    }

    public MemorySegment NewWeakGlobalRef()
    {
        return this.pointer().get(ADDRESS, OFFSET__NewWeakGlobalRef);
    }

    public void NewWeakGlobalRef(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__NewWeakGlobalRef, value);
    }

    public MemorySegment $NewWeakGlobalRef()
    {
        return this.pointer().asSlice(OFFSET__NewWeakGlobalRef, ADDRESS);
    }

    public MemorySegment DeleteWeakGlobalRef()
    {
        return this.pointer().get(ADDRESS, OFFSET__DeleteWeakGlobalRef);
    }

    public void DeleteWeakGlobalRef(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__DeleteWeakGlobalRef, value);
    }

    public MemorySegment $DeleteWeakGlobalRef()
    {
        return this.pointer().asSlice(OFFSET__DeleteWeakGlobalRef, ADDRESS);
    }

    public MemorySegment ExceptionCheck()
    {
        return this.pointer().get(ADDRESS, OFFSET__ExceptionCheck);
    }

    public void ExceptionCheck(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__ExceptionCheck, value);
    }

    public MemorySegment $ExceptionCheck()
    {
        return this.pointer().asSlice(OFFSET__ExceptionCheck, ADDRESS);
    }

    public MemorySegment NewDirectByteBuffer()
    {
        return this.pointer().get(ADDRESS, OFFSET__NewDirectByteBuffer);
    }

    public void NewDirectByteBuffer(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__NewDirectByteBuffer, value);
    }

    public MemorySegment $NewDirectByteBuffer()
    {
        return this.pointer().asSlice(OFFSET__NewDirectByteBuffer, ADDRESS);
    }

    public MemorySegment GetDirectBufferAddress()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetDirectBufferAddress);
    }

    public void GetDirectBufferAddress(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetDirectBufferAddress, value);
    }

    public MemorySegment $GetDirectBufferAddress()
    {
        return this.pointer().asSlice(OFFSET__GetDirectBufferAddress, ADDRESS);
    }

    public MemorySegment GetDirectBufferCapacity()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetDirectBufferCapacity);
    }

    public void GetDirectBufferCapacity(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetDirectBufferCapacity, value);
    }

    public MemorySegment $GetDirectBufferCapacity()
    {
        return this.pointer().asSlice(OFFSET__GetDirectBufferCapacity, ADDRESS);
    }

    public MemorySegment GetObjectRefType()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetObjectRefType);
    }

    public void GetObjectRefType(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetObjectRefType, value);
    }

    public MemorySegment $GetObjectRefType()
    {
        return this.pointer().asSlice(OFFSET__GetObjectRefType, ADDRESS);
    }

    public MemorySegment GetModule()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetModule);
    }

    public void GetModule(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetModule, value);
    }

    public MemorySegment $GetModule()
    {
        return this.pointer().asSlice(OFFSET__GetModule, ADDRESS);
    }

    public MemorySegment IsVirtualThread()
    {
        return this.pointer().get(ADDRESS, OFFSET__IsVirtualThread);
    }

    public void IsVirtualThread(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__IsVirtualThread, value);
    }

    public MemorySegment $IsVirtualThread()
    {
        return this.pointer().asSlice(OFFSET__IsVirtualThread, ADDRESS);
    }

    public MemorySegment GetStringUTFLengthAsLong()
    {
        return this.pointer().get(ADDRESS, OFFSET__GetStringUTFLengthAsLong);
    }

    public void GetStringUTFLengthAsLong(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET__GetStringUTFLengthAsLong, value);
    }

    public MemorySegment $GetStringUTFLengthAsLong()
    {
        return this.pointer().asSlice(OFFSET__GetStringUTFLengthAsLong, ADDRESS);
    }
}
