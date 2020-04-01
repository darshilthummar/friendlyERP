package com.essyerp.erp.repo;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.essyerp.erp.model.sale.SalesModel;
import com.essyerp.erp.model.stock.StockModel;
import com.essyerp.erp.model.stock.StockTransaction;

@Repository
public interface StockTransactionRepo extends JpaRepository<StockTransaction, Long>,DataTablesRepository<StockTransaction, Long> 
{

	
	
	@Query(value="select count(id) from stock_tbl where is_delete=0 and Product_ID=?1 ",nativeQuery=true)
	public int findProduct(long pId);
//
//
//	@Query(value = "SELECT count(id) FROM SalesModel where isdelete=0 ")
//	public int TotalSales();

	@Query(value="update stock_tbl set qty=qty+?1  where is_delete=0 and Product_ID=?2 ",nativeQuery=true)
	public void updateAddStock(long qty,long id);
	
	@Query(value="update stock_tbl set qty=qty-?1  where is_delete=0 and Product_ID=?2 ",nativeQuery=true)
	public void updateSubStock(long qty,long id);
	
	
	

	
}
