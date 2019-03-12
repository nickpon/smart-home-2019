package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightsEventProcessor implements EventProcessor {

    private void applicator(Light light, boolean boolLight, Room room, String strInfo) {
        light.setOn(boolLight);
        System.out.println("Light # " + light.getId());
        System.out.println("In the room " + room.getName());
        System.out.println(strInfo);
    }

    private boolean isLightEvent(SensorEvent event) {
        return event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF;
    }

    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isLightEvent(event)) return;
        for (Room room : smartHome.getRooms()) {
            Light light = room.getId(event.getObjectId());
            if (light == null) {
                continue;
            }
            if (event.getType() == LIGHT_ON) {
                applicator(light, true, room, "Was on at that period of time");
            } else {
                applicator(light, false, room, "Was off at that period of time");
            }
        }
    }
}
