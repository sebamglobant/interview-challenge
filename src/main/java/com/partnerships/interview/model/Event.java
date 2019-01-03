package com.partnerships.interview.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Event {
    private Integer id;
    private String name;
    private Date date;
    private Venue venue;
}
