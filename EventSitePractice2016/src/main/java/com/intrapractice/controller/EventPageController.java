package com.intrapractice.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.intrapractice.dao.EventsDao;
import com.intrapractice.pojo.EventPojo;

@Controller
public class EventPageController {

	@Autowired
	private EventsDao eventsDao;

	@RequestMapping(value = "/CreateEvent", method = RequestMethod.POST)
	public ModelAndView saveEvent(@ModelAttribute EventPojo events) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

		Date eventsDate = null;
		try {
			eventsDate = dateFormat.parse(events.getDate());

		} catch (java.text.ParseException e) {

			System.out.println("Error with parse the date format!");

		}
		//OwnerId is 6 , because login is not ready
		boolean result = eventsDao.createEvent(events.getTitle(), events.getDescription(), eventsDate,
				events.getLocation(), 6);

		if (result) {

			System.out.println("Ready");
			return new ModelAndView("redirect:/");

		}

		return new ModelAndView("redirect:/CreateEvent?error=true");

	}

	@RequestMapping(value = "/CreateEvent", method = RequestMethod.GET)
	public ModelAndView newContact(
			@RequestParam(required = false, name = "error", defaultValue = "false") boolean error) {
		ModelAndView model = new ModelAndView("createEvent");
		EventPojo newEvent = new EventPojo();
		model.addObject("events", newEvent);

		model.addObject("error", error);

		return model;
	}

}
