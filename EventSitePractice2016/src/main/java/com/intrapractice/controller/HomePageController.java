package com.intrapractice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.intrapractice.dao.EventsDao;
import com.intrapractice.dao.UserDao;
import com.intrapractice.pojo.Event;
import com.intrapractice.pojo.User;

@Controller
public class HomePageController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private EventsDao eventsDao;

	@RequestMapping(value = "/")
	public ModelAndView test(HttpServletResponse response) throws IOException {

		ModelAndView mav = new ModelAndView("home");

		List<User> users = userDao.getAllUsers();
		mav.addObject("users", users);

		//TODO: replace hardcoded strings with request params
		List<Event> events = eventsDao.getEventsInDateRange("2016/01/01", "2016/12/31");
		mav.addObject("events", events);

		return mav;

	}

	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletResponse response) throws IOException {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
}
