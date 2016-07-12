package com.intrapractice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.intrapractice.dao.UserDao;
import com.intrapractice.pojo.User;

@Controller
@ResponseBody
public class RestController {
	@Autowired
    private UserDao userDao;
	
	@RequestMapping(value="/createUser", method=RequestMethod.POST)
	public boolean createUser(HttpServletResponse response, @RequestParam String name, @RequestParam String email, @RequestParam String token) throws IOException{
		User existingUser = userDao.getUser(email);
		if(existingUser == null) {
			return userDao.createUser(name, email, token);
		} else {
			return false;
		}
	}
}
