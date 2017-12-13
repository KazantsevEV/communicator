#include "voicerecognition.h"

#if defined(Q_OS_ANDROID)
#include <QtAndroidExtras>
#include <QtAndroid>
#endif

VoiceRecognition::VoiceRecognition(QObject *parent)
    :QObject(parent)
{

}

void VoiceRecognition::start()
{
#if defined (Q_OS_ANDROID)
    //QAndroidJniObject activity = QtAndroid::androidActivity();
    //jint height = activity.callMethod<jint>("Test");
    //emit setText(QString::number((int) height));

    if(m_result)
        delete m_result;

    m_result = new AndroidActivityResultReceiver(this);

    QAndroidJniObject intent = QAndroidJniObject::callStaticObjectMethod(
                    "com/example/myPackage/SpeechRecognition",
                    "createRecognitionIntent",
                    "()Landroid/content/Intent;");

    QtAndroid::startActivity(intent, 1, m_result);
#endif
}

void AndroidActivityResultReceiver::handleActivityResult(int receiverRequestCode, int resultCode, const QAndroidJniObject &data)
{
    if(data.isValid()) {
        if(resultCode == -1) {

        }
        jint size = data.callMethod<jint>("size");
        qDebug()<<"receiverRequestCode"<<receiverRequestCode<<"resultCode"<<resultCode;
        m_parent->setText(QString::number((int) size));
    }
}
