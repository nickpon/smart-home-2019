package com.coolcompany.smarthome.sample;

import com.coolcompany.smarthome.events.SensorEventsManager;

import java.io.IOException;

public class Sample {

    public static void main(String[] args) throws IOException {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(event -> {
            System.out.println("Event type [" + event.getEventType() + "] from object with id=" + event.getObjectId() + "]");
        });
        sensorEventsManager.start();
    }
}
