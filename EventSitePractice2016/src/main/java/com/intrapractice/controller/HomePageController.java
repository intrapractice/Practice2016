package com.intrapractice.controller;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.intrapractice.dao.EventsDao;
import com.intrapractice.dao.UserDao;
import com.intrapractice.pojo.Event;

@Controller
public class HomePageController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private EventsDao eventsDao;

	@RequestMapping(value = "/")
	public ModelAndView test(@RequestParam(required=false, name="month", defaultValue="-1")int month,
			HttpServletResponse response) throws IOException {

		ModelAndView mav = new ModelAndView("home");

		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		System.out.println("month is "+month);
		if(month>-1){
			cal.set(Calendar.MONTH, month);
		}
		int year = cal.get(Calendar.YEAR);
		int month1 = cal.get(Calendar.MONTH)+1;
		int nextMonth = 0;
		int newYear = year;
		if (month1==12) {
			nextMonth = 1;
			newYear = year + 1;
		} else {
			nextMonth = month1 + 1;
		}
		System.out.println("getting events between "+year + "/" + month1 + "/01 and "+newYear + "/" + nextMonth + "/01");
		List<Event> events = eventsDao.getEventsInDateRange(year + "/" + month1 + "/01", newYear + "/" + nextMonth + "/01");
		mav.addObject("events", events);
System.out.println("events is "+events.size());
		return mav;

	}

	@RequestMapping(value = "/getEventsByMonth")
	public String getEventsByMonth(HttpServletResponse response, @RequestParam String monthWord,
			@RequestParam int year) {

		int month = 0;
		switch (monthWord) {
		case "January":
			month = 0;
			break;
		case "February":
			month = 1;
			break;
		case "March":
			month = 2;
			break;
		case "April":
			month = 3;
			break;
		case "May":
			month = 4;
			break;
		case "June":
			month = 5;
			break;
		case "July":
			month = 6;
			break;
		case "August":
			month = 7;
			break;
		case "September":
			month = 8;
			break;
		case "October":
			month = 9;
			break;
		case "November":
			month = 10;
			break;
		case "December":
			month = 11;
			break;
		}

		int nextMonth = 0;
		int newYear = year;
		if (month==11) {
			nextMonth = 1;
			newYear = year + 1;
		} else {
			nextMonth = month + 1;
		}
		List<Event> events = eventsDao.getEventsInDateRange(year + "/" + month + "/01",
				newYear + "/" + nextMonth + "/01");

		if (!events.isEmpty()) {
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = null;
			try {
				File temp = File.createTempFile("temp-file-name3", ".tmp");
				mapper.writeValue(temp, events);
				jsonInString = mapper.writeValueAsString(events);
				System.out.println("------>" + jsonInString);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return jsonInString;
		}
		return "";

	}

	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletResponse response) throws IOException {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
  
    @RequestMapping(value = "/license")
	public ModelAndView login(HttpServletResponse response) throws IOException {
		ModelAndView mav = new ModelAndView("disclaimerEULA");
		return mav;
	}
}
