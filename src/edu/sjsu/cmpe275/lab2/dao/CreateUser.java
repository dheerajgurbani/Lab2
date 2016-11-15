package edu.sjsu.cmpe275.lab2.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.sjsu.cmpe275.lab2.model.Address;
import edu.sjsu.cmpe275.lab2.model.User;

import org.json.simple.*;

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
	      
	      address.setState(state);
	      address.setStreet(street);
	      address.setZip(zip);
	      address.setCity(city);
	      user.setAddress(address);

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

     entitymanager.persist( user );
     entitymanager.getTransaction( ).commit( );
     entitymanager.close( );
     emfactory.close( );
	 return user;
	}

	public void update(String firstname, String lastname, String title, String city, String state, String zip,
			String street, String userId) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	      
	      Address address = new Address( ); 
		  User user = new User();
		
		user = entitymanager.find(User.class, userId);
		
		  user.setFirstname(firstname);
	      user.setLastname(lastname);
	      user.setTitle(title);
	      address.setState(state);
	      address.setStreet(street);
	      address.setZip(zip);
	      address.setCity(city);
	      user.setAddress(address);
	      
	      entitymanager.getTransaction().commit();
	      entitymanager.close( );
	      emfactory.close( );	
	}

	public void deleteObjectById(String userId, String addressId) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	      
	      Address address = new Address( ); 
		  User user = new User();
		  
		  user = entitymanager.find(User.class, userId);
		  address = entitymanager.find(Address.class, addressId);
		 
		  entitymanager.getTransaction().begin();
		  entitymanager.remove(user);
		  entitymanager.remove(address);
		  entitymanager.getTransaction().commit();
		
	}

	public User getJsonById(String userid) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	      
	      Address address = new Address( ); 
		  User user = new User();
		  
		  user = entitymanager.find(User.class, userid);
		  	entitymanager.persist( user );
		     entitymanager.getTransaction( ).commit( );
		     entitymanager.close( );
		     emfactory.close( );
		  	return user;
	}

	
}

