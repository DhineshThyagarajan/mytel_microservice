package com.mytel.plan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytel.plan.dto.PlanDTO;
import com.mytel.plan.entity.Plan;
import com.mytel.plan.repository.Planrepository;
@Service
public class PlanService {
	
	
	@Autowired
	Planrepository planrepo;
	@Autowired
	ModelMapper modmap;
	
	public List <PlanDTO> getAllplans(){
		
		List<Plan> plans = planrepo.findAll();
		List<PlanDTO> planDTOs = new ArrayList<>();

		for (Plan plan : plans) {
			PlanDTO planDTO = this.modmap.map(plan,PlanDTO.class);
			planDTOs.add(planDTO);
		}

		return planDTOs;
		
	}
	public PlanDTO getSpecificPlan(int planId) {
		Optional<Plan> id = this.planrepo.findById(planId);
		return this.modmap.map(id,PlanDTO.class);
	}

}
