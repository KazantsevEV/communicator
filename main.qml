import QtQuick 2.6
import QtQuick.Window 2.2
import QtQuick.Controls 2.1

Window {
    visible: true
    width: 640
    height: 480
    title: qsTr("Hello World")

    Connections {
        target: recognition

        onSetText: {
            mainForm.textRecognition.text = text;
        }
    }

    MainForm {
        id: mainForm
        anchors.fill: parent
        btnStartRecognition.onClicked: {
            recognition.start();
        }

    }
}
