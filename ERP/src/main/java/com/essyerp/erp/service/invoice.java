package com.essyerp.erp.service;



import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.essyerp.erp.model.customer.CustomerModel;
import com.essyerp.erp.model.purchase.PurchaseModel;
import com.essyerp.erp.model.purchase.PurchaseitemModel;
import com.essyerp.erp.model.stock.StockModel;
import com.essyerp.erp.repo.CustomerRepo;
import com.essyerp.erp.repo.PurchaseRepo;
import com.essyerp.erp.repo.PurchaseitemRepo;
import com.essyerp.erp.repo.StockRepo;

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
public class invoice {

	
	
	@Autowired
	private PurchaseitemRepo repo1;
	
	@Autowired
	private PurchaseRepo repo2;
	
	
	
	public String exportReport1(Long id,HttpServletResponse response,HttpServletRequest request) throws JRException, IOException
	{
		Long userId = (Long) request.getSession().getAttribute("UserId");
//		List<StockModel> stockModel =   repo.findStockData(userId);
		List<PurchaseitemModel> purchaseitemModel =   repo1.findbypurchaseId(id);
		
		PurchaseModel purchaseModel =   repo2.findbyPurchaseId(id, userId).orElse(null);

		
		
		System.out.println("==================>>>>>>>>>>>>>>>>>>================="+purchaseitemModel);
		
		File file = ResourceUtils.getFile( "classpath:static/assets/invoice.jrxml");
		
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(purchaseitemModel);
		
		Map<String,Object> parameters = new HashMap<String,Object>();
		
		parameters.put("Gtotal",purchaseModel.getGrandtotal());
		parameters.put("invoiceno",purchaseModel.getInvoiceno());
		parameters.put("date",purchaseModel.getDate());
		parameters.put("cfname",purchaseModel.getSupplier().getCfname()+" "+purchaseModel.getSupplier().getClname());
		//parameters.put("clname",purchaseModel.getSupplier().getClname());
		parameters.put("address",purchaseModel.getSupplier().getAddress());
		parameters.put("postcode",purchaseModel.getSupplier().getPostcode());
		parameters.put("city",purchaseModel.getSupplier().getCity().getCity());
		JasperPrint jasperPrint = JasperFillManager.fillReport( jasperReport , parameters, datasource);
		
//		if(reportFormat.equalsIgnoreCase("xls")) {
//			
//			response.setContentType( "application/xls" );
//			response.setHeader("Content-disposition",
//	                  "attachment; filename=" +
//	                  "user.xls" );
//					
//			OutputStream outputStream = response.getOutputStream();
//			JRXlsExporter exporter = new JRXlsExporter();
//			exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
//			exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,outputStream);
//			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,Boolean.TRUE);
//			exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.FALSE);
//			exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
//			exporter.exportReport();
//			outputStream.close();
//		//	JasperExportManager.exportReportToHtmlFile(jasperPrint, "/Users/patelyash/Desktop/untitledfolder"+"/student.html"); 
//		}
//		if(reportFormat.equalsIgnoreCase("pdf")) {
			
			
			response.setContentType( "application/pdf" );
		    response.setHeader("Content-disposition",
			                  "inline; filename=" +
		                      "invoice.pdf" );
			OutputStream outputStream = response.getOutputStream();
			
			
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
			outputStream.close();
			
			//JasperExportManager.exportReportToPdfFile(jasperPrint, "/Users/patelyash/Desktop/untitledfolder"+"/student3.pdf");
//		}
		

		return "/index";
		
	}
	
}
