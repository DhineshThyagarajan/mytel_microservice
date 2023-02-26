package com.mytel.familyfriend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class FamilyFriend {
	
	@Id
	@GeneratedValue
	int id;
	@Column(name = "phone_no")
	long phoneNo;
	@Column(name = "friend_and_family")
	long friendAndFamily;

}
