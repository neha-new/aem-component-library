package com.adobe.aem.guides.wknd.core.eventHandler;

import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.jcr.api.SlingRepository;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.observation.EventListener;
import javax.jcr.observation.ObservationManager;

@Component(service = EventListener
        .class, immediate = true)
public class PracticeEventListener implements EventListener {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Reference
    private SlingRepository repository;

    @Reference
    ResourceResolverFactory resolverFactory;

    private ObservationManager observationManager;

    private final String[] nodeTypes = new String[]{"nt:unstructured", "nt:folder", "cq:PageContent", "cq:Page"};

    protected void activate(ComponentContext context) throws Exception {
        Session session = repository.login(new SimpleCredentials("admin", "admin".toCharArray()));
        session.getWorkspace().getObservationManager().addEventListener(this, Event.PROPERTY_ADDED | Event.NODE_ADDED,
                "/content/practice", true, null, null, false);
        log.info(">>>>>>>>>>>> Property added or changed");
    }

    protected void deactivate(ComponentContext componentContext) {
        try {
            if (observationManager != null) {
                observationManager.removeEventListener(this);
                log.info(">>>>>>>>>> Remove Listener");
            }
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onEvent(EventIterator eventIterator) {
        while (eventIterator.hasNext()) {
            try {
                log.info(">>>>>>>>> onEvent Path = '{}'", eventIterator.nextEvent().getPath());
            } catch (RepositoryException e) {
                log.info("RepositoryException", e);
            }
        }

    }

}
