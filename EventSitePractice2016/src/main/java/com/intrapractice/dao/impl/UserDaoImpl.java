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
        String sql = "SELECT * FROM user";
        List<User> listContact = new ArrayList<User>();/*jdbcTemplate.query(sql, new RowMapper<User>() {
     
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User aContact = new User();
     
                aContact.setName(rs.getString("name"));
                aContact.setEmail(rs.getString("email"));
                aContact.setToken(rs.getString("token"));
     
                return aContact;
            }

        });*/
        listContact.add(new User("asd@asd.asd","martin test",null));
        return listContact;
    }
    
    

}
