package com.partnerships.interview.utils.db.mappers;

import com.partnerships.interview.model.Event;
import com.partnerships.interview.model.Venue;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventRowMapper implements RowMapper<Event> {
    @Nullable
    @Override
    public Event mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        final Venue venue = new Venue();
        venue.setId(resultSet.getInt("venue_id"));
        venue.setName(resultSet.getString("venue_name"));
        venue.setCity(resultSet.getString("venue_city"));
        venue.setState(resultSet.getString("venue_state"));

        final Event event = new Event();
        event.setId(resultSet.getInt("id"));
        event.setDate(resultSet.getDate("date"));
        event.setName(resultSet.getString("name"));
        event.setVenue(venue);
        return event;
    }
}
