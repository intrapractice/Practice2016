package com.intrapractice.dao;

import java.util.List;

import com.intrapractice.pojo.User;

public interface UserDao {
    public List<User> getAllUsers();

    public boolean createUser(String name, String email, String token);

    public User getUser(String email);

    public User getUserByName(String name);
    
    public User getUserByID(int id);

	public User getUserByToken(String token);

}
