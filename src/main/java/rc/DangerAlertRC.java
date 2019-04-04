package rc;

import ru.sbt.mipt.oop.*;

public class DangerAlertRC implements Command {
    private Alarm alarm;

    public DangerAlertRC(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void execute() {
        alarm.danger();
    }
}