package in.rdsit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.rdsit.binding.SearchRequest;
import in.rdsit.entity.CitizenPlan;
import jakarta.servlet.http.HttpServletResponse;

@Service
public interface ReportService {
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean exportExcel(HttpServletResponse response) throws  Exception;
	
	public boolean exportPdf(HttpServletResponse response) throws  Exception;
	

}
