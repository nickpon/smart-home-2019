package ru.sbt.mipt.oop;


public class ActivatedState implements AlarmState {
    @Override
    public AlarmState activate(int code, int password) {

        System.out.println("Alarm has already activated");

        return this;
    }

    @Override
    public AlarmState deactivate(int code, int password) {
        if (code == password) {

            System.out.println("Alarm is deactivated");

            return new DeactivatedState();
        } else {
            return danger();
        }
    }

    @Override
    public AlarmState danger() {
        System.out.println("Alarm is in danger!!!");
        return new DangerSignalState();
    }
}