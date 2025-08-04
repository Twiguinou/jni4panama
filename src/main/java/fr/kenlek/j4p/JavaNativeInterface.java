package fr.kenlek.j4p;

import fr.kenlek.jpgen.api.dynload.DowncallTransformer;
import fr.kenlek.jpgen.api.dynload.Layout;
import fr.kenlek.jpgen.api.dynload.LinkingDowncallDispatcher;
import fr.kenlek.jpgen.api.dynload.NativeProxies;
import fr.kenlek.jpgen.api.dynload.Redirect;
import fr.kenlek.jpgen.api.dynload.Unbound;

import java.lang.foreign.Arena;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.nio.file.Path;

import static java.lang.foreign.MemorySegment.NULL;

import static java.lang.foreign.ValueLayout.*;

import static fr.kenlek.j4p.JObjectRefType.*;
import static fr.kenlek.jpgen.api.ForeignUtils.SYSTEM_LINKER;
import static fr.kenlek.jpgen.api.dynload.DowncallTransformer.PUBLIC_GROUP_TRANSFORMER;
import static java.lang.foreign.SymbolLookup.libraryLookup;
import static java.lang.invoke.MethodType.methodType;
import static java.util.Objects.requireNonNull;

@Layout.Generic({
    @Layout.Case(target = JNIEnv.class, layout = @Layout(value = "LAYOUT", container = JNIEnv.class, referenced = true)),
    @Layout.Case(target = JavaVM.class, layout = @Layout(value = "LAYOUT", container = JavaVM.class, referenced = true))
})
public interface JavaNativeInterface
{
    int JNI_OK = 0;
    int JNI_ERR = -1;
    int JNI_EDETACHED = -2;
    int JNI_EVERSION = -3;
    int JNI_ENOMEM = -4;
    int JNI_EEXIST = -5;
    int JNI_EINVAL = -6;

    int JNI_COMMIT = 1;
    int JNI_ABORT = 2;

    int JNI_VERSION_1_1 = 0x00010001;
    int JNI_VERSION_1_2 = 0x00010002;
    int JNI_VERSION_1_4 = 0x00010004;
    int JNI_VERSION_1_6 = 0x00010006;
    int JNI_VERSION_1_8 = 0x00010008;
    int JNI_VERSION_9 = 0x00090000;
    int JNI_VERSION_10 = 0x000a0000;
    int JNI_VERSION_19 = 0x00130000;
    int JNI_VERSION_20 = 0x00140000;
    int JNI_VERSION_21 = 0x00150000;
    int JNI_VERSION_24 = 0x00180000;

    static JavaNativeInterface load(SymbolLookup lookup, Linker linker)
    {
        return NativeProxies.instantiate(JavaNativeInterface.class, new LinkingDowncallDispatcher(lookup, linker).compose(
            makeCallArranger(JNIEnv.class, JNINativeInterface.class).and(makeCallArranger(JavaVM.class, JNIInvokeInterface.class)).and(PUBLIC_GROUP_TRANSFORMER)
        ));
    }

    static JavaNativeInterface load(Arena arena)
    {
        String javaHome = requireNonNull(System.getProperty("java.home"), "Unable to resolve java.home system property.");
        Path libraryPath = Path.of(javaHome).resolve("lib", System.mapLibraryName("java"));
        return load(libraryLookup(libraryPath, arena), SYSTEM_LINKER);
    }

    private static DowncallTransformer makeCallArranger(Class<?> handleType, Class<?> functionsType)
    {
        return DowncallTransformer.matching(
            method -> method.isAnnotationPresent(Unbound.class) && method.getParameterCount() > 0 && method.getParameterTypes()[0].equals(handleType),
            (method, handle) ->
            {
                try
                {
                    MethodHandles.Lookup lookup = MethodHandles.publicLookup();
                    // handle is R(MemorySegment,MemorySegment,...)
                    handle = MethodHandles.filterArguments(handle, 0, lookup.findVirtual(functionsType, method.getName(), methodType(MemorySegment.class)));
                    // handle is R(JNINativeInterface or JNIInvokeInterface,MemorySegment,...)
                    handle = MethodHandles.filterArguments(handle, 0, lookup.findVirtual(handleType, "functions", methodType(functionsType)));
                    // handle is R(JNIEnv or JavaVM,MemorySegment,...)
                    handle = MethodHandles.filterArguments(handle, 1, NativeProxies.findGroupUnwrapper(lookup, handleType));
                    // handle is R(JNIEnv or JavaVM,JNIEnv or JavaVM,...)
                    return MethodHandles.foldArguments(handle, MethodHandles.identity(handleType));
                    // we return R(JNIEnv or JavaVM,...)
                }
                catch (NoSuchMethodException | IllegalAccessException e)
                {
                    throw new RuntimeException(e);
                }
            }
        );
    }

    @Redirect("JNI_GetDefaultJavaVMInitArgs")
    int GetDefaultJavaVMInitArgs(MemorySegment args);

    @Redirect("JNI_CreateJavaVM")
    int CreateJavaVM(MemorySegment pvm, MemorySegment penv, MemorySegment args);

    @Redirect("JNI_GetCreatedJavaVMs")
    int GetCreatedJavaVMs(MemorySegment vmBuf, int bufLen, MemorySegment nVMs);

    @Redirect("JNI_OnLoad")
    int OnLoad(JavaVM vm, MemorySegment reserved);

    @Redirect("JNI_OnUnload")
    void OnUnload(JavaVM vm, MemorySegment reserved);

    @Unbound
    int GetVersion(JNIEnv env);

    @Unbound
    MemorySegment DefineClass(JNIEnv env, MemorySegment name, MemorySegment loader, MemorySegment buf, int len);

    @Unbound
    MemorySegment FindClass(JNIEnv env, MemorySegment name);

    @Unbound
    MemorySegment FromReflectedMethod(JNIEnv env, MemorySegment method);

    @Unbound
    MemorySegment GetSuperclass(JNIEnv env, MemorySegment sub);

    @Unbound
    boolean IsAssignableFrom(JNIEnv env, MemorySegment sub, MemorySegment sup);

    @Unbound
    MemorySegment ToReflectedField(JNIEnv env, MemorySegment cls, MemorySegment fieldID, boolean isStatic);

    @Unbound
    int Throw(JNIEnv env, MemorySegment obj);

    @Unbound
    int ThrowNew(JNIEnv env, MemorySegment clazz, MemorySegment msg);

    @Unbound
    MemorySegment ExceptionOccurred(JNIEnv env);

    @Unbound
    void ExceptionDescribe(JNIEnv env);

    @Unbound
    void ExceptionClear(JNIEnv env);

    @Unbound
    void FatalError(JNIEnv env, MemorySegment msg);

    @Unbound
    int PushLocalFrame(JNIEnv env, int capacity);

    @Unbound
    MemorySegment PopLocalFrame(JNIEnv env, MemorySegment result);

    @Unbound
    MemorySegment NewGlobalRef(JNIEnv env, MemorySegment lobj);

    @Unbound
    void DeleteGlobalRef(JNIEnv env, MemorySegment gref);

    @Unbound
    void DeleteLocalRef(JNIEnv env, MemorySegment obj);

    @Unbound
    boolean IsSameObject(JNIEnv env, MemorySegment obj1, MemorySegment obj2);

    @Unbound
    MemorySegment NewLocalRef(JNIEnv env, MemorySegment ref);

    @Unbound
    int EnsureLocalCapacity(JNIEnv env, int capacity);

    @Unbound
    MemorySegment AllocObject(JNIEnv env, MemorySegment clazz);

    @Unbound
    MemorySegment NewObjectA(JNIEnv env, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    MemorySegment GetObjectClass(JNIEnv env, MemorySegment obj);

    @Unbound
    boolean IsInstanceOf(JNIEnv env, MemorySegment obj, MemorySegment clazz);

    @Unbound
    MemorySegment GetMethodID(JNIEnv env, MemorySegment clazz, MemorySegment name, MemorySegment sig);

    @Unbound
    MemorySegment CallObjectMethodA(JNIEnv env, MemorySegment obj, MemorySegment methodID, MemorySegment args);

    @Unbound
    boolean CallBooleanMethodA(JNIEnv env, MemorySegment obj, MemorySegment methodID, MemorySegment args);

    @Unbound
    byte CallByteMethodA(JNIEnv env, MemorySegment obj, MemorySegment methodID, MemorySegment args);

    @Unbound
    char CallCharMethodA(JNIEnv env, MemorySegment obj, MemorySegment methodID, MemorySegment args);

    @Unbound
    short CallShortMethodA(JNIEnv env, MemorySegment obj, MemorySegment methodID, MemorySegment args);

    @Unbound
    int CallIntMethodA(JNIEnv env, MemorySegment obj, MemorySegment methodID, MemorySegment args);

    @Unbound
    long CallLongMethodA(JNIEnv env, MemorySegment obj, MemorySegment methodID, MemorySegment args);

    @Unbound
    float CallFloatMethodA(JNIEnv env, MemorySegment obj, MemorySegment methodID, MemorySegment args);

    @Unbound
    double CallDoubleMethodA(JNIEnv env, MemorySegment obj, MemorySegment methodID, MemorySegment args);

    @Unbound
    void CallVoidMethodA(JNIEnv env, MemorySegment obj, MemorySegment methodID, MemorySegment args);

    @Unbound
    MemorySegment CallNonvirtualObjectMethodA(JNIEnv env, MemorySegment obj, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    boolean CallNonvirtualBooleanMethodA(JNIEnv env, MemorySegment obj, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    byte CallNonvirtualByteMethodA(JNIEnv env, MemorySegment obj, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    char CallNonvirtualCharMethodA(JNIEnv env, MemorySegment obj, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    short CallNonvirtualShortMethodA(JNIEnv env, MemorySegment obj, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    int CallNonvirtualIntMethodA(JNIEnv env, MemorySegment obj, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    long CallNonvirtualLongMethodA(JNIEnv env, MemorySegment obj, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    float CallNonvirtualFloatMethodA(JNIEnv env, MemorySegment obj, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    double CallNonvirtualDoubleMethodA(JNIEnv env, MemorySegment obj, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    void CallNonvirtualVoidMethodA(JNIEnv env, MemorySegment obj, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    MemorySegment GetFieldID(JNIEnv env, MemorySegment clazz, MemorySegment name, MemorySegment sig);

    @Unbound
    MemorySegment GetObjectField(JNIEnv env, MemorySegment obj, MemorySegment fieldID);

    @Unbound
    boolean GetBooleanField(JNIEnv env, MemorySegment obj, MemorySegment fieldID);

    @Unbound
    byte GetByteField(JNIEnv env, MemorySegment obj, MemorySegment fieldID);

    @Unbound
    char GetCharField(JNIEnv env, MemorySegment obj, MemorySegment fieldID);

    @Unbound
    short GetShortField(JNIEnv env, MemorySegment obj, MemorySegment fieldID);

    @Unbound
    int GetIntField(JNIEnv env, MemorySegment obj, MemorySegment fieldID);

    @Unbound
    long GetLongField(JNIEnv env, MemorySegment obj, MemorySegment fieldID);

    @Unbound
    float GetFloatField(JNIEnv env, MemorySegment obj, MemorySegment fieldID);

    @Unbound
    double GetDoubleField(JNIEnv env, MemorySegment obj, MemorySegment fieldID);

    @Unbound
    void SetObjectField(JNIEnv env, MemorySegment obj, MemorySegment fieldID, MemorySegment val);

    @Unbound
    void SetBooleanField(JNIEnv env, MemorySegment obj, MemorySegment fieldID, boolean val);

    @Unbound
    void SetByteField(JNIEnv env, MemorySegment obj, MemorySegment fieldID, byte val);

    @Unbound
    void SetCharField(JNIEnv env, MemorySegment obj, MemorySegment fieldID, char val);

    @Unbound
    void SetShortField(JNIEnv env, MemorySegment obj, MemorySegment fieldID, short val);

    @Unbound
    void SetIntField(JNIEnv env, MemorySegment obj, MemorySegment fieldID, int val);

    @Unbound
    void SetLongField(JNIEnv env, MemorySegment obj, MemorySegment fieldID, long val);

    @Unbound
    void SetFloatField(JNIEnv env, MemorySegment obj, MemorySegment fieldID, float val);

    @Unbound
    void SetDoubleField(JNIEnv env, MemorySegment obj, MemorySegment fieldID, double val);

    @Unbound
    MemorySegment GetStaticMethodID(JNIEnv env, MemorySegment clazz, MemorySegment name, MemorySegment sig);

    @Unbound
    MemorySegment CallStaticObjectMethodA(JNIEnv env, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    boolean CallStaticBooleanMethodA(JNIEnv env, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    byte CallStaticByteMethodA(JNIEnv env, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    char CallStaticCharMethodA(JNIEnv env, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    short CallStaticShortMethodA(JNIEnv env, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    int CallStaticIntMethodA(JNIEnv env, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    long CallStaticLongMethodA(JNIEnv env, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    float CallStaticFloatMethodA(JNIEnv env, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    double CallStaticDoubleMethodA(JNIEnv env, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    void CallStaticVoidMethodA(JNIEnv env, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    @Unbound
    MemorySegment GetStaticFieldID(JNIEnv env, MemorySegment clazz, MemorySegment name, MemorySegment sig);

    @Unbound
    MemorySegment GetStaticObjectField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID);

    @Unbound
    boolean GetStaticBooleanField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID);

    @Unbound
    byte GetStaticByteField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID);

    @Unbound
    char GetStaticCharField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID);

    @Unbound
    short GetStaticShortField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID);

    @Unbound
    int GetStaticIntField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID);

    @Unbound
    long GetStaticLongField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID);

    @Unbound
    float GetStaticFloatField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID);

    @Unbound
    double GetStaticDoubleField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID);

    @Unbound
    void SetStaticObjectField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID, MemorySegment value);

    @Unbound
    void SetStaticBooleanField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID, boolean value);

    @Unbound
    void SetStaticByteField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID, byte value);

    @Unbound
    void SetStaticCharField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID, char value);

    @Unbound
    void SetStaticShortField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID, short value);

    @Unbound
    void SetStaticIntField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID, int value);

    @Unbound
    void SetStaticLongField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID, long value);

    @Unbound
    void SetStaticFloatField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID, float value);

    @Unbound
    void SetStaticDoubleField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID, double value);

    @Unbound
    MemorySegment NewString(JNIEnv env, MemorySegment unicode, int len);

    @Unbound
    int GetStringLength(JNIEnv env, MemorySegment str);

    @Unbound
    MemorySegment GetStringChars(JNIEnv env, MemorySegment str, MemorySegment isCopy);

    @Unbound
    void ReleaseStringChars(JNIEnv env, MemorySegment str, MemorySegment chars);

    @Unbound
    MemorySegment NewStringUTF(JNIEnv env, MemorySegment utf);

    @Unbound
    MemorySegment GetStringUTFLength(JNIEnv env, MemorySegment str);

    @Unbound
    MemorySegment GetStringUTFChars(JNIEnv env, MemorySegment str, MemorySegment isCopy);

    @Unbound
    void ReleaseStringUTFChars(JNIEnv env, MemorySegment str, MemorySegment chars);

    @Unbound
    int GetArrayLength(JNIEnv env, MemorySegment array);

    @Unbound
    MemorySegment NewObjectArray(JNIEnv env, int len, MemorySegment clazz, MemorySegment init);

    @Unbound
    MemorySegment GetObjectArrayElement(JNIEnv env, MemorySegment array, int index);

    @Unbound
    void SetObjectArrayElement(JNIEnv env, MemorySegment array, int index, MemorySegment val);

    @Unbound
    MemorySegment NewBooleanArray(JNIEnv env, int len);

    @Unbound
    MemorySegment NewByteArray(JNIEnv env, int len);

    @Unbound
    MemorySegment NewCharArray(JNIEnv env, int len);

    @Unbound
    MemorySegment NewShortArray(JNIEnv env, int len);

    @Unbound
    MemorySegment NewIntArray(JNIEnv env, int len);

    @Unbound
    MemorySegment NewLongArray(JNIEnv env, int len);

    @Unbound
    MemorySegment NewFloatArray(JNIEnv env, int len);

    @Unbound
    MemorySegment NewDoubleArray(JNIEnv env, int len);

    @Unbound
    MemorySegment GetBooleanArrayElements(JNIEnv env, MemorySegment array, MemorySegment isCopy);

    @Unbound
    MemorySegment GetByteArrayElements(JNIEnv env, MemorySegment array, MemorySegment isCopy);

    @Unbound
    MemorySegment GetCharArrayElements(JNIEnv env, MemorySegment array, MemorySegment isCopy);

    @Unbound
    MemorySegment GetShortArrayElements(JNIEnv env, MemorySegment array, MemorySegment isCopy);

    @Unbound
    MemorySegment GetIntArrayElements(JNIEnv env, MemorySegment array, MemorySegment isCopy);

    @Unbound
    MemorySegment GetLongArrayElements(JNIEnv env, MemorySegment array, MemorySegment isCopy);

    @Unbound
    MemorySegment GetFloatArrayElements(JNIEnv env, MemorySegment array, MemorySegment isCopy);

    @Unbound
    MemorySegment GetDoubleArrayElements(JNIEnv env, MemorySegment array, MemorySegment isCopy);

    @Unbound
    void ReleaseBooleanArrayElements(JNIEnv env, MemorySegment array, MemorySegment elems, int mode);

    @Unbound
    void ReleaseByteArrayElements(JNIEnv env, MemorySegment array, MemorySegment elems, int mode);

    @Unbound
    void ReleaseCharArrayElements(JNIEnv env, MemorySegment array, MemorySegment elems, int mode);

    @Unbound
    void ReleaseShortArrayElements(JNIEnv env, MemorySegment array, MemorySegment elems, int mode);

    @Unbound
    void ReleaseIntArrayElements(JNIEnv env, MemorySegment array, MemorySegment elems, int mode);

    @Unbound
    void ReleaseLongArrayElements(JNIEnv env, MemorySegment array, MemorySegment elems, int mode);

    @Unbound
    void ReleaseFloatArrayElements(JNIEnv env, MemorySegment array, MemorySegment elems, int mode);

    @Unbound
    void ReleaseDoubleArrayElements(JNIEnv env, MemorySegment array, MemorySegment elems, int mode);

    @Unbound
    void GetBooleanArrayRegion(JNIEnv env, MemorySegment array, int start, int l, MemorySegment buf);

    @Unbound
    void GetByteArrayRegion(JNIEnv env, MemorySegment array, int start, int len, MemorySegment buf);

    @Unbound
    void GetCharArrayRegion(JNIEnv env, MemorySegment array, int start, int len, MemorySegment buf);

    @Unbound
    void GetShortArrayRegion(JNIEnv env, MemorySegment array, int start, int len, MemorySegment buf);

    @Unbound
    void GetIntArrayRegion(JNIEnv env, MemorySegment array, int start, int len, MemorySegment buf);

    @Unbound
    void GetLongArrayRegion(JNIEnv env, MemorySegment array, int start, int len, MemorySegment buf);

    @Unbound
    void GetFloatArrayRegion(JNIEnv env, MemorySegment array, int start, int len, MemorySegment buf);

    @Unbound
    void GetDoubleArrayRegion(JNIEnv env, MemorySegment array, int start, int len, MemorySegment buf);

    @Unbound
    void SetBooleanArrayRegion(JNIEnv env, MemorySegment array, int start, int l, MemorySegment buf);

    @Unbound
    void SetByteArrayRegion(JNIEnv env, MemorySegment array, int start, int len, MemorySegment buf);

    @Unbound
    void SetCharArrayRegion(JNIEnv env, MemorySegment array, int start, int len, MemorySegment buf);

    @Unbound
    void SetShortArrayRegion(JNIEnv env, MemorySegment array, int start, int len, MemorySegment buf);

    @Unbound
    void SetIntArrayRegion(JNIEnv env, MemorySegment array, int start, int len, MemorySegment buf);

    @Unbound
    void SetLongArrayRegion(JNIEnv env, MemorySegment array, int start, int len, MemorySegment buf);

    @Unbound
    void SetFloatArrayRegion(JNIEnv env, MemorySegment array, int start, int len, MemorySegment buf);

    @Unbound
    void SetDoubleArrayRegion(JNIEnv env, MemorySegment array, int start, int len, MemorySegment buf);

    @Unbound
    int RegisterNatives(JNIEnv env, MemorySegment clazz, MemorySegment methods, int nMethods);

    @Unbound
    int UnregisterNatives(JNIEnv env, MemorySegment clazz);

    @Unbound
    int MonitorEnter(JNIEnv env, MemorySegment obj);

    @Unbound
    int MonitorExit(JNIEnv env, MemorySegment obj);

    @Unbound
    int GetJavaVM(JNIEnv env, MemorySegment vm);

    @Unbound
    void GetStringRegion(JNIEnv env, MemorySegment str, int start, int len, MemorySegment buf);

    @Unbound
    void GetStringUTFRegion(JNIEnv env, MemorySegment str, int start, int len, MemorySegment buf);

    @Unbound
    MemorySegment GetPrimitiveArrayCritical(JNIEnv env, MemorySegment array, MemorySegment isCopy);

    @Unbound
    void ReleasePrimitiveArrayCritical(JNIEnv env, MemorySegment array, MemorySegment carray, int mode);

    @Unbound
    MemorySegment GetStringCritical(JNIEnv env, MemorySegment string, MemorySegment isCopy);

    @Unbound
    void ReleaseStringCritical(JNIEnv env, MemorySegment string, MemorySegment cstring);

    @Unbound
    MemorySegment NewWeakGlobalRef(JNIEnv env, MemorySegment obj);

    @Unbound
    void DeleteWeakGlobalRef(JNIEnv env, MemorySegment ref);

    @Unbound
    boolean ExceptionCheck(JNIEnv env);

    @Unbound
    MemorySegment NewDirectByteBuffer(JNIEnv env, MemorySegment address, long capacity);

    @Unbound
    MemorySegment GetDirectBufferAddress(JNIEnv env, MemorySegment buf);

    @Unbound
    long GetDirectBufferCapacity(JNIEnv env, MemorySegment buf);

    @Unbound
    int GetObjectRefType(JNIEnv env, MemorySegment obj);

    @Unbound
    MemorySegment GetModule(JNIEnv env, MemorySegment clazz);

    @Unbound
    boolean IsVirtualThread(JNIEnv env, MemorySegment obj);

    @Unbound
    long GetStringUTFLengthAsLong(JNIEnv env, MemorySegment str);

    @Unbound
    int DestroyJavaVM(JavaVM vm);

    @Unbound
    int AttachCurrentThread(JavaVM vm, MemorySegment penv, MemorySegment args);

    @Unbound
    int DetachCurrentThread(JavaVM vm);

    @Unbound
    int GetEnv(JavaVM vm, MemorySegment penv, int version);

    @Unbound
    int AttachCurrentThreadAsDaemon(JavaVM vm, MemorySegment penv, MemorySegment args);

    default JNIEnv getCurrentJNIEnv(int searchBias, int version)
    {
        if (searchBias <= 0)
        {
            throw new IllegalArgumentException("Search bias must be strictly greater than 0.");
        }

        int result;
        try (Arena arena = Arena.ofConfined())
        {
            MemorySegment pVMs = arena.allocate(ADDRESS, searchBias);
            MemorySegment pVMCount = arena.allocate(JAVA_INT);
            result = this.GetCreatedJavaVMs(pVMs, searchBias, pVMCount);
            if (result != 0)
            {
                throw new RuntimeException("Failed to query Java VMs: " + result);
            }

            int vmCount = pVMCount.get(JAVA_INT, 0);
            if (vmCount <= 0)
            {
                throw new RuntimeException("No Java VM found.");
            }

            MemorySegment pEnv = arena.allocate(ADDRESS);
            for (int i = 0; i < vmCount; i++)
            {
                JavaVM vm = new JavaVM(pVMs.getAtIndex(ADDRESS, i).reinterpret(JavaVM.LAYOUT.byteSize()));

                result = this.GetEnv(vm, pEnv, version);
                if (result == JNI_EVERSION)
                {
                    // A thread can only be bound to a single VM
                    throw new RuntimeException("JNI version %d is not supported.".formatted(result));
                }
                else if (result != JNI_OK)
                {
                    continue;
                }

                return new JNIEnv(pEnv.get(ADDRESS, 0).reinterpret(JNIEnv.LAYOUT.byteSize()));
            }

            throw new RuntimeException("No Java VM could be tied to the current thread.");
        }
    }

    default JNIEnv getCurrentJNIEnv(int version)
    {
        return this.getCurrentJNIEnv(1, version);
    }

    default Reference localReference(JNIEnv env, MemorySegment value)
    {
        return new Reference(this, env, value, JNILocalRefType);
    }

    default Reference globalReference(JNIEnv env, MemorySegment value)
    {
        return new Reference(this, env, value, JNIGlobalRefType);
    }

    default Reference weakReference(JNIEnv env, MemorySegment value)
    {
        return new Reference(this, env, value, JNIWeakGlobalRefType);
    }

    default Reference findClass(JNIEnv env, Class<?> clazz)
    {
        try (Arena arena = Arena.ofConfined())
        {
            if (clazz.getClassLoader() == null)
            {
                return globalReference(env, this.FindClass(env, arena.allocateFrom(clazz.descriptorString())));
            }

            try (
                Reference threadClass = this.findClass(env, Thread.class);
                Reference currentThread = globalReference(env, this.CallStaticObjectMethodA(
                    env, threadClass.value, this.getStaticMethodID(env, threadClass.value, "currentThread", methodType(Thread.class)), NULL
                ));
                Reference classLoader = globalReference(env, this.CallObjectMethodA(
                    env, currentThread.value, this.getMethodID(env, threadClass.value, "getContextClassLoader", methodType(ClassLoader.class)), NULL
                ));
                Reference classClass = this.findClass(env, Class.class);
                Reference className = globalReference(env, this.NewStringUTF(env, arena.allocateFrom(clazz.getName())))
            )
            {
                MemorySegment args = arena.allocate(JValue.LAYOUT, 3);
                JValue.getAtIndex(args, 0).l(className.value);
                JValue.getAtIndex(args, 1).z(false);
                JValue.getAtIndex(args, 2).l(classLoader.value);

                return globalReference(env, this.CallStaticObjectMethodA(env, classClass.value, this.getStaticMethodID(
                    env, classClass.value, "forName", methodType(Class.class, String.class, boolean.class, ClassLoader.class)
                ), args));
            }
        }
    }

    default MemorySegment getMethodID(JNIEnv env, MemorySegment clazz, String name, MethodType type)
    {
        try (Arena arena = Arena.ofConfined())
        {
            return this.GetMethodID(env, clazz, arena.allocateFrom(name), arena.allocateFrom(type.descriptorString()));
        }
    }

    default MemorySegment getFieldID(JNIEnv env, MemorySegment clazz, String name, Class<?> type)
    {
        try (Arena arena = Arena.ofConfined())
        {
            return this.GetFieldID(env, clazz, arena.allocateFrom(name), arena.allocateFrom(type.descriptorString()));
        }
    }

    default MemorySegment getStaticMethodID(JNIEnv env, MemorySegment clazz, String name, MethodType type)
    {
        try (Arena arena = Arena.ofConfined())
        {
            return this.GetStaticMethodID(env, clazz, arena.allocateFrom(name), arena.allocateFrom(type.descriptorString()));
        }
    }

    default MemorySegment getStaticFieldID(JNIEnv env, MemorySegment clazz, String name, Class<?> type)
    {
        try (Arena arena = Arena.ofConfined())
        {
            return this.GetStaticFieldID(env, clazz, arena.allocateFrom(name), arena.allocateFrom(type.descriptorString()));
        }
    }
}
