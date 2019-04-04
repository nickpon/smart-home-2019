package rc;

import ru.sbt.mipt.oop.SmartHome;

public class TurnAllLightsOnRC implements Command {
    public SmartHome smartHome;
    public TurnAllLightsOnRC(SmartHome smartHome){
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        smartHome.setAllLightsTo(true);
    }
}