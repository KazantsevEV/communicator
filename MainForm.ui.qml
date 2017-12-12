import QtQuick 2.6
import QtQuick.Controls 2.1

Item {
    width: 400
    height: 400

    property alias btnStart: btnStart

    Button {
        id: btnStart
        x: 260
        y: 105
        width: 76
        height: 40
        text: qsTr("Старт")
    }
}
