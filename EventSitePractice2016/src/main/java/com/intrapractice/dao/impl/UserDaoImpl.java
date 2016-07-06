package com.intrapractice.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.intrapractice.dao.UserDao;
import com.intrapractice.pojo.User;

public class UserDaoImpl implements UserDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<User> getAllUsers() {
        System.out.println("Entering the dao");
        String sql = "SELECT * FROM USERS_";
        List<User> listContact = jdbcTemplate.query(sql, new RowMapper<User>() {
     
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User aContact = new User();
     
                aContact.setName(rs.getString("USER_NAME"));
                aContact.setEmail(rs.getString("USER_EMAIL"));
                aContact.setToken(rs.getString("USER_TOKEN"));
     
                return aContact;
            }

        });
        return listContact;
    }
    
    

}
