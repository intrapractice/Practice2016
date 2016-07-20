package com.intrapractice.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
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

		Date date= new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int nextMonth = month + 1;
		
		List<Event> events = eventsDao.getEventsInDateRange(year+"/"+month+"/01", year+"/"+nextMonth+"/01");
		mav.addObject("events", events);

		return mav;

	}

	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletResponse response) throws IOException {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
}
