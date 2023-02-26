package com.mytel.calldetails.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CallDetailsDTO {

	long calledBy;
	long calledTo;
	Date calledOn;
	int duration;
}
