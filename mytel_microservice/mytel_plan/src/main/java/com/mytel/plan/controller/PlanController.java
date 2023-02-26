package com.mytel.plan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mytel.plan.dto.PlanDTO;
import com.mytel.plan.service.PlanService;

@RestController
@CrossOrigin
public class PlanController {

	@Autowired
	PlanService planser;
	
	@GetMapping(value ="/plans", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PlanDTO> getAllPlans() {
		return planser.getAllplans();
	}
	
	@RequestMapping(value = "/plans/{planId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PlanDTO getSpecificPlans(@PathVariable Integer planId) {
		return planser.getSpecificPlan(planId);
	}
	
}
