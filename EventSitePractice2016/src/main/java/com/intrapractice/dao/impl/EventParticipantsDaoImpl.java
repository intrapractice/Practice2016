package com.intrapractice.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.intrapractice.dao.EventParticipantsDao;
import com.intrapractice.dao.EventsDao;
import com.intrapractice.dao.UserDao;
import com.intrapractice.pojo.User;

public class EventParticipantsDaoImpl implements EventParticipantsDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private EventsDao eventDao;
	
	 public boolean addParticipantForEvent(int eventId, int userId) {
		 
		 String sql = "INSERT INTO EVENT_PARTICIPANTS(EVENT_ID, USER_ID) VALUES(?,?)";
		 
		 if(userDao.getUserByID(userId) == null || eventDao.getEventById(eventId)== null) {
			 return false;
		 } 
		 
		 try {
			 Object[] values = new Object[]{eventId,userId};
			 
			 int rowsAffected = jdbcTemplate.update(sql,values);
			 
			 if(rowsAffected == 1) {
				 return true;
			 }	
		 }catch(DuplicateKeyException exception) {
			 exception.printStackTrace();
			 return false;
		 }
		 
			 
		 
		 return false;
	 }
	 
	 public List<User> getParticipantsForEvent(int eventId) {
	
		 String sql = "SELECT * FROM USERS_  "
		 		+ "WHERE USERS_.ID IN (SELECT USER_ID "
		 		+ "					FROM EVENT_PARTICIPANTS"
		 		+ "					WHERE EVENT_PARTICIPANTS.EVENT_ID=" + eventId+")"; 
		 
		 List<User> listOfParticipants = jdbcTemplate.query(sql, new RowMapper<User>() {
			 
		        @Override
		        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		           User user = new User();
		           user.setName(rs.getString("USER_NAME"));
		           
		            return user;
		        }
		 
		    });
		 
		 	//for(int i=0 ; i<listOfParticipants.size();i++) {
		 		//System.out.println(listOfParticipants.get(i));
		 	//}
		 	return listOfParticipants;
	 }
	 
	 @Override
	 public int getEventParticipantsCount(int eventId) {
		 
		 String sql = "SELECT COUNT(EVENT_ID) FROM EVENT_PARTICIPANTS WHERE EVENT_ID= " + eventId;
		 
		 int eventParticipantsCount = jdbcTemplate.queryForObject(sql, Integer.class);
		 
		 return eventParticipantsCount;
	 }

}
