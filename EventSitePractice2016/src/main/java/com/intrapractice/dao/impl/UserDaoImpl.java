package com.intrapractice.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.intrapractice.dao.UserDao;
import com.intrapractice.pojo.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT * FROM USERS_";
		List<User> listContact = jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();

				user.setId(rs.getInt("ID"));
				user.setName(rs.getString("USER_NAME"));
				user.setEmail(rs.getString("USER_EMAIL"));
				user.setToken(rs.getString("USER_TOKEN"));

				return user;
			}

		});
		return listContact;
	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createUser(String name, String email, String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserID(int id) {

		String sql = "SELECT * FROM USERS_ WHERE ID = " + 1;

		return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {

					User user = new User();

					user.setId(rs.getInt("ID"));
					user.setName(rs.getString("USER_NAME"));
					user.setEmail(rs.getString("USER_EMAIL"));
					user.setToken(rs.getString("USER_TOKEN"));

					return user;

				}

				return null;
			}

		});

	}

}
