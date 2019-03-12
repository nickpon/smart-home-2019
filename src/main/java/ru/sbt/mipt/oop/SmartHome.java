package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome {
    Collection<Room> rooms;

    public void lightTurnOff() {
        for (Room room : getRooms()) {
            for (Light light : room.getLights()) {
                light.setOn(false);
                SensorCommand sensorCommand = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                System.out.println("Sending " + sensorCommand);
            }
        }
    }

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public Collection<Room> getRooms() {
        return rooms;
    }
}
