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
        venue.id = resultSet.getInt("venue_id");
        venue.name = resultSet.getString("venue_name");
        venue.city = resultSet.getString("venue_city");
        venue.state = resultSet.getString("venue_state");

        final Event event = new Event();
        event.id = resultSet.getInt("id");
        event.date = resultSet.getDate("date");
        event.name = resultSet.getString("name");
        event.venue = venue;
        return event;
    }
}
