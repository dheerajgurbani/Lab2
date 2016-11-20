package edu.sjsu.cmpe275.lab2.controller;


import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	public ModelAndView updateDeleteUser(@PathVariable("userid")String userid,
			HttpServletResponse httpRes){
		ModelAndView model = null;
		User userDetails = cU.getObjectById(userid);
		System.out.println("USer Detais NULL -->              "+userDetails);
		
		//System.out.println("USer Detais along with ID -->              "+userDetails.getId());
		if(userDetails==null){
			System.out.print("Eror page coming SEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
			httpRes.setStatus( HttpServletResponse.SC_NOT_FOUND);
			 model = new ModelAndView("errorPage");
			 model.addObject("givenid", userid);
		}else{
			System.out.println("USer Detais along with ID -->              "+userDetails.getId());
			 model = new ModelAndView("userUpdateDelete");
			model.addObject(userDetails);
			
		}
		return model;
	}
	
	@RequestMapping(value = "user/{userid}"+"json=true", method = RequestMethod.GET )
	public ModelAndView jsonUser(@PathVariable("userid")String userid){
		
		ObjectMapper mapper = new ObjectMapper();
		User user = cU.getJsonById(userid);
		String jsonString = null;
		
		try {
		jsonString = mapper.writeValueAsString(user);
		System.out.println(jsonString);
		}
		 catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		ModelAndView model = new ModelAndView("jsonUserDetails");
		model.addObject("userdetails", jsonString);
		return model;
	}

	//@RequestMapping(value = "/updateUser", method = RequestMethod.POST )
	@RequestMapping(value="/user/{userid}" ,method = RequestMethod.POST)
	public ModelAndView updateUser(@PathVariable("userid") String userId,@RequestParam Map<String, String> req){
		System.out.println("Results are Shown here ----------->"+ req.get("firstname") );
		cU.update(req.get("firstname"), req.get("lastname"), req.get("title"), req.get("city"), req.get("state"), req.get("zip"), req.get("street"), userId);
		//cU.update(firstname, lastname, title, city, state, zip, street, userId);
		//ModelAndView model = new ModelAndView("successfulUserUpdate");
		//return model;
/*		return new ModelAndView("redirect:" + "/user/{userid}");
*/		ModelAndView model = new ModelAndView("afterUserUpdate");
		User userDetails = cU.getObjectById(userId);
		
		model.addObject(userDetails);
		return model;
		}
	
	/*@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE )
	public String deleteUser(@PathVariable("userId")  String userId){
		
		System.out.println(userId +"i delete  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		cU.deleteObjectById(userId);
		
		//ModelAndView model = new ModelAndView("successfulDeletion");
		
		return "user";
	}*/
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE )
	public String deleteUser(@PathVariable("userId")  String userId){
		
		System.out.println(userId +"i delete  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		cU.deleteObjectById(userId);
		
		//ModelAndView model = new ModelAndView("successfulDeletion");
		
		return "user";
	}
	
	
	
}

