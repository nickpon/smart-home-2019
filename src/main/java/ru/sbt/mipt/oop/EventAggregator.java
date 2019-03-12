package ru.sbt.mipt.oop;

public interface EventAggregator {

    void processEvent(SmartHome smartHome, SensorEvent event);

}
