package in.rdsit.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.rdsit.entity.CitizenPlan;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {

	public void generate(HttpServletResponse response,List<CitizenPlan> plans,File f) throws Exception {
		
		// Creating the Object of Document
		Document document = new Document(PageSize.A4);

		// Getting instance of PdfWriter
		PdfWriter pdfWriter=PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		
		// Creating font
				// Setting font style and size
				Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
				fontTitle.setSize(20);


		// Opening the created document to modify it
		document.open();
		Paragraph paragraph = new Paragraph("Citizen Plan info",fontTitle);
		//Adding the created paragraph in document
		document.add(paragraph);
		// Creating a table of 3 columns
		PdfPTable table = new PdfPTable(6);
		table.addCell("ID");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Plan startDate");
		table.addCell("Plan EndDate");
		

		for(CitizenPlan plan :plans) {
		table.addCell(String.valueOf(plan.getCid()));
		table.addCell(plan.getCitizenName());
		table.addCell(plan.getPlanName());
		table.addCell(plan.getPlanSatatus());
		table.addCell(plan.getPlanStartDate()+"");
		table.addCell(plan.getPlantEndDate()+"");
		
		}
		document.add(table);

		document.close();
		
	}
}
