package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.UserDetails;

public interface DemoRepository extends CrudRepository<UserDetails, String>{

	/*
	 * void save(UserDetails user); UserDetails findById(String id); Map<String,
	 * UserDetails> findAll(); void update(UserDetails user); void delete(String
	 * id);
	 */
	
	
}
