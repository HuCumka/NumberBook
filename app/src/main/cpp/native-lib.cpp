#include <jni.h>
#include <string>


extern "C" JNIEXPORT jobjectArray JNICALL
Java_com_dominigames_numberbook_MainActivity_contact_1name_1list(JNIEnv* env, jobject jobj) {
    jobjectArray ret;
    int i;

    char *message[3]= {"Денис",
                       "Сергей",
                       "Артем"};

    ret = (jobjectArray)env->NewObjectArray(3,
                                            env->FindClass("java/lang/String"),
                                            env->NewStringUTF(""));

    for(int i = 0; i < 3; i++) {
        env->SetObjectArrayElement(
                ret,i,env->NewStringUTF(message[i]));
    }
    return(ret);
}

extern "C"
JNIEXPORT jobjectArray JNICALL
Java_com_dominigames_numberbook_MainActivity_contact_1number_1list
        (JNIEnv *env, jobject jobj){

    jobjectArray ret;
    int i;

    char *message[3]= {"+79905523451",
                       "+79503412445",
                       "+79208567865"};

    ret = (jobjectArray)env->NewObjectArray(3,
                                           env->FindClass("java/lang/String"),
                                           env->NewStringUTF(""));

    for(i = 0; i < 3; i++) {
        env->SetObjectArrayElement(
                ret,i,env->NewStringUTF(message[i]));
    }
    return(ret);
}