package in.rdsit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.rdsit.binding.SearchRequest;
import in.rdsit.entity.CitizenPlan;
import in.rdsit.service.ReportServiceImpl;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {
	
	@Autowired
	ReportServiceImpl service;
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename=plans.xls");
		service.exportExcel(response);
	}
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment;filename=plans.pdf");
		service.exportPdf(response);
	}
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("searchResults", new SearchRequest());
		init(model);
		return "index";
	}
	@PostMapping("/search")
	public String searchRequest(@ModelAttribute("searchResult") SearchRequest request,Model model) {		
		List<CitizenPlan> plans=service.search(request);
		model.addAttribute("searchResults", plans);
		init(model);
		return "index";
	}
	
	
	public void init(Model model) {
		model.addAttribute("planNames",service.getPlanNames());
		model.addAttribute("planStatuses",service.getPlanStatus());
	}
}
