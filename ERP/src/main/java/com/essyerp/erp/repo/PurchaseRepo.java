package com.essyerp.erp.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.essyerp.erp.model.purchase.PurchaseModel;

@Repository
public interface PurchaseRepo extends JpaRepository<PurchaseModel, Long>,DataTablesRepository<PurchaseModel, Long> 
{
	@Query(value = "SELECT max(invoiceno) FROM PurchaseModel")
	public int MaxInvoiceNo();
	
	@Query(value = "SELECT count(id) FROM PurchaseModel where isdelete=0 ")
	public int TotalPurchase();
	
	
	@Query(value="SELECT { fn MONTHNAME(a.date) }  AS 'Month',\n" + 
			"	  \n" + 
			"       SUM(a.purchase_grand_total) AS 'purchase' ,\n" + 
			"       SUM(a.sale_grand_total) AS 'sale'\n" + 
			"FROM (\n" + 
			"SELECT t1.date,\n" + 
			"       t1.purchase_grand_total,\n" + 
			"       t2.sale_grand_total\n" + 
			"       FROM purchase_tbl t1\n" + 
			"LEFT JOIN sales_tbl t2 ON t1.date = t2.date WHERE t1.is_delete=0\n" + 
			"UNION\n" + 
			"SELECT t2.date,\n" + 
			"       t1.purchase_grand_total,\n" + 
			"       t2.sale_grand_total\n" + 
			"       FROM purchase_tbl t1\n" + 
			"RIGHT JOIN sales_tbl t2 ON t1.date = t2.date WHERE t2.is_delete=0) a\n" + 
			"WHERE YEAR(a.date) = YEAR(CURDATE()) GROUP BY { fn MONTHNAME(a.date) },MONTH(a.date) order by MONTH(a.date);\n" + 
			"\n" + 
			"",nativeQuery=true)
	public List<Map<String,String>> getPurchaseAll(String year); 
	
}