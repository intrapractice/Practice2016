package com.intrapractice.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.intrapractice.dao.CategoryDao;
import com.intrapractice.pojo.Category;

public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Category> getAllCategories() {

		String sql = "SELECT * FROM CATEGORIES_";

		List<Category> listCategories = jdbcTemplate.query(sql, new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int numOfRow) throws SQLException {

				Category category = new Category();

				category.setId(rs.getInt("ID"));
				category.setTitle(rs.getString("CATEGORY_TITLE"));

				return category;
			}

		});
		return listCategories;
	}

	@Override
	public Category getCategoryById(int categoryId) {

		String sql = "SELECT * FROM CATEGORIES_ WHERE ID = " + categoryId;

		return jdbcTemplate.query(sql, new ResultSetExtractor<Category>() {

			@Override
			public Category extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {

					Category category = new Category();

					category.setId(rs.getInt("ID"));
					category.setTitle(rs.getString("CATEGORY_TITLE"));

					return category;

				}

				return null;
			}

		});

	}

	public boolean createCategory(String title) {

		String sql = "INSERT INTO CATEGORIES_ (CATEGORY_TITLE) VALUES (?)";

		int numberOfRows = jdbcTemplate.update(sql, title);

		if (numberOfRows > 0) {
			return true;

		}
		return false;
		
	}

	public boolean updateCategory(String title, int categoryId) {

		String sql = "UPDATE CATEGORIES_ SET CATEGORY_TITLE=? WHERE ID=?";

		int numberOfRows = jdbcTemplate.update(sql, title, categoryId);

		if (numberOfRows > 0) {
			return true;

		}
		return false;
		
	}

	public boolean deleteCategoryById(int categoryId) {
		String sql = "DELETE FROM CATEGORIES_ WHERE ID=" + categoryId;
		try {

			int rowsAffected = jdbcTemplate.update(sql);

			if (rowsAffected == 1) {
				return true;
			}

			return false;
		} catch (DataIntegrityViolationException exception) {
			exception.printStackTrace();
			return false;

		}
	}

	@Override
	public Category getCategoryByName(String categoryTitle) {

		String sql = "SELECT * FROM CATEGORIES_ WHERE CATEGORY_TITLE LIKE '" + categoryTitle + "'";

		return jdbcTemplate.query(sql, new ResultSetExtractor<Category>() {

			@Override
			public Category extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {

					Category category = new Category();

					category.setId(rs.getInt("ID"));
					category.setTitle(rs.getString("CATEGORY_TITLE"));

					return category;

				}

				return null;
			}

		});

	}

}
