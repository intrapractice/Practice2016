package com.intrapractice.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.intrapractice.pojo.User;

public interface UserDao {
    public List<User> getAllUsers();
}
