package com.mytel.customer.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
	long phoneNo;
	String name;
	int age;
	char gender;
	List<Long> friendAndFamily;
	String password;
	String address;
	PlanDTO currentPlan;

}
