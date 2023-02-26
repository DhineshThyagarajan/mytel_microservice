package com.mytel.customer.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanDTO {

    Integer planId;
	
	String planName;

	Integer nationalRate;

	Integer localRate;
	
}
