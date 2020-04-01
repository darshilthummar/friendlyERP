package com.essyerp.erp.repo;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.essyerp.erp.model.sale.SalesModel;

@Repository
public interface SalesRepo extends JpaRepository<SalesModel, Long>,DataTablesRepository<SalesModel, Long> 
{

	
	
	@Query(value = "SELECT max(invoiceno) FROM SalesModel")
	public int MaxInvoiceNo();


	@Query(value = "SELECT count(id) FROM SalesModel where isdelete=0 ")
	public int TotalSales();
	

	@Query(value="select sum(sale_grand_total) from sales_tbl where is_delete=0 and payment_type=?1 ",nativeQuery=true)
	public Long caseCount(String type);
	//SELECT SUM(column_name)	FROM table_name	WHERE condition;
	
}
