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
    Android/AndroidManifest.xml \
    Android/gradle/wrapper/gradle-wrapper.jar \
    Android/gradlew \
    Android/res/values/libs.xml \
    Android/build.gradle \
    Android/gradle/wrapper/gradle-wrapper.properties \
    Android/gradlew.bat

    ANDROID_PACKAGE_SOURCE_DIR = $$PWD/Android
}

qnx: target.path = /tmp/$${TARGET}/bin
else: unix:!android: target.path = /opt/$${TARGET}/bin
!isEmpty(target.path): INSTALLS += target

DISTFILES += \
    Android/src/com/example/myPackage/StatusBarActivity.java
