package com.vivid.partnerships.interview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = {"*"})
    @GetMapping("/events")
    public List<Event> getEvents() {
        List<Event> events = eventService.getEvents();
        LOGGER.info("Returning {} events", events.size());
        return events;
    }

    @CrossOrigin(origins = {"*"})
    @PostMapping("/addEvent")
    public boolean insertEvent(@RequestBody() Event event) {

        LOGGER.info(event.name);
        Venue venue = new Venue();
        venue.name = "RED BULL STADIUM";
        venue.city = "New York";
        venue.state = "NY";

        Event _event = new Event();
        _event.name = "MSI International";
        _event.date = new Date();
        _event.venue = venue;

        return eventService.insertEvent(_event) > 0;
    }
}
