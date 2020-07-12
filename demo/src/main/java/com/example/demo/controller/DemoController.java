package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserDetails;
import com.example.demo.repository.DemoRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/rest/demo")
public class DemoController {
	
	@Autowired
	DemoRepository demoRepository;
	
	/*
	 * private RedisTemplate<String, UserDetails> redisTemplate; private
	 * HashOperations hashOperations; private static final String KEY = "USER_KEY";
	 * 
	 * public DemoController(RedisTemplate<String, UserDetails> redisTemplate) {
	 * this.redisTemplate = redisTemplate; hashOperations =
	 * redisTemplate.opsForHash(); }
	 */
	
//	public DemoController(DemoRepository demoRepository) {
//		this.demoRepository = demoRepository;
//	}

	@HystrixCommand(fallbackMethod = "fallBack", commandKey = "demo", groupKey = "demo")
	@GetMapping("/display")
	public String display() {
		if(RandomUtils.nextBoolean()) {
			throw new RuntimeException("Failed");
		}
		return new String("Hello");
	}
	
	public String fallBack() {
		return "fall back initiated";
	}
	
	@GetMapping("/data/{name}")
	public ResponseEntity<List<String>> getData(@PathVariable("name") final String name) {
		List<String> list = null;
		if(name != null && name.equalsIgnoreCase("rudra")) {
			list = new ArrayList<String>();
			list.add("abc");
			list.add("zzz");
			list.add("xyz");
		} else {
			list = new ArrayList<>();
		}
		
		return ResponseEntity.ok(list);
	}
	
	/*
	 * @GetMapping("/save/{id}/{amount}") public ResponseEntity<UserDetails>
	 * saveData(@PathVariable("id") final String id, @PathVariable("amount") final
	 * Long amount) { demoRepository.save(new UserDetails(id, amount)); return
	 * ResponseEntity.ok(demoRepository.findById(id)); }
	 * 
	 * @GetMapping("update/{id}") public UserDetails update(@PathVariable("id")
	 * final String id) { demoRepository.update(new UserDetails(id, 10000L)); return
	 * demoRepository.findById(id); }
	 * 
	 * @GetMapping("/all") public Map<String, UserDetails> getAll() { throw new
	 * RuntimeException("Erroe runtime"); // return demoRepository.findAll(); }
	 * 
	 * @GetMapping("/delete/{id}") public Map<String, UserDetails>
	 * delete(@PathVariable("id") final String id) { demoRepository.delete(id);
	 * return getAll(); }
	 */
	
	@PostMapping("/save")
	public ResponseEntity<HttpStatus> saveData(@RequestBody UserDetails userDetails) {
		throw new RuntimeException("aava,hk,");
//		HttpStatus status = demoRepository.save(userDetails) != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
//		return ResponseEntity.ok(status);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Iterable<UserDetails>> getAll() {
		Iterable<UserDetails> list = demoRepository.findAll();
		return ResponseEntity.ok(list);
	}
	
	
}
