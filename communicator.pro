TEMPLATE = app

QT += qml quick
CONFIG += c++11

SOURCES += main.cpp \
    voicerecognition.cpp

HEADERS += \
    voicerecognition.h

RESOURCES += qml.qrc

android {
    QT += androidextras
    DISTFILES += \
    Android/src/com/example/myPackage/SpeechRecognition.java

    ANDROID_PACKAGE_SOURCE_DIR = $$PWD/Android
}

qnx: target.path = /tmp/$${TARGET}/bin
else: unix:!android: target.path = /opt/$${TARGET}/bin
!isEmpty(target.path): INSTALLS += target

DISTFILES += \
    android/AndroidManifest.xml \
    android/res/values/libs.xml \
    android/build.gradle

ANDROID_PACKAGE_SOURCE_DIR = $$PWD/android
