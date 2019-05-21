package tests;

import org.junit.Test;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.EventProcessor;
import ru.sbt.mipt.oop.MainDoorEventProcessor;
import ru.sbt.mipt.oop.ToFileSmartHome;
import ru.sbt.mipt.oop.SmartHomeLoader;
import ru.sbt.mipt.oop.Light;
import java.io.IOException;
import static org.junit.Assert.assertFalse;


public class MainDoorEventProcessorTest {
    private EventProcessor mainDoorEventProcessor;
    private SmartHome smartHome;
    private SensorEvent event;


    @Test
    public void testDoorIsClosed() throws IOException {
        mainDoorEventProcessor = new MainDoorEventProcessor();
        SmartHomeLoader smartHomeLoader = new ToFileSmartHome();
        smartHome = smartHomeLoader.loadSmartHome();
        event = new SensorEvent(SensorEventType.DOOR_CLOSED, "3");

        mainDoorEventProcessor.processEvent(smartHome, event);
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                for (Door door : room.getDoors()) {
                    assertFalse(door.getIsOpen());
                }
            }
        }
        System.out.println("OK");
    }

    @Test
    public void testLightIsOff() throws IOException {
        mainDoorEventProcessor = new MainDoorEventProcessor();
        SmartHomeLoader smartHomeLoader = new ToFileSmartHome();
        smartHome = smartHomeLoader.loadSmartHome();
        event = new SensorEvent(SensorEventType.DOOR_CLOSED, "3");

        mainDoorEventProcessor.processEvent(smartHome, event);
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                for (Light light : room.getLights()) {
                    assertFalse(light.isOn());
                }
            }
        }
        System.out.println("OK");
    }
}