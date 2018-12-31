package com.vivid.partnerships.interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EventService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

     public List<Event> getEvents() {
         return jdbcTemplate.query("SELECT e.id, e.date, e.name, v.id as venue_id, v.name as venue_name," +
                 "v.city as venue_city, v.state as venue_state " +
                 "FROM events e INNER JOIN venues v " +
                 "WHERE e.venue_id = v.id", new EventRowMapper());
    }
}
