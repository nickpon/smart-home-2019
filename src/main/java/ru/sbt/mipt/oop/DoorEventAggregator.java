package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;

public class DoorEventAggregator implements EventAggregator {

    private void changeDoorState(Room room, boolean opened, Door door, String previousState) {
        door.setOpen(opened);
        System.out.println("The door # " + door.getId());
        System.out.println("In the room " + room.getName());
        System.out.println(previousState);
    }

    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!(event.getType() == DOOR_OPEN ) ||
                (event.getType() == DOOR_CLOSED)) {
            return;
        }

        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        changeDoorState(room, true, door, "Was opened at that period of time");
                    } else {
                        changeDoorState(room, false, door, "Was closed at that period of time");
                    }
                }
            }
        }
    }
}
