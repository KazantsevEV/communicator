import QtQuick 2.6
import QtQuick.Window 2.2

Window {
    visible: true
    width: 640
    height: 480
    title: qsTr("Hello World")
    Connections {
        target: recognition
        onSetText: {
            labelResult.text = labelResult.text + text
        }
    }

    MainForm {
        anchors.fill: parent
        Text {
            id: labelResult
            anchors.left: parent.left
            anchors.right: parent.right
            anchors.top: parent.top
            height: 500
        }
        btnStart.width: 300
        btnStart.height: 100
        btnStart.onClicked: {
            recognition.start()
        }

    }
}
