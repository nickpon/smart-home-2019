package tests;

import org.junit.Test;
import rc.*;
import ru.sbt.mipt.oop.*;
import java.io.IOException;
import static org.junit.Assert.*;

public class LightRCOffTest {
    public static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    SmartHome smartHome;

    public LightRCOffTest() throws IOException {
        smartHome = smartHomeLoader.loadSmartHome();
    }

    @Test
    public void execute() {
        TurnAllLightsOffRC ligthsoffCommand = new TurnAllLightsOffRC(smartHome);
        ligthsoffCommand.execute();
        Boolean AreAllLightsOff = (Boolean) LightHelper.AreAllLightsOff(smartHome);
        assertEquals(false,AreAllLightsOff);
        System.out.println("OK");

    }
}