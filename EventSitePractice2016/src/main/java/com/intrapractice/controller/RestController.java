package com.intrapractice.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	public String createUser(HttpServletResponse response, @RequestParam String name, @RequestParam String email, @RequestParam String token) throws IOException{
		System.out.println("name " + name + " token " + token + " email " + email);
		User existingUser = userDao.getUserByToken(token);
		System.out.println("Existuser" + existingUser);
		if(existingUser == null) {
			boolean createUser = userDao.createUser(name, email, token);
			System.out.println("Create user " + createUser);
			return String.valueOf(createUser);
		} else {
			return "false";
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
	
	@RequestMapping(value = "/joinedEvents", method=RequestMethod.GET)
	public @ResponseBody String joinedEvents(HttpServletResponse response, @RequestParam int userId){
		ObjectMapper mapper = new ObjectMapper();
		List<Integer> listOfJoinedEvents = eventsDao.getJoinedEventsByUserId(userId);
		String joinedEvents = null;
		try {
			File temp = File.createTempFile("temp-file-name5", ".tmp"); 
			mapper.writeValue(temp, listOfJoinedEvents);
			joinedEvents = mapper.writeValueAsString(listOfJoinedEvents);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return	joinedEvents;
	
		
	}
	
	@RequestMapping(value ="/deleteEvent", method = RequestMethod.POST)
	public @ResponseBody boolean deleteEvent(HttpServletResponse response, @RequestParam int eventId) {
		return eventsDao.deleteEventById(eventId);
	}
	
	@RequestMapping(value = "/likeEvent", method=RequestMethod.POST)
	public boolean likeEvent(HttpServletResponse response, @RequestParam int eventId, @RequestParam int userId) {
		return eventLikeDao.likeEvent(eventId, userId);
	}
	
	@RequestMapping(value = "/unlikeEvent", method = RequestMethod.POST)
    public boolean unlikeEvent(HttpServletResponse response, @RequestParam int eventId, @RequestParam int userId) {
        return eventLikeDao.unlikeEvent(eventId, userId);
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
	
	@RequestMapping(value = "/unlikeCategory", method = RequestMethod.POST)
	public boolean unlikeCategory(HttpServletResponse response, @RequestParam int categoryId, @RequestParam int userId) {
		return categoryLikeDao.unlikeCategory(categoryId, userId);
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
	
	@RequestMapping(value = "/createCategory", method = RequestMethod.GET)
	public String createCategory(HttpServletResponse response, @RequestParam String categoryTitle) {
		Category cat = categoryDao.getCategoryByName(categoryTitle);
		if(cat==null){
			boolean result = categoryDao.createCategory(categoryTitle);
			if(result){
				Category cat2 = categoryDao.getCategoryByName(categoryTitle);
				ObjectMapper mapper = new ObjectMapper();
		        String jsonInString = null;
		        try {
		            File temp = File.createTempFile("temp-file-name3", ".tmp"); 
		            mapper.writeValue(temp, cat2);
		            jsonInString = mapper.writeValueAsString(cat2);
		            System.out.println("------>"+jsonInString);
		        }catch(Exception e) {
		            e.printStackTrace();
		        }
		        return jsonInString;
			}
		}
		return "";
	}
	

	@RequestMapping(value="/getCurrentUser", method=RequestMethod.GET)
	public String getCurrentUser(HttpServletResponse response, @RequestParam String token) throws IOException{
	    ObjectMapper mapper = new ObjectMapper();
        User currentUser = userDao.getUserByToken(token);
        System.out.println(currentUser);
        String jsonInString = null;
        try {
            File temp = File.createTempFile("temp-file-name8", ".tmp");
            mapper.writeValue(temp, currentUser);
            jsonInString = mapper.writeValueAsString(currentUser);
            System.out.println(jsonInString);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return jsonInString;	
	}

	@RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
	public boolean updateCategory(HttpServletResponse response, @RequestParam String categoryTitle, int categoryId) {
		return categoryDao.updateCategory(categoryTitle, categoryId);
	}
	
	@RequestMapping(value = "/getEventsForMonth", method = RequestMethod.GET)
	public String eventsForMonth(HttpServletResponse response, @RequestParam String date) {
		 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
	    try {
	        dateFormat.parse(date); 
	    }
	    catch(ParseException ex) {
	        return "Wrong date format";
	    }
		
		 ObjectMapper mapper = new ObjectMapper();
	        List<Event> eventsForMonth = eventsDao.getEventsInDateRange(date+"/01", date+"/31");
	        String jsonInString = null;
	        try {
	            File temp = File.createTempFile("temp-file-name9", ".tmp");
	            mapper.writeValue(temp, eventsForMonth);
	            jsonInString = mapper.writeValueAsString(eventsForMonth);
	            System.out.println(jsonInString);
	        }catch(Exception e) {
	            e.printStackTrace();
	        }
	        return jsonInString;
	}
	
}
