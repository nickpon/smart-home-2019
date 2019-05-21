package rc;

import ru.sbt.mipt.oop.EntranceDoorFinder;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.SmartHome;

public class CloseEntranceDoor implements Command {
    private final Door entranceDoor;

    public CloseEntranceDoor(Door entranceDoor){
        this.entranceDoor = entranceDoor;
    }

    @Override
    public void execute() {
        entranceDoor.setOpen(false);
    }
}