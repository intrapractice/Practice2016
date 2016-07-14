package com.intrapractice.dao.impl;

import java.util.List;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.intrapractice.dao.EventLikesDao;
import org.springframework.jdbc.core.RowMapper;
public class EventLikesDaoImpl implements EventLikesDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean likeEvent(int eventId, int userId) {
		
		String sql = "INSERT INTO EVENT_LIKES(EVENT_ID,USER_ID) VALUES(?,?)";
		
		try {
			int rowsAffected = jdbcTemplate.update(sql, eventId, userId);
			
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
	public int getEventLikesCount(int eventId) {
		String sql = "SELECT COUNT(EVENT_ID) FROM EVENT_LIKES WHERE EVENT_ID=" + eventId;
		
		int likesCount = jdbcTemplate.queryForObject(sql, Integer.class);
		
		return likesCount;
		
	}
	
	@Override
	public List<Integer> getEventsLikedByUser(int userId) {
		
		String sql = "SELECT EVENT_ID FROM EVENT_LIKES WHERE USER_ID=" + userId;
		
		List<Map<String,Object>> queryResult = jdbcTemplate.queryForList(sql);
		List<Integer> listOfEvents = new ArrayList<Integer>();
		for(Map row : queryResult) {
			listOfEvents.add((Integer) row.get("EVENT_ID"));
			System.out.println(row.get("EVENT_ID"));
		}
		
		return listOfEvents;
	}
}
