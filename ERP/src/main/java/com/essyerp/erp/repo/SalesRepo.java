package com.essyerp.erp.repo;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.essyerp.erp.model.sale.SalesModel;

@Repository
public interface SalesRepo extends JpaRepository<SalesModel, Long>,DataTablesRepository<SalesModel, Long> 
{

	
	
	@Query(value = "SELECT COALESCE(MAX(invoice_number),0) AS Max FROM sales_tbl where user_id=?1",nativeQuery=true)
	public int MaxInvoiceNo(Long UserID);


	@Query(value = "SELECT count(id) FROM SalesModel where isdelete=0 and userid=?1")
	public int TotalSales(Long UserID);
	

	@Query(value="select sum(sale_grand_total) from sales_tbl where is_delete=0 and payment_type=?1 and user_id=?2",nativeQuery=true)
	public Long caseCount(String type,Long UserID);
	//SELECT SUM(column_name)	FROM table_name	WHERE condition;
	
}
