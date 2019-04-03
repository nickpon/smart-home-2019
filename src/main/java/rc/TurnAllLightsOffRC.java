package rc;

import ru.sbt.mipt.oop.SmartHome;

public class TurnAllLightsOffRC implements InterfaceCommand {
    public SmartHome smartHome;
    public TurnAllLightsOffRC(SmartHome smartHome){
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.turnAllLightsOnOrOff(false);
    }
}