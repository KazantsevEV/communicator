#include "voicerecognition.h"

#if defined(Q_OS_ANDROID)
#include <QAndroidJniObject>
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
    QAndroidJniObject activity = QtAndroid::androidActivity();
    jint height = activity.callMethod<jint>("Test");
    emit setText(QString::number((int) height));
#endif
}
