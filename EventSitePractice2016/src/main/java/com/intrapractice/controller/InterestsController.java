package com.intrapractice.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.intrapractice.dao.CategoryDao;

@Controller
public class InterestsController {

	@Autowired
	private CategoryDao categoriesDao;
	
	@RequestMapping(value="/interests")
	public ModelAndView interests(HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("interests");
		
		List<com.intrapractice.pojo.Category> categories = categoriesDao.getAllCategories();
		mav.addObject("categories", categories);
		
		return mav;
	}
}
