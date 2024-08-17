package com.jspiders.springbootproject.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Adhar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long adharnumber;
	private String location;
	private long contact;
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public long getAdharnumber() {
		return adharnumber;
	}
	public void setAdharnumber(long adharnumber) {
		this.adharnumber = adharnumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	
	
	
	
	
	
}
