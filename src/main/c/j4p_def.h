#ifndef _J4P_DEF_H_
#define _J4P_DEF_H_

#include <jni.h>

static inline jobject globalReference(JNIEnv* env, jobject localReference)
{
    jobject globalReference = (*env)->NewGlobalRef(env, localReference);
    (*env)->DeleteLocalRef(env, localReference);
    return globalReference;
}

#endif _J4P_DEF_H_
