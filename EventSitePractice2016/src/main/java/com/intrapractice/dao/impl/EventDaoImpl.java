package com.intrapractice.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.intrapractice.dao.CategoryDao;
import com.intrapractice.dao.EventParticipantsDao;
import com.intrapractice.dao.EventsDao;
import com.intrapractice.dao.UserDao;
import com.intrapractice.pojo.Event;

public class EventDaoImpl implements EventsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private UserDao userDaoImpl;
	
	@Autowired
	private CategoryDao catedoryDao;
	
	@Autowired
    private EventParticipantsDao eventParticipantsDao;

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
				event.setDate(rs.getTimestamp("EVENT_DATE"));
				event.setEndDate(rs.getTimestamp("EVENT_END_DATE"));
				event.setCategory(catedoryDao.getCategoryById(rs.getInt("CATEGORY_ID")));

				return event;
			}

		});
		return listEvents;
	}

	@Override
	public Event getEventById(int id) {

		String sql = "SELECT * FROM EVENTS_ WHERE ID = " + id;

		return jdbcTemplate.query(sql, new ResultSetExtractor<Event>() {

			@Override
			public Event extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {

					Event event = new Event();

					event.setId(rs.getInt("ID"));
					event.setTitle(rs.getString("EVENT_TITLE"));
					event.setLocation(rs.getString("EVENT_LOCATION"));
					event.setOwner(userDaoImpl.getUserByID(rs.getInt("EVENT_OWNER")));
					event.setDescription(rs.getString("EVENT_DESCRIPTION"));
					event.setDate(rs.getTimestamp("EVENT_DATE"));
					event.setEndDate(rs.getTimestamp("EVENT_END_DATE"));
					event.setCategory(catedoryDao.getCategoryById(rs.getInt("CATEGORY_ID")));
					event.setParticipants(eventParticipantsDao.getParticipantsForEvent(rs.getInt("ID")));
					return event;

				}

				return null;
			}

		});

	}

	@Override
	public boolean createEvent(String title, String description, Date eventDate, Date eventEndDate, String location, int ownerId , int categoryId) {
		int numberOfRows = 0;
		String sql = "INSERT INTO EVENTS_ (EVENT_TITLE,EVENT_DESCRIPTION,EVENT_DATE,EVENT_END_DATE,EVENT_LOCATION,EVENT_OWNER,CATEGORY_ID)"
				+ "VALUES (?,?,?,?,?,?,?)";
		try{
		
		 numberOfRows = jdbcTemplate.update(sql, title, description, eventDate, eventEndDate, location, ownerId , categoryId);
		
		}catch(DuplicateKeyException e){
			e.printStackTrace();
			return false;
		}
		if (numberOfRows > 0) {
			return true;

		}
		return false;
	}
	
	@Override
	public boolean updateEvent(String title, String description, Date eventDate, Date eventEndDate, String location, int eventId , int categoryId) {
		
		String sql = "UPDATE EVENTS_ SET EVENT_TITLE=?, EVENT_DESCRIPTION=?, EVENT_DATE=?, "
                + "EVENT_END_DATE=?, EVENT_LOCATION=? , CATEGORY_ID=? WHERE ID=?";
		
		int numberOfRows = jdbcTemplate.update(sql, title, description, eventDate, eventEndDate, location, categoryId, eventId);
		
		if (numberOfRows > 0) {
			return true;

		}
		return false;
	}

	@Override
	public List<Event> getEventsByOwnerId(int ownerId) {
		String sql = "SELECT * FROM EVENTS_ WHERE EVENT_OWNER=" + ownerId;
		List<Event> listOfEvents = jdbcTemplate.query(sql, new RowMapper<Event>() {
			 
	        @Override
	        public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
	           Event event = new Event();
	           event.setId(rs.getInt("ID"));
	           event.setTitle(rs.getString("EVENT_TITLE"));
	           event.setDescription(rs.getString("EVENT_DESCRIPTION"));
	           event.setOwner(userDaoImpl.getUserByID(rs.getInt("EVENT_OWNER")));
	           event.setDate(rs.getTimestamp("EVENT_DATE"));
	           event.setEndDate(rs.getTimestamp("EVENT_END_DATE"));
	           event.setLocation(rs.getString("EVENT_LOCATION"));
	            return event;
	        }
	 
	    });
		return listOfEvents;
	}

	@Override
	public List<Event> getJoinedEventsByUserId(int userId) {
		String sql = "SELECT EVENTS_.EVENT_TITLE, EVENTS_.EVENT_DESCRIPTION, EVENTS_.EVENT_DATE, "
				+ "EVENTS_.EVENT_END_DATE, EVENTS_.EVENT_OWNER, "
				+ "EVENTS_.EVENT_LOCATION"
				+ " FROM EVENTS_ JOIN EVENT_PARTICIPANTS "
				+ "ON EVENTS_.ID = EVENT_PARTICIPANTS.EVENT_ID"
				+ " WHERE EVENT_PARTICIPANTS.USER_ID =" + userId;
				
		List<Event> listOfJoinedEvents = jdbcTemplate.query(sql, new RowMapper<Event>() {
			 
	        @Override
	        public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
	           Event event = new Event();
	           event.setTitle(rs.getString("EVENT_TITLE"));
	           event.setDescription(rs.getString("EVENT_DESCRIPTION"));
	           event.setOwner(userDaoImpl.getUserByID(rs.getInt("EVENT_OWNER")));
	           event.setDate(rs.getTimestamp("EVENT_DATE"));
	           event.setEndDate(rs.getTimestamp("EVENT_END_DATE"));
	           event.setLocation(rs.getString("EVENT_LOCATION"));
	            return event;
	        }
	 
	    });
		return listOfJoinedEvents;
	}
	
	@Override
	public boolean deleteEventById(int eventId){
		String sql = "DELETE FROM EVENTS_ WHERE ID=" + eventId;
		String sqlDeleteFromLikes = "DELETE FROM EVENT_LIKES WHERE EVENT_ID=" + eventId;
		String sqlDeleteFromParticipants = "DELETE FROM EVENT_PARTICIPANTS WHERE EVENT_ID=" + eventId;
		try {
			
			jdbcTemplate.update(sqlDeleteFromLikes);
			jdbcTemplate.update(sqlDeleteFromParticipants);
			int rowsAffected = jdbcTemplate.update(sql);
			
			if(rowsAffected == 1) {
				return true;
			}
			
			return false;
		}catch(DataIntegrityViolationException exception) {
			exception.printStackTrace();
			return false;
			
		}
		
	}
	@Override
    public List<Event> getEventsInDateRange(String beginDate, String endDate) {
        //date format should be in format '2016/07/20'
        String sql = "SELECT * FROM EVENTS_ WHERE EVENT_DATE BETWEEN '"+beginDate+"' AND '"+endDate+"'";
        List<Event> listEvents = jdbcTemplate.query(sql, new RowMapper<Event>() {

            @Override
            public Event mapRow(ResultSet rs, int numOfRow) throws SQLException {

                Event event = new Event();

                event.setId(rs.getInt("ID"));
                event.setTitle(rs.getString("EVENT_TITLE"));
                event.setLocation(rs.getString("EVENT_LOCATION"));
                event.setOwner(userDaoImpl.getUserByID(rs.getInt("EVENT_OWNER")));
                event.setDescription(rs.getString("EVENT_DESCRIPTION"));
                event.setDate(rs.getTimestamp("EVENT_DATE"));
                event.setEndDate(rs.getTimestamp("EVENT_END_DATE"));

                return event;
            }

        });
        return listEvents;
    }

}
