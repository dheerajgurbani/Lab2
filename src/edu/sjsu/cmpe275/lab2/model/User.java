package edu.sjsu.cmpe275.lab2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private String id;
    private String firstname;
    private String lastname;
    private String title;
    @Embedded
    private Address address;
    @ManyToMany(mappedBy="user", fetch=FetchType.LAZY) 
   private List<Phone> phones;
	public User() {
	}
	public User(String id, String firstname, String lastname, String title, Address address, List<Phone> phones) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.title = title;
		this.address = address;
		this.phones = phones;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	@Override
	public String toString()
	{
	return String.format(this.id);
	}

}
