#include <jni.h>
#include <string>
#include <vector>

class Contact
{
    std::string name;
    std::string number;

public:

    Contact(std::string &name, std::string &number)
    {
        this->name = name;
        this->number = number;
    }

    std::string getContact()
    {
        return "{\n\"name\": \"" + this->name + "\",\n\"number\": \"" + this->number + "\",\n}";
    }
};


std::vector<std::string> nameList = {"Денис",
                                     "Алексей",
                                     "Саня",
                                     "Сережа",
                                     "Макс",
                                     "Мама"};

std::vector<std::string> numberList = {"+79545234145",
                                       "+79204234327"
                                       "+79514654625"
                                       "+79097547789",
                                       "+79584647011"
                                       "+79616788332"};

std::vector<Contact> contactList()
{
    std::vector<Contact> contacts;
    for(int i = 0; i < nameList.size(); i++)
    {
        contacts.push_back(Contact(nameList[i], numberList[i]));
    }

    return contacts;
}


extern "C" JNIEXPORT jobjectArray JNICALL
Java_com_dominigames_numberbook_MainActivity_contact_1name_1list(JNIEnv* env, jobject jobj) {
    jobjectArray ret;

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

    char *message[3]= {"+79905523451",
                       "+79503412445",
                       "+79208567865"};

    ret = (jobjectArray)env->NewObjectArray(3,
                                           env->FindClass("java/lang/String"),
                                           env->NewStringUTF(""));

    for(int i = 0; i < 3; i++) {
        env->SetObjectArrayElement(
                ret,i,env->NewStringUTF(message[i]));
    }
    return(ret);
}
