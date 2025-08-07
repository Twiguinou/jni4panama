package fr.kenlek.j4p;

import java.lang.foreign.MemorySegment;

import static fr.kenlek.j4p.JObjectRefType.*;

public final class Reference implements AutoCloseable
{
    private final JavaNativeInterface m_jni;
    private final JNIEnv m_env;
    public final MemorySegment value;

    Reference(JavaNativeInterface jni, JNIEnv env, MemorySegment value)
    {
        this.m_jni = jni;
        this.m_env = env;
        this.value = value;
    }

    public int type()
    {
        return this.m_jni.GetObjectRefType(this.m_env, this.value);
    }

    @Override
    public void close()
    {
        switch (this.type())
        {
            case JNILocalRefType -> this.m_jni.DeleteLocalRef(this.m_env, this.value);
            case JNIGlobalRefType -> this.m_jni.DeleteGlobalRef(this.m_env, this.value);
            case JNIWeakGlobalRefType -> this.m_jni.DeleteWeakGlobalRef(this.m_env, this.value);
        }
    }
}
