#ifndef VOICERECOGNITION_H
#define VOICERECOGNITION_H

#include <QObject>

class VoiceRecognition : public QObject
{
    Q_OBJECT
public:
    VoiceRecognition(QObject *parent = nullptr);
public slots:
    void start();
signals:
    void setText(QString text);
};

#endif // VOICERECOGNITION_H
