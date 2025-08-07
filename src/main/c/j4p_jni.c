#include "j4p_def.h"

#define J4P_JNI_WRAPPER_VOID(x) JNIEXPORT jobject j4p_jni_##x(JNIEnv* env)
#define J4P_JNI_WRAPPER(x, ...) JNIEXPORT jobject j4p_jni_##x(JNIEnv* env, __VA_ARGS__)
#define J4P_JNI_WRAP_VOID(x) globalReference(env, (*env)->x(env))
#define J4P_JNI_WRAP(x, ...) globalReference(env, (*env)->x(env, __VA_ARGS__))

J4P_JNI_WRAPPER(DefineClass, const char* name, jobject loader, const jbyte* buf, jsize len)
{
    return J4P_JNI_WRAP(DefineClass, name, loader, buf, len);
}

J4P_JNI_WRAPPER(FindClass, const char* name)
{
    return J4P_JNI_WRAP(FindClass, name);
}

J4P_JNI_WRAPPER(ToReflectedMethod, jclass cls, jmethodID methodID, jboolean isStatic)
{
    return J4P_JNI_WRAP(ToReflectedMethod, cls, methodID, isStatic);
}

J4P_JNI_WRAPPER(GetSuperclass, jclass sub)
{
    return J4P_JNI_WRAP(GetSuperclass, sub);
}

J4P_JNI_WRAPPER(ToReflectedField, jclass cls, jfieldID fieldID, jboolean isStatic)
{
    return J4P_JNI_WRAP(ToReflectedField, cls, fieldID, isStatic);
}

J4P_JNI_WRAPPER_VOID(ExceptionOccurred)
{
    return J4P_JNI_WRAP_VOID(ExceptionOccurred);
}

J4P_JNI_WRAPPER(AllocObject, jclass clazz)
{
    return J4P_JNI_WRAP(AllocObject, clazz);
}

J4P_JNI_WRAPPER(NewObjectA, jclass clazz, jmethodID methodID, const jvalue* args)
{
    return J4P_JNI_WRAP(NewObjectA, clazz, methodID, args);
}

J4P_JNI_WRAPPER(GetObjectClass, jobject obj)
{
    return J4P_JNI_WRAP(GetObjectClass, obj);
}

J4P_JNI_WRAPPER(CallObjectMethodA, jobject obj, jmethodID methodID, const jvalue* args)
{
    return J4P_JNI_WRAP(CallObjectMethodA, obj, methodID, args);
}

J4P_JNI_WRAPPER(CallNonvirtualObjectMethodA, jobject obj, jclass clazz, jmethodID methodID, const jvalue* args)
{
    return J4P_JNI_WRAP(CallNonvirtualObjectMethodA, obj, clazz, methodID, args);
}

J4P_JNI_WRAPPER(GetObjectField, jobject obj, jfieldID fieldID)
{
    return J4P_JNI_WRAP(GetObjectField, obj, fieldID);
}

J4P_JNI_WRAPPER(CallStaticObjectMethodA, jclass clazz, jmethodID methodID, const jvalue* args)
{
    return J4P_JNI_WRAP(CallStaticObjectMethodA, clazz, methodID, args);
}

J4P_JNI_WRAPPER(GetStaticObjectField, jclass clazz, jfieldID fieldID)
{
    return J4P_JNI_WRAP(GetStaticObjectField, clazz, fieldID);
}

J4P_JNI_WRAPPER(NewString, const jchar* unicode, jsize len)
{
    return J4P_JNI_WRAP(NewString, unicode, len);
}

J4P_JNI_WRAPPER(NewStringUTF, const char* utf)
{
    return J4P_JNI_WRAP(NewStringUTF, utf);
}

J4P_JNI_WRAPPER(NewObjectArray, jsize len, jclass clazz, jobject init)
{
    return J4P_JNI_WRAP(NewObjectArray, len, clazz, init);
}

J4P_JNI_WRAPPER(GetObjectArrayElement, jobjectArray array, jsize index)
{
    return J4P_JNI_WRAP(GetObjectArrayElement, array, index);
}

J4P_JNI_WRAPPER(NewBooleanArray, jsize len)
{
    return J4P_JNI_WRAP(NewBooleanArray, len);
}

J4P_JNI_WRAPPER(NewByteArray, jsize len)
{
    return J4P_JNI_WRAP(NewByteArray, len);
}

J4P_JNI_WRAPPER(NewCharArray, jsize len)
{
    return J4P_JNI_WRAP(NewCharArray, len);
}

J4P_JNI_WRAPPER(NewShortArray, jsize len)
{
    return J4P_JNI_WRAP(NewShortArray, len);
}

J4P_JNI_WRAPPER(NewIntArray, jsize len)
{
    return J4P_JNI_WRAP(NewIntArray, len);
}

J4P_JNI_WRAPPER(NewLongArray, jsize len)
{
    return J4P_JNI_WRAP(NewLongArray, len);
}

J4P_JNI_WRAPPER(NewFloatArray, jsize len)
{
    return J4P_JNI_WRAP(NewFloatArray, len);
}

J4P_JNI_WRAPPER(NewDoubleArray, jsize len)
{
    return J4P_JNI_WRAP(NewDoubleArray, len);
}

J4P_JNI_WRAPPER(NewDirectByteBuffer, void* address, jlong capacity)
{
    return J4P_JNI_WRAP(NewDirectByteBuffer, address, capacity);
}

J4P_JNI_WRAPPER(GetModule, jclass clazz)
{
    return J4P_JNI_WRAP(GetModule, clazz);
}
