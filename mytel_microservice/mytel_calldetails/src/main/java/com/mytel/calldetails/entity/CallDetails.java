package com.mytel.calldetails.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CallDetails {
	
	@Id
	@GeneratedValue
	long id;
	@Column(nullable = false)
	long calledBy;
	@Column(nullable = false)
	long calledTo;
	@Column(nullable = false)
	Date calledOn;
	@Column(nullable = false)
	int duration;

}
