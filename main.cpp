#include <QGuiApplication>
#include <QQmlApplicationEngine>
#include "voicerecognition.h"
#include <QQmlContext>

int main(int argc, char *argv[])
{
    QGuiApplication app(argc, argv);
    QQmlApplicationEngine engine;
    VoiceRecognition recognition;
    QQmlContext *context = engine.rootContext();
    context->setContextProperty("recognition", &recognition);


    engine.load(QUrl(QStringLiteral("qrc:/main.qml")));
    if (engine.rootObjects().isEmpty())
        return -1;

    return app.exec();
}
