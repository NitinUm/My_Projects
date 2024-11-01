package in.his_plans.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.his_plans.dto.PlanDto;
import in.his_plans.service.PlanService;

@RestController
public class PlanRestController {

	@Autowired
	private PlanService planService;
	
	private Logger logger = LoggerFactory.getLogger(PlanRestController.class);
	
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody PlanDto planDto){
		
		logger.info("Plan Save Process Start..");
		
		boolean savePlan = planService.savePlan(planDto);
		
		if(savePlan) {
			return new ResponseEntity<>("Plan Saved" , HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("Failed to Save", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("plans")
	public ResponseEntity<List<PlanDto>> getPlans(){
		List<PlanDto> plans = planService.getPlans();
		return new ResponseEntity<List<PlanDto>>(plans, HttpStatus.OK);
	}
	
	@GetMapping("plan/{planId}")
	public ResponseEntity<PlanDto> getPlan(@PathVariable("planId") Integer planId){
		PlanDto plan = planService.getPlan(planId);
		return new ResponseEntity<PlanDto>(plan, HttpStatus.OK);
	}
	
	@PutMapping("plan/{planId}/{activeSw}")
	public ResponseEntity<String> updatePlanStatus(@PathVariable("planId") Integer planId ,@PathVariable("activeSw") String activeSw){
		boolean status = planService.updatePlan(planId, activeSw);
		if(status) {
			return new ResponseEntity<String>("Plan Updated", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Update Failed" , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
