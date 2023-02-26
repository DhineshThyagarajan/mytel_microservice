package com.mytel.customer.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {
	
	@Id
	@Column(name = "phone_no", nullable = false)
	Long phoneNo;
	@Column(nullable = false, length = 50)
	String name;
	@Column(nullable = false)
	Integer age;
	@Column(nullable = false, length = 50)
	String address;
	@Column(nullable = false, length = 50)
	String password;
	@Column(nullable = false, length = 1)
	char gender;
	@Column(name="plan_id",nullable = false)
	Integer planId;
	
	public Customer() {
		super();
	}
	
	
}
