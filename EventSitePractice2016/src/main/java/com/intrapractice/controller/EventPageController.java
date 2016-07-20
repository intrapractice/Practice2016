package com.intrapractice.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.intrapractice.dao.CategoryDao;
import com.intrapractice.dao.EventsDao;
import com.intrapractice.pojo.Category;
import com.intrapractice.pojo.Event;
import com.intrapractice.pojo.EventPojo;

@Controller
public class EventPageController {

	@Autowired
	private EventsDao eventsDao;
	
	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value = "/CreateEvent", method = RequestMethod.POST)
	public ModelAndView saveEvent(@ModelAttribute EventPojo events) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		Date eventsDate = null;
		Date eventsEndDate = null;
		try {
			eventsDate = dateFormat.parse(events.getDate());
			eventsEndDate = dateFormat.parse(events.getEndDate());

		} catch (java.text.ParseException e) {

			System.out.println("Error with parse the date format!");
			
		}

		boolean result = eventsDao.createEvent(events.getTitle(), events.getDescription(), eventsDate, eventsEndDate,
				events.getLocation(), events.getUserId() ,events.getCategoryId());

		if (result) {

			System.out.println("Ready");
			return new ModelAndView("redirect:/");

		}

		return new ModelAndView("redirect:/CreateEvent?error=true");

	}

	@RequestMapping(value = "/CreateEvent", method = RequestMethod.GET)
	public ModelAndView newEvent(
			@RequestParam(required = false, name = "error", defaultValue = "false") boolean error,
			HttpServletResponse response) {

		ModelAndView model = new ModelAndView("createEvent");
		EventPojo newEvent = new EventPojo();
		model.addObject("events", newEvent);

		List<Category> listCategory =  categoryDao.getAllCategories();
		model.addObject("categories",listCategory);
		
		model.addObject("error", error);
		model.addObject("formURL", "/EventSitePractice2016/CreateEvent");

		return model;
	}

	@RequestMapping(value = "/UpdateEvent", method = RequestMethod.POST)
	public ModelAndView updateEvent(@ModelAttribute EventPojo events) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date eventsDate = null;
		Date eventsEndDate = null;
		try {
			eventsDate = dateFormat.parse(events.getDate());
			eventsEndDate = dateFormat.parse(events.getEndDate());

		} catch (java.text.ParseException e) {

			System.out.println("Error with parse the date format!");

		}
		
		boolean result = eventsDao.createEvent(events.getTitle(), events.getDescription(), eventsDate, eventsEndDate,
				events.getLocation(), events.getUserId() , events.getCategoryId());

		if (result) {

			System.out.println("Ready");
			return new ModelAndView("redirect:/");

		}

		return new ModelAndView("redirect:/CreateEvent?error=true");

	}

	@RequestMapping(value = "/UpdateEvent/{eventId}", method = RequestMethod.GET)
	public ModelAndView newEvent2(@PathVariable int eventId,
			@RequestParam(required = false, name = "error", defaultValue = "false") boolean error) {

		ModelAndView model = new ModelAndView("createEvent");
		Event eventById = eventsDao.getEventById(eventId);
		EventPojo event = new EventPojo();
		event.setDescription(eventById.getDescription());
		model.addObject("events", eventById);
		
		List<Category> listCategory =  categoryDao.getAllCategories();
		model.addObject("categories",listCategory);

		model.addObject("error", error);
		model.addObject("formURL", "/EventSitePractice2016/UpdateEvent");

		return model;
	}

}
