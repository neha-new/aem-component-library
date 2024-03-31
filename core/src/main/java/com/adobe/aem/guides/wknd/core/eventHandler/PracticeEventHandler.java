package com.adobe.aem.guides.wknd.core.eventHandler;

import org.apache.sling.api.SlingConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = EventHandler.class,
immediate = true,
property = { EventConstants.EVENT_TOPIC + "=org/apache/sling/api/resource/Resource/ADDED",})
public class PracticeEventHandler implements EventHandler {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Override
    public void handleEvent(Event event){
        log.info("Event Topic = {}, Path = {}",event.getTopic(),event.getProperty(SlingConstants.PROPERTY_PATH));
    }
}
