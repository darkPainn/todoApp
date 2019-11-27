package com.sedat.rest.webservices.restfulwebservices.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sedat.rest.webservices.restfulwebservices.model.User;

@Repository
@Transactional
public class UserDAOService {
	
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	public long insertUser(User user) {
//		entityManager.persist(user);
//		return user.getId();
//	}
}
