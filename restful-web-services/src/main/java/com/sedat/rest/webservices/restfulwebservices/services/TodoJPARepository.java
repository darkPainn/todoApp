package com.sedat.rest.webservices.restfulwebservices.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sedat.rest.webservices.restfulwebservices.model.Todo;

//first parameter is telling which entity we are managing and second is what is the primary key <Todo, Long>
@Repository
public interface TodoJPARepository extends JpaRepository<Todo, Long>{
	
	//it is very important that the column name actyually exists in the table
	List<Todo> findByDescription(String description);

}
