/*
 * package com.example.demo.repository.impl;
 * 
 * import java.util.Map; import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.data.redis.core.HashOperations; import
 * org.springframework.data.redis.core.RedisTemplate; import
 * org.springframework.data.repository.CrudRepository; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.stereotype.Repository;
 * 
 * import com.example.demo.model.UserDetails; import
 * com.example.demo.repository.DemoRepository;
 * 
 * @Repository public class DemoRepositoryImpl {
 * 
 * @Autowired DemoRepository demoRepository;
 * 
 * private RedisTemplate<String, UserDetails> redisTemplate; private
 * HashOperations hashOperations;
 * 
 * private static final String KEY = "USER1";
 * 
 * public DemoRepositoryImpl(RedisTemplate<String, UserDetails> redisTemplate) {
 * this.redisTemplate = redisTemplate;
 * 
 * hashOperations = redisTemplate.opsForHash(); }
 * 
 * public HttpStatus saveData(UserDetails userDetails) { HttpStatus status =
 * demoRepository.save(userDetails) != null ? HttpStatus.OK :
 * HttpStatus.BAD_REQUEST; return status; }
 * 
 * @Override
 * 
 * public void save(UserDetails user) { hashOperations.put(KEY, user.getId(),
 * user);
 * 
 * }
 * 
 * @Override public UserDetails findById(String id) { return (UserDetails)
 * hashOperations.get(KEY, id); }
 * 
 * @Override public Map<String, UserDetails> findAll() { return
 * hashOperations.entries(KEY); }
 * 
 * 
 * 
 * @Override public void update(UserDetails user) { save(user); }
 * 
 * 
 * 
 * @Override public void delete(String id) { hashOperations.delete(KEY, id); }
 * 
 * 
 * 
 * 
 * 
 * }
 */