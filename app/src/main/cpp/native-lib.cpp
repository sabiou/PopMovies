//
// Created by farouk on 12/06/20.
//
#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_com_package_name_Keys_apiKey(JNIEnv *env, jobject object) {
    std::string api_key = "03ac1bb2cf9b74661d41fbca8087307b";
    return env->NewStringUTF(api_key.c_str());
}

