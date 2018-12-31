package com.vivid.partnerships.interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class EventService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EventService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

     public List<Event> getEvents() {
         return jdbcTemplate.query(
             "SELECT e.id, e.date, e.name, v.id as venue_id, v.name as venue_name," +
             "v.city as venue_city, v.state as venue_state " +
             "FROM events e INNER JOIN venues v " +
             "WHERE e.venue_id = v.id", new EventRowMapper());
    }

    public int insertEvent(Event event) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String insertVenue = "INSERT INTO venues(name, city, state) VALUES (?,?,?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                final PreparedStatement ps = con.prepareStatement(insertVenue, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, event.venue.name);
                ps.setString(2, event.venue.city);
                ps.setString(3, event.venue.state);
                return ps;
            }
        }, keyHolder);

        return jdbcTemplate.update("INSERT INTO events(venue_id, name, date) VALUES (?,?,?)",
            keyHolder.getKey(), event.name, event.date);
    }
}
