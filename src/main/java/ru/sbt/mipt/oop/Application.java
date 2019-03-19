package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Application {

    private static SmartHomeLoader smartHomeLoader = new ToFileSmartHome();

    public static void main(String... args) throws IOException {
        SmartHome smartHome = smartHomeLoader.loadSmartHome();

        goThroughLoops(smartHome);
    }

    private static void goThroughLoops(SmartHome smartHome) {
        EventGetter RandomSensorEventProvider = new RandomSensorEventProvider();
        SensorEvent nextEvent = RandomSensorEventProvider.getNextSensorEvent();
        Collection<EventProcessor> eventProcessors = configureEventProcessors();

        while (nextEvent != null) {
            System.out.println("Event: " + nextEvent);
            for (EventProcessor eventProcessor : eventProcessors) {
                eventProcessor.processEvent(smartHome, nextEvent);
            }
            nextEvent = RandomSensorEventProvider.getNextSensorEvent();
        }
    }

    public static void setSmartHomeLoader(SmartHomeLoader smartHomeLoader) {
        Application.smartHomeLoader = smartHomeLoader;
    }

    private static Collection<EventProcessor> configureEventProcessors() {
        Collection<EventProcessor> eventProcessors = new ArrayList<>();
        modifyAggregators(eventProcessors);
        return eventProcessors;
    }

    private static void modifyAggregators(Collection<EventProcessor> eventProcessors) {
        eventProcessors.add(new LightsEventProcessor());
        eventProcessors.add(new DoorEventProcessor());
        eventProcessors.add(new MainDoorEventProcessor());
    }

}
