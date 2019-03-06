package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Application {

    private static SmartHomeApplication smartHomeApplication = new ToFileSmartHome();

    public static void main(String... args) throws IOException {
        SmartHome smartHome = smartHomeApplication.loadSmartHome();

        goThroughLoops(smartHome);
    }

    private static void goThroughLoops(SmartHome smartHome) {
        SensorEvent nextEvent = RandomSensorEventProvider.getNextEvent();
        Collection<EventAggregator> eventAggregators = configureEventProcessors();
        makeLoops(nextEvent, eventAggregators, smartHome);
    }

    private static void makeLoops (SensorEvent nextEvent, Collection<EventAggregator> eventAggregators,
                                   SmartHome smartHome) {
        while (nextEvent != null) {
            System.out.println("Event: " + nextEvent);
            for (EventAggregator eventAggregator : eventAggregators) {
                eventAggregator.processEvent(smartHome, nextEvent);
            }
            nextEvent = RandomSensorEventProvider.getNextEvent();
        }
    }

    public static void setSmartHomeApplication(SmartHomeApplication smartHomeApplication) {
        Application.smartHomeApplication = smartHomeApplication;
    }

    private static Collection<EventAggregator> configureEventProcessors() {
        Collection<EventAggregator> eventAggregators = new ArrayList<>();
        modifyAggregators(eventAggregators);
        return eventAggregators;
    }

    private static void modifyAggregators(Collection<EventAggregator> eventAggregators) {
        eventAggregators.add(new LightsEventAggregator());
        eventAggregators.add(new DoorEventAggregator());
        eventAggregators.add(new MainDoorEventAggregator());
    }

}
