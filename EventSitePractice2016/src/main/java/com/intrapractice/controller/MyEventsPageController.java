package com.intrapractice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.intrapractice.dao.EventsDao;
import com.intrapractice.pojo.Event;

@Controller
public class MyEventsPageController {
	
	@Autowired
	private EventsDao eventsDao;

	@RequestMapping(value = "/myEvents")
	public ModelAndView test(HttpServletResponse response) throws IOException {

		ModelAndView mav = new ModelAndView("myEvents");
		
		List<Event> events = eventsDao.getAllEvents();
		mav.addObject("events", events);

		return mav;

	}

}
