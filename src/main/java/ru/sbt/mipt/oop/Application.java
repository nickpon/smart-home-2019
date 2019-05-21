package ru.sbt.mipt.oop;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    private static final Logger logger = LogManager.getLogger(Application.class);
    public static void main(String... args) throws IOException {
        logger.info("Starting configuration");
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigSpring.class);
        SmartHomeLoader smartHomeLoader = context.getBean(SmartHomeLoader.class);
        SmartHome smarthome = smartHomeLoader.loadSmartHome();
        startEvents(smarthome);
    }

    private static void startEvents(SmartHome smartHome)  throws IOException {
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