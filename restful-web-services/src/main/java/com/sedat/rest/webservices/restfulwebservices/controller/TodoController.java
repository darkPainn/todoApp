package com.sedat.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sedat.rest.webservices.restfulwebservices.model.Todo;
import com.sedat.rest.webservices.restfulwebservices.services.TodoHardCodedService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoController {
	//ALL THE RETURNS HERE ARE FOLLOWING THE REST STANDARDS IN TERMS OF WHAT SHOULF BE RETURNED WHEN THOSE ACTIONS PUT POST ETC HAPPENS
	
	
	@Autowired
	private TodoHardCodedService todoService;
	
	//get all the todos
	@GetMapping("/users/{username}/todos")
	public List<Todo> getTodos(@PathVariable("username") String username){
		return this.todoService.findTodos(username);
	}
	
	//get a single todo by id and username
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable("username") String username, @PathVariable("id") Long id){
		return this.todoService.findById(username, id);
	}
	
	//update a todo
	@PutMapping("/users/{username}/todos/")
	public Response updateTodo(
			@PathVariable("username") String username,
			@RequestBody Todo todo) {
		return Response.ok(this.todoService.save(username, todo)).build();
	}
	
	//create a todo
	@PostMapping("/users/{username}/todos")
	public Response createTodo(@PathVariable("username") String username, @RequestBody Todo todo) {
		Todo createdTodo = this.todoService.save(username, todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdTodo.getId()).toUri();
		return Response.ok(uri).build();
	}
	
	//delete a todo
	@DeleteMapping("/users/{username}/todos/{id}")
	public Response deleteTodo(@PathVariable("username") String username, @PathVariable("id") Long id) {
		if(this.todoService.deleteTodo(username, id)) {
			return Response.ok().build();
		}
		return Response.notModified().build();
	}	
	
	

}
