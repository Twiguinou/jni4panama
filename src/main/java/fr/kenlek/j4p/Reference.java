package fr.kenlek.j4p;

import java.lang.foreign.MemorySegment;

import static java.lang.foreign.MemorySegment.NULL;

import static fr.kenlek.j4p.JObjectRefType.*;

public final class Reference implements AutoCloseable
{
    private final JavaNativeInterface m_jni;
    private final JNIEnv m_env;
    public final MemorySegment value;
    public final int type;

    Reference(JavaNativeInterface jni, JNIEnv env, MemorySegment value, int type)
    {
        this.value = switch (type)
        {
            case JNILocalRefType -> jni.NewLocalRef(env, value);
            case JNIGlobalRefType -> jni.NewGlobalRef(env, value);
            case JNIWeakGlobalRefType -> jni.NewWeakGlobalRef(env, value);
            default -> throw new IllegalArgumentException("Invalid reference type: " + type);
        };
        if (this.value.equals(NULL))
        {
            throw new RuntimeException("Unable to create global reference.");
        }

        this.m_jni = jni;
        this.m_env = env;
        this.type = type;
    }

    @Override
    public void close()
    {
        switch (this.type)
        {
            case JNILocalRefType -> this.m_jni.DeleteLocalRef(this.m_env, this.value);
            case JNIGlobalRefType -> this.m_jni.DeleteGlobalRef(this.m_env, this.value);
            case JNIWeakGlobalRefType -> this.m_jni.DeleteWeakGlobalRef(this.m_env, this.value);
        }
    }
}
