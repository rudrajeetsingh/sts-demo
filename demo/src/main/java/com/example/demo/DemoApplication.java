package com.example.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import com.example.demo.config.RedisProperties;
import com.example.demo.model.UserDetails;

import redis.embedded.RedisServer;
@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
@EnableRedisRepositories
public class DemoApplication {
	
	private RedisServer redisServer;
	
	@Bean
	LettuceConnectionFactory lettuceConnectionFactory(RedisProperties redisProperties) {
		return new LettuceConnectionFactory(redisProperties.getRedisHost(), redisProperties.getRedisPort());
	}
	
	@Bean
	RedisTemplate<String, UserDetails> redisTemplate(LettuceConnectionFactory connectionFactory) {
		RedisTemplate<String, UserDetails> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		return redisTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	public DemoApplication(RedisProperties redisProperties) {
		this.redisServer = new RedisServer(redisProperties.getRedisPort());
	}
	
	@PostConstruct 
	public void postConstruct() { 
		redisServer.start(); 
	}
	
	@PreDestroy
	public void preDestroy() {
		redisServer.stop();
	}

}
