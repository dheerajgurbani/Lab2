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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Phone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private String id;
    private String number; 
    private String description;
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
        name="Phone_User",
        joinColumns=@JoinColumn(name="Phone_ID", referencedColumnName="ID"),
        inverseJoinColumns=@JoinColumn(name="USER_ID", referencedColumnName="ID"))
    private List<User> user;
    @Embedded
    private Address address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<User> getUser() {
		return user;
	}
	public Phone() {
		super();
	}
	public Phone(String id, String number, String description, List<User> user, Address address) {
		super();
		this.id = id;
		this.number = number;
		this.description = description;
		this.user = user;
		this.address = address;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString()
	{
	return String.format(this.number);
	}
}
