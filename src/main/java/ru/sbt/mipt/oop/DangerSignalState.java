package ru.sbt.mipt.oop;


public class DangerSignalState implements AlarmState {

    public DangerSignalState() {
        System.out.println("Sending sms");
    }

    @Override
    public AlarmState activate(int code, int password) {
        System.out.println("Alarm is in danger state");
        return this;
    }

    @Override
    public AlarmState deactivate(int code, int password) {
        if (code == password) {
            System.out.println("Alarm was deactivated");
            return new DeactivatedState();
        } else {
            return danger();
        }
    }

    @Override
    public AlarmState danger() {
        System.out.println("Alarm is in danger state");
        return this;
    }
}