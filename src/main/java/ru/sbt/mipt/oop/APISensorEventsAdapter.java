package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;

import java.io.IOException;

public class APISensorEventsAdapter {
    private SensorEventsManager sensorEventsManager;
    private SmartHome smartHome;

    public APISensorEventsAdapter(SmartHome smartHome) {
        this.sensorEventsManager = new SensorEventsManager();
        this.smartHome = smartHome;
    }

    public void addEventProcessor(EventProcessor eventProcessor) {
        sensorEventsManager.registerEventHandler(new APIEventAdapter(smartHome,eventProcessor));
    }

    public void start() throws IOException {
        sensorEventsManager.start();
    }
}