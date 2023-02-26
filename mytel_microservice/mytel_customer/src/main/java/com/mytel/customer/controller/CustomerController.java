package com.mytel.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mytel.customer.dto.CustomerDTO;
import com.mytel.customer.dto.LoginDTO;
import com.mytel.customer.dto.PlanDTO;
import com.mytel.customer.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {


	@Autowired
	CustomerService custService;
	
	@Value("${friend.uri}")
	String friendUri;

	@Value("${path.uri}")
	String pathUri;

	
	// Create a new customer
	@RequestMapping(value = "/customers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createCustomer(@RequestBody CustomerDTO custDTO) {
		custService.createCustomer(custDTO);
	}

	// Login
	@RequestMapping(value = "/login", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@RequestBody LoginDTO loginDTO) {
		return custService.login(loginDTO);
	}

	// Fetches full profile of a specific customer
	@RequestMapping(value = "/customers/{phoneNo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO getCustomerProfile(@PathVariable Long phoneNo) {
		CustomerDTO custDTO=custService.getCustomerProfile(phoneNo);
		PlanDTO planDTO=new RestTemplate().getForObject(pathUri+custDTO.getCurrentPlan().getPlanId(), PlanDTO.class);
		custDTO.setCurrentPlan(planDTO);
		
		@SuppressWarnings("unchecked")
		List<Long> friends=new RestTemplate().getForObject(friendUri+phoneNo+"/friends", List.class);
		custDTO.setFriendAndFamily(friends);
		return custDTO;
	}

	
}
