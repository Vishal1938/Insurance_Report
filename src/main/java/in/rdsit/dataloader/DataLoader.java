package in.rdsit.dataloader;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.rdsit.entity.CitizenPlan;
import in.rdsit.repo.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner{

	@Autowired
	private CitizenPlanRepository repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		CitizenPlan c1=new CitizenPlan();
		c1.setPlanName("TOM");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanSatatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlantEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmoutnt(5000.00);
		
		CitizenPlan c2=new CitizenPlan();
		c2.setPlanName("DICK");
		c2.setGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanSatatus("Denied");
		c2.setDenialReason("Rental Income");
		
		CitizenPlan c3=new CitizenPlan();
		c3.setPlanName("HARRY");
		c3.setGender("Male");
		c3.setPlanName("Cash");
		c3.setPlanSatatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setPlantEndDate(LocalDate.now().plusMonths(6));
		c3.setBenefitAmoutnt(5000.00);
		c3.setPlanTerminatedDate(LocalDate.now());
		c3.setTerminationReason("Employed");
		
		CitizenPlan c4=new CitizenPlan();
		c4.setPlanName("David");
		c4.setGender("Male");
		c4.setPlanName("Food");
		c4.setPlanSatatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlantEndDate(LocalDate.now().plusMonths(6));
		c4.setBenefitAmoutnt(4000.00);
		
		CitizenPlan c5=new CitizenPlan();
		c5.setPlanName("Robert");
		c5.setGender("Male");
		c5.setPlanName("Food");
		c5.setPlanSatatus("Denied");
		c5.setDenialReason("Property Income");
		
		CitizenPlan c6=new CitizenPlan();
		c6.setPlanName("Orlen");
		c6.setGender("Fe-Male");
		c6.setPlanName("Food");
		c6.setPlanSatatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		c6.setPlantEndDate(LocalDate.now().plusMonths(6));
		c6.setBenefitAmoutnt(5000.00);
		c6.setPlanTerminatedDate(LocalDate.now());
		c6.setTerminationReason("Employed");
		
		CitizenPlan c7=new CitizenPlan();
		c7.setPlanName("Charles");
		c7.setGender("Male");
		c7.setPlanName("Medical");
		c7.setPlanSatatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlantEndDate(LocalDate.now().plusMonths(6));
		c7.setBenefitAmoutnt(4000.00);
		
		CitizenPlan c8=new CitizenPlan();
		c8.setPlanName("Smith");
		c8.setGender("Male");
		c8.setPlanName("Medical");
		c8.setPlanSatatus("Denied");
		c8.setDenialReason("Property Income");
		
		CitizenPlan c9=new CitizenPlan();
		c9.setPlanName("Neel");
		c9.setGender("Male");
		c9.setPlanName("Medical");
		c9.setPlanSatatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().minusMonths(4));
		c9.setPlantEndDate(LocalDate.now().plusMonths(6));
		c9.setBenefitAmoutnt(5000.00);
		c9.setPlanTerminatedDate(LocalDate.now());
		c9.setTerminationReason("Govt Job");
		
		CitizenPlan c10=new CitizenPlan();
		c10.setPlanName("steve");
		c10.setGender("Male");
		c10.setPlanName("Employement");
		c10.setPlanSatatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlantEndDate(LocalDate.now().plusMonths(6));
		c10.setBenefitAmoutnt(5000.00);
		
		CitizenPlan c11=new CitizenPlan();
		c11.setPlanName("Moris");
		c11.setGender("Male");
		c11.setPlanName("Employement");
		c11.setPlanSatatus("Denied");
		c11.setDenialReason("Property Income");
		
		CitizenPlan c12=new CitizenPlan();
		c12.setPlanName("Gibs");
		c12.setGender("Fe-Male");
		c12.setPlanName("Employement");
		c12.setPlanSatatus("Terminated");
		c12.setPlanStartDate(LocalDate.now().minusMonths(4));
		c12.setPlantEndDate(LocalDate.now().plusMonths(6));
		c12.setBenefitAmoutnt(5000.00);
		c12.setPlanTerminatedDate(LocalDate.now());
		c12.setTerminationReason("Govt Job");
		
		List<CitizenPlan> list=Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
		
		repo.saveAll(list);
		
		
	}

}
