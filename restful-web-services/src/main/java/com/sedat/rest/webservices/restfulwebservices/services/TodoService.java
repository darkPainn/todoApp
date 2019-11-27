package com.sedat.rest.webservices.restfulwebservices.services;

import java.util.List;

import com.sedat.rest.webservices.restfulwebservices.model.Todo;

public interface TodoService {
	
	public List<Todo> findTodos(String username);
	
	public Todo save(String username, Todo todo);
	
	public boolean deleteTodo(String username, Long id);
	
	public Todo findById(String username, Long id);

}
