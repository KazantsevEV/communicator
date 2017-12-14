import QtQuick 2.6
import QtQuick.Controls 2.1

Item {
    width: 400
    height: 400

    property alias btnStart: btnStart

    Button {
        id: btnStart
        x: 162
        y: 180
        width: 76
        height: 40
        text: qsTr("Старт")
    }
}
