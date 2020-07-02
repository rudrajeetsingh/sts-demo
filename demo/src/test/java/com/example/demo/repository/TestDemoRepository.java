package com.example.demo.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.config.TestRedisConfiguration;
import com.example.demo.model.UserDetails;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestRedisConfiguration.class)
public class TestDemoRepository {
	
	@Autowired
	DemoRepository demoRepository;
	
	@Test
	public void testSave() {
//		UserDetails userDetails = new UserDetails("001", 23000L);
		UserDetails user = demoRepository.findById("1");
		assertNotNull(user);
		
	}
	
	

}
