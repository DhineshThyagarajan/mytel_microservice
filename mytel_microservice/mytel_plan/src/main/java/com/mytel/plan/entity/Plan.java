package com.mytel.plan.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Plan {
	
	@Id
	@Column(name="plan_id",nullable=false)
	Integer planId;
	@Column(name="plan_name",nullable=false,length=50)
	String planName;
	@Column(name="local_rate",nullable=false)
	Integer localrate;
	@Column(name="national_rate",nullable=false)
	Integer nationalrate;

}
