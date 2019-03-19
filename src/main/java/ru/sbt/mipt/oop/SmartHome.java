package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome implements Actionable{
    Collection<Room> rooms;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    private Alarm alarm = new Alarm(1234,1234);

    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public void executeAction(Action action){
        action.execute(this);
        rooms.forEach(c -> c.executeAction(action));
    }

    public void setAlarm(Alarm alarm){
        this.alarm = alarm;
    }
    public Alarm getAlarm(){
        return alarm;
    }
    public AlarmState getAlarmState(){
        return alarm.getState();
    }
}
