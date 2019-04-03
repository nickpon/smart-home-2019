package rc;

import ru.sbt.mipt.oop.*;

public abstract class ActivateAlarmRC implements InterfaceCommand{
    private SmartHome smartHome;
    private int password;

    public ActivateAlarmRC(SmartHome smartHome, int password) {
        this.smartHome = smartHome;
        this.password = password;
    }

    @Override
    public void execute() {
        smartHome.getAlarm().activate(password);
    }
}