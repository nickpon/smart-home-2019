package rc;

import ru.sbt.mipt.oop.SmartHome;

public class TurnAllLightsOffRC implements Command {
    public SmartHome smartHome;
    public TurnAllLightsOffRC(SmartHome smartHome){
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.setAllLightsTo(false);
    }
}