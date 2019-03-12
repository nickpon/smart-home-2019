package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class MainDoorEventAggregator implements EventAggregator {

    private void eventType(SensorEvent event) {
        if (event.getType() != DOOR_CLOSED) {
            return;
        }
    }

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {

        eventType(event);

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
