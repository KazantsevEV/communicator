#ifndef VOICERECOGNITION_H
#define VOICERECOGNITION_H

#include <QObject>
#if defined(Q_OS_ANDROID)
#include <QAndroidActivityResultReceiver>


class VoiceRecognition;

class AndroidActivityResultReceiver : public QAndroidActivityResultReceiver
{
    VoiceRecognition *m_parent;
public:
    AndroidActivityResultReceiver(VoiceRecognition *parent)
        : m_parent(parent)
    {
    }
private:
    void handleActivityResult(int receiverRequestCode, int resultCode, const QAndroidJniObject &data);
};
#endif
class VoiceRecognition : public QObject
{
    Q_OBJECT
    #if defined(Q_OS_ANDROID)
    AndroidActivityResultReceiver *m_result = nullptr;
    #endif
public:
    VoiceRecognition(QObject *parent = nullptr);
public slots:
    void start();
signals:
    void setText(QString text);
};

#endif // VOICERECOGNITION_H
