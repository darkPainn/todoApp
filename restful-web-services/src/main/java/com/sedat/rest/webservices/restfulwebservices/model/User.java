package com.sedat.rest.webservices.restfulwebservices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

//@Entity
public class User {
	
	//@GeneratedValue
	private long id;
	private String username;
	private String password;
	
	public User() {
		
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public long getId() {
		return this.id;
	}

}
