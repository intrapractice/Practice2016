package com.intrapractice.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.intrapractice.dao.EventsDao;
import com.intrapractice.dao.UserDao;
import com.intrapractice.pojo.Event;


public class EventDaoImpl implements EventsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private UserDao userDaoImpl;

	@Override
	public List<Event> getAllEvents() {

		String sql = "SELECT * FROM EVENTS_";

		List<Event> listEvents = jdbcTemplate.query(sql, new RowMapper<Event>() {

			@Override
			public Event mapRow(ResultSet rs, int numOfRow) throws SQLException {

				Event event = new Event();

				event.setId(rs.getInt("ID"));
				event.setTitle(rs.getString("EVENT_TITLE"));
				event.setLocation(rs.getString("EVENT_LOCATION"));
				event.setOwner(userDaoImpl.getUserByID(rs.getInt("EVENT_OWNER")));
				event.setDescription(rs.getString("EVENT_DESCRIPTION"));
				event.setTimestamp(rs.getTimestamp("EVENT_DATE"));

				return event;
			}

		});
		return listEvents;
	}

	@Override
	public Event getEventById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createEvent(String title, String description, Date eventDate, String location, int ownerId) {
		
		

		String sql = "INSERT INTO EVENTS_ (EVENT_TITLE,EVENT_DESCRIPTION,EVENT_DATE,EVENT_LOCATION,EVENT_OWNER) VALUES (?,?,?,?,?)";
				

		int numberOfRows = jdbcTemplate.update(sql, title, description, eventDate, location, ownerId);

		if (numberOfRows > 0) {
			return true;

		}
		return false;
	}

	@Override
	public List<Event> getEventsByOwnerId(int ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getJoinedEventsByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
