package com.sedat.rest.webservices.restfulwebservices.model;

public class HelloWorldBean {
	
	private String message = "Hello world bean";

	public HelloWorldBean(String format) {
		this.message = format;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}
	
	

}
