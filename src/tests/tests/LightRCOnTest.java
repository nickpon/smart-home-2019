package tests;

import org.junit.Test;
import ru.sbt.mipt.oop.*;
import java.io.IOException;
import static org.junit.Assert.*;
import rc.*;

public class LightRCOnTest {
    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    SmartHome smartHome;

    public LightRCOnTest() throws IOException {
        smartHome = smartHomeLoader.loadSmartHome();
    }

    @Test
    public void execute() {
        TurnAllLightsOnRC ligthsOnCommand = new TurnAllLightsOnRC(smartHome);
        ligthsOnCommand.execute();
        Boolean isAllLightsOn = (Boolean) tests.LightHelper.AreAllLightsOff(smartHome);
        assertEquals(true, isAllLightsOn);
        System.out.println("OK");
    }
}