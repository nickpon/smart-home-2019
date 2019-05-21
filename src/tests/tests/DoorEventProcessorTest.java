package tests;

import org.junit.Test;
import ru.sbt.mipt.oop.*;
import java.io.IOException;
import static org.junit.Assert.*;


public class DoorEventProcessorTest {
    private static SmartHomeLoader smartHomeLoader = new ToFileSmartHome();
    private SmartHome smartHome = smartHomeLoader.loadSmartHome();
    private DoorEventProcessor doorEventProcessor;
    private SensorEventType sensoreventtype = SensorEventType.DOOR_OPEN;
    private String objectId = "1";
    private SensorEvent sensorEvent = new SensorEvent(sensoreventtype, objectId);

    public DoorEventProcessorTest() throws IOException {
    }

    private static Door findDoorByID(SmartHome smartHome, String Id ){
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(Id)) {
                    return door;
                }
            }
        }
        return null;
    }

    @Test
    public void processEventFirstTest() {
        doorEventProcessor = new DoorEventProcessor();
        doorEventProcessor.processEvent(smartHome, sensorEvent);
        Door door1 = findDoorByID(smartHome, "1");
        assertEquals(true, door1.getIsOpen());
        System.out.println("OK");
    }

    @Test
    public void notNull() {
        doorEventProcessor = new DoorEventProcessor();
        doorEventProcessor.processEvent(smartHome, sensorEvent);
        Door door3 = findDoorByID(smartHome, "0");
        assertNull(door3);
        System.out.println("OK");
    }
}