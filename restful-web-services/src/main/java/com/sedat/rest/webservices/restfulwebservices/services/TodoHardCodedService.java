package com.sedat.rest.webservices.restfulwebservices.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sedat.rest.webservices.restfulwebservices.model.Todo;

@Service
public class TodoHardCodedService implements TodoService {
	
	private static Map<String, List<Todo>> todosForUser = new HashMap<>();
	private static Long id = 0L;
	
	static {
		List<Todo> todos = new ArrayList<Todo>();
		String user = "sefo";
		todos.add(new Todo(++id, "Learn how to dance", new Date(), false));
		todos.add(new Todo(++id, "Learn how to code", new Date(), false));
		todos.add(new Todo(++id, "Learn how to sleep", new Date(), false));
		todosForUser.put(user, todos);		
	}
	
	public List<Todo> findTodos(String username){
		return todosForUser.get(username);
	}
	
	public Todo save(String username, Todo todo) {
		//means we dont have the todo yet
		if(todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++id);
			todosForUser.get(username).add(todo);
		}else {
			//we are updating the user's todo
			deleteTodo(username, todo.getId());
			todosForUser.get(username).add(todo);
		}
		return todo;
	}
	
	public boolean deleteTodo(String username, Long id) {
		boolean result = false;
		Todo todo = findById(username, id);
		if(todo != null) {
			todosForUser.get(username).remove(todo);
			result = true;
		}
		
		return result;
	}
	
	public Todo findById(String username, Long id) {
		for(Todo eachTodod : todosForUser.get(username)) {
			if(eachTodod.getId() == id) {
				return eachTodod;
			}
		}
		return null;
	}

}
