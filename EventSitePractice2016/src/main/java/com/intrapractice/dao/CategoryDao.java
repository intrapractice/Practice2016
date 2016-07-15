package com.intrapractice.dao;

import java.util.List;
import com.intrapractice.pojo.Category;

public interface CategoryDao {
	
	public List<Category> getAllCategories();
	
	public Category getCategoryById(int categoryId);
	
	public boolean createCategory(String title);
	
	public boolean updateCategory(String title, int categoryId);
	
	public boolean deleteCategoryById(int categoryId);
	
}
