package in.rdsit.service;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import in.rdsit.binding.SearchRequest;
import in.rdsit.entity.CitizenPlan;
import in.rdsit.repo.CitizenPlanRepository;
import in.rdsit.util.Emailutils;
import in.rdsit.util.ExcelGenerator;
import in.rdsit.util.PdfGenerator;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private CitizenPlanRepository repo;
	@Autowired
	private Emailutils eutils;
	@Autowired
	private ExcelGenerator generator;
	@Autowired
	private PdfGenerator pdfGenerate;

	@Override
	public List<String> getPlanNames() {
		// TODO Auto-generated method stub
		return repo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		// TODO Auto-generated method stub
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		// TODO Auto-generated method stub
		CitizenPlan entity=new CitizenPlan();
		if(null !=request.getPlanName() || "" !=request.getPlanName()) {
			entity.setPlanName(request.getPlanName());
		}
		if(null !=request.getPlanstatus() || "" !=request.getPlanstatus()) {
			entity.setPlanSatatus(request.getPlanstatus());
		}
		if(null !=request.getGender() || "" !=request.getGender()) {
			entity.setGender(request.getGender());
		}
		if(null !=request.getPlanStartDate()) {
			LocalDate startDate=request.getPlanStartDate();
			entity.setPlanStartDate(startDate);
		}
		if(null !=request.getPlanEndDate()) {
			LocalDate endDate=request.getPlanEndDate();
			entity.setPlantEndDate(endDate);
		}
		
		return repo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		File f=new File("plans.xls");
		List<CitizenPlan> records=repo.findAll();
		
		generator.generate(response, records, f);
		String subject="Test mailSubject";
		String to="SinghVishal35038@gmail.com";
		String body="<h1> This is the Plan-info</h2>";
		
		eutils.sendMail(to, subject, body, f);
		f.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		        
		        File f=new File("plans.pdf");
		
				List<CitizenPlan> records=repo.findAll();
				pdfGenerate.generate(response, records,f);
				String subject="Test mail Subject";
				String to="singhvishal35038@gmail.com";
				String body="<h1> This is the Plan-info</h2>";
				eutils.sendMail(to, subject, body, f);
				f.delete();
		return true;
	}

}
