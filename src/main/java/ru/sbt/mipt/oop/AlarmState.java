package ru.sbt.mipt.oop;


public interface AlarmState {

    AlarmState activate(int Code, int password);
    AlarmState deactivate(int Code, int password);
    default boolean activated(){
        return false;
    }
    AlarmState danger();
}