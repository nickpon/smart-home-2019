package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;

import java.io.IOException;
import java.util.*;

public class APIEventAdapter implements EventHandler {
    private EventProcessor eventProcessor;
    private SmartHome smartHome;
    private static Map<String,SensorEventType> eventSet = new HashMap<>();
    public APIEventAdapter(SmartHome smartHome, EventProcessor eventProcessor){
        this.eventProcessor = eventProcessor;
        this.smartHome = smartHome;

        eventSet.put("Alarm is currently activated", SensorEventType.ALARM_ACTIVATE);
        eventSet.put("Alarm is currently deactivated",SensorEventType.ALARM_DEACTIVATE);

        eventSet.put("Light is currently turned on",SensorEventType.LIGHT_ON);
        eventSet.put("Light is currently turned off",SensorEventType.LIGHT_OFF);

        eventSet.put("Door is currently opened",SensorEventType.DOOR_OPEN);
        eventSet.put("Door is currently closed", SensorEventType.DOOR_CLOSED);

    }
    @Override
    public void handleEvent(CCSensorEvent event) throws IOException {
        SensorEvent sensorEvent = new SensorEvent(eventSet.get(event.getEventType()),event.getObjectId());
        eventProcessor.processEvent(smartHome,sensorEvent);
    }
}