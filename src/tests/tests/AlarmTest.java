package tests;

import org.junit.Test;
import ru.sbt.mipt.oop.*;
import static org.junit.Assert.*;


public class AlarmTest {
    Alarm alarm = new Alarm(1234,21);

    @Test
    public void getIdTest() {
        assertEquals(21, alarm.getId());
        System.out.println("OK");
    }

    @Test
    public void activateAlarmTest() {
        alarm.activate(1234);
        assertTrue(alarm.getState() instanceof ActivatedState);
        System.out.println("OK");
    }

    @Test
    public void deactivateAlarmTest() {
        alarm.deactivate(1234);
        assertTrue(alarm.getState() instanceof DeactivatedState);
        System.out.println("OK");
    }
}