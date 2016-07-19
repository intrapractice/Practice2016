package com.intrapractice.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intrapractice.dao.CategoryDao;
import com.intrapractice.dao.CategoryLikesDao;
import com.intrapractice.dao.EventLikesDao;
import com.intrapractice.dao.EventParticipantsDao;
import com.intrapractice.dao.EventsDao;
import com.intrapractice.dao.UserDao;
import com.intrapractice.pojo.Category;
import com.intrapractice.pojo.Event;
import com.intrapractice.pojo.User;

@Controller
@ResponseBody
public class RestController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    private UserDao userDao;
	
	@Autowired 
	private EventParticipantsDao participantsDao;
	
	@Autowired 
	private EventsDao eventsDao;
	
	@Autowired
	private EventLikesDao eventLikeDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private CategoryLikesDao categoryLikeDao;
	
	
	
	@RequestMapping(value="/createUser", method=RequestMethod.POST)
	public boolean createUser(HttpServletResponse response, @RequestParam String name, @RequestParam String email, @RequestParam String token) throws IOException{
		User existingUser = userDao.getUser(email);
		if(existingUser == null) {
			return userDao.createUser(name, email, token);
		} else {
			return false;
		}
	}
	
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public boolean joinEvent(HttpServletResponse response, @RequestParam int eventId, @RequestParam int userId) {
		
		return	participantsDao.addParticipantForEvent(eventId, userId);
	}
	
	@RequestMapping(value = "/eventParticipants", method=RequestMethod.POST)
	public @ResponseBody String eventParticipants(HttpServletResponse response, @RequestParam int eventId){
		ObjectMapper mapper = new ObjectMapper();
		List<User> listOfParticipants = participantsDao.getParticipantsForEvent(eventId);
		String jsonInString = null;
		try {
			File temp = File.createTempFile("temp-file-name2", ".tmp"); 
			mapper.writeValue(temp, listOfParticipants);
			jsonInString = mapper.writeValueAsString(listOfParticipants);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return jsonInString;
		
	}
	
	@RequestMapping(value = "/eventParticipantsCount", method=RequestMethod.POST)
	public int eventParticipantsCount(HttpServletResponse response, @RequestParam int eventId) {
		return participantsDao.getEventParticipantsCount(eventId);
	}
	
	@RequestMapping(value = "/getEventById", method = RequestMethod.POST)
	public @ResponseBody Event  getEventById(HttpServletResponse response, @RequestParam int eventId) {
		return eventsDao.getEventById(eventId);
	}
	
	@RequestMapping(value = "/eventsByOwner", method=RequestMethod.POST)
	public @ResponseBody String eventsByOwner(HttpServletResponse response, @RequestParam int ownerId){
		ObjectMapper mapper = new ObjectMapper();
		List<Event> listOfEvents = eventsDao.getEventsByOwnerId(ownerId);
		String list = null;
		try {
			File temp = File.createTempFile("temp-file-name3", ".tmp"); 
			mapper.writeValue(temp, listOfEvents);
			list = mapper.writeValueAsString(listOfEvents);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	@RequestMapping(value = "/joinedEvents", method=RequestMethod.POST)
	public @ResponseBody String joinedEvents(HttpServletResponse response, @RequestParam int userId){
		ObjectMapper mapper = new ObjectMapper();
		List<Event> listOfEvents = eventsDao.getJoinedEventsByUserId(userId);
		String joinedEvents = null;
		try {
			File temp = File.createTempFile("temp-file-name4", ".tmp"); 
			mapper.writeValue(temp, listOfEvents);
			joinedEvents = mapper.writeValueAsString(listOfEvents);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return joinedEvents;
		
	}
	
	@RequestMapping(value ="/deleteEvent", method = RequestMethod.POST)
	public @ResponseBody boolean deleteEvent(HttpServletResponse response, @RequestParam int eventId) {
		return eventsDao.deleteEventById(eventId);
	}
	
	@RequestMapping(value = "/likeEvent", method=RequestMethod.POST)
	public boolean likeEvent(HttpServletResponse response, @RequestParam int eventId, @RequestParam int userId) {
		return eventLikeDao.likeEvent(eventId, userId);
	}
	
	@RequestMapping(value = "/eventLikesCount", method=RequestMethod.POST)
	public int eventLikesCount(HttpServletResponse response, @RequestParam int eventId) {
		return eventLikeDao.getEventLikesCount(eventId);
	}
	
	@RequestMapping(value = "/eventsLikedByUser", method = RequestMethod.POST)
	public String eventsLikedByUser(HttpServletResponse response, @RequestParam int userId) {
		ObjectMapper mapper = new ObjectMapper();
		List<Integer> listOfLikedEvents = eventLikeDao.getEventsLikedByUser(userId);
		String likes = null;
		try {
			File temp = File.createTempFile("temp-file-name", ".tmp"); 
			mapper.writeValue(temp, listOfLikedEvents);
			likes = mapper.writeValueAsString(listOfLikedEvents);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return	likes;
	}
	
	@RequestMapping(value = "/getAllCategories", method = RequestMethod.POST)
	public @ResponseBody String  getCategoryById(HttpServletResponse response) {
		
		ObjectMapper mapper = new ObjectMapper();
		List<Category> listOfCategories = categoryDao.getAllCategories();
		String allCategories = null;
		try {
			File temp = File.createTempFile("temp-file-name4", ".tmp"); 
			mapper.writeValue(temp, listOfCategories);
			allCategories = mapper.writeValueAsString(listOfCategories);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return allCategories;
		
	}
	
	@RequestMapping(value = "/getCategoryById", method = RequestMethod.POST)
	public @ResponseBody Category  getCategoryById(HttpServletResponse response, @RequestParam int categoryId) {
		return categoryDao.getCategoryById(categoryId);
	}
	
	@RequestMapping(value ="/deleteCategory", method = RequestMethod.POST)
	public @ResponseBody boolean deleteCategory(HttpServletResponse response, @RequestParam int categoryId) {
		return categoryDao.deleteCategoryById(categoryId);
	}
	
	@RequestMapping(value = "/likeCategory", method=RequestMethod.POST)
	public boolean likeCategory(HttpServletResponse response, @RequestParam int categoryId, @RequestParam int userId) {
		return categoryLikeDao.likeCategory(categoryId, userId);
	}
	
	@RequestMapping(value = "/categoryLikesCount", method=RequestMethod.POST)
	public int categorylikesCount(HttpServletResponse response, @RequestParam int categoryId) {
		return categoryLikeDao.getCategoryLikesCount(categoryId);
	}
	
	@RequestMapping(value = "/categoriesLikedByUser", method = RequestMethod.POST)
	public String categoriesLikedByUser(HttpServletResponse response, @RequestParam int userId) {
		ObjectMapper mapper = new ObjectMapper();
		List<Integer> listOfLikedCategories = categoryLikeDao.getCategoriesLikedByUser(userId);
		String likes = null;
		try {
			File temp = File.createTempFile("temp-file-name5", ".tmp"); 
			mapper.writeValue(temp, listOfLikedCategories);
			likes = mapper.writeValueAsString(listOfLikedCategories);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return	likes;
	}
	
	@RequestMapping(value = "/createCategory", method = RequestMethod.POST)
	public boolean createCategory(HttpServletResponse response, @RequestParam String categoryTitle) {
		return categoryDao.createCategory(categoryTitle);
	}
	
	@RequestMapping(value="/getCurrentUser", method=RequestMethod.GET)
	public String getCurrentUser(HttpServletResponse response, @RequestParam String email) throws IOException{
	    //TODO: test without writing to file, should return User JSON
	    ObjectMapper mapper = new ObjectMapper();
        User currentUser = userDao.getUser(email);
        String jsonInString = null;
        try {
            File temp = File.createTempFile("temp-file-name8", ".tmp"); 
            mapper.writeValue(temp, currentUser);
            jsonInString = mapper.writeValueAsString(currentUser);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return jsonInString;	
	}
	
}
