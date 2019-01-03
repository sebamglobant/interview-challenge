package com.partnerships.interview.controller;

import com.partnerships.interview.model.Event;
import com.partnerships.interview.services.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return eventService.insertEvent(event) > 0;
    }
}
