package com.mytel.calldetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mytel.calldetails.dto.CallDetailsDTO;
import com.mytel.calldetails.service.CallDetailsService;

@RestController
@CrossOrigin
public class CallDetailsController {
	
	@Autowired
	CallDetailsService callserv;
	
	
	@RequestMapping(value = "/customers/{phoneNo}/calldetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CallDetailsDTO> getCustomerCallDetails(@PathVariable long phoneNo) {
		return callserv.getCustomerCallDetails(phoneNo);
	}


}
