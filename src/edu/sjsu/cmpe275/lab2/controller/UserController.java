package edu.sjsu.cmpe275.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.cmpe275.lab2.dao.CreateUser;
import edu.sjsu.cmpe275.lab2.model.User;

@Controller
public class UserController {
	
	@RequestMapping(value = "/user", method = RequestMethod.GET )
	public ModelAndView createUser(){
		ModelAndView model = new ModelAndView("user");
		return model;
	}
	
	@RequestMapping(value = "/welcom", method = RequestMethod.POST )
	public ModelAndView createUserSuccess(@RequestParam("firstname") String firstname,
											@RequestParam("lastname") String lastname,
											@RequestParam("title") String title,
											@RequestParam("city") String city,
											@RequestParam("state") String state,
											@RequestParam("zip") String zip,
											@RequestParam("street") String street){
		CreateUser cU = new CreateUser();
		cU.insert(firstname, lastname, title, city, state, zip, street);
		
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("welcomeMessage", "" +firstname+lastname+title+state+city+zip+street);
		return model;
	}
	
	@RequestMapping(value = "/userid", method = RequestMethod.GET )
	public ModelAndView updateDeleteUser(/*@PathVariable("id")String id*/){
		ModelAndView model = new ModelAndView("userUpdateDelete");
		User user = new User ();
		user.setFirstname("spursh");
		user.setLastname("ujjawal");
		model.addObject(user);
		return model;
	}
	
}

