package com.mytel.familyfriend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mytel.familyfriend.entity.FamilyFriend;

public interface FamilyFriendRepository extends JpaRepository <FamilyFriend,Integer> {
	
	List<FamilyFriend> getByPhoneNo(Long phoneNo);

}
