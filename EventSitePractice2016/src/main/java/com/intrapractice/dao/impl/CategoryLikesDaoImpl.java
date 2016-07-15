package com.intrapractice.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.intrapractice.dao.CategoryLikesDao;

public class CategoryLikesDaoImpl implements CategoryLikesDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean likeCategory(int categoryId, int userId) {
		
		String sql = "INSERT INTO CATEGORIES_LIKES(CATEGORY_ID,USER_ID) VALUES(?,?)";
		
		try {
			int rowsAffected = jdbcTemplate.update(sql, categoryId, userId);
			
			if(rowsAffected == 1) {
				return true;
			}
			
			return false;
		}catch(DataIntegrityViolationException exception) {
			exception.printStackTrace();
			return false;
			
		}
	}
	
	public int getCategoryLikesCount(int categoryId) {
		
		String sql = "SELECT COUNT(CATEGORY_ID) FROM CATEGORIES_LIKES WHERE CATEGORY_ID=" + categoryId;
		
		int likesCount = jdbcTemplate.queryForObject(sql, Integer.class);
		
		return likesCount;
	}
	
	public List<Integer> getCategoriesLikedByUser(int userId) {
		
		String sql = "SELECT CATEGORY_ID FROM CATEGORIES_LIKES WHERE USER_ID=" + userId;
		
		List<Map<String,Object>> queryResult = jdbcTemplate.queryForList(sql);
		List<Integer> listOfCategories = new ArrayList<Integer>();
		for(Map row : queryResult) {
			listOfCategories.add((Integer) row.get("CATEGORY_ID"));
			System.out.println(row.get("CATEGORY_ID"));
		}
		
		return listOfCategories;
	}

}
