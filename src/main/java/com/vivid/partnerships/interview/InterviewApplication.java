package com.vivid.partnerships.interview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

@SpringBootApplication
public class InterviewApplication implements CommandLineRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(InterviewApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InterviewApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... strings) throws Exception {

		this.createTables();
		this.insertSartedData();
	}

	private void createTables() {
		LOGGER.info("Creating venues table");
		jdbcTemplate.execute("CREATE TABLE venues(" +
				"id SERIAL primary key," +
				"name VARCHAR(50)," +
				"city VARCHAR(50)," +
				"state VARCHAR(50));");

		LOGGER.info("Creating events table");

		jdbcTemplate.execute("CREATE TABLE events(" +
				"id SERIAL," +
				"venue_id INTEGER," +
				"name VARCHAR(255), " +
				"date DATE," +
				"CONSTRAINT venue_id_fk FOREIGN KEY (venue_id) REFERENCES venues(id));");
	}

	private void insertSartedData() {
		LOGGER.info("Inserting data into venues table");
		jdbcTemplate.update("INSERT INTO venues (name, city, state) VALUES (?,?,?)",
				"Wrigley Field", "Chicago", "IL");

		LOGGER.info("Inserting data into events table");
		jdbcTemplate.update("INSERT INTO events (venue_id, name, date) VALUES (?,?,?)",
				1, "Chicago White Sox vs. Chicago Cubs", new Date());
	}
}
