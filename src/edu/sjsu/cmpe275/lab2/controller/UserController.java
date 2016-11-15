package edu.sjsu.cmpe275.lab2.controller;

import org.json.simple.JSONArray;
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
	
	CreateUser cU = new CreateUser();
	
	@RequestMapping(value = "/user", method = RequestMethod.GET )
	public ModelAndView createUser(){
		ModelAndView model = new ModelAndView("user");
		return model;
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.POST )
	public ModelAndView createUserSuccess(@RequestParam("firstname") String firstname,
											@RequestParam("lastname") String lastname,
											@RequestParam("title") String title,
											@RequestParam("city") String city,
											@RequestParam("state") String state,
											@RequestParam("zip") String zip,
											@RequestParam("street") String street){
		cU.insert(firstname, lastname, title, city, state, zip, street);
		
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("welcomeMessage", "" +firstname+lastname+title+state+city+zip+street);
		return model;
	}
	
	@RequestMapping(value = "user/{userid}", method = RequestMethod.GET )
	public ModelAndView updateDeleteUser(@PathVariable("userid")String userid){
		ModelAndView model = new ModelAndView("userUpdateDelete");
		User userDetails = cU.getObjectById(userid);
		model.addObject(userDetails);
		return model;
	}
	
	@RequestMapping(value = "user/{userid}?json=true", method = RequestMethod.GET )
	public ModelAndView jsonUser(@PathVariable("userid")String userid){
		JSONArray jArray = new JSONArray();
		jArray = cU.getJsonById(userid);
		/*User userDetails = cU.getJsonById(userid);*/
		ModelAndView model = new ModelAndView("jsonUserDetails");
		model.addObject(jArray);
		return model;
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST )
	public ModelAndView updateUser(@RequestParam("firstname") String firstname,
											@RequestParam("lastname") String lastname,
											@RequestParam("title") String title,
											@RequestParam("city") String city,
											@RequestParam("state") String state,
											@RequestParam("zip") String zip,
											@RequestParam("street") String street,
											@RequestParam("userId") String userId,
											@RequestParam("addressId") String addressId){
		System.out.println("user "+ userId + "address "+ addressId);
		cU.update(firstname, lastname, title, city, state, zip, street, userId, addressId);
		ModelAndView model = new ModelAndView("successfulUserUpdate");
		/*model.addObject("welcomeMessage", "" +firstname+lastname+title+state+city+zip+street);*/
		return model;
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE )
	public ModelAndView deleteUser(@RequestParam("userId") String userId,
								   @RequestParam("addressId") String addressId){
		cU.deleteObjectById(userId, addressId);
		ModelAndView model = new ModelAndView("successfulDeletion");
		return model;
	}
	
}

