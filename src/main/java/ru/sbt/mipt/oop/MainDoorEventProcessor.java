package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

public class MainDoorEventProcessor implements EventProcessor {

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {

        if (event.getType() != DOOR_CLOSED) return;

        for (Room mainRoom : smartHome.getRooms()) {
            for (Door mainDoor : mainRoom.getDoors()) {
                if (mainDoor.getId().equals(event.getObjectId())) {
                    if (mainRoom.getName().equals("hall")) {
                        for (Room room : smartHome.getRooms()) {
                            for (Light light : room.getLights()) {
                                light.setOn(false);
                                SensorCommand sensorCommand = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                                System.out.println("Sending " + sensorCommand);
                            }
                        }
                    }
                }
            }
        }
    }
}
