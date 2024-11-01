package in.his_plans.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.his_plans.dto.PlanDto;
import in.his_plans.entity.PlanMaster;
import in.his_plans.repo.PlanMasterRepo;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanMasterRepo planMasterRepo;
	
	//Saving All the plans
	@Override
	public boolean savePlan(PlanDto planDto) {
		
		PlanMaster entity = new PlanMaster();
		
		BeanUtils.copyProperties(planDto, entity);
		
		entity.setActiveSw("Y");
		
		PlanMaster savedPlan = planMasterRepo.save(entity);
		
		return savedPlan.getPlanId() != null;
	}

	//Retriving All the Plans
	@Override
	public List<PlanDto> getPlans() {
		List<PlanMaster> entities = planMasterRepo.findAll();
		
		List<PlanDto> planDto = new ArrayList<>();
		
		entities.forEach(e -> {
			PlanDto dto = new PlanDto();
			BeanUtils.copyProperties(e, dto);
			planDto.add(dto);
		});
		return planDto;
	}

	//Use for edit the plan , show the specific plan using planId
	@Override
	public PlanDto getPlan(Integer planId) {
		PlanMaster entity = planMasterRepo.findById(planId).orElseThrow();
		
		PlanDto dto = new PlanDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public boolean updatePlan(Integer planId, String status) {
		PlanMaster entity = planMasterRepo.findById(planId).orElseThrow();
		
		entity.setActiveSw(status);
		
		planMasterRepo.save(entity);
		
		return true;
	}

}
