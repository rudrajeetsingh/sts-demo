package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserDetails;
import com.example.demo.repository.DemoRepository;

@RestController
@RequestMapping("/rest/demo")
public class DemoController {
	
	DemoRepository demoRepository;
	
	public DemoController(DemoRepository demoRepository) {
		this.demoRepository = demoRepository;
	}

	@GetMapping("/display")
	public String display() {
		return new String("Hello");
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
	
	@GetMapping("/save/{id}/{amount}")
	public ResponseEntity<UserDetails> saveData(@PathVariable("id") final String id, @PathVariable("amount") final Long amount) {
		demoRepository.save(new UserDetails(id, amount));
		return ResponseEntity.ok(demoRepository.findById(id));
	}
	
	@GetMapping("update/{id}")
	public UserDetails update(@PathVariable("id") final String id) {
		demoRepository.update(new UserDetails(id, 10000L));
		return demoRepository.findById(id);
	}
	
	@GetMapping("/all")
	public Map<String, UserDetails> getAll() {
//		return demoRepository.findAll();
		throw new RuntimeException("Dummy Exception...");
		
	}
	
	@GetMapping("/delete/{id}")
	public Map<String, UserDetails> delete(@PathVariable("id") final String id) {
		demoRepository.delete(id);
		return getAll();
	}
	
}
