package edu.sjsu.cmpe275.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@RequestMapping("/user")
	public ModelAndView createUser(){
		ModelAndView model = new ModelAndView("user");
		return model;
	}
	
	@RequestMapping("/phone")
	public ModelAndView createPhone(){
		ModelAndView model = new ModelAndView("phone");
		return model;
	}
}

