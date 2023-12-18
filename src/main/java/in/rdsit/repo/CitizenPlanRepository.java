package in.rdsit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.rdsit.entity.CitizenPlan;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Integer> {
	
	@Query("SELECT DISTINCT cp.planName FROM CitizenPlan cp")
	public List<String> getPlanNames();
	
	@Query("SELECT DISTINCT cp.planStatus FROM CitizenPlan cp")
	public List<String> getPlanStatus();

}
