package fr.kenlek.j4p;

import module fr.kenlek.jpgen.api;
import module java.base;

import fr.kenlek.jpgen.api.Buffer;

import static fr.kenlek.jpgen.api.ForeignUtils.makeStructLayout;
import static java.lang.foreign.ValueLayout.*;

@Layout.Container("LAYOUT")
public record JNINativeInterface(MemorySegment pointer) implements Addressable
{
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
    public static final long OFFSET_reserved0 = LAYOUT.byteOffset(PathElement.groupElement("reserved0"));
    public static final long OFFSET_reserved1 = LAYOUT.byteOffset(PathElement.groupElement("reserved1"));
    public static final long OFFSET_reserved2 = LAYOUT.byteOffset(PathElement.groupElement("reserved2"));
    public static final long OFFSET_reserved3 = LAYOUT.byteOffset(PathElement.groupElement("reserved3"));
    public static final long OFFSET_GetVersion = LAYOUT.byteOffset(PathElement.groupElement("GetVersion"));
    public static final long OFFSET_DefineClass = LAYOUT.byteOffset(PathElement.groupElement("DefineClass"));
    public static final long OFFSET_FindClass = LAYOUT.byteOffset(PathElement.groupElement("FindClass"));
    public static final long OFFSET_FromReflectedMethod = LAYOUT.byteOffset(PathElement.groupElement("FromReflectedMethod"));
    public static final long OFFSET_FromReflectedField = LAYOUT.byteOffset(PathElement.groupElement("FromReflectedField"));
    public static final long OFFSET_ToReflectedMethod = LAYOUT.byteOffset(PathElement.groupElement("ToReflectedMethod"));
    public static final long OFFSET_GetSuperclass = LAYOUT.byteOffset(PathElement.groupElement("GetSuperclass"));
    public static final long OFFSET_IsAssignableFrom = LAYOUT.byteOffset(PathElement.groupElement("IsAssignableFrom"));
    public static final long OFFSET_ToReflectedField = LAYOUT.byteOffset(PathElement.groupElement("ToReflectedField"));
    public static final long OFFSET_Throw = LAYOUT.byteOffset(PathElement.groupElement("Throw"));
    public static final long OFFSET_ThrowNew = LAYOUT.byteOffset(PathElement.groupElement("ThrowNew"));
    public static final long OFFSET_ExceptionOccurred = LAYOUT.byteOffset(PathElement.groupElement("ExceptionOccurred"));
    public static final long OFFSET_ExceptionDescribe = LAYOUT.byteOffset(PathElement.groupElement("ExceptionDescribe"));
    public static final long OFFSET_ExceptionClear = LAYOUT.byteOffset(PathElement.groupElement("ExceptionClear"));
    public static final long OFFSET_FatalError = LAYOUT.byteOffset(PathElement.groupElement("FatalError"));
    public static final long OFFSET_PushLocalFrame = LAYOUT.byteOffset(PathElement.groupElement("PushLocalFrame"));
    public static final long OFFSET_PopLocalFrame = LAYOUT.byteOffset(PathElement.groupElement("PopLocalFrame"));
    public static final long OFFSET_NewGlobalRef = LAYOUT.byteOffset(PathElement.groupElement("NewGlobalRef"));
    public static final long OFFSET_DeleteGlobalRef = LAYOUT.byteOffset(PathElement.groupElement("DeleteGlobalRef"));
    public static final long OFFSET_DeleteLocalRef = LAYOUT.byteOffset(PathElement.groupElement("DeleteLocalRef"));
    public static final long OFFSET_IsSameObject = LAYOUT.byteOffset(PathElement.groupElement("IsSameObject"));
    public static final long OFFSET_NewLocalRef = LAYOUT.byteOffset(PathElement.groupElement("NewLocalRef"));
    public static final long OFFSET_EnsureLocalCapacity = LAYOUT.byteOffset(PathElement.groupElement("EnsureLocalCapacity"));
    public static final long OFFSET_AllocObject = LAYOUT.byteOffset(PathElement.groupElement("AllocObject"));
    public static final long OFFSET_NewObject = LAYOUT.byteOffset(PathElement.groupElement("NewObject"));
    public static final long OFFSET_NewObjectV = LAYOUT.byteOffset(PathElement.groupElement("NewObjectV"));
    public static final long OFFSET_NewObjectA = LAYOUT.byteOffset(PathElement.groupElement("NewObjectA"));
    public static final long OFFSET_GetObjectClass = LAYOUT.byteOffset(PathElement.groupElement("GetObjectClass"));
    public static final long OFFSET_IsInstanceOf = LAYOUT.byteOffset(PathElement.groupElement("IsInstanceOf"));
    public static final long OFFSET_GetMethodID = LAYOUT.byteOffset(PathElement.groupElement("GetMethodID"));
    public static final long OFFSET_CallObjectMethod = LAYOUT.byteOffset(PathElement.groupElement("CallObjectMethod"));
    public static final long OFFSET_CallObjectMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallObjectMethodV"));
    public static final long OFFSET_CallObjectMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallObjectMethodA"));
    public static final long OFFSET_CallBooleanMethod = LAYOUT.byteOffset(PathElement.groupElement("CallBooleanMethod"));
    public static final long OFFSET_CallBooleanMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallBooleanMethodV"));
    public static final long OFFSET_CallBooleanMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallBooleanMethodA"));
    public static final long OFFSET_CallByteMethod = LAYOUT.byteOffset(PathElement.groupElement("CallByteMethod"));
    public static final long OFFSET_CallByteMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallByteMethodV"));
    public static final long OFFSET_CallByteMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallByteMethodA"));
    public static final long OFFSET_CallCharMethod = LAYOUT.byteOffset(PathElement.groupElement("CallCharMethod"));
    public static final long OFFSET_CallCharMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallCharMethodV"));
    public static final long OFFSET_CallCharMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallCharMethodA"));
    public static final long OFFSET_CallShortMethod = LAYOUT.byteOffset(PathElement.groupElement("CallShortMethod"));
    public static final long OFFSET_CallShortMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallShortMethodV"));
    public static final long OFFSET_CallShortMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallShortMethodA"));
    public static final long OFFSET_CallIntMethod = LAYOUT.byteOffset(PathElement.groupElement("CallIntMethod"));
    public static final long OFFSET_CallIntMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallIntMethodV"));
    public static final long OFFSET_CallIntMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallIntMethodA"));
    public static final long OFFSET_CallLongMethod = LAYOUT.byteOffset(PathElement.groupElement("CallLongMethod"));
    public static final long OFFSET_CallLongMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallLongMethodV"));
    public static final long OFFSET_CallLongMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallLongMethodA"));
    public static final long OFFSET_CallFloatMethod = LAYOUT.byteOffset(PathElement.groupElement("CallFloatMethod"));
    public static final long OFFSET_CallFloatMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallFloatMethodV"));
    public static final long OFFSET_CallFloatMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallFloatMethodA"));
    public static final long OFFSET_CallDoubleMethod = LAYOUT.byteOffset(PathElement.groupElement("CallDoubleMethod"));
    public static final long OFFSET_CallDoubleMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallDoubleMethodV"));
    public static final long OFFSET_CallDoubleMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallDoubleMethodA"));
    public static final long OFFSET_CallVoidMethod = LAYOUT.byteOffset(PathElement.groupElement("CallVoidMethod"));
    public static final long OFFSET_CallVoidMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallVoidMethodV"));
    public static final long OFFSET_CallVoidMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallVoidMethodA"));
    public static final long OFFSET_CallNonvirtualObjectMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualObjectMethod"));
    public static final long OFFSET_CallNonvirtualObjectMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualObjectMethodV"));
    public static final long OFFSET_CallNonvirtualObjectMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualObjectMethodA"));
    public static final long OFFSET_CallNonvirtualBooleanMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualBooleanMethod"));
    public static final long OFFSET_CallNonvirtualBooleanMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualBooleanMethodV"));
    public static final long OFFSET_CallNonvirtualBooleanMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualBooleanMethodA"));
    public static final long OFFSET_CallNonvirtualByteMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualByteMethod"));
    public static final long OFFSET_CallNonvirtualByteMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualByteMethodV"));
    public static final long OFFSET_CallNonvirtualByteMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualByteMethodA"));
    public static final long OFFSET_CallNonvirtualCharMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualCharMethod"));
    public static final long OFFSET_CallNonvirtualCharMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualCharMethodV"));
    public static final long OFFSET_CallNonvirtualCharMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualCharMethodA"));
    public static final long OFFSET_CallNonvirtualShortMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualShortMethod"));
    public static final long OFFSET_CallNonvirtualShortMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualShortMethodV"));
    public static final long OFFSET_CallNonvirtualShortMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualShortMethodA"));
    public static final long OFFSET_CallNonvirtualIntMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualIntMethod"));
    public static final long OFFSET_CallNonvirtualIntMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualIntMethodV"));
    public static final long OFFSET_CallNonvirtualIntMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualIntMethodA"));
    public static final long OFFSET_CallNonvirtualLongMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualLongMethod"));
    public static final long OFFSET_CallNonvirtualLongMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualLongMethodV"));
    public static final long OFFSET_CallNonvirtualLongMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualLongMethodA"));
    public static final long OFFSET_CallNonvirtualFloatMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualFloatMethod"));
    public static final long OFFSET_CallNonvirtualFloatMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualFloatMethodV"));
    public static final long OFFSET_CallNonvirtualFloatMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualFloatMethodA"));
    public static final long OFFSET_CallNonvirtualDoubleMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualDoubleMethod"));
    public static final long OFFSET_CallNonvirtualDoubleMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualDoubleMethodV"));
    public static final long OFFSET_CallNonvirtualDoubleMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualDoubleMethodA"));
    public static final long OFFSET_CallNonvirtualVoidMethod = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualVoidMethod"));
    public static final long OFFSET_CallNonvirtualVoidMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualVoidMethodV"));
    public static final long OFFSET_CallNonvirtualVoidMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallNonvirtualVoidMethodA"));
    public static final long OFFSET_GetFieldID = LAYOUT.byteOffset(PathElement.groupElement("GetFieldID"));
    public static final long OFFSET_GetObjectField = LAYOUT.byteOffset(PathElement.groupElement("GetObjectField"));
    public static final long OFFSET_GetBooleanField = LAYOUT.byteOffset(PathElement.groupElement("GetBooleanField"));
    public static final long OFFSET_GetByteField = LAYOUT.byteOffset(PathElement.groupElement("GetByteField"));
    public static final long OFFSET_GetCharField = LAYOUT.byteOffset(PathElement.groupElement("GetCharField"));
    public static final long OFFSET_GetShortField = LAYOUT.byteOffset(PathElement.groupElement("GetShortField"));
    public static final long OFFSET_GetIntField = LAYOUT.byteOffset(PathElement.groupElement("GetIntField"));
    public static final long OFFSET_GetLongField = LAYOUT.byteOffset(PathElement.groupElement("GetLongField"));
    public static final long OFFSET_GetFloatField = LAYOUT.byteOffset(PathElement.groupElement("GetFloatField"));
    public static final long OFFSET_GetDoubleField = LAYOUT.byteOffset(PathElement.groupElement("GetDoubleField"));
    public static final long OFFSET_SetObjectField = LAYOUT.byteOffset(PathElement.groupElement("SetObjectField"));
    public static final long OFFSET_SetBooleanField = LAYOUT.byteOffset(PathElement.groupElement("SetBooleanField"));
    public static final long OFFSET_SetByteField = LAYOUT.byteOffset(PathElement.groupElement("SetByteField"));
    public static final long OFFSET_SetCharField = LAYOUT.byteOffset(PathElement.groupElement("SetCharField"));
    public static final long OFFSET_SetShortField = LAYOUT.byteOffset(PathElement.groupElement("SetShortField"));
    public static final long OFFSET_SetIntField = LAYOUT.byteOffset(PathElement.groupElement("SetIntField"));
    public static final long OFFSET_SetLongField = LAYOUT.byteOffset(PathElement.groupElement("SetLongField"));
    public static final long OFFSET_SetFloatField = LAYOUT.byteOffset(PathElement.groupElement("SetFloatField"));
    public static final long OFFSET_SetDoubleField = LAYOUT.byteOffset(PathElement.groupElement("SetDoubleField"));
    public static final long OFFSET_GetStaticMethodID = LAYOUT.byteOffset(PathElement.groupElement("GetStaticMethodID"));
    public static final long OFFSET_CallStaticObjectMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticObjectMethod"));
    public static final long OFFSET_CallStaticObjectMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticObjectMethodV"));
    public static final long OFFSET_CallStaticObjectMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticObjectMethodA"));
    public static final long OFFSET_CallStaticBooleanMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticBooleanMethod"));
    public static final long OFFSET_CallStaticBooleanMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticBooleanMethodV"));
    public static final long OFFSET_CallStaticBooleanMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticBooleanMethodA"));
    public static final long OFFSET_CallStaticByteMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticByteMethod"));
    public static final long OFFSET_CallStaticByteMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticByteMethodV"));
    public static final long OFFSET_CallStaticByteMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticByteMethodA"));
    public static final long OFFSET_CallStaticCharMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticCharMethod"));
    public static final long OFFSET_CallStaticCharMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticCharMethodV"));
    public static final long OFFSET_CallStaticCharMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticCharMethodA"));
    public static final long OFFSET_CallStaticShortMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticShortMethod"));
    public static final long OFFSET_CallStaticShortMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticShortMethodV"));
    public static final long OFFSET_CallStaticShortMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticShortMethodA"));
    public static final long OFFSET_CallStaticIntMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticIntMethod"));
    public static final long OFFSET_CallStaticIntMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticIntMethodV"));
    public static final long OFFSET_CallStaticIntMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticIntMethodA"));
    public static final long OFFSET_CallStaticLongMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticLongMethod"));
    public static final long OFFSET_CallStaticLongMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticLongMethodV"));
    public static final long OFFSET_CallStaticLongMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticLongMethodA"));
    public static final long OFFSET_CallStaticFloatMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticFloatMethod"));
    public static final long OFFSET_CallStaticFloatMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticFloatMethodV"));
    public static final long OFFSET_CallStaticFloatMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticFloatMethodA"));
    public static final long OFFSET_CallStaticDoubleMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticDoubleMethod"));
    public static final long OFFSET_CallStaticDoubleMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticDoubleMethodV"));
    public static final long OFFSET_CallStaticDoubleMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticDoubleMethodA"));
    public static final long OFFSET_CallStaticVoidMethod = LAYOUT.byteOffset(PathElement.groupElement("CallStaticVoidMethod"));
    public static final long OFFSET_CallStaticVoidMethodV = LAYOUT.byteOffset(PathElement.groupElement("CallStaticVoidMethodV"));
    public static final long OFFSET_CallStaticVoidMethodA = LAYOUT.byteOffset(PathElement.groupElement("CallStaticVoidMethodA"));
    public static final long OFFSET_GetStaticFieldID = LAYOUT.byteOffset(PathElement.groupElement("GetStaticFieldID"));
    public static final long OFFSET_GetStaticObjectField = LAYOUT.byteOffset(PathElement.groupElement("GetStaticObjectField"));
    public static final long OFFSET_GetStaticBooleanField = LAYOUT.byteOffset(PathElement.groupElement("GetStaticBooleanField"));
    public static final long OFFSET_GetStaticByteField = LAYOUT.byteOffset(PathElement.groupElement("GetStaticByteField"));
    public static final long OFFSET_GetStaticCharField = LAYOUT.byteOffset(PathElement.groupElement("GetStaticCharField"));
    public static final long OFFSET_GetStaticShortField = LAYOUT.byteOffset(PathElement.groupElement("GetStaticShortField"));
    public static final long OFFSET_GetStaticIntField = LAYOUT.byteOffset(PathElement.groupElement("GetStaticIntField"));
    public static final long OFFSET_GetStaticLongField = LAYOUT.byteOffset(PathElement.groupElement("GetStaticLongField"));
    public static final long OFFSET_GetStaticFloatField = LAYOUT.byteOffset(PathElement.groupElement("GetStaticFloatField"));
    public static final long OFFSET_GetStaticDoubleField = LAYOUT.byteOffset(PathElement.groupElement("GetStaticDoubleField"));
    public static final long OFFSET_SetStaticObjectField = LAYOUT.byteOffset(PathElement.groupElement("SetStaticObjectField"));
    public static final long OFFSET_SetStaticBooleanField = LAYOUT.byteOffset(PathElement.groupElement("SetStaticBooleanField"));
    public static final long OFFSET_SetStaticByteField = LAYOUT.byteOffset(PathElement.groupElement("SetStaticByteField"));
    public static final long OFFSET_SetStaticCharField = LAYOUT.byteOffset(PathElement.groupElement("SetStaticCharField"));
    public static final long OFFSET_SetStaticShortField = LAYOUT.byteOffset(PathElement.groupElement("SetStaticShortField"));
    public static final long OFFSET_SetStaticIntField = LAYOUT.byteOffset(PathElement.groupElement("SetStaticIntField"));
    public static final long OFFSET_SetStaticLongField = LAYOUT.byteOffset(PathElement.groupElement("SetStaticLongField"));
    public static final long OFFSET_SetStaticFloatField = LAYOUT.byteOffset(PathElement.groupElement("SetStaticFloatField"));
    public static final long OFFSET_SetStaticDoubleField = LAYOUT.byteOffset(PathElement.groupElement("SetStaticDoubleField"));
    public static final long OFFSET_NewString = LAYOUT.byteOffset(PathElement.groupElement("NewString"));
    public static final long OFFSET_GetStringLength = LAYOUT.byteOffset(PathElement.groupElement("GetStringLength"));
    public static final long OFFSET_GetStringChars = LAYOUT.byteOffset(PathElement.groupElement("GetStringChars"));
    public static final long OFFSET_ReleaseStringChars = LAYOUT.byteOffset(PathElement.groupElement("ReleaseStringChars"));
    public static final long OFFSET_NewStringUTF = LAYOUT.byteOffset(PathElement.groupElement("NewStringUTF"));
    public static final long OFFSET_GetStringUTFLength = LAYOUT.byteOffset(PathElement.groupElement("GetStringUTFLength"));
    public static final long OFFSET_GetStringUTFChars = LAYOUT.byteOffset(PathElement.groupElement("GetStringUTFChars"));
    public static final long OFFSET_ReleaseStringUTFChars = LAYOUT.byteOffset(PathElement.groupElement("ReleaseStringUTFChars"));
    public static final long OFFSET_GetArrayLength = LAYOUT.byteOffset(PathElement.groupElement("GetArrayLength"));
    public static final long OFFSET_NewObjectArray = LAYOUT.byteOffset(PathElement.groupElement("NewObjectArray"));
    public static final long OFFSET_GetObjectArrayElement = LAYOUT.byteOffset(PathElement.groupElement("GetObjectArrayElement"));
    public static final long OFFSET_SetObjectArrayElement = LAYOUT.byteOffset(PathElement.groupElement("SetObjectArrayElement"));
    public static final long OFFSET_NewBooleanArray = LAYOUT.byteOffset(PathElement.groupElement("NewBooleanArray"));
    public static final long OFFSET_NewByteArray = LAYOUT.byteOffset(PathElement.groupElement("NewByteArray"));
    public static final long OFFSET_NewCharArray = LAYOUT.byteOffset(PathElement.groupElement("NewCharArray"));
    public static final long OFFSET_NewShortArray = LAYOUT.byteOffset(PathElement.groupElement("NewShortArray"));
    public static final long OFFSET_NewIntArray = LAYOUT.byteOffset(PathElement.groupElement("NewIntArray"));
    public static final long OFFSET_NewLongArray = LAYOUT.byteOffset(PathElement.groupElement("NewLongArray"));
    public static final long OFFSET_NewFloatArray = LAYOUT.byteOffset(PathElement.groupElement("NewFloatArray"));
    public static final long OFFSET_NewDoubleArray = LAYOUT.byteOffset(PathElement.groupElement("NewDoubleArray"));
    public static final long OFFSET_GetBooleanArrayElements = LAYOUT.byteOffset(PathElement.groupElement("GetBooleanArrayElements"));
    public static final long OFFSET_GetByteArrayElements = LAYOUT.byteOffset(PathElement.groupElement("GetByteArrayElements"));
    public static final long OFFSET_GetCharArrayElements = LAYOUT.byteOffset(PathElement.groupElement("GetCharArrayElements"));
    public static final long OFFSET_GetShortArrayElements = LAYOUT.byteOffset(PathElement.groupElement("GetShortArrayElements"));
    public static final long OFFSET_GetIntArrayElements = LAYOUT.byteOffset(PathElement.groupElement("GetIntArrayElements"));
    public static final long OFFSET_GetLongArrayElements = LAYOUT.byteOffset(PathElement.groupElement("GetLongArrayElements"));
    public static final long OFFSET_GetFloatArrayElements = LAYOUT.byteOffset(PathElement.groupElement("GetFloatArrayElements"));
    public static final long OFFSET_GetDoubleArrayElements = LAYOUT.byteOffset(PathElement.groupElement("GetDoubleArrayElements"));
    public static final long OFFSET_ReleaseBooleanArrayElements = LAYOUT.byteOffset(PathElement.groupElement("ReleaseBooleanArrayElements"));
    public static final long OFFSET_ReleaseByteArrayElements = LAYOUT.byteOffset(PathElement.groupElement("ReleaseByteArrayElements"));
    public static final long OFFSET_ReleaseCharArrayElements = LAYOUT.byteOffset(PathElement.groupElement("ReleaseCharArrayElements"));
    public static final long OFFSET_ReleaseShortArrayElements = LAYOUT.byteOffset(PathElement.groupElement("ReleaseShortArrayElements"));
    public static final long OFFSET_ReleaseIntArrayElements = LAYOUT.byteOffset(PathElement.groupElement("ReleaseIntArrayElements"));
    public static final long OFFSET_ReleaseLongArrayElements = LAYOUT.byteOffset(PathElement.groupElement("ReleaseLongArrayElements"));
    public static final long OFFSET_ReleaseFloatArrayElements = LAYOUT.byteOffset(PathElement.groupElement("ReleaseFloatArrayElements"));
    public static final long OFFSET_ReleaseDoubleArrayElements = LAYOUT.byteOffset(PathElement.groupElement("ReleaseDoubleArrayElements"));
    public static final long OFFSET_GetBooleanArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("GetBooleanArrayRegion"));
    public static final long OFFSET_GetByteArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("GetByteArrayRegion"));
    public static final long OFFSET_GetCharArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("GetCharArrayRegion"));
    public static final long OFFSET_GetShortArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("GetShortArrayRegion"));
    public static final long OFFSET_GetIntArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("GetIntArrayRegion"));
    public static final long OFFSET_GetLongArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("GetLongArrayRegion"));
    public static final long OFFSET_GetFloatArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("GetFloatArrayRegion"));
    public static final long OFFSET_GetDoubleArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("GetDoubleArrayRegion"));
    public static final long OFFSET_SetBooleanArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("SetBooleanArrayRegion"));
    public static final long OFFSET_SetByteArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("SetByteArrayRegion"));
    public static final long OFFSET_SetCharArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("SetCharArrayRegion"));
    public static final long OFFSET_SetShortArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("SetShortArrayRegion"));
    public static final long OFFSET_SetIntArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("SetIntArrayRegion"));
    public static final long OFFSET_SetLongArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("SetLongArrayRegion"));
    public static final long OFFSET_SetFloatArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("SetFloatArrayRegion"));
    public static final long OFFSET_SetDoubleArrayRegion = LAYOUT.byteOffset(PathElement.groupElement("SetDoubleArrayRegion"));
    public static final long OFFSET_RegisterNatives = LAYOUT.byteOffset(PathElement.groupElement("RegisterNatives"));
    public static final long OFFSET_UnregisterNatives = LAYOUT.byteOffset(PathElement.groupElement("UnregisterNatives"));
    public static final long OFFSET_MonitorEnter = LAYOUT.byteOffset(PathElement.groupElement("MonitorEnter"));
    public static final long OFFSET_MonitorExit = LAYOUT.byteOffset(PathElement.groupElement("MonitorExit"));
    public static final long OFFSET_GetJavaVM = LAYOUT.byteOffset(PathElement.groupElement("GetJavaVM"));
    public static final long OFFSET_GetStringRegion = LAYOUT.byteOffset(PathElement.groupElement("GetStringRegion"));
    public static final long OFFSET_GetStringUTFRegion = LAYOUT.byteOffset(PathElement.groupElement("GetStringUTFRegion"));
    public static final long OFFSET_GetPrimitiveArrayCritical = LAYOUT.byteOffset(PathElement.groupElement("GetPrimitiveArrayCritical"));
    public static final long OFFSET_ReleasePrimitiveArrayCritical = LAYOUT.byteOffset(PathElement.groupElement("ReleasePrimitiveArrayCritical"));
    public static final long OFFSET_GetStringCritical = LAYOUT.byteOffset(PathElement.groupElement("GetStringCritical"));
    public static final long OFFSET_ReleaseStringCritical = LAYOUT.byteOffset(PathElement.groupElement("ReleaseStringCritical"));
    public static final long OFFSET_NewWeakGlobalRef = LAYOUT.byteOffset(PathElement.groupElement("NewWeakGlobalRef"));
    public static final long OFFSET_DeleteWeakGlobalRef = LAYOUT.byteOffset(PathElement.groupElement("DeleteWeakGlobalRef"));
    public static final long OFFSET_ExceptionCheck = LAYOUT.byteOffset(PathElement.groupElement("ExceptionCheck"));
    public static final long OFFSET_NewDirectByteBuffer = LAYOUT.byteOffset(PathElement.groupElement("NewDirectByteBuffer"));
    public static final long OFFSET_GetDirectBufferAddress = LAYOUT.byteOffset(PathElement.groupElement("GetDirectBufferAddress"));
    public static final long OFFSET_GetDirectBufferCapacity = LAYOUT.byteOffset(PathElement.groupElement("GetDirectBufferCapacity"));
    public static final long OFFSET_GetObjectRefType = LAYOUT.byteOffset(PathElement.groupElement("GetObjectRefType"));
    public static final long OFFSET_GetModule = LAYOUT.byteOffset(PathElement.groupElement("GetModule"));
    public static final long OFFSET_IsVirtualThread = LAYOUT.byteOffset(PathElement.groupElement("IsVirtualThread"));
    public static final long OFFSET_GetStringUTFLengthAsLong = LAYOUT.byteOffset(PathElement.groupElement("GetStringUTFLengthAsLong"));

    public JNINativeInterface
    {
        Addressable.checkLayoutConstraints(pointer, LAYOUT);
    }

    public JNINativeInterface(SegmentAllocator allocator)
    {
        this(allocator.allocate(LAYOUT));
    }

    public static Buffer<JNINativeInterface> buffer(MemorySegment data)
    {
        return Buffer.slices(data, LAYOUT, JNINativeInterface::new);
    }

    public static Buffer<JNINativeInterface> allocate(SegmentAllocator allocator, long size)
    {
        return Buffer.allocateSlices(allocator, LAYOUT, size, JNINativeInterface::new);
    }

    public static JNINativeInterface getAtIndex(MemorySegment buffer, long offset, long index)
    {
        return new JNINativeInterface(buffer.asSlice(LAYOUT.scale(offset, index), LAYOUT));
    }

    public static void setAtIndex(MemorySegment buffer, long offset, long index, JNINativeInterface value)
    {
        MemorySegment.copy(value.pointer(), 0, buffer, LAYOUT.scale(offset, index), LAYOUT.byteSize());
    }

    public void copyFrom(JNINativeInterface other)
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

    public MemorySegment reserved3()
    {
        return this.pointer().get(ADDRESS, OFFSET_reserved3);
    }

    public void reserved3(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_reserved3, value);
    }

    public MemorySegment $reserved3()
    {
        return this.pointer().asSlice(OFFSET_reserved3, ADDRESS);
    }

    public MemorySegment GetVersion()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetVersion);
    }

    public void GetVersion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetVersion, value);
    }

    public MemorySegment $GetVersion()
    {
        return this.pointer().asSlice(OFFSET_GetVersion, ADDRESS);
    }

    public MemorySegment DefineClass()
    {
        return this.pointer().get(ADDRESS, OFFSET_DefineClass);
    }

    public void DefineClass(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_DefineClass, value);
    }

    public MemorySegment $DefineClass()
    {
        return this.pointer().asSlice(OFFSET_DefineClass, ADDRESS);
    }

    public MemorySegment FindClass()
    {
        return this.pointer().get(ADDRESS, OFFSET_FindClass);
    }

    public void FindClass(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_FindClass, value);
    }

    public MemorySegment $FindClass()
    {
        return this.pointer().asSlice(OFFSET_FindClass, ADDRESS);
    }

    public MemorySegment FromReflectedMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_FromReflectedMethod);
    }

    public void FromReflectedMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_FromReflectedMethod, value);
    }

    public MemorySegment $FromReflectedMethod()
    {
        return this.pointer().asSlice(OFFSET_FromReflectedMethod, ADDRESS);
    }

    public MemorySegment FromReflectedField()
    {
        return this.pointer().get(ADDRESS, OFFSET_FromReflectedField);
    }

    public void FromReflectedField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_FromReflectedField, value);
    }

    public MemorySegment $FromReflectedField()
    {
        return this.pointer().asSlice(OFFSET_FromReflectedField, ADDRESS);
    }

    public MemorySegment ToReflectedMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_ToReflectedMethod);
    }

    public void ToReflectedMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_ToReflectedMethod, value);
    }

    public MemorySegment $ToReflectedMethod()
    {
        return this.pointer().asSlice(OFFSET_ToReflectedMethod, ADDRESS);
    }

    public MemorySegment GetSuperclass()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetSuperclass);
    }

    public void GetSuperclass(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetSuperclass, value);
    }

    public MemorySegment $GetSuperclass()
    {
        return this.pointer().asSlice(OFFSET_GetSuperclass, ADDRESS);
    }

    public MemorySegment IsAssignableFrom()
    {
        return this.pointer().get(ADDRESS, OFFSET_IsAssignableFrom);
    }

    public void IsAssignableFrom(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_IsAssignableFrom, value);
    }

    public MemorySegment $IsAssignableFrom()
    {
        return this.pointer().asSlice(OFFSET_IsAssignableFrom, ADDRESS);
    }

    public MemorySegment ToReflectedField()
    {
        return this.pointer().get(ADDRESS, OFFSET_ToReflectedField);
    }

    public void ToReflectedField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_ToReflectedField, value);
    }

    public MemorySegment $ToReflectedField()
    {
        return this.pointer().asSlice(OFFSET_ToReflectedField, ADDRESS);
    }

    public MemorySegment Throw()
    {
        return this.pointer().get(ADDRESS, OFFSET_Throw);
    }

    public void Throw(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_Throw, value);
    }

    public MemorySegment $Throw()
    {
        return this.pointer().asSlice(OFFSET_Throw, ADDRESS);
    }

    public MemorySegment ThrowNew()
    {
        return this.pointer().get(ADDRESS, OFFSET_ThrowNew);
    }

    public void ThrowNew(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_ThrowNew, value);
    }

    public MemorySegment $ThrowNew()
    {
        return this.pointer().asSlice(OFFSET_ThrowNew, ADDRESS);
    }

    public MemorySegment ExceptionOccurred()
    {
        return this.pointer().get(ADDRESS, OFFSET_ExceptionOccurred);
    }

    public void ExceptionOccurred(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_ExceptionOccurred, value);
    }

    public MemorySegment $ExceptionOccurred()
    {
        return this.pointer().asSlice(OFFSET_ExceptionOccurred, ADDRESS);
    }

    public MemorySegment ExceptionDescribe()
    {
        return this.pointer().get(ADDRESS, OFFSET_ExceptionDescribe);
    }

    public void ExceptionDescribe(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_ExceptionDescribe, value);
    }

    public MemorySegment $ExceptionDescribe()
    {
        return this.pointer().asSlice(OFFSET_ExceptionDescribe, ADDRESS);
    }

    public MemorySegment ExceptionClear()
    {
        return this.pointer().get(ADDRESS, OFFSET_ExceptionClear);
    }

    public void ExceptionClear(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_ExceptionClear, value);
    }

    public MemorySegment $ExceptionClear()
    {
        return this.pointer().asSlice(OFFSET_ExceptionClear, ADDRESS);
    }

    public MemorySegment FatalError()
    {
        return this.pointer().get(ADDRESS, OFFSET_FatalError);
    }

    public void FatalError(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_FatalError, value);
    }

    public MemorySegment $FatalError()
    {
        return this.pointer().asSlice(OFFSET_FatalError, ADDRESS);
    }

    public MemorySegment PushLocalFrame()
    {
        return this.pointer().get(ADDRESS, OFFSET_PushLocalFrame);
    }

    public void PushLocalFrame(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_PushLocalFrame, value);
    }

    public MemorySegment $PushLocalFrame()
    {
        return this.pointer().asSlice(OFFSET_PushLocalFrame, ADDRESS);
    }

    public MemorySegment PopLocalFrame()
    {
        return this.pointer().get(ADDRESS, OFFSET_PopLocalFrame);
    }

    public void PopLocalFrame(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_PopLocalFrame, value);
    }

    public MemorySegment $PopLocalFrame()
    {
        return this.pointer().asSlice(OFFSET_PopLocalFrame, ADDRESS);
    }

    public MemorySegment NewGlobalRef()
    {
        return this.pointer().get(ADDRESS, OFFSET_NewGlobalRef);
    }

    public void NewGlobalRef(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_NewGlobalRef, value);
    }

    public MemorySegment $NewGlobalRef()
    {
        return this.pointer().asSlice(OFFSET_NewGlobalRef, ADDRESS);
    }

    public MemorySegment DeleteGlobalRef()
    {
        return this.pointer().get(ADDRESS, OFFSET_DeleteGlobalRef);
    }

    public void DeleteGlobalRef(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_DeleteGlobalRef, value);
    }

    public MemorySegment $DeleteGlobalRef()
    {
        return this.pointer().asSlice(OFFSET_DeleteGlobalRef, ADDRESS);
    }

    public MemorySegment DeleteLocalRef()
    {
        return this.pointer().get(ADDRESS, OFFSET_DeleteLocalRef);
    }

    public void DeleteLocalRef(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_DeleteLocalRef, value);
    }

    public MemorySegment $DeleteLocalRef()
    {
        return this.pointer().asSlice(OFFSET_DeleteLocalRef, ADDRESS);
    }

    public MemorySegment IsSameObject()
    {
        return this.pointer().get(ADDRESS, OFFSET_IsSameObject);
    }

    public void IsSameObject(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_IsSameObject, value);
    }

    public MemorySegment $IsSameObject()
    {
        return this.pointer().asSlice(OFFSET_IsSameObject, ADDRESS);
    }

    public MemorySegment NewLocalRef()
    {
        return this.pointer().get(ADDRESS, OFFSET_NewLocalRef);
    }

    public void NewLocalRef(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_NewLocalRef, value);
    }

    public MemorySegment $NewLocalRef()
    {
        return this.pointer().asSlice(OFFSET_NewLocalRef, ADDRESS);
    }

    public MemorySegment EnsureLocalCapacity()
    {
        return this.pointer().get(ADDRESS, OFFSET_EnsureLocalCapacity);
    }

    public void EnsureLocalCapacity(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_EnsureLocalCapacity, value);
    }

    public MemorySegment $EnsureLocalCapacity()
    {
        return this.pointer().asSlice(OFFSET_EnsureLocalCapacity, ADDRESS);
    }

    public MemorySegment AllocObject()
    {
        return this.pointer().get(ADDRESS, OFFSET_AllocObject);
    }

    public void AllocObject(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_AllocObject, value);
    }

    public MemorySegment $AllocObject()
    {
        return this.pointer().asSlice(OFFSET_AllocObject, ADDRESS);
    }

    public MemorySegment NewObject()
    {
        return this.pointer().get(ADDRESS, OFFSET_NewObject);
    }

    public void NewObject(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_NewObject, value);
    }

    public MemorySegment $NewObject()
    {
        return this.pointer().asSlice(OFFSET_NewObject, ADDRESS);
    }

    public MemorySegment NewObjectV()
    {
        return this.pointer().get(ADDRESS, OFFSET_NewObjectV);
    }

    public void NewObjectV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_NewObjectV, value);
    }

    public MemorySegment $NewObjectV()
    {
        return this.pointer().asSlice(OFFSET_NewObjectV, ADDRESS);
    }

    public MemorySegment NewObjectA()
    {
        return this.pointer().get(ADDRESS, OFFSET_NewObjectA);
    }

    public void NewObjectA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_NewObjectA, value);
    }

    public MemorySegment $NewObjectA()
    {
        return this.pointer().asSlice(OFFSET_NewObjectA, ADDRESS);
    }

    public MemorySegment GetObjectClass()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetObjectClass);
    }

    public void GetObjectClass(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetObjectClass, value);
    }

    public MemorySegment $GetObjectClass()
    {
        return this.pointer().asSlice(OFFSET_GetObjectClass, ADDRESS);
    }

    public MemorySegment IsInstanceOf()
    {
        return this.pointer().get(ADDRESS, OFFSET_IsInstanceOf);
    }

    public void IsInstanceOf(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_IsInstanceOf, value);
    }

    public MemorySegment $IsInstanceOf()
    {
        return this.pointer().asSlice(OFFSET_IsInstanceOf, ADDRESS);
    }

    public MemorySegment GetMethodID()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetMethodID);
    }

    public void GetMethodID(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetMethodID, value);
    }

    public MemorySegment $GetMethodID()
    {
        return this.pointer().asSlice(OFFSET_GetMethodID, ADDRESS);
    }

    public MemorySegment CallObjectMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallObjectMethod);
    }

    public void CallObjectMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallObjectMethod, value);
    }

    public MemorySegment $CallObjectMethod()
    {
        return this.pointer().asSlice(OFFSET_CallObjectMethod, ADDRESS);
    }

    public MemorySegment CallObjectMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallObjectMethodV);
    }

    public void CallObjectMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallObjectMethodV, value);
    }

    public MemorySegment $CallObjectMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallObjectMethodV, ADDRESS);
    }

    public MemorySegment CallObjectMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallObjectMethodA);
    }

    public void CallObjectMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallObjectMethodA, value);
    }

    public MemorySegment $CallObjectMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallObjectMethodA, ADDRESS);
    }

    public MemorySegment CallBooleanMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallBooleanMethod);
    }

    public void CallBooleanMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallBooleanMethod, value);
    }

    public MemorySegment $CallBooleanMethod()
    {
        return this.pointer().asSlice(OFFSET_CallBooleanMethod, ADDRESS);
    }

    public MemorySegment CallBooleanMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallBooleanMethodV);
    }

    public void CallBooleanMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallBooleanMethodV, value);
    }

    public MemorySegment $CallBooleanMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallBooleanMethodV, ADDRESS);
    }

    public MemorySegment CallBooleanMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallBooleanMethodA);
    }

    public void CallBooleanMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallBooleanMethodA, value);
    }

    public MemorySegment $CallBooleanMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallBooleanMethodA, ADDRESS);
    }

    public MemorySegment CallByteMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallByteMethod);
    }

    public void CallByteMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallByteMethod, value);
    }

    public MemorySegment $CallByteMethod()
    {
        return this.pointer().asSlice(OFFSET_CallByteMethod, ADDRESS);
    }

    public MemorySegment CallByteMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallByteMethodV);
    }

    public void CallByteMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallByteMethodV, value);
    }

    public MemorySegment $CallByteMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallByteMethodV, ADDRESS);
    }

    public MemorySegment CallByteMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallByteMethodA);
    }

    public void CallByteMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallByteMethodA, value);
    }

    public MemorySegment $CallByteMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallByteMethodA, ADDRESS);
    }

    public MemorySegment CallCharMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallCharMethod);
    }

    public void CallCharMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallCharMethod, value);
    }

    public MemorySegment $CallCharMethod()
    {
        return this.pointer().asSlice(OFFSET_CallCharMethod, ADDRESS);
    }

    public MemorySegment CallCharMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallCharMethodV);
    }

    public void CallCharMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallCharMethodV, value);
    }

    public MemorySegment $CallCharMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallCharMethodV, ADDRESS);
    }

    public MemorySegment CallCharMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallCharMethodA);
    }

    public void CallCharMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallCharMethodA, value);
    }

    public MemorySegment $CallCharMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallCharMethodA, ADDRESS);
    }

    public MemorySegment CallShortMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallShortMethod);
    }

    public void CallShortMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallShortMethod, value);
    }

    public MemorySegment $CallShortMethod()
    {
        return this.pointer().asSlice(OFFSET_CallShortMethod, ADDRESS);
    }

    public MemorySegment CallShortMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallShortMethodV);
    }

    public void CallShortMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallShortMethodV, value);
    }

    public MemorySegment $CallShortMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallShortMethodV, ADDRESS);
    }

    public MemorySegment CallShortMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallShortMethodA);
    }

    public void CallShortMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallShortMethodA, value);
    }

    public MemorySegment $CallShortMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallShortMethodA, ADDRESS);
    }

    public MemorySegment CallIntMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallIntMethod);
    }

    public void CallIntMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallIntMethod, value);
    }

    public MemorySegment $CallIntMethod()
    {
        return this.pointer().asSlice(OFFSET_CallIntMethod, ADDRESS);
    }

    public MemorySegment CallIntMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallIntMethodV);
    }

    public void CallIntMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallIntMethodV, value);
    }

    public MemorySegment $CallIntMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallIntMethodV, ADDRESS);
    }

    public MemorySegment CallIntMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallIntMethodA);
    }

    public void CallIntMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallIntMethodA, value);
    }

    public MemorySegment $CallIntMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallIntMethodA, ADDRESS);
    }

    public MemorySegment CallLongMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallLongMethod);
    }

    public void CallLongMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallLongMethod, value);
    }

    public MemorySegment $CallLongMethod()
    {
        return this.pointer().asSlice(OFFSET_CallLongMethod, ADDRESS);
    }

    public MemorySegment CallLongMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallLongMethodV);
    }

    public void CallLongMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallLongMethodV, value);
    }

    public MemorySegment $CallLongMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallLongMethodV, ADDRESS);
    }

    public MemorySegment CallLongMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallLongMethodA);
    }

    public void CallLongMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallLongMethodA, value);
    }

    public MemorySegment $CallLongMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallLongMethodA, ADDRESS);
    }

    public MemorySegment CallFloatMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallFloatMethod);
    }

    public void CallFloatMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallFloatMethod, value);
    }

    public MemorySegment $CallFloatMethod()
    {
        return this.pointer().asSlice(OFFSET_CallFloatMethod, ADDRESS);
    }

    public MemorySegment CallFloatMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallFloatMethodV);
    }

    public void CallFloatMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallFloatMethodV, value);
    }

    public MemorySegment $CallFloatMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallFloatMethodV, ADDRESS);
    }

    public MemorySegment CallFloatMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallFloatMethodA);
    }

    public void CallFloatMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallFloatMethodA, value);
    }

    public MemorySegment $CallFloatMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallFloatMethodA, ADDRESS);
    }

    public MemorySegment CallDoubleMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallDoubleMethod);
    }

    public void CallDoubleMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallDoubleMethod, value);
    }

    public MemorySegment $CallDoubleMethod()
    {
        return this.pointer().asSlice(OFFSET_CallDoubleMethod, ADDRESS);
    }

    public MemorySegment CallDoubleMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallDoubleMethodV);
    }

    public void CallDoubleMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallDoubleMethodV, value);
    }

    public MemorySegment $CallDoubleMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallDoubleMethodV, ADDRESS);
    }

    public MemorySegment CallDoubleMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallDoubleMethodA);
    }

    public void CallDoubleMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallDoubleMethodA, value);
    }

    public MemorySegment $CallDoubleMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallDoubleMethodA, ADDRESS);
    }

    public MemorySegment CallVoidMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallVoidMethod);
    }

    public void CallVoidMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallVoidMethod, value);
    }

    public MemorySegment $CallVoidMethod()
    {
        return this.pointer().asSlice(OFFSET_CallVoidMethod, ADDRESS);
    }

    public MemorySegment CallVoidMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallVoidMethodV);
    }

    public void CallVoidMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallVoidMethodV, value);
    }

    public MemorySegment $CallVoidMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallVoidMethodV, ADDRESS);
    }

    public MemorySegment CallVoidMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallVoidMethodA);
    }

    public void CallVoidMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallVoidMethodA, value);
    }

    public MemorySegment $CallVoidMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallVoidMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualObjectMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualObjectMethod);
    }

    public void CallNonvirtualObjectMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualObjectMethod, value);
    }

    public MemorySegment $CallNonvirtualObjectMethod()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualObjectMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualObjectMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualObjectMethodV);
    }

    public void CallNonvirtualObjectMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualObjectMethodV, value);
    }

    public MemorySegment $CallNonvirtualObjectMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualObjectMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualObjectMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualObjectMethodA);
    }

    public void CallNonvirtualObjectMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualObjectMethodA, value);
    }

    public MemorySegment $CallNonvirtualObjectMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualObjectMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualBooleanMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualBooleanMethod);
    }

    public void CallNonvirtualBooleanMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualBooleanMethod, value);
    }

    public MemorySegment $CallNonvirtualBooleanMethod()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualBooleanMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualBooleanMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualBooleanMethodV);
    }

    public void CallNonvirtualBooleanMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualBooleanMethodV, value);
    }

    public MemorySegment $CallNonvirtualBooleanMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualBooleanMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualBooleanMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualBooleanMethodA);
    }

    public void CallNonvirtualBooleanMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualBooleanMethodA, value);
    }

    public MemorySegment $CallNonvirtualBooleanMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualBooleanMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualByteMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualByteMethod);
    }

    public void CallNonvirtualByteMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualByteMethod, value);
    }

    public MemorySegment $CallNonvirtualByteMethod()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualByteMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualByteMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualByteMethodV);
    }

    public void CallNonvirtualByteMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualByteMethodV, value);
    }

    public MemorySegment $CallNonvirtualByteMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualByteMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualByteMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualByteMethodA);
    }

    public void CallNonvirtualByteMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualByteMethodA, value);
    }

    public MemorySegment $CallNonvirtualByteMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualByteMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualCharMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualCharMethod);
    }

    public void CallNonvirtualCharMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualCharMethod, value);
    }

    public MemorySegment $CallNonvirtualCharMethod()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualCharMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualCharMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualCharMethodV);
    }

    public void CallNonvirtualCharMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualCharMethodV, value);
    }

    public MemorySegment $CallNonvirtualCharMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualCharMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualCharMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualCharMethodA);
    }

    public void CallNonvirtualCharMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualCharMethodA, value);
    }

    public MemorySegment $CallNonvirtualCharMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualCharMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualShortMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualShortMethod);
    }

    public void CallNonvirtualShortMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualShortMethod, value);
    }

    public MemorySegment $CallNonvirtualShortMethod()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualShortMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualShortMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualShortMethodV);
    }

    public void CallNonvirtualShortMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualShortMethodV, value);
    }

    public MemorySegment $CallNonvirtualShortMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualShortMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualShortMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualShortMethodA);
    }

    public void CallNonvirtualShortMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualShortMethodA, value);
    }

    public MemorySegment $CallNonvirtualShortMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualShortMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualIntMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualIntMethod);
    }

    public void CallNonvirtualIntMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualIntMethod, value);
    }

    public MemorySegment $CallNonvirtualIntMethod()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualIntMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualIntMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualIntMethodV);
    }

    public void CallNonvirtualIntMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualIntMethodV, value);
    }

    public MemorySegment $CallNonvirtualIntMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualIntMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualIntMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualIntMethodA);
    }

    public void CallNonvirtualIntMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualIntMethodA, value);
    }

    public MemorySegment $CallNonvirtualIntMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualIntMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualLongMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualLongMethod);
    }

    public void CallNonvirtualLongMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualLongMethod, value);
    }

    public MemorySegment $CallNonvirtualLongMethod()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualLongMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualLongMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualLongMethodV);
    }

    public void CallNonvirtualLongMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualLongMethodV, value);
    }

    public MemorySegment $CallNonvirtualLongMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualLongMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualLongMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualLongMethodA);
    }

    public void CallNonvirtualLongMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualLongMethodA, value);
    }

    public MemorySegment $CallNonvirtualLongMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualLongMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualFloatMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualFloatMethod);
    }

    public void CallNonvirtualFloatMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualFloatMethod, value);
    }

    public MemorySegment $CallNonvirtualFloatMethod()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualFloatMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualFloatMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualFloatMethodV);
    }

    public void CallNonvirtualFloatMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualFloatMethodV, value);
    }

    public MemorySegment $CallNonvirtualFloatMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualFloatMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualFloatMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualFloatMethodA);
    }

    public void CallNonvirtualFloatMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualFloatMethodA, value);
    }

    public MemorySegment $CallNonvirtualFloatMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualFloatMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualDoubleMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualDoubleMethod);
    }

    public void CallNonvirtualDoubleMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualDoubleMethod, value);
    }

    public MemorySegment $CallNonvirtualDoubleMethod()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualDoubleMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualDoubleMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualDoubleMethodV);
    }

    public void CallNonvirtualDoubleMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualDoubleMethodV, value);
    }

    public MemorySegment $CallNonvirtualDoubleMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualDoubleMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualDoubleMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualDoubleMethodA);
    }

    public void CallNonvirtualDoubleMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualDoubleMethodA, value);
    }

    public MemorySegment $CallNonvirtualDoubleMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualDoubleMethodA, ADDRESS);
    }

    public MemorySegment CallNonvirtualVoidMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualVoidMethod);
    }

    public void CallNonvirtualVoidMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualVoidMethod, value);
    }

    public MemorySegment $CallNonvirtualVoidMethod()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualVoidMethod, ADDRESS);
    }

    public MemorySegment CallNonvirtualVoidMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualVoidMethodV);
    }

    public void CallNonvirtualVoidMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualVoidMethodV, value);
    }

    public MemorySegment $CallNonvirtualVoidMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualVoidMethodV, ADDRESS);
    }

    public MemorySegment CallNonvirtualVoidMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallNonvirtualVoidMethodA);
    }

    public void CallNonvirtualVoidMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallNonvirtualVoidMethodA, value);
    }

    public MemorySegment $CallNonvirtualVoidMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallNonvirtualVoidMethodA, ADDRESS);
    }

    public MemorySegment GetFieldID()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetFieldID);
    }

    public void GetFieldID(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetFieldID, value);
    }

    public MemorySegment $GetFieldID()
    {
        return this.pointer().asSlice(OFFSET_GetFieldID, ADDRESS);
    }

    public MemorySegment GetObjectField()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetObjectField);
    }

    public void GetObjectField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetObjectField, value);
    }

    public MemorySegment $GetObjectField()
    {
        return this.pointer().asSlice(OFFSET_GetObjectField, ADDRESS);
    }

    public MemorySegment GetBooleanField()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetBooleanField);
    }

    public void GetBooleanField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetBooleanField, value);
    }

    public MemorySegment $GetBooleanField()
    {
        return this.pointer().asSlice(OFFSET_GetBooleanField, ADDRESS);
    }

    public MemorySegment GetByteField()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetByteField);
    }

    public void GetByteField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetByteField, value);
    }

    public MemorySegment $GetByteField()
    {
        return this.pointer().asSlice(OFFSET_GetByteField, ADDRESS);
    }

    public MemorySegment GetCharField()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetCharField);
    }

    public void GetCharField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetCharField, value);
    }

    public MemorySegment $GetCharField()
    {
        return this.pointer().asSlice(OFFSET_GetCharField, ADDRESS);
    }

    public MemorySegment GetShortField()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetShortField);
    }

    public void GetShortField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetShortField, value);
    }

    public MemorySegment $GetShortField()
    {
        return this.pointer().asSlice(OFFSET_GetShortField, ADDRESS);
    }

    public MemorySegment GetIntField()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetIntField);
    }

    public void GetIntField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetIntField, value);
    }

    public MemorySegment $GetIntField()
    {
        return this.pointer().asSlice(OFFSET_GetIntField, ADDRESS);
    }

    public MemorySegment GetLongField()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetLongField);
    }

    public void GetLongField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetLongField, value);
    }

    public MemorySegment $GetLongField()
    {
        return this.pointer().asSlice(OFFSET_GetLongField, ADDRESS);
    }

    public MemorySegment GetFloatField()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetFloatField);
    }

    public void GetFloatField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetFloatField, value);
    }

    public MemorySegment $GetFloatField()
    {
        return this.pointer().asSlice(OFFSET_GetFloatField, ADDRESS);
    }

    public MemorySegment GetDoubleField()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetDoubleField);
    }

    public void GetDoubleField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetDoubleField, value);
    }

    public MemorySegment $GetDoubleField()
    {
        return this.pointer().asSlice(OFFSET_GetDoubleField, ADDRESS);
    }

    public MemorySegment SetObjectField()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetObjectField);
    }

    public void SetObjectField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetObjectField, value);
    }

    public MemorySegment $SetObjectField()
    {
        return this.pointer().asSlice(OFFSET_SetObjectField, ADDRESS);
    }

    public MemorySegment SetBooleanField()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetBooleanField);
    }

    public void SetBooleanField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetBooleanField, value);
    }

    public MemorySegment $SetBooleanField()
    {
        return this.pointer().asSlice(OFFSET_SetBooleanField, ADDRESS);
    }

    public MemorySegment SetByteField()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetByteField);
    }

    public void SetByteField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetByteField, value);
    }

    public MemorySegment $SetByteField()
    {
        return this.pointer().asSlice(OFFSET_SetByteField, ADDRESS);
    }

    public MemorySegment SetCharField()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetCharField);
    }

    public void SetCharField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetCharField, value);
    }

    public MemorySegment $SetCharField()
    {
        return this.pointer().asSlice(OFFSET_SetCharField, ADDRESS);
    }

    public MemorySegment SetShortField()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetShortField);
    }

    public void SetShortField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetShortField, value);
    }

    public MemorySegment $SetShortField()
    {
        return this.pointer().asSlice(OFFSET_SetShortField, ADDRESS);
    }

    public MemorySegment SetIntField()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetIntField);
    }

    public void SetIntField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetIntField, value);
    }

    public MemorySegment $SetIntField()
    {
        return this.pointer().asSlice(OFFSET_SetIntField, ADDRESS);
    }

    public MemorySegment SetLongField()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetLongField);
    }

    public void SetLongField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetLongField, value);
    }

    public MemorySegment $SetLongField()
    {
        return this.pointer().asSlice(OFFSET_SetLongField, ADDRESS);
    }

    public MemorySegment SetFloatField()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetFloatField);
    }

    public void SetFloatField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetFloatField, value);
    }

    public MemorySegment $SetFloatField()
    {
        return this.pointer().asSlice(OFFSET_SetFloatField, ADDRESS);
    }

    public MemorySegment SetDoubleField()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetDoubleField);
    }

    public void SetDoubleField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetDoubleField, value);
    }

    public MemorySegment $SetDoubleField()
    {
        return this.pointer().asSlice(OFFSET_SetDoubleField, ADDRESS);
    }

    public MemorySegment GetStaticMethodID()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetStaticMethodID);
    }

    public void GetStaticMethodID(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetStaticMethodID, value);
    }

    public MemorySegment $GetStaticMethodID()
    {
        return this.pointer().asSlice(OFFSET_GetStaticMethodID, ADDRESS);
    }

    public MemorySegment CallStaticObjectMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticObjectMethod);
    }

    public void CallStaticObjectMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticObjectMethod, value);
    }

    public MemorySegment $CallStaticObjectMethod()
    {
        return this.pointer().asSlice(OFFSET_CallStaticObjectMethod, ADDRESS);
    }

    public MemorySegment CallStaticObjectMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticObjectMethodV);
    }

    public void CallStaticObjectMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticObjectMethodV, value);
    }

    public MemorySegment $CallStaticObjectMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallStaticObjectMethodV, ADDRESS);
    }

    public MemorySegment CallStaticObjectMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticObjectMethodA);
    }

    public void CallStaticObjectMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticObjectMethodA, value);
    }

    public MemorySegment $CallStaticObjectMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallStaticObjectMethodA, ADDRESS);
    }

    public MemorySegment CallStaticBooleanMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticBooleanMethod);
    }

    public void CallStaticBooleanMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticBooleanMethod, value);
    }

    public MemorySegment $CallStaticBooleanMethod()
    {
        return this.pointer().asSlice(OFFSET_CallStaticBooleanMethod, ADDRESS);
    }

    public MemorySegment CallStaticBooleanMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticBooleanMethodV);
    }

    public void CallStaticBooleanMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticBooleanMethodV, value);
    }

    public MemorySegment $CallStaticBooleanMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallStaticBooleanMethodV, ADDRESS);
    }

    public MemorySegment CallStaticBooleanMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticBooleanMethodA);
    }

    public void CallStaticBooleanMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticBooleanMethodA, value);
    }

    public MemorySegment $CallStaticBooleanMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallStaticBooleanMethodA, ADDRESS);
    }

    public MemorySegment CallStaticByteMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticByteMethod);
    }

    public void CallStaticByteMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticByteMethod, value);
    }

    public MemorySegment $CallStaticByteMethod()
    {
        return this.pointer().asSlice(OFFSET_CallStaticByteMethod, ADDRESS);
    }

    public MemorySegment CallStaticByteMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticByteMethodV);
    }

    public void CallStaticByteMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticByteMethodV, value);
    }

    public MemorySegment $CallStaticByteMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallStaticByteMethodV, ADDRESS);
    }

    public MemorySegment CallStaticByteMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticByteMethodA);
    }

    public void CallStaticByteMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticByteMethodA, value);
    }

    public MemorySegment $CallStaticByteMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallStaticByteMethodA, ADDRESS);
    }

    public MemorySegment CallStaticCharMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticCharMethod);
    }

    public void CallStaticCharMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticCharMethod, value);
    }

    public MemorySegment $CallStaticCharMethod()
    {
        return this.pointer().asSlice(OFFSET_CallStaticCharMethod, ADDRESS);
    }

    public MemorySegment CallStaticCharMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticCharMethodV);
    }

    public void CallStaticCharMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticCharMethodV, value);
    }

    public MemorySegment $CallStaticCharMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallStaticCharMethodV, ADDRESS);
    }

    public MemorySegment CallStaticCharMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticCharMethodA);
    }

    public void CallStaticCharMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticCharMethodA, value);
    }

    public MemorySegment $CallStaticCharMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallStaticCharMethodA, ADDRESS);
    }

    public MemorySegment CallStaticShortMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticShortMethod);
    }

    public void CallStaticShortMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticShortMethod, value);
    }

    public MemorySegment $CallStaticShortMethod()
    {
        return this.pointer().asSlice(OFFSET_CallStaticShortMethod, ADDRESS);
    }

    public MemorySegment CallStaticShortMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticShortMethodV);
    }

    public void CallStaticShortMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticShortMethodV, value);
    }

    public MemorySegment $CallStaticShortMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallStaticShortMethodV, ADDRESS);
    }

    public MemorySegment CallStaticShortMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticShortMethodA);
    }

    public void CallStaticShortMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticShortMethodA, value);
    }

    public MemorySegment $CallStaticShortMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallStaticShortMethodA, ADDRESS);
    }

    public MemorySegment CallStaticIntMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticIntMethod);
    }

    public void CallStaticIntMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticIntMethod, value);
    }

    public MemorySegment $CallStaticIntMethod()
    {
        return this.pointer().asSlice(OFFSET_CallStaticIntMethod, ADDRESS);
    }

    public MemorySegment CallStaticIntMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticIntMethodV);
    }

    public void CallStaticIntMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticIntMethodV, value);
    }

    public MemorySegment $CallStaticIntMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallStaticIntMethodV, ADDRESS);
    }

    public MemorySegment CallStaticIntMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticIntMethodA);
    }

    public void CallStaticIntMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticIntMethodA, value);
    }

    public MemorySegment $CallStaticIntMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallStaticIntMethodA, ADDRESS);
    }

    public MemorySegment CallStaticLongMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticLongMethod);
    }

    public void CallStaticLongMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticLongMethod, value);
    }

    public MemorySegment $CallStaticLongMethod()
    {
        return this.pointer().asSlice(OFFSET_CallStaticLongMethod, ADDRESS);
    }

    public MemorySegment CallStaticLongMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticLongMethodV);
    }

    public void CallStaticLongMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticLongMethodV, value);
    }

    public MemorySegment $CallStaticLongMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallStaticLongMethodV, ADDRESS);
    }

    public MemorySegment CallStaticLongMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticLongMethodA);
    }

    public void CallStaticLongMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticLongMethodA, value);
    }

    public MemorySegment $CallStaticLongMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallStaticLongMethodA, ADDRESS);
    }

    public MemorySegment CallStaticFloatMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticFloatMethod);
    }

    public void CallStaticFloatMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticFloatMethod, value);
    }

    public MemorySegment $CallStaticFloatMethod()
    {
        return this.pointer().asSlice(OFFSET_CallStaticFloatMethod, ADDRESS);
    }

    public MemorySegment CallStaticFloatMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticFloatMethodV);
    }

    public void CallStaticFloatMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticFloatMethodV, value);
    }

    public MemorySegment $CallStaticFloatMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallStaticFloatMethodV, ADDRESS);
    }

    public MemorySegment CallStaticFloatMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticFloatMethodA);
    }

    public void CallStaticFloatMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticFloatMethodA, value);
    }

    public MemorySegment $CallStaticFloatMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallStaticFloatMethodA, ADDRESS);
    }

    public MemorySegment CallStaticDoubleMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticDoubleMethod);
    }

    public void CallStaticDoubleMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticDoubleMethod, value);
    }

    public MemorySegment $CallStaticDoubleMethod()
    {
        return this.pointer().asSlice(OFFSET_CallStaticDoubleMethod, ADDRESS);
    }

    public MemorySegment CallStaticDoubleMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticDoubleMethodV);
    }

    public void CallStaticDoubleMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticDoubleMethodV, value);
    }

    public MemorySegment $CallStaticDoubleMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallStaticDoubleMethodV, ADDRESS);
    }

    public MemorySegment CallStaticDoubleMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticDoubleMethodA);
    }

    public void CallStaticDoubleMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticDoubleMethodA, value);
    }

    public MemorySegment $CallStaticDoubleMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallStaticDoubleMethodA, ADDRESS);
    }

    public MemorySegment CallStaticVoidMethod()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticVoidMethod);
    }

    public void CallStaticVoidMethod(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticVoidMethod, value);
    }

    public MemorySegment $CallStaticVoidMethod()
    {
        return this.pointer().asSlice(OFFSET_CallStaticVoidMethod, ADDRESS);
    }

    public MemorySegment CallStaticVoidMethodV()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticVoidMethodV);
    }

    public void CallStaticVoidMethodV(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticVoidMethodV, value);
    }

    public MemorySegment $CallStaticVoidMethodV()
    {
        return this.pointer().asSlice(OFFSET_CallStaticVoidMethodV, ADDRESS);
    }

    public MemorySegment CallStaticVoidMethodA()
    {
        return this.pointer().get(ADDRESS, OFFSET_CallStaticVoidMethodA);
    }

    public void CallStaticVoidMethodA(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_CallStaticVoidMethodA, value);
    }

    public MemorySegment $CallStaticVoidMethodA()
    {
        return this.pointer().asSlice(OFFSET_CallStaticVoidMethodA, ADDRESS);
    }

    public MemorySegment GetStaticFieldID()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetStaticFieldID);
    }

    public void GetStaticFieldID(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetStaticFieldID, value);
    }

    public MemorySegment $GetStaticFieldID()
    {
        return this.pointer().asSlice(OFFSET_GetStaticFieldID, ADDRESS);
    }

    public MemorySegment GetStaticObjectField()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetStaticObjectField);
    }

    public void GetStaticObjectField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetStaticObjectField, value);
    }

    public MemorySegment $GetStaticObjectField()
    {
        return this.pointer().asSlice(OFFSET_GetStaticObjectField, ADDRESS);
    }

    public MemorySegment GetStaticBooleanField()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetStaticBooleanField);
    }

    public void GetStaticBooleanField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetStaticBooleanField, value);
    }

    public MemorySegment $GetStaticBooleanField()
    {
        return this.pointer().asSlice(OFFSET_GetStaticBooleanField, ADDRESS);
    }

    public MemorySegment GetStaticByteField()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetStaticByteField);
    }

    public void GetStaticByteField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetStaticByteField, value);
    }

    public MemorySegment $GetStaticByteField()
    {
        return this.pointer().asSlice(OFFSET_GetStaticByteField, ADDRESS);
    }

    public MemorySegment GetStaticCharField()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetStaticCharField);
    }

    public void GetStaticCharField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetStaticCharField, value);
    }

    public MemorySegment $GetStaticCharField()
    {
        return this.pointer().asSlice(OFFSET_GetStaticCharField, ADDRESS);
    }

    public MemorySegment GetStaticShortField()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetStaticShortField);
    }

    public void GetStaticShortField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetStaticShortField, value);
    }

    public MemorySegment $GetStaticShortField()
    {
        return this.pointer().asSlice(OFFSET_GetStaticShortField, ADDRESS);
    }

    public MemorySegment GetStaticIntField()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetStaticIntField);
    }

    public void GetStaticIntField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetStaticIntField, value);
    }

    public MemorySegment $GetStaticIntField()
    {
        return this.pointer().asSlice(OFFSET_GetStaticIntField, ADDRESS);
    }

    public MemorySegment GetStaticLongField()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetStaticLongField);
    }

    public void GetStaticLongField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetStaticLongField, value);
    }

    public MemorySegment $GetStaticLongField()
    {
        return this.pointer().asSlice(OFFSET_GetStaticLongField, ADDRESS);
    }

    public MemorySegment GetStaticFloatField()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetStaticFloatField);
    }

    public void GetStaticFloatField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetStaticFloatField, value);
    }

    public MemorySegment $GetStaticFloatField()
    {
        return this.pointer().asSlice(OFFSET_GetStaticFloatField, ADDRESS);
    }

    public MemorySegment GetStaticDoubleField()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetStaticDoubleField);
    }

    public void GetStaticDoubleField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetStaticDoubleField, value);
    }

    public MemorySegment $GetStaticDoubleField()
    {
        return this.pointer().asSlice(OFFSET_GetStaticDoubleField, ADDRESS);
    }

    public MemorySegment SetStaticObjectField()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetStaticObjectField);
    }

    public void SetStaticObjectField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetStaticObjectField, value);
    }

    public MemorySegment $SetStaticObjectField()
    {
        return this.pointer().asSlice(OFFSET_SetStaticObjectField, ADDRESS);
    }

    public MemorySegment SetStaticBooleanField()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetStaticBooleanField);
    }

    public void SetStaticBooleanField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetStaticBooleanField, value);
    }

    public MemorySegment $SetStaticBooleanField()
    {
        return this.pointer().asSlice(OFFSET_SetStaticBooleanField, ADDRESS);
    }

    public MemorySegment SetStaticByteField()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetStaticByteField);
    }

    public void SetStaticByteField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetStaticByteField, value);
    }

    public MemorySegment $SetStaticByteField()
    {
        return this.pointer().asSlice(OFFSET_SetStaticByteField, ADDRESS);
    }

    public MemorySegment SetStaticCharField()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetStaticCharField);
    }

    public void SetStaticCharField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetStaticCharField, value);
    }

    public MemorySegment $SetStaticCharField()
    {
        return this.pointer().asSlice(OFFSET_SetStaticCharField, ADDRESS);
    }

    public MemorySegment SetStaticShortField()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetStaticShortField);
    }

    public void SetStaticShortField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetStaticShortField, value);
    }

    public MemorySegment $SetStaticShortField()
    {
        return this.pointer().asSlice(OFFSET_SetStaticShortField, ADDRESS);
    }

    public MemorySegment SetStaticIntField()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetStaticIntField);
    }

    public void SetStaticIntField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetStaticIntField, value);
    }

    public MemorySegment $SetStaticIntField()
    {
        return this.pointer().asSlice(OFFSET_SetStaticIntField, ADDRESS);
    }

    public MemorySegment SetStaticLongField()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetStaticLongField);
    }

    public void SetStaticLongField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetStaticLongField, value);
    }

    public MemorySegment $SetStaticLongField()
    {
        return this.pointer().asSlice(OFFSET_SetStaticLongField, ADDRESS);
    }

    public MemorySegment SetStaticFloatField()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetStaticFloatField);
    }

    public void SetStaticFloatField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetStaticFloatField, value);
    }

    public MemorySegment $SetStaticFloatField()
    {
        return this.pointer().asSlice(OFFSET_SetStaticFloatField, ADDRESS);
    }

    public MemorySegment SetStaticDoubleField()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetStaticDoubleField);
    }

    public void SetStaticDoubleField(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetStaticDoubleField, value);
    }

    public MemorySegment $SetStaticDoubleField()
    {
        return this.pointer().asSlice(OFFSET_SetStaticDoubleField, ADDRESS);
    }

    public MemorySegment NewString()
    {
        return this.pointer().get(ADDRESS, OFFSET_NewString);
    }

    public void NewString(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_NewString, value);
    }

    public MemorySegment $NewString()
    {
        return this.pointer().asSlice(OFFSET_NewString, ADDRESS);
    }

    public MemorySegment GetStringLength()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetStringLength);
    }

    public void GetStringLength(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetStringLength, value);
    }

    public MemorySegment $GetStringLength()
    {
        return this.pointer().asSlice(OFFSET_GetStringLength, ADDRESS);
    }

    public MemorySegment GetStringChars()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetStringChars);
    }

    public void GetStringChars(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetStringChars, value);
    }

    public MemorySegment $GetStringChars()
    {
        return this.pointer().asSlice(OFFSET_GetStringChars, ADDRESS);
    }

    public MemorySegment ReleaseStringChars()
    {
        return this.pointer().get(ADDRESS, OFFSET_ReleaseStringChars);
    }

    public void ReleaseStringChars(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_ReleaseStringChars, value);
    }

    public MemorySegment $ReleaseStringChars()
    {
        return this.pointer().asSlice(OFFSET_ReleaseStringChars, ADDRESS);
    }

    public MemorySegment NewStringUTF()
    {
        return this.pointer().get(ADDRESS, OFFSET_NewStringUTF);
    }

    public void NewStringUTF(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_NewStringUTF, value);
    }

    public MemorySegment $NewStringUTF()
    {
        return this.pointer().asSlice(OFFSET_NewStringUTF, ADDRESS);
    }

    public MemorySegment GetStringUTFLength()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetStringUTFLength);
    }

    public void GetStringUTFLength(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetStringUTFLength, value);
    }

    public MemorySegment $GetStringUTFLength()
    {
        return this.pointer().asSlice(OFFSET_GetStringUTFLength, ADDRESS);
    }

    public MemorySegment GetStringUTFChars()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetStringUTFChars);
    }

    public void GetStringUTFChars(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetStringUTFChars, value);
    }

    public MemorySegment $GetStringUTFChars()
    {
        return this.pointer().asSlice(OFFSET_GetStringUTFChars, ADDRESS);
    }

    public MemorySegment ReleaseStringUTFChars()
    {
        return this.pointer().get(ADDRESS, OFFSET_ReleaseStringUTFChars);
    }

    public void ReleaseStringUTFChars(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_ReleaseStringUTFChars, value);
    }

    public MemorySegment $ReleaseStringUTFChars()
    {
        return this.pointer().asSlice(OFFSET_ReleaseStringUTFChars, ADDRESS);
    }

    public MemorySegment GetArrayLength()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetArrayLength);
    }

    public void GetArrayLength(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetArrayLength, value);
    }

    public MemorySegment $GetArrayLength()
    {
        return this.pointer().asSlice(OFFSET_GetArrayLength, ADDRESS);
    }

    public MemorySegment NewObjectArray()
    {
        return this.pointer().get(ADDRESS, OFFSET_NewObjectArray);
    }

    public void NewObjectArray(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_NewObjectArray, value);
    }

    public MemorySegment $NewObjectArray()
    {
        return this.pointer().asSlice(OFFSET_NewObjectArray, ADDRESS);
    }

    public MemorySegment GetObjectArrayElement()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetObjectArrayElement);
    }

    public void GetObjectArrayElement(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetObjectArrayElement, value);
    }

    public MemorySegment $GetObjectArrayElement()
    {
        return this.pointer().asSlice(OFFSET_GetObjectArrayElement, ADDRESS);
    }

    public MemorySegment SetObjectArrayElement()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetObjectArrayElement);
    }

    public void SetObjectArrayElement(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetObjectArrayElement, value);
    }

    public MemorySegment $SetObjectArrayElement()
    {
        return this.pointer().asSlice(OFFSET_SetObjectArrayElement, ADDRESS);
    }

    public MemorySegment NewBooleanArray()
    {
        return this.pointer().get(ADDRESS, OFFSET_NewBooleanArray);
    }

    public void NewBooleanArray(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_NewBooleanArray, value);
    }

    public MemorySegment $NewBooleanArray()
    {
        return this.pointer().asSlice(OFFSET_NewBooleanArray, ADDRESS);
    }

    public MemorySegment NewByteArray()
    {
        return this.pointer().get(ADDRESS, OFFSET_NewByteArray);
    }

    public void NewByteArray(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_NewByteArray, value);
    }

    public MemorySegment $NewByteArray()
    {
        return this.pointer().asSlice(OFFSET_NewByteArray, ADDRESS);
    }

    public MemorySegment NewCharArray()
    {
        return this.pointer().get(ADDRESS, OFFSET_NewCharArray);
    }

    public void NewCharArray(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_NewCharArray, value);
    }

    public MemorySegment $NewCharArray()
    {
        return this.pointer().asSlice(OFFSET_NewCharArray, ADDRESS);
    }

    public MemorySegment NewShortArray()
    {
        return this.pointer().get(ADDRESS, OFFSET_NewShortArray);
    }

    public void NewShortArray(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_NewShortArray, value);
    }

    public MemorySegment $NewShortArray()
    {
        return this.pointer().asSlice(OFFSET_NewShortArray, ADDRESS);
    }

    public MemorySegment NewIntArray()
    {
        return this.pointer().get(ADDRESS, OFFSET_NewIntArray);
    }

    public void NewIntArray(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_NewIntArray, value);
    }

    public MemorySegment $NewIntArray()
    {
        return this.pointer().asSlice(OFFSET_NewIntArray, ADDRESS);
    }

    public MemorySegment NewLongArray()
    {
        return this.pointer().get(ADDRESS, OFFSET_NewLongArray);
    }

    public void NewLongArray(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_NewLongArray, value);
    }

    public MemorySegment $NewLongArray()
    {
        return this.pointer().asSlice(OFFSET_NewLongArray, ADDRESS);
    }

    public MemorySegment NewFloatArray()
    {
        return this.pointer().get(ADDRESS, OFFSET_NewFloatArray);
    }

    public void NewFloatArray(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_NewFloatArray, value);
    }

    public MemorySegment $NewFloatArray()
    {
        return this.pointer().asSlice(OFFSET_NewFloatArray, ADDRESS);
    }

    public MemorySegment NewDoubleArray()
    {
        return this.pointer().get(ADDRESS, OFFSET_NewDoubleArray);
    }

    public void NewDoubleArray(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_NewDoubleArray, value);
    }

    public MemorySegment $NewDoubleArray()
    {
        return this.pointer().asSlice(OFFSET_NewDoubleArray, ADDRESS);
    }

    public MemorySegment GetBooleanArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetBooleanArrayElements);
    }

    public void GetBooleanArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetBooleanArrayElements, value);
    }

    public MemorySegment $GetBooleanArrayElements()
    {
        return this.pointer().asSlice(OFFSET_GetBooleanArrayElements, ADDRESS);
    }

    public MemorySegment GetByteArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetByteArrayElements);
    }

    public void GetByteArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetByteArrayElements, value);
    }

    public MemorySegment $GetByteArrayElements()
    {
        return this.pointer().asSlice(OFFSET_GetByteArrayElements, ADDRESS);
    }

    public MemorySegment GetCharArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetCharArrayElements);
    }

    public void GetCharArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetCharArrayElements, value);
    }

    public MemorySegment $GetCharArrayElements()
    {
        return this.pointer().asSlice(OFFSET_GetCharArrayElements, ADDRESS);
    }

    public MemorySegment GetShortArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetShortArrayElements);
    }

    public void GetShortArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetShortArrayElements, value);
    }

    public MemorySegment $GetShortArrayElements()
    {
        return this.pointer().asSlice(OFFSET_GetShortArrayElements, ADDRESS);
    }

    public MemorySegment GetIntArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetIntArrayElements);
    }

    public void GetIntArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetIntArrayElements, value);
    }

    public MemorySegment $GetIntArrayElements()
    {
        return this.pointer().asSlice(OFFSET_GetIntArrayElements, ADDRESS);
    }

    public MemorySegment GetLongArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetLongArrayElements);
    }

    public void GetLongArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetLongArrayElements, value);
    }

    public MemorySegment $GetLongArrayElements()
    {
        return this.pointer().asSlice(OFFSET_GetLongArrayElements, ADDRESS);
    }

    public MemorySegment GetFloatArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetFloatArrayElements);
    }

    public void GetFloatArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetFloatArrayElements, value);
    }

    public MemorySegment $GetFloatArrayElements()
    {
        return this.pointer().asSlice(OFFSET_GetFloatArrayElements, ADDRESS);
    }

    public MemorySegment GetDoubleArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetDoubleArrayElements);
    }

    public void GetDoubleArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetDoubleArrayElements, value);
    }

    public MemorySegment $GetDoubleArrayElements()
    {
        return this.pointer().asSlice(OFFSET_GetDoubleArrayElements, ADDRESS);
    }

    public MemorySegment ReleaseBooleanArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET_ReleaseBooleanArrayElements);
    }

    public void ReleaseBooleanArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_ReleaseBooleanArrayElements, value);
    }

    public MemorySegment $ReleaseBooleanArrayElements()
    {
        return this.pointer().asSlice(OFFSET_ReleaseBooleanArrayElements, ADDRESS);
    }

    public MemorySegment ReleaseByteArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET_ReleaseByteArrayElements);
    }

    public void ReleaseByteArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_ReleaseByteArrayElements, value);
    }

    public MemorySegment $ReleaseByteArrayElements()
    {
        return this.pointer().asSlice(OFFSET_ReleaseByteArrayElements, ADDRESS);
    }

    public MemorySegment ReleaseCharArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET_ReleaseCharArrayElements);
    }

    public void ReleaseCharArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_ReleaseCharArrayElements, value);
    }

    public MemorySegment $ReleaseCharArrayElements()
    {
        return this.pointer().asSlice(OFFSET_ReleaseCharArrayElements, ADDRESS);
    }

    public MemorySegment ReleaseShortArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET_ReleaseShortArrayElements);
    }

    public void ReleaseShortArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_ReleaseShortArrayElements, value);
    }

    public MemorySegment $ReleaseShortArrayElements()
    {
        return this.pointer().asSlice(OFFSET_ReleaseShortArrayElements, ADDRESS);
    }

    public MemorySegment ReleaseIntArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET_ReleaseIntArrayElements);
    }

    public void ReleaseIntArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_ReleaseIntArrayElements, value);
    }

    public MemorySegment $ReleaseIntArrayElements()
    {
        return this.pointer().asSlice(OFFSET_ReleaseIntArrayElements, ADDRESS);
    }

    public MemorySegment ReleaseLongArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET_ReleaseLongArrayElements);
    }

    public void ReleaseLongArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_ReleaseLongArrayElements, value);
    }

    public MemorySegment $ReleaseLongArrayElements()
    {
        return this.pointer().asSlice(OFFSET_ReleaseLongArrayElements, ADDRESS);
    }

    public MemorySegment ReleaseFloatArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET_ReleaseFloatArrayElements);
    }

    public void ReleaseFloatArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_ReleaseFloatArrayElements, value);
    }

    public MemorySegment $ReleaseFloatArrayElements()
    {
        return this.pointer().asSlice(OFFSET_ReleaseFloatArrayElements, ADDRESS);
    }

    public MemorySegment ReleaseDoubleArrayElements()
    {
        return this.pointer().get(ADDRESS, OFFSET_ReleaseDoubleArrayElements);
    }

    public void ReleaseDoubleArrayElements(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_ReleaseDoubleArrayElements, value);
    }

    public MemorySegment $ReleaseDoubleArrayElements()
    {
        return this.pointer().asSlice(OFFSET_ReleaseDoubleArrayElements, ADDRESS);
    }

    public MemorySegment GetBooleanArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetBooleanArrayRegion);
    }

    public void GetBooleanArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetBooleanArrayRegion, value);
    }

    public MemorySegment $GetBooleanArrayRegion()
    {
        return this.pointer().asSlice(OFFSET_GetBooleanArrayRegion, ADDRESS);
    }

    public MemorySegment GetByteArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetByteArrayRegion);
    }

    public void GetByteArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetByteArrayRegion, value);
    }

    public MemorySegment $GetByteArrayRegion()
    {
        return this.pointer().asSlice(OFFSET_GetByteArrayRegion, ADDRESS);
    }

    public MemorySegment GetCharArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetCharArrayRegion);
    }

    public void GetCharArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetCharArrayRegion, value);
    }

    public MemorySegment $GetCharArrayRegion()
    {
        return this.pointer().asSlice(OFFSET_GetCharArrayRegion, ADDRESS);
    }

    public MemorySegment GetShortArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetShortArrayRegion);
    }

    public void GetShortArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetShortArrayRegion, value);
    }

    public MemorySegment $GetShortArrayRegion()
    {
        return this.pointer().asSlice(OFFSET_GetShortArrayRegion, ADDRESS);
    }

    public MemorySegment GetIntArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetIntArrayRegion);
    }

    public void GetIntArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetIntArrayRegion, value);
    }

    public MemorySegment $GetIntArrayRegion()
    {
        return this.pointer().asSlice(OFFSET_GetIntArrayRegion, ADDRESS);
    }

    public MemorySegment GetLongArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetLongArrayRegion);
    }

    public void GetLongArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetLongArrayRegion, value);
    }

    public MemorySegment $GetLongArrayRegion()
    {
        return this.pointer().asSlice(OFFSET_GetLongArrayRegion, ADDRESS);
    }

    public MemorySegment GetFloatArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetFloatArrayRegion);
    }

    public void GetFloatArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetFloatArrayRegion, value);
    }

    public MemorySegment $GetFloatArrayRegion()
    {
        return this.pointer().asSlice(OFFSET_GetFloatArrayRegion, ADDRESS);
    }

    public MemorySegment GetDoubleArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetDoubleArrayRegion);
    }

    public void GetDoubleArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetDoubleArrayRegion, value);
    }

    public MemorySegment $GetDoubleArrayRegion()
    {
        return this.pointer().asSlice(OFFSET_GetDoubleArrayRegion, ADDRESS);
    }

    public MemorySegment SetBooleanArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetBooleanArrayRegion);
    }

    public void SetBooleanArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetBooleanArrayRegion, value);
    }

    public MemorySegment $SetBooleanArrayRegion()
    {
        return this.pointer().asSlice(OFFSET_SetBooleanArrayRegion, ADDRESS);
    }

    public MemorySegment SetByteArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetByteArrayRegion);
    }

    public void SetByteArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetByteArrayRegion, value);
    }

    public MemorySegment $SetByteArrayRegion()
    {
        return this.pointer().asSlice(OFFSET_SetByteArrayRegion, ADDRESS);
    }

    public MemorySegment SetCharArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetCharArrayRegion);
    }

    public void SetCharArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetCharArrayRegion, value);
    }

    public MemorySegment $SetCharArrayRegion()
    {
        return this.pointer().asSlice(OFFSET_SetCharArrayRegion, ADDRESS);
    }

    public MemorySegment SetShortArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetShortArrayRegion);
    }

    public void SetShortArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetShortArrayRegion, value);
    }

    public MemorySegment $SetShortArrayRegion()
    {
        return this.pointer().asSlice(OFFSET_SetShortArrayRegion, ADDRESS);
    }

    public MemorySegment SetIntArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetIntArrayRegion);
    }

    public void SetIntArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetIntArrayRegion, value);
    }

    public MemorySegment $SetIntArrayRegion()
    {
        return this.pointer().asSlice(OFFSET_SetIntArrayRegion, ADDRESS);
    }

    public MemorySegment SetLongArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetLongArrayRegion);
    }

    public void SetLongArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetLongArrayRegion, value);
    }

    public MemorySegment $SetLongArrayRegion()
    {
        return this.pointer().asSlice(OFFSET_SetLongArrayRegion, ADDRESS);
    }

    public MemorySegment SetFloatArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetFloatArrayRegion);
    }

    public void SetFloatArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetFloatArrayRegion, value);
    }

    public MemorySegment $SetFloatArrayRegion()
    {
        return this.pointer().asSlice(OFFSET_SetFloatArrayRegion, ADDRESS);
    }

    public MemorySegment SetDoubleArrayRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET_SetDoubleArrayRegion);
    }

    public void SetDoubleArrayRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_SetDoubleArrayRegion, value);
    }

    public MemorySegment $SetDoubleArrayRegion()
    {
        return this.pointer().asSlice(OFFSET_SetDoubleArrayRegion, ADDRESS);
    }

    public MemorySegment RegisterNatives()
    {
        return this.pointer().get(ADDRESS, OFFSET_RegisterNatives);
    }

    public void RegisterNatives(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_RegisterNatives, value);
    }

    public MemorySegment $RegisterNatives()
    {
        return this.pointer().asSlice(OFFSET_RegisterNatives, ADDRESS);
    }

    public MemorySegment UnregisterNatives()
    {
        return this.pointer().get(ADDRESS, OFFSET_UnregisterNatives);
    }

    public void UnregisterNatives(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_UnregisterNatives, value);
    }

    public MemorySegment $UnregisterNatives()
    {
        return this.pointer().asSlice(OFFSET_UnregisterNatives, ADDRESS);
    }

    public MemorySegment MonitorEnter()
    {
        return this.pointer().get(ADDRESS, OFFSET_MonitorEnter);
    }

    public void MonitorEnter(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_MonitorEnter, value);
    }

    public MemorySegment $MonitorEnter()
    {
        return this.pointer().asSlice(OFFSET_MonitorEnter, ADDRESS);
    }

    public MemorySegment MonitorExit()
    {
        return this.pointer().get(ADDRESS, OFFSET_MonitorExit);
    }

    public void MonitorExit(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_MonitorExit, value);
    }

    public MemorySegment $MonitorExit()
    {
        return this.pointer().asSlice(OFFSET_MonitorExit, ADDRESS);
    }

    public MemorySegment GetJavaVM()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetJavaVM);
    }

    public void GetJavaVM(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetJavaVM, value);
    }

    public MemorySegment $GetJavaVM()
    {
        return this.pointer().asSlice(OFFSET_GetJavaVM, ADDRESS);
    }

    public MemorySegment GetStringRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetStringRegion);
    }

    public void GetStringRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetStringRegion, value);
    }

    public MemorySegment $GetStringRegion()
    {
        return this.pointer().asSlice(OFFSET_GetStringRegion, ADDRESS);
    }

    public MemorySegment GetStringUTFRegion()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetStringUTFRegion);
    }

    public void GetStringUTFRegion(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetStringUTFRegion, value);
    }

    public MemorySegment $GetStringUTFRegion()
    {
        return this.pointer().asSlice(OFFSET_GetStringUTFRegion, ADDRESS);
    }

    public MemorySegment GetPrimitiveArrayCritical()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetPrimitiveArrayCritical);
    }

    public void GetPrimitiveArrayCritical(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetPrimitiveArrayCritical, value);
    }

    public MemorySegment $GetPrimitiveArrayCritical()
    {
        return this.pointer().asSlice(OFFSET_GetPrimitiveArrayCritical, ADDRESS);
    }

    public MemorySegment ReleasePrimitiveArrayCritical()
    {
        return this.pointer().get(ADDRESS, OFFSET_ReleasePrimitiveArrayCritical);
    }

    public void ReleasePrimitiveArrayCritical(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_ReleasePrimitiveArrayCritical, value);
    }

    public MemorySegment $ReleasePrimitiveArrayCritical()
    {
        return this.pointer().asSlice(OFFSET_ReleasePrimitiveArrayCritical, ADDRESS);
    }

    public MemorySegment GetStringCritical()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetStringCritical);
    }

    public void GetStringCritical(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetStringCritical, value);
    }

    public MemorySegment $GetStringCritical()
    {
        return this.pointer().asSlice(OFFSET_GetStringCritical, ADDRESS);
    }

    public MemorySegment ReleaseStringCritical()
    {
        return this.pointer().get(ADDRESS, OFFSET_ReleaseStringCritical);
    }

    public void ReleaseStringCritical(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_ReleaseStringCritical, value);
    }

    public MemorySegment $ReleaseStringCritical()
    {
        return this.pointer().asSlice(OFFSET_ReleaseStringCritical, ADDRESS);
    }

    public MemorySegment NewWeakGlobalRef()
    {
        return this.pointer().get(ADDRESS, OFFSET_NewWeakGlobalRef);
    }

    public void NewWeakGlobalRef(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_NewWeakGlobalRef, value);
    }

    public MemorySegment $NewWeakGlobalRef()
    {
        return this.pointer().asSlice(OFFSET_NewWeakGlobalRef, ADDRESS);
    }

    public MemorySegment DeleteWeakGlobalRef()
    {
        return this.pointer().get(ADDRESS, OFFSET_DeleteWeakGlobalRef);
    }

    public void DeleteWeakGlobalRef(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_DeleteWeakGlobalRef, value);
    }

    public MemorySegment $DeleteWeakGlobalRef()
    {
        return this.pointer().asSlice(OFFSET_DeleteWeakGlobalRef, ADDRESS);
    }

    public MemorySegment ExceptionCheck()
    {
        return this.pointer().get(ADDRESS, OFFSET_ExceptionCheck);
    }

    public void ExceptionCheck(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_ExceptionCheck, value);
    }

    public MemorySegment $ExceptionCheck()
    {
        return this.pointer().asSlice(OFFSET_ExceptionCheck, ADDRESS);
    }

    public MemorySegment NewDirectByteBuffer()
    {
        return this.pointer().get(ADDRESS, OFFSET_NewDirectByteBuffer);
    }

    public void NewDirectByteBuffer(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_NewDirectByteBuffer, value);
    }

    public MemorySegment $NewDirectByteBuffer()
    {
        return this.pointer().asSlice(OFFSET_NewDirectByteBuffer, ADDRESS);
    }

    public MemorySegment GetDirectBufferAddress()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetDirectBufferAddress);
    }

    public void GetDirectBufferAddress(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetDirectBufferAddress, value);
    }

    public MemorySegment $GetDirectBufferAddress()
    {
        return this.pointer().asSlice(OFFSET_GetDirectBufferAddress, ADDRESS);
    }

    public MemorySegment GetDirectBufferCapacity()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetDirectBufferCapacity);
    }

    public void GetDirectBufferCapacity(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetDirectBufferCapacity, value);
    }

    public MemorySegment $GetDirectBufferCapacity()
    {
        return this.pointer().asSlice(OFFSET_GetDirectBufferCapacity, ADDRESS);
    }

    public MemorySegment GetObjectRefType()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetObjectRefType);
    }

    public void GetObjectRefType(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetObjectRefType, value);
    }

    public MemorySegment $GetObjectRefType()
    {
        return this.pointer().asSlice(OFFSET_GetObjectRefType, ADDRESS);
    }

    public MemorySegment GetModule()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetModule);
    }

    public void GetModule(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetModule, value);
    }

    public MemorySegment $GetModule()
    {
        return this.pointer().asSlice(OFFSET_GetModule, ADDRESS);
    }

    public MemorySegment IsVirtualThread()
    {
        return this.pointer().get(ADDRESS, OFFSET_IsVirtualThread);
    }

    public void IsVirtualThread(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_IsVirtualThread, value);
    }

    public MemorySegment $IsVirtualThread()
    {
        return this.pointer().asSlice(OFFSET_IsVirtualThread, ADDRESS);
    }

    public MemorySegment GetStringUTFLengthAsLong()
    {
        return this.pointer().get(ADDRESS, OFFSET_GetStringUTFLengthAsLong);
    }

    public void GetStringUTFLengthAsLong(MemorySegment value)
    {
        this.pointer().set(ADDRESS, OFFSET_GetStringUTFLengthAsLong, value);
    }

    public MemorySegment $GetStringUTFLengthAsLong()
    {
        return this.pointer().asSlice(OFFSET_GetStringUTFLengthAsLong, ADDRESS);
    }
}
