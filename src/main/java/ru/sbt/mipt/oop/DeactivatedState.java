package ru.sbt.mipt.oop;


public class DeactivatedState implements AlarmState {

    @Override
    public AlarmState activate(int code, int password) {
        if (code == password) {
            System.out.println("Alarm was activated");
            return new ActivatedState();
        } else {
            return danger();
        }
    }

    @Override
    public AlarmState deactivate(int code, int password) {
        System.out.println("Alarm have already deactivated");
        return this;
    }

    @Override
    public AlarmState danger() {
        System.out.println("Alarm is in danger state");
        return new DangerSignalState();
    }
}