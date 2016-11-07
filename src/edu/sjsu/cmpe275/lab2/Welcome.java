package edu.sjsu.cmpe275.lab2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Welcome {
	
	@RequestMapping("/welcome")
	public ModelAndView function(){
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("welcomeMessage", "Hello Dheeraj");
		return model;
	}
	
}

