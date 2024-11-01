package in.his_plans.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "PLANS")
public class PlanMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer planId;
	
	private String planName;
	
	private LocalDate planStartDate;
	
	private LocalDate planEndDate;
	
	private String activeSw;
	
	private String comments;
	
	@CreationTimestamp
	private LocalDate createdDate;
	
	@CreationTimestamp
	private LocalDate updatedDate;
	
	private Integer createdBy;
	
	private Integer updatedBy;

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public LocalDate getStartDate() {
		return planStartDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.planStartDate = startDate;
	}

	public LocalDate getEndDate() {
		return planEndDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.planEndDate = endDate;
	}

	public String getActiveSw() {
		return activeSw;
	}

	public void setActiveSw(String activeSw) {
		this.activeSw = activeSw;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
