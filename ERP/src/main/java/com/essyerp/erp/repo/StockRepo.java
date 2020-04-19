package com.essyerp.erp.repo;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.essyerp.erp.model.stock.StockModel;

@Repository
public interface StockRepo extends JpaRepository<StockModel, Long>,DataTablesRepository<StockModel, Long> 
{

	
	
	@Query(value="select count(id) from stock_tbl where is_delete=0 and Product_ID=?1 and user_id=?2",nativeQuery=true)
	public int findProduct(long pId,Long UserID);
//
//
//	@Query(value = "SELECT count(id) FROM SalesModel where isdelete=0 ")
//	public int TotalSales();
	
//	@Modifying
//	@Query("update ContactVo set tag=?1 where contactId=?2")
//	void updateTag(String value, Long id);

	@Modifying
	@Query("update StockModel set qty=qty+?1  where isdelete=0 and product.id=?2 ")
	public void updateAddStock(long qty,long id);
	
	@Modifying
	@Query("update StockModel set qty=qty-?1  where isdelete=0 and product.id=?2 ")
	public void updateSubStock(long qty,long id);

	@Query(value="select qty from stock_tbl where is_delete=0 and Product_ID=?1 and user_id=?2",nativeQuery=true)
	public long findqty(long productId,Long UserID);
	
	
	@Query(value="select sum(qty) from stock_tbl where is_delete=0 and user_id=?1",nativeQuery=true)
	public Long countStock(Long UserID);
	//SELECT SUM(column_name) FROM table_name	WHERE condition;	

	
}
