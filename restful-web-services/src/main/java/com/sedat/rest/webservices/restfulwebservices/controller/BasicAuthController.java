package com.sedat.rest.webservices.restfulwebservices.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.sedat.rest.webservices.restfulwebservices.model.User;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthController {
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User("sefo", "123"));
		users.add(new User("fifo","hot"));
	}
	
	@GetMapping("/basicauth")
	public Response basicAuthenticate() {
		return null;
	}
	
//	@GetMapping("/basicauth")
//	public Response basicAuthenticate(@RequestHeader("username") String username, @RequestHeader("password") String password) {
//		System.out.println(username + password);
//		boolean result = false;
//		for(User eachUser : users) {
//			String curusername = eachUser.getUsername();
//			String curpassword = eachUser.getPassword();
//			if(curusername.equals(username) && curpassword.equals(password)) {
//				result = true;
//			}
//		}		
//		if(result) {
//			return Response.ok().build();
//		}else {
//			return Response.status(401).build();
//		}
//	}

}
