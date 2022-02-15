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
        return "{\n\"name\":\"" + this->name + "\",\n\"number\":\"" + this->number + "\"\n}";
    }
};


std::vector<std::string> nameList = {"Денис",
                                     "Алексей",
                                     "Саня",
                                     "Сережа",
                                     "Макс",
                                     "Мама"};

std::vector<std::string> numberList = {"+79545234145",
                                       "+79204234327",
                                       "+79514654625",
                                       "+79097547789",
                                       "+79584647011",
                                       "+79616788332"};


static std::vector<Contact> createContactList()
{
    std::vector<Contact> contacts;
    for(int i = 0; i < nameList.size(); i++)
    {
        contacts.emplace_back(Contact(nameList[i], numberList[i]));
    }

    return contacts;
}



extern "C" JNIEXPORT jstring JNICALL
Java_com_dominigames_numberbook_MainActivity_contactListAsJSONString(JNIEnv* env, jobject jobj)
{
    std::string contactJSONString = "{\"contacts\":[\n";
    std::vector<Contact> contactList = createContactList();

    for(int i = 0; i < contactList.size(); i++)
    {
        contactJSONString += contactList[i].getContact() + ",\n\n";
    }


    contactJSONString = contactJSONString.substr(0, contactJSONString.size() - 3);

    contactJSONString += "\n]\n}";

    return env->NewStringUTF(contactJSONString.c_str());
}
