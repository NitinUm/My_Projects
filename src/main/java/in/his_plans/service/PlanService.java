package in.his_plans.service;

import java.util.List;

import in.his_plans.dto.PlanDto;

public interface PlanService {

	public boolean savePlan(PlanDto planDto);
	
	public List<PlanDto> getPlans();
	
	public PlanDto getPlan(Integer planId);
	
	public boolean updatePlan(Integer planId , String status);
}
