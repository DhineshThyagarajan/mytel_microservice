package com.mytel.customer.dto;

import java.util.List;

import com.mytel.customer.entity.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
	
	
	long phoneNo;
	String name;
	int age;
	char gender;
	List<Long> friendAndFamily;
	String password;
	String address;
	PlanDTO currentPlan;


	// Converts Entity into DTO
	public static CustomerDTO valueOf(Customer cust) {
		CustomerDTO custDTO = new CustomerDTO();
		custDTO.setAge(cust.getAge());
		custDTO.setGender(cust.getGender());
		custDTO.setName(cust.getName());
		custDTO.setPhoneNo(cust.getPhoneNo());
		custDTO.setAddress(cust.getAddress());
		PlanDTO planDTO = new PlanDTO();
		planDTO.setPlanId(cust.getPlanId());
		custDTO.setCurrentPlan(planDTO);
		custDTO.setCurrentPlan(planDTO);
		return custDTO;
	}

	// Converts DTO into Entity
	public Customer createEntity() {
		Customer cust = new Customer();
		cust.setAge(this.getAge());
		cust.setGender(this.getGender());
		cust.setName(this.getName());
		cust.setPhoneNo(this.getPhoneNo());
		cust.setAddress(this.getAddress());
		cust.setPassword(this.getPassword());
		cust.setPlanId(this.getCurrentPlan().planId);
		return cust;
	}


}

