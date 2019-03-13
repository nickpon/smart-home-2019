package ru.sbt.mipt.oop;

import java.util.Collection;

public class Room implements Actionable {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        this.doors = doors;
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    public Light getId(String objectId) {
        for (Light light : lights) {
            if (light.getId().equals(objectId)) {
                return light;
            }
        }
        return null;
    }

    @Override
    public void executeAction(Action action) {
        action.execute(this);
        lights.forEach(light -> light.executeAction(action));
        doors.forEach(door -> door.executeAction(action));
    }
}
