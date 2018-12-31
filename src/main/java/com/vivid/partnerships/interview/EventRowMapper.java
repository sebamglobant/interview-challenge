package com.vivid.partnerships.interview;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventRowMapper implements RowMapper<Event> {
    @Nullable
    @Override
    public Event mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        final Event event = new Event();
        event.id = resultSet.getInt("id");
        event.date = resultSet.getDate("date");
        event.name = resultSet.getString("name");
        event.venue = null;
        return event;
    }
}
