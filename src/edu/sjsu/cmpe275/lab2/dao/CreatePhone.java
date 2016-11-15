package edu.sjsu.cmpe275.lab2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import edu.sjsu.cmpe275.lab2.model.Address;
import edu.sjsu.cmpe275.lab2.model.Phone;

public class CreatePhone {
	public void insert(String number, String description, String city, String state, String zip, String street) {
		EntityManagerFactory emfactory =  Persistence.createEntityManagerFactory( "275_lab2" );
		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		Phone phn = new Phone();
		phn.setNumber(number);
		phn.setDescription(description);
		Address addr = new Address();
		addr.setCity(city);
		addr.setState(state);
		addr.setStreet(street);
		addr.setZip(zip);
		phn.setAddress(addr);
		entitymanager.persist( addr );
	    entitymanager.persist( phn );
	    entitymanager.getTransaction( ).commit( );
	    entitymanager.close( );
	    emfactory.close( );
	}
	
	public Phone getObjectById(String phoneid) {
	      
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "275_lab2" );
	    EntityManager entitymanager = emfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	      
	      Address address = new Address( ); 
		  Phone phone = new Phone();
	   
	 phone = entitymanager.find(Phone.class, phoneid);	
	 entitymanager.persist( address );
     entitymanager.persist( phone );
     entitymanager.getTransaction( ).commit( );
     entitymanager.close( );
     emfactory.close( );
	 return phone;
	}
	
	
}
