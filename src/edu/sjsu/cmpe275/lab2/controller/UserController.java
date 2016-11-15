package edu.sjsu.cmpe275.lab2.controller;


import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.codehaus.jackson.*;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public ModelAndView updateDeleteUser(@PathVariable("userid")String userid){
		ModelAndView model = new ModelAndView("userUpdateDelete");
		User userDetails = cU.getObjectById(userid);
		model.addObject(userDetails);

		return model;
	}
	
	@RequestMapping(value = "userJ/{userid}", method = RequestMethod.GET )
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	    
	   
	    User user = entitymanager.find(User.class, userid);
	    ObjectMapper mapper = new ObjectMapper();
	    
	    
	    
		JSONArray jArray = new JSONArray();
		jArray = cU.getJsonById(userid);
		User userDetails = cU.getJsonById(userid);
		ModelAndView model = new ModelAndView("jsonUserDetails");
		model.addObject(jArray);
		return model;
	    
		User user = new User();
		  
		  //user = entitymanager.find(User.class, userid);
		  entitymanager.getTransaction().commit();
	      entitymanager.close( );
	      emfactory.close( );
		  String jsonInString = mapper.writeValueAsString(user);
		  return user;

		
	}*/
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST )
	public ModelAndView updateUser(@RequestParam("firstname") String firstname,
											@RequestParam("lastname") String lastname,
											@RequestParam("title") String title,
											@RequestParam("city") String city,
											@RequestParam("state") String state,
											@RequestParam("zip") String zip,
											@RequestParam("street") String street,
											@RequestParam("userId") String userId){
		System.out.println("user "+ userId );
		cU.update(firstname, lastname, title, city, state, zip, street, userId);
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

