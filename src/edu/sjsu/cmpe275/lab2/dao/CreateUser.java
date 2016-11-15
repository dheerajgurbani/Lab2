package edu.sjsu.cmpe275.lab2.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.sjsu.cmpe275.lab2.model.Address;
import edu.sjsu.cmpe275.lab2.model.User;

public class CreateUser {	
	public void insert(String firstname, String lastname, String title, String city, String state, String zip, String street) {
		// TODO Auto-generated method stub
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
	      
	      EntityManager entitymanager = emfactory.createEntityManager( );
	      entitymanager.getTransaction( ).begin( );
	      
	      Address address = new Address( ); 
	      User user = new User();
	      user.setFirstname(firstname);
	      user.setLastname(lastname);
	      user.setTitle(title);
	      address.setCity(city);
	      address.setState(state);
	      address.setStreet(street);
	      address.setZip(zip);
	      user.setAddress(address);
	      entitymanager.persist( address );
	      entitymanager.persist( user );
	      entitymanager.getTransaction( ).commit( );
	      entitymanager.close( );
	      emfactory.close( );
	}
	public User getObjectById(String userid) {
	      
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	      
	      Address address = new Address( ); 
		  User user = new User();
	   
	 user = entitymanager.find(User.class, userid);	
	 entitymanager.persist( address );
     entitymanager.persist( user );
     entitymanager.getTransaction( ).commit( );
     entitymanager.close( );
     emfactory.close( );
	 return user;
	}
}