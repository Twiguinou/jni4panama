#include <jawt.h>
#include "j4p_def.h"

#define J4P_AWT_WRAPPER_VOID(x) JNIEXPORT jobject j4p_awt_##x(JAWT* jawt, JNIEnv* env)
#define J4P_AWT_WRAPPER(x, ...) JNIEXPORT jobject j4p_awt_##x(JAWT* jawt, JNIEnv* env, __VA_ARGS__)
#define J4P_AWT_WRAP_VOID(x) globalReference(env, jawt->x(env))
#define J4P_AWT_WRAP(x, ...) globalReference(env, jawt->x(env, __VA_ARGS__))

J4P_AWT_WRAPPER(GetComponent, void* platformInfo)
{
    return J4P_AWT_WRAP(GetComponent, platformInfo);
}

J4P_AWT_WRAPPER(CreateEmbeddedFrame, void* platformInfo)
{
    return J4P_AWT_WRAP(CreateEmbeddedFrame, platformInfo);
}
