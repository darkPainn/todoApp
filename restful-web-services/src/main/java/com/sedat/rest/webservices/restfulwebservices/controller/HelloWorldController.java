package com.sedat.rest.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sedat.rest.webservices.restfulwebservices.model.HelloWorldBean;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class HelloWorldController {
	
	@GetMapping(path="/hello-world")
	public String sayHello() {
		return "Hello world";
	}
	
	@GetMapping(path="hello-world-bean")
	public HelloWorldBean getBean() {
		return new HelloWorldBean("hello world");
	}
	
	@GetMapping(path="hello-world/{name}")
	public HelloWorldBean getBeanWithName(@PathVariable("name") String name) {
		//throw new RuntimeException("Server is down");
		return new HelloWorldBean(String.format("Hello %s", name));
	}

}
