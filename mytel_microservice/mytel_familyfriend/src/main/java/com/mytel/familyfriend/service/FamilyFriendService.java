package com.mytel.familyfriend.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytel.familyfriend.dto.FamilyFriendDTO;
import com.mytel.familyfriend.entity.FamilyFriend;
import com.mytel.familyfriend.repository.FamilyFriendRepository;

@Service
public class FamilyFriendService {
	
	@Autowired
	FamilyFriendRepository famrepo;
	
	@Autowired
	ModelMapper modmap;
	
	
	public void saveFriend(Long phoneNo, FamilyFriendDTO friendDTO) {
		friendDTO.setPhoneNo(phoneNo);
		FamilyFriend friend = this.modmap.map(friendDTO,FamilyFriend.class);
		famrepo.save(friend);
	

}
	public List<Long> getSpecificFriends(Long phoneNo){
		List<Long> friendList= new ArrayList<Long>();
		List<FamilyFriend> friends=famrepo.getByPhoneNo(phoneNo);
		for (FamilyFriend friendFamily : friends) {
			friendList.add(friendFamily.getFriendAndFamily());
		}
		return friendList;
	}

	
	
}
