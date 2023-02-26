package com.mytel.familyfriend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mytel.familyfriend.dto.FamilyFriendDTO;
import com.mytel.familyfriend.service.FamilyFriendService;

@RestController
@CrossOrigin
public class FamilyFriendController {
	
	@Autowired
	FamilyFriendService famserv;
	
	@RequestMapping(value = "/customers/{phoneNo}/friends", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveFriend(@PathVariable Long phoneNo, @RequestBody FamilyFriendDTO friendDTO) {
		famserv.saveFriend(phoneNo, friendDTO);
	}

	// Fetches friend and family numbers of a given customer phoneNo
	@RequestMapping(value = "/customers/{phoneNo}/friends", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Long> getSpecificFriends(@PathVariable Long phoneNo) {
		return famserv.getSpecificFriends(phoneNo);
	}

}
