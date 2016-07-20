package com.intrapractice.dao;

import java.util.List;

public interface CategoryLikesDao {
	
	public boolean likeCategory(int categoryId, int userId);

	public boolean unlikeCategory(int categoryId, int userId);

    public int getCategoryLikesCount(int categoryId);

    public List<Integer> getCategoriesLikedByUser(int userId);
    

}
