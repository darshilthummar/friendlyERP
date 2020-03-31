package com.essyerp.erp.service;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.essyerp.erp.model.customer.CustomerModel;
import com.essyerp.erp.repo.CustomerRepo;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

@Service
public class UserServiceReport {

	@Autowired
	private CustomerRepo customerRepo;
	
	
	public String exportReport(String reportFormat,HttpServletResponse response) throws JRException, IOException
	{
		List<CustomerModel> customerModel =   customerRepo.findAll();
		
		
		File file = ResourceUtils.getFile( "classpath:static/assets/student.jrxml");
		
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(customerModel);
		
		Map<String,Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Friendly ERP"); 
		
		JasperPrint jasperPrint = JasperFillManager.fillReport( jasperReport , parameters, datasource);
		
		if(reportFormat.equalsIgnoreCase("xls")) {
			
			response.setContentType( "application/xls" );
			response.setHeader("Content-disposition",
	                  "attachment; filename=" +
	                  "user.xls" );
					
			OutputStream outputStream = response.getOutputStream();
			JRXlsExporter exporter = new JRXlsExporter();
			exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,outputStream);
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.FALSE);
			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
			exporter.exportReport();
			outputStream.close();
		//	JasperExportManager.exportReportToHtmlFile(jasperPrint, "/Users/patelyash/Desktop/untitledfolder"+"/student.html"); 
		}
		if(reportFormat.equalsIgnoreCase("pdf")) {
			
			response.setContentType( "application/pdf" );
//			response.setHeader("Content-disposition",
//			                  "attachment; filename=" +
//			                  "user.pdf" );
			OutputStream outputStream = response.getOutputStream();
			
			
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
 			outputStream.close();
			
			//JasperExportManager.exportReportToPdfFile(jasperPrint, "/Users/patelyash/Desktop/untitledfolder"+"/student3.pdf");
		}
		

		return "/index";
		
	}
	
}
