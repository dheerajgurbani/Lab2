package edu.sjsu.cmpe275.lab2.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.sjsu.cmpe275.lab2.dao.CreatePhone;
import edu.sjsu.cmpe275.lab2.dao.CreateUser;
import edu.sjsu.cmpe275.lab2.model.Phone;
import edu.sjsu.cmpe275.lab2.model.User;


@Controller
public class PhoneController {
	CreatePhone pU = new CreatePhone();
	@RequestMapping(value = "/phone", method = RequestMethod.GET )
	public ModelAndView createPhone(){
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
	@RequestMapping(value = "/phoneDisplay", method = RequestMethod.POST )
	public ModelAndView createPhoneSuccess(@RequestParam("phoneNumber") String phoneNumber,
											
											@RequestParam("description") String description,
											@RequestParam("city") String city,
											@RequestParam("state") String state,
											@RequestParam("zip") String zip,
											@RequestParam("street") String street){
		
		pU.insert(phoneNumber, description, city, state, zip, street);
		
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("welcomeMessage", "" +phoneNumber+" "+description+" "+state+" "+city+" "+zip+" "+street);
		return model;
	}
	
	@RequestMapping(value = "phone/{phoneid}", method = RequestMethod.GET )
	public ModelAndView updateDeletePhone(@PathVariable("phoneid")String phoneid){
		ModelAndView model = new ModelAndView("phoneUpdateDelete");
		Phone phoneDetails = pU.getObjectById(phoneid);
		model.addObject(phoneDetails);
		return model;
	}
	
	@RequestMapping(value="/phone/{phoneid}" ,method = RequestMethod.POST)
	public ModelAndView updatePhone(
											@PathVariable("phoneid") String phoneId,
											@RequestParam Map<String, String> req){
		System.out.println("Phone Results are Shown here ----------->"+ req.get("number") );
		System.out.println(req.get("userId"));
		System.out.println("update post");
		String selectedUser=  req.get("phoneUserElement");
		System.out.println("multiple user"+selectedUser);
		if(selectedUser == null)
		{
			pU.updatePhoneNoRemove(req.get("phoneNumber"), req.get("description"), req.get("title"), req.get("city"), req.get("state"), req.get("zip"), req.get("street"), req.get("userId"), phoneId);

		}
		else
		{
			pU.updatePhone(req.get("phoneNumber"), req.get("description"), req.get("title"), req.get("city"), req.get("state"), req.get("zip"), req.get("street"), req.get("userId"), req.get("phoneUserElement"), phoneId);
		}
		

		/*for (int i = 0; i < selectedUser.length(); i++ )
		{
			System.out.println(selectedUser[i]);
		}*/
		/*System.out.println("selectedd user"+req.get("phoneUserElement"));*/
		//pU.updatePhone(req.get("phoneNumber"), req.get("description"), req.get("title"), req.get("city"), req.get("state"), req.get("zip"), req.get("street"), req.get("userId"), req.get("phoneUserElement"), phoneId);
		//cU.update(firstname, lastname, title, city, state, zip, street, userId);
		ModelAndView model = new ModelAndView("successfulUserUpdate");
		return model;
	}
	
	@RequestMapping(value = "/phone/{phoneId}", method = RequestMethod.DELETE )
	public ModelAndView deleteUser(@PathVariable  String phoneId){
		System.out.println("Phone Deletion getting called in controller <<<< ------   here  ");
		pU.deleteObjectById(phoneId);
		ModelAndView model = new ModelAndView("successfulDeletion");
		
		return model;
	}
	
}
