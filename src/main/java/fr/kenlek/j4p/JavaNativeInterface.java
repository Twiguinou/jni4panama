package fr.kenlek.j4p;

import module fr.kenlek.jpgen.api;
import module java.base;

import fr.kenlek.jpgen.api.Buffer;

import static fr.kenlek.jpgen.api.ForeignUtils.loadLookup;
import static fr.kenlek.jpgen.api.dynload.DowncallTransformer.PUBLIC_GROUP_TRANSFORMER;
import static java.lang.foreign.MemorySegment.NULL;
import static java.lang.foreign.SymbolLookup.libraryLookup;
import static java.lang.foreign.ValueLayout.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.methodType;
import static java.util.Objects.requireNonNull;

@Layout.Generic({
    @Layout.Case(target = JNIEnv.class, layout = @Layout(value = "LAYOUT", container = JNIEnv.class, referenced = true)),
    @Layout.Case(target = JavaVM.class, layout = @Layout(value = "LAYOUT", container = JavaVM.class, referenced = true))
})
public interface JavaNativeInterface
{
    DowncallTransformer DOWNCALL_TRANSFORMER = makeCallArranger(JNIEnv.class, JNINativeInterface.class)
        .and(makeCallArranger(JavaVM.class, JNIInvokeInterface.class))
        .and(PUBLIC_GROUP_TRANSFORMER);

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

    static SymbolLookup jvmLookup(Arena arena)
    {
        String javaHome = requireNonNull(System.getProperty("java.home"), "Unable to resolve java.home system property.");
        Path sharedLibrariesDirectory = Path.of(javaHome).resolve(Host.select(
            Platform.OS.WINDOWS.value("bin"),
            Host.ALL_TARGETS.value("lib")
        ));
        return libraryLookup(sharedLibrariesDirectory.resolve("server", System.mapLibraryName("jvm")), arena);
    }

    static SymbolLookup j4pLookup(Arena arena) throws IOException
    {
        String libraryPath = System.getProperty("j4p.library.path");
        if (libraryPath != null)
        {
            return libraryLookup(Path.of(libraryPath), arena);
        }

        String libraryName = "j4p-" + Platform.CURRENT.code();
        try
        {
            return libraryLookup(libraryName, arena);
        }
        catch (IllegalArgumentException _)
        {
            try (InputStream input = requireNonNull(JavaNativeInterface.class.getResourceAsStream("natives/" + System.mapLibraryName(libraryName))))
            {
                return loadLookup(arena, input, "j4p");
            }
        }
    }

    private static DowncallTransformer makeCallArranger(Class<?> handleType, Class<?> functionsType)
    {
        return DowncallTransformer.filter((method, handle) ->
        {
            MethodHandles.Lookup lookup = publicLookup();
            MethodType MT_MemorySegment = methodType(MemorySegment.class);

            try
            {
                // handle is R(MemorySegment,MemorySegment,...)
                handle = filterArguments(handle, 0, lookup.findVirtual(functionsType, method.getName(), MT_MemorySegment));
                // handle is R(JNINativeInterface or JNIInvokeInterface,MemorySegment,...)
                handle = filterArguments(handle, 0, lookup.findVirtual(handleType, "functions", methodType(functionsType)));
                // handle is R(JNIEnv or JavaVM,MemorySegment,...)
                handle = filterArguments(handle, 1, lookup.findVirtual(handleType, "pointer", MT_MemorySegment));
                // handle is R(JNIEnv or JavaVM,JNIEnv or JavaVM,...)
                return foldArguments(handle, identity(handleType));
                // we return R(JNIEnv or JavaVM,...)
            }
            catch (NoSuchMethodException | IllegalAccessException e)
            {
                throw new RuntimeException(e);
            }
        }, method -> method.isAnnotationPresent(Unbound.class) && method.getParameterCount() > 0 && method.getParameterTypes()[0].equals(handleType));
    }

    static JavaNativeInterface load(SymbolLookup lookup)
    {
        return NativeProxies.make(JavaNativeInterface.class, new LinkingDispatcher(lookup).and(DOWNCALL_TRANSFORMER));
    }

    static JavaNativeInterface load(SymbolLookup jvmLookup, SymbolLookup j4pLookup)
    {
        return load(jvmLookup.or(j4pLookup));
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

    default Reference reference(JNIEnv env, MemorySegment value)
    {
        return new Reference(this, env, value);
    }

    @Unbound
    int GetVersion(JNIEnv env);

    @Redirect("j4p_jni_DefineClass")
    MemorySegment _DefineClass(JNIEnv env, MemorySegment name, MemorySegment loader, MemorySegment buf, int len);

    default Reference DefineClass(JNIEnv env, MemorySegment name, MemorySegment loader, MemorySegment buf, int len)
    {
        return this.reference(env, this._DefineClass(env, name, loader, buf, len));
    }

    @Redirect("j4p_jni_FindClass")
    MemorySegment _FindClass(JNIEnv env, MemorySegment name);

    default Reference FindClass(JNIEnv env, MemorySegment name)
    {
        return this.reference(env, this._FindClass(env, name));
    }

    @Unbound
    MemorySegment FromReflectedMethod(JNIEnv env, MemorySegment method);

    @Unbound
    MemorySegment FromReflectedField(JNIEnv env, MemorySegment field);

    @Redirect("j4p_jni_ToReflectedMethod")
    MemorySegment _ToReflectedMethod(JNIEnv env, MemorySegment cls, MemorySegment methodID, boolean isStatic);

    default Reference ToReflectedMethod(JNIEnv env, MemorySegment cls, MemorySegment methodID, boolean isStatic)
    {
        return this.reference(env, this._ToReflectedMethod(env, cls, methodID, isStatic));
    }

    @Redirect("j4p_jni_GetSuperclass")
    MemorySegment _GetSuperclass(JNIEnv env, MemorySegment sub);

    default Reference GetSuperclass(JNIEnv env, MemorySegment sub)
    {
        return this.reference(env, this._GetSuperclass(env, sub));
    }

    @Unbound
    boolean IsAssignableFrom(JNIEnv env, MemorySegment sub, MemorySegment sup);

    @Redirect("j4p_jni_ToReflectedField")
    MemorySegment _ToReflectedField(JNIEnv env, MemorySegment cls, MemorySegment fieldID, boolean isStatic);

    default Reference ToReflectedField(JNIEnv env, MemorySegment cls, MemorySegment fieldID, boolean isStatic)
    {
        return this.reference(env, this._ToReflectedField(env, cls, fieldID, isStatic));
    }

    @Unbound
    int Throw(JNIEnv env, MemorySegment obj);

    @Unbound
    int ThrowNew(JNIEnv env, MemorySegment clazz, MemorySegment msg);

    @Redirect("j4p_jni_ExceptionOccurred")
    MemorySegment _ExceptionOccurred(JNIEnv env);

    default Reference ExceptionOccurred(JNIEnv env)
    {
        return this.reference(env, this._ExceptionOccurred(env));
    }

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

    @Redirect("j4p_jni_AllocObject")
    MemorySegment _AllocObject(JNIEnv env, MemorySegment clazz);

    default Reference AllocObject(JNIEnv env, MemorySegment clazz)
    {
        return this.reference(env, this._AllocObject(env, clazz));
    }

    @Redirect("j4p_jni_NewObjectA")
    MemorySegment _NewObjectA(JNIEnv env, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    default Reference NewObjectA(JNIEnv env, MemorySegment clazz, MemorySegment methodID, MemorySegment args)
    {
        return this.reference(env, this._NewObjectA(env, clazz, methodID, args));
    }

    @Redirect("j4p_jni_GetObjectClass")
    MemorySegment _GetObjectClass(JNIEnv env, MemorySegment obj);

    default Reference GetObjectClass(JNIEnv env, MemorySegment obj)
    {
        return this.reference(env, this._GetObjectClass(env, obj));
    }

    @Unbound
    boolean IsInstanceOf(JNIEnv env, MemorySegment obj, MemorySegment clazz);

    @Unbound
    MemorySegment GetMethodID(JNIEnv env, MemorySegment clazz, MemorySegment name, MemorySegment sig);

    @Redirect("j4p_jni_CallObjectMethodA")
    MemorySegment _CallObjectMethodA(JNIEnv env, MemorySegment obj, MemorySegment methodID, MemorySegment args);

    default Reference CallObjectMethodA(JNIEnv env, MemorySegment obj, MemorySegment methodID, MemorySegment args)
    {
        return this.reference(env, this._CallObjectMethodA(env, obj, methodID, args));
    }

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

    @Redirect("j4p_jni_CallNonvirtualObjectMethodA")
    MemorySegment _CallNonvirtualObjectMethodA(JNIEnv env, MemorySegment obj, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    default Reference CallNonvirtualObjectMethodA(JNIEnv env, MemorySegment obj, MemorySegment clazz, MemorySegment methodID, MemorySegment args)
    {
        return this.reference(env, this._CallNonvirtualObjectMethodA(env, obj, clazz, methodID, args));
    }

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

    @Redirect("j4p_jni_GetObjectField")
    MemorySegment _GetObjectField(JNIEnv env, MemorySegment obj, MemorySegment fieldID);

    default Reference GetObjectField(JNIEnv env, MemorySegment obj, MemorySegment fieldID)
    {
        return this.reference(env, this._GetObjectField(env, obj, fieldID));
    }

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

    @Redirect("j4p_jni_CallStaticObjectMethodA")
    MemorySegment _CallStaticObjectMethodA(JNIEnv env, MemorySegment clazz, MemorySegment methodID, MemorySegment args);

    default Reference CallStaticObjectMethodA(JNIEnv env, MemorySegment clazz, MemorySegment methodID, MemorySegment args)
    {
        return this.reference(env, this._CallStaticObjectMethodA(env, clazz, methodID, args));
    }

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

    @Redirect("j4p_jni_GetStaticObjectField")
    MemorySegment _GetStaticObjectField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID);

    default Reference GetStaticObjectField(JNIEnv env, MemorySegment clazz, MemorySegment fieldID)
    {
        return this.reference(env, this._GetStaticObjectField(env, clazz, fieldID));
    }

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

    @Redirect("j4p_jni_NewString")
    MemorySegment _NewString(JNIEnv env, MemorySegment unicode, int len);

    default Reference NewString(JNIEnv env, MemorySegment unicode, int len)
    {
        return this.reference(env, this._NewString(env, unicode, len));
    }

    @Unbound
    int GetStringLength(JNIEnv env, MemorySegment str);

    @Unbound
    MemorySegment GetStringChars(JNIEnv env, MemorySegment str, MemorySegment isCopy);

    @Unbound
    void ReleaseStringChars(JNIEnv env, MemorySegment str, MemorySegment chars);

    @Redirect("j4p_jni_NewStringUTF")
    MemorySegment _NewStringUTF(JNIEnv env, MemorySegment utf);

    default Reference NewStringUTF(JNIEnv env, MemorySegment utf)
    {
        return this.reference(env, this._NewStringUTF(env, utf));
    }

    @Unbound
    MemorySegment GetStringUTFLength(JNIEnv env, MemorySegment str);

    @Unbound
    MemorySegment GetStringUTFChars(JNIEnv env, MemorySegment str, MemorySegment isCopy);

    @Unbound
    void ReleaseStringUTFChars(JNIEnv env, MemorySegment str, MemorySegment chars);

    @Unbound
    int GetArrayLength(JNIEnv env, MemorySegment array);

    @Redirect("j4p_jni_NewObjectArray")
    MemorySegment _NewObjectArray(JNIEnv env, int len, MemorySegment clazz, MemorySegment init);

    default Reference NewObjectArray(JNIEnv env, int len, MemorySegment clazz, MemorySegment init)
    {
        return this.reference(env, this._NewObjectArray(env, len, clazz, init));
    }

    @Redirect("j4p_jni_GetObjectArrayElement")
    MemorySegment _GetObjectArrayElement(JNIEnv env, MemorySegment array, int index);

    default Reference GetObjectArrayElement(JNIEnv env, MemorySegment array, int index)
    {
        return this.reference(env, this._GetObjectArrayElement(env, array, index));
    }

    @Unbound
    void SetObjectArrayElement(JNIEnv env, MemorySegment array, int index, MemorySegment val);

    @Redirect("j4p_jni_NewBooleanArray")
    MemorySegment _NewBooleanArray(JNIEnv env, int len);

    default Reference NewBooleanArray(JNIEnv env, int len)
    {
        return this.reference(env, this._NewBooleanArray(env, len));
    }

    @Redirect("j4p_jni_NewByteArray")
    MemorySegment _NewByteArray(JNIEnv env, int len);

    default Reference NewByteArray(JNIEnv env, int len)
    {
        return this.reference(env, this._NewByteArray(env, len));
    }

    @Redirect("j4p_jni_NewCharArray")
    MemorySegment _NewCharArray(JNIEnv env, int len);

    default Reference NewCharArray(JNIEnv env, int len)
    {
        return this.reference(env, this._NewCharArray(env, len));
    }

    @Redirect("j4p_jni_NewShortArray")
    MemorySegment _NewShortArray(JNIEnv env, int len);

    default Reference NewShortArray(JNIEnv env, int len)
    {
        return this.reference(env, this._NewShortArray(env, len));
    }

    @Redirect("j4p_jni_NewIntArray")
    MemorySegment _NewIntArray(JNIEnv env, int len);

    default Reference NewIntArray(JNIEnv env, int len)
    {
        return this.reference(env, this._NewIntArray(env, len));
    }

    @Redirect("j4p_jni_NewLongArray")
    MemorySegment _NewLongArray(JNIEnv env, int len);

    default Reference NewLongArray(JNIEnv env, int len)
    {
        return this.reference(env, this._NewLongArray(env, len));
    }

    @Redirect("j4p_jni_NewFloatArray")
    MemorySegment _NewFloatArray(JNIEnv env, int len);

    default Reference NewFloatArray(JNIEnv env, int len)
    {
        return this.reference(env, this._NewFloatArray(env, len));
    }

    @Redirect("j4p_jni_NewDoubleArray")
    MemorySegment _NewDoubleArray(JNIEnv env, int len);

    default Reference NewDoubleArray(JNIEnv env, int len)
    {
        return this.reference(env, this._NewDoubleArray(env, len));
    }

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

    @Redirect("j4p_jni_NewDirectByteBuffer")
    MemorySegment _NewDirectByteBuffer(JNIEnv env, MemorySegment address, long capacity);

    default Reference NewDirectByteBuffer(JNIEnv env, MemorySegment address, long capacity)
    {
        return this.reference(env, this._NewDirectByteBuffer(env, address, capacity));
    }

    @Unbound
    MemorySegment GetDirectBufferAddress(JNIEnv env, MemorySegment buf);

    @Unbound
    long GetDirectBufferCapacity(JNIEnv env, MemorySegment buf);

    @Unbound
    int GetObjectRefType(JNIEnv env, MemorySegment obj);

    @Redirect("j4p_jni_GetModule")
    MemorySegment _GetModule(JNIEnv env, MemorySegment clazz);

    default Reference GetModule(JNIEnv env, MemorySegment clazz)
    {
        return this.reference(env, this._GetModule(env, clazz));
    }

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
                JavaVM vm = new JavaVM(pVMs.getAtIndex(ADDRESS.withTargetLayout(JavaVM.LAYOUT), i));

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

                return new JNIEnv(pEnv.get(ADDRESS.withTargetLayout(JNIEnv.LAYOUT), 0));
            }

            throw new RuntimeException("No Java VM could be tied to the current thread.");
        }
    }

    default JNIEnv getCurrentJNIEnv(int version)
    {
        return this.getCurrentJNIEnv(1, version);
    }

    default Reference findClass(JNIEnv env, Class<?> clazz)
    {
        try (Arena arena = Arena.ofConfined())
        {
            if (clazz.getClassLoader() == null)
            {
                return this.FindClass(env, arena.allocateFrom(clazz.descriptorString()));
            }

            try (
                Reference threadClass = this.findClass(env, Thread.class);
                Reference currentThread = this.CallStaticObjectMethodA(
                    env, threadClass.value, this.getStaticMethodID(env, threadClass.value, "currentThread", methodType(Thread.class)), NULL
                );
                Reference classLoader = this.CallObjectMethodA(
                    env, currentThread.value, this.getMethodID(env, threadClass.value, "getContextClassLoader", methodType(ClassLoader.class)), NULL
                );
                Reference classClass = this.findClass(env, Class.class);
                Reference className = this.NewStringUTF(env, arena.allocateFrom(clazz.getName()))
            )
            {
                Buffer<JValue> args = JValue.allocate(arena, 3);
                args.get(0).l(className.value);
                args.get(1).z(false);
                args.get(2).l(classLoader.value);

                return this.CallStaticObjectMethodA(env, classClass.value, this.getStaticMethodID(
                    env, classClass.value, "forName", methodType(Class.class, String.class, boolean.class, ClassLoader.class)
                ), args.pointer());
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

    default Reference getNativeObject(JNIEnv env, Object object)
    {
        final class Container
        {
            static Object VALUE;
        }

        synchronized (Container.class)
        {
            Container.VALUE = object;
            try (Reference clazz = this.findClass(env, Container.class))
            {
                return this.GetStaticObjectField(env, clazz.value, this.getStaticFieldID(env, clazz.value, "VALUE", Object.class));
            }
        }
    }

    default Object getJavaObject(JNIEnv env, MemorySegment object)
    {
        final class Container
        {
            static Object VALUE;
        }

        synchronized (Container.class)
        {
            try (Reference clazz = this.findClass(env, Container.class))
            {
                this.SetStaticObjectField(env, clazz.value, this.getStaticFieldID(env, clazz.value, "VALUE", Object.class), object);
            }

            return Container.VALUE;
        }
    }
}
