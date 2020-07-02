package com.example.demo.repository.impl;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserDetails;
import com.example.demo.repository.DemoRepository;

@Repository
public class DemoRepositoryImpl implements DemoRepository {

	private RedisTemplate<String, UserDetails> redisTemplate;
	private HashOperations hashOperations;
	
	private static final String KEY = "USER1";
	
	public DemoRepositoryImpl(RedisTemplate<String, UserDetails> redisTemplate) {
		this.redisTemplate = redisTemplate;
		
		hashOperations = redisTemplate.opsForHash();
	}
	
	@Override
	public void save(UserDetails user) {
		hashOperations.put(KEY, user.getId(), user);

	}

	@Override
	public UserDetails findById(String id) {
		return (UserDetails) hashOperations.get(KEY, id);
	}

	@Override
	public Map<String, UserDetails> findAll() {
		return hashOperations.entries(KEY);
	}

	@Override
	public void update(UserDetails user) {
		save(user);
	}

	@Override
	public void delete(String id) {
		hashOperations.delete(KEY, id);
	}

}
