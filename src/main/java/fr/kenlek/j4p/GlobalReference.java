package fr.kenlek.j4p;

import java.lang.foreign.MemorySegment;

import static java.lang.foreign.MemorySegment.NULL;

public final class GlobalReference implements AutoCloseable
{
    private final JavaNativeInterface m_jni;
    private final JNIEnv m_env;
    public final MemorySegment value;

    public GlobalReference(JavaNativeInterface jni, JNIEnv env, MemorySegment value)
    {
        this.value = jni.NewGlobalRef(env, value);
        if (this.value.equals(NULL))
        {
            throw new RuntimeException("Unable to create global reference.");
        }

        this.m_jni = jni;
        this.m_env = env;
    }

    @Override
    public void close()
    {
        this.m_jni.DeleteGlobalRef(this.m_env, this.value);
    }

    @Override
    public String toString()
    {
        return "GlobalReference[m_env=%s, value=%s]".formatted(this.m_env, this.value);
    }
}
