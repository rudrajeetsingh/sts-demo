package com.example.demo.model;

import java.io.Serializable;

public class UserDetails implements Serializable {

	private String id;
	private Long amount;
	
	public UserDetails(String id, Long amount) {
		super();
		this.id = id;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
}
