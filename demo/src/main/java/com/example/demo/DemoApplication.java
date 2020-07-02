package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import com.example.demo.config.RedisProperties;
import com.example.demo.model.UserDetails;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
@EnableRedisRepositories
public class DemoApplication {
	
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

}
