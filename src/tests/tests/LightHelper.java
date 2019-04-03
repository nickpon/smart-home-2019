package tests;
import ru.sbt.mipt.oop.*;

import static org.junit.Assert.assertEquals;

public class LightHelper {
    private static Light FindLight(SmartHome smartHome, String Id ){
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(Id))
                    return light;
            }
        }
        return null;
    }

    public static Boolean AreAllLightsOff(SmartHome smartHome) {
        return (
                FindLight(smartHome,"1").isOn() &&

                FindLight(smartHome,"2").isOn() &&

                FindLight(smartHome,"3").isOn() &&

                FindLight(smartHome,"4").isOn() &&

                FindLight(smartHome,"5").isOn() &&

                FindLight(smartHome,"6").isOn() &&

                FindLight(smartHome,"7").isOn() &&

                FindLight(smartHome,"8").isOn() &&

                FindLight(smartHome,"9").isOn()
        );
    }

    public static void AreAllLightsHallOK(SmartHome smartHome) {
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                for (Light light : room.getLights()) {
                    assertEquals(false, light.isOn());
                }
            }
        }
    }
}