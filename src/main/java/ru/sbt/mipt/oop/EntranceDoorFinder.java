package ru.sbt.mipt.oop;

public class EntranceDoorFinder {

    private static class DoorFinderAction implements Action {

        private Door entranceDoor;

        public Door getEntranceDoor() {
            return entranceDoor;
        }

        @Override
        public void execute(Object obj) {
            if (obj instanceof Room) {
                Room room = (Room) obj;
                if (room.getName().equals("hall")) {
                    for (Door door : room.getDoors()) {
                        entranceDoor = door;
                    }
                }
            }
        }
    }

    public Door findEntranceDoor(SmartHome smartHome) {
        DoorFinderAction doorFinderAction = new DoorFinderAction();
        smartHome.executeAction(doorFinderAction);
        return doorFinderAction.getEntranceDoor();
    }
}
