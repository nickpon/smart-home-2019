package tests;

import org.junit.Test;
import ru.sbt.mipt.oop.*;
import java.io.IOException;
import static org.junit.Assert.*;
import rc.*;

public class LightHallRCTest {
    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    SmartHome smartHome;

    public LightHallRCTest() throws IOException {
        smartHome = smartHomeLoader.loadSmartHome();
    }

    @Test
    public void execute() {
        TurnOffInHallLightsRC ligthsOnCommand = new TurnOffInHallLightsRC(smartHome);
        ligthsOnCommand.execute();
        tests.LightHelper.AreAllLightsHallOK(smartHome);
        System.out.println("OK");
    }
}