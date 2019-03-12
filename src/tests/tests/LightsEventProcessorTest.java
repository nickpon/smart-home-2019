package tests;

import org.junit.Test;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.LightsEventProcessor;
import ru.sbt.mipt.oop.ToFileSmartHome;
import ru.sbt.mipt.oop.SmartHomeLoader;
import java.io.IOException;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LightsEventProcessorTest {
    private EventProcessor lightEventProcessor;
    private static SmartHomeLoader smartHomeLoader;
    private SmartHome smartHome;
    private SensorEvent event;

    @Test
    public void testIsLightOn() throws IOException {
        lightEventProcessor = new LightsEventProcessor();
        smartHomeLoader = new ToFileSmartHome();
        smartHome = smartHomeLoader.loadSmartHome();
        event = new SensorEvent(SensorEventType.LIGHT_ON, "1");
        lightEventProcessor.processEvent(smartHome, event);
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals("1")) {
                    assertTrue(light.isOn());
                }
            }
        }
        System.out.println("OK");
    }

    @Test
    public void testIsLightOff() throws IOException {
        lightEventProcessor = new LightsEventProcessor();
        smartHomeLoader = new ToFileSmartHome();
        smartHome = smartHomeLoader.loadSmartHome();
        event = new SensorEvent(SensorEventType.LIGHT_OFF, "1");
        lightEventProcessor.processEvent(smartHome, event);
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals("1")) {
                    assertFalse(light.isOn());
                }
            }
        }
        System.out.println("OK");
    }
}