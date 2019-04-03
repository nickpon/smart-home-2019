package rc;

import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.SmartHome;

public class CloseEntranceDoor implements InterfaceCommand {
    public SmartHome smartHome;

    public CloseEntranceDoor(SmartHome smartHome){
        this.smartHome = smartHome;
    }

    @Override
    public void execute() {
        for (Room room: smartHome.getRooms()){
            if (room.getName().equals("hall")){
                for(Door door: room.getDoors()){
                    door.setOpen(false);
                }
            }
        }
    }
}