package com.partnerships.interview;

import com.partnerships.interview.model.Event;
import com.partnerships.interview.model.Venue;
import com.partnerships.interview.services.EventService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InterviewApplicationTests {

	@Autowired
	private EventService eventService;

	@Test
	public void contextLoads() {
		List<Event> events = eventService.getEvents();
		Assert.assertTrue("Init app events test", events.size() > 0);
	}

	@Test
	public void insertEventsTest() {
		Venue venue = new Venue();
		venue.setName("Red Bull Stadium");
		venue.setCity("Miami");
		venue.setState("FL");

		Event event = new Event();
		event.setVenue(venue);
		event.setName("MSI International");
		event.setDate(new Date());

		int insertionSuccess = eventService.insertEvent(event);

		Assert.assertEquals("Insert new event test",1, insertionSuccess);
	}

	@Test
	public void getEventsTest() {
		List<Event> events_1 = eventService.getEvents();
		Venue venue = new Venue();
		venue.setName("Red Bull Stadium");
		venue.setCity("Miami");
		venue.setState("FL");

		Event event = new Event();
		event.setVenue(venue);
		event.setName("MSI International");
		event.setDate(new Date());

		eventService.insertEvent(event);

		List<Event> events_2 = eventService.getEvents();

		Assert.assertNotEquals("Events after inserts", events_1, events_2);
		Assert.assertNotNull("Events pre insert", events_1);
		Assert.assertNotNull("Events post insert", events_2);
	}

}
