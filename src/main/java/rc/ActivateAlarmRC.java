package rc;

import ru.sbt.mipt.oop.*;

public class ActivateAlarmRC implements Command {
    private Alarm alarm;
    private int password;

    public ActivateAlarmRC(Alarm alarm, int password) {
        this.alarm = alarm;
        this.password = password;
    }

    @Override
    public void execute() {
        alarm.activate(password);
    }
}