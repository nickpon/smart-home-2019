package rc;

import ru.sbt.mipt.oop.*;

public class TurnOffInHallLightsRC implements InterfaceCommand {
    public SmartHome smartHome;
    public TurnOffInHallLightsRC(SmartHome smartHome){
        this.smartHome = smartHome;
    }

    private void LightFinder(Room room) {
        if (room.getName().equals("hall")){
            for (Light light: room.getLights()){
                light.setOn(false);
            }

        }
    }

    @Override
    public void execute() {
        for(Room room: smartHome.getRooms()){
            LightFinder(room);
        }
    }
}