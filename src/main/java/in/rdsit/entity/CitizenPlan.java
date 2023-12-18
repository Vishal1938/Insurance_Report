package in.rdsit.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CitizenPlan_TBL")
public class CitizenPlan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cid;
	private String citizenName;
	private String planName;
	
	private String planStatus;
	
	private LocalDate planStartDate;
	
	private LocalDate plantEndDate;
	
	private LocalDate planTerminatedDate;
    private Double benefitAmoutnt;
	
	private String denialReason;
	
	private String terminationReason;
	
	private String gender;
	
	public String getPlanSatatus() {
		return planStatus;
	}

	public void setPlanSatatus(String planSatatus) {
		this.setPlanStatus(planSatatus);
	}
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCitizenName() {
		return citizenName;
	}

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public LocalDate getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(LocalDate planStartDate) {
		this.planStartDate = planStartDate;
	}

	public LocalDate getPlantEndDate() {
		return plantEndDate;
	}

	public void setPlantEndDate(LocalDate plantEndDate) {
		this.plantEndDate = plantEndDate;
	}

	public LocalDate getPlanTerminatedDate() {
		return planTerminatedDate;
	}

	public void setPlanTerminatedDate(LocalDate planTerminatedDate) {
		this.planTerminatedDate = planTerminatedDate;
	}

	public Double getBenefitAmoutnt() {
		return benefitAmoutnt;
	}

	public void setBenefitAmoutnt(Double benefitAmoutnt) {
		this.benefitAmoutnt = benefitAmoutnt;
	}

	public String getDenialReason() {
		return denialReason;
	}

	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}

	public String getTerminationReason() {
		return terminationReason;
	}

	public void setTerminationReason(String terminationReason) {
		this.terminationReason = terminationReason;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	
}
