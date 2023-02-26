package com.mytel.calldetails.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.mytel.calldetails.dto.CallDetailsDTO;
import com.mytel.calldetails.entity.CallDetails;
import com.mytel.calldetails.repository.CallDetailsRepository;

@Service
public class CallDetailsService {
	
	@Autowired
	CallDetailsRepository callrepo;
	@Autowired
	ModelMapper modmap;
	
	public List<CallDetailsDTO> getCustomerCallDetails(@PathVariable long phoneNo) {


		List<CallDetails> callDetails = callrepo.findByCalledBy(phoneNo);
		List<CallDetailsDTO> callsDTO = new ArrayList<CallDetailsDTO>();

		for (CallDetails call : callDetails) {
			callsDTO.add(this.modmap.map(call, CallDetailsDTO.class));
		}

		return callsDTO;
	}

}
