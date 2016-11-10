package edu.sjsu.cmpe275.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PhoneController {
	
	@RequestMapping(value = "/phone", method = RequestMethod.GET )
	public ModelAndView createUser(){
		ModelAndView model = new ModelAndView("phone");
		return model;
	}
	
	/*@RequestMapping(value = "/welcome", method = RequestMethod.POST )
	public ModelAndView createUserSuccess(@RequestParam("phoneNumber") String phoneNumber,
											@RequestParam("description") String description,
											@RequestParam("city") String city,
											@RequestParam("state") String state,
											@RequestParam("zip") String zip,
											@RequestParam("street") String street){
		CreateAddress cA = new CreateAddress();
		//cA.insert(firstname, lastname, title, city, state, zip, street);
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("welcomeMessage", "" +phoneNumber+description+state+city+zip+street);
		return model;
	}*/

}
