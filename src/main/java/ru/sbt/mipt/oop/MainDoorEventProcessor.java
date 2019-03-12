package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class MainDoorEventProcessor implements EventProcessor {

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {

        if (event.getType() != DOOR_CLOSED) return;

        for (Room mainRoom : smartHome.getRooms()) {
            for (Door mainDoor : mainRoom.getDoors()) {
                if (mainDoor.getId().equals(event.getObjectId())) {
                    if (mainRoom.getName().equals("main")) {
                        smartHome.lightTurnOff();
                    }
                }
            }
        }
    }
}
