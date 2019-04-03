package tests;

import org.junit.Test;
import ru.sbt.mipt.oop.*;
import rc.*;
import static org.junit.Assert.*;

public class DangerRCTest {
    Alarm alarm = new Alarm(1234,1234);
    DangerAlertRC test = new DangerAlertRC(alarm);

    @Test
    public void execute() {
        test.execute();
        alarm.getState();
        assertTrue(alarm.getState() instanceof DangerSignalState);
        System.out.println("OK");
    }
}