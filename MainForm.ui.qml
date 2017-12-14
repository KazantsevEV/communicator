import QtQuick 2.6
import QtQuick.Controls 2.1

Item {
    width: 400
    height: 400

    property alias btnStartRecognition: btnStartRecognition
    property alias textRecognition: textRecognition

    Button {
        id: btnStartRecognition
        x: 146
        y: 180
        width: 108
        height: 30
        text: qsTr("Начать запись")
    }

    Text {
        id: textRecognition
        x: 146
        y: 125
        width: 108
        height: 41
        font.pixelSize: 12
    }
}
