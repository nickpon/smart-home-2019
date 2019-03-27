package com.coolcompany.smarthome.events;

import java.io.IOException;

public interface EventHandler {

    void handleEvent(CCSensorEvent event) throws IOException;

}
