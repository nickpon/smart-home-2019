package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

public class LightsEventProcessor implements EventProcessor {

    private void applicator(Light light, boolean boolLight, String strInfo) {
        light.setOn(boolLight);
        System.out.println("Light # " + light.getId());
        System.out.println(strInfo);
    }

    private boolean isLightEvent(SensorEvent event) {
        return event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF;
    }

    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isLightEvent(event)) return;
        /*for (Room room : smartHome.getRooms()) {
            Light light = room.getId(event.getObjectId());
            if (light == null) {
                continue;
            }
            if (event.getType() == LIGHT_ON) {
                applicator(light, true, "Was on at that period of time");
            } else {
                applicator(light, false, "Was off at that period of time");
            }
        }*/

        smartHome.executeAction(object -> {
                    if (object instanceof Light) {
                        Light light = (Light) object;
                        if (light.getId().equals(event.getObjectId())) {
                            if (event.getType() == LIGHT_ON) {
                                applicator(light, true, "Was on at that period of time");
                            } else {
                                applicator(light, false, "Was off at that period of time");
                            }
                        }
                    }
                }
        );

    }
}
