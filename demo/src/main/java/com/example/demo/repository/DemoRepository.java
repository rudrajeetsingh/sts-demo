package com.example.demo.repository;

import java.util.Map;

import com.example.demo.model.UserDetails;

public interface DemoRepository {

	void save(UserDetails user);
	UserDetails findById(String id);
	Map<String, UserDetails> findAll();
	void update(UserDetails user);
	void delete(String id);
	
}
