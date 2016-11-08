package edu.sjsu.cmpe275.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@RequestMapping("/user")
	public ModelAndView getUser(){
		ModelAndView model = new ModelAndView("user");
		return model;
	}
}

