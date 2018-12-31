package com.vivid.partnerships.interview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class EventController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    private final EventService eventService;

    @Autowired
    public EventController(final EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public List<Event> getEvents() {
        List<Event> events = eventService.getEvents();
        LOGGER.info("Returning {} events", events.size());
        return events;
    }

    @GetMapping("/insertEvent")
    public boolean insertEvent() {
        Venue venue = new Venue();
        venue.name = "RED BULL STADIUM";
        venue.city = "New York";
        venue.state = "NY";

        Event event = new Event();
        event.name = "MSI International";
        event.date = new Date();
        event.venue = venue;

        return eventService.insertEvent(event) > 0;
    }
}
