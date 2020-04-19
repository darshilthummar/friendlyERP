package com.essyerp.erp.repo;

import java.util.List;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.essyerp.erp.model.sale.SalesItemModel;

@Repository
public interface SalesItemRepo extends JpaRepository<SalesItemModel, Long>,DataTablesRepository<SalesItemModel, Long> 
{


	
	@Modifying
	@Query("delete from SalesItemModel  where id in (?1)")	
	void deleteSalesItem(List<Long> l);
	
//	SELECT SUM((rate * quantity) - (quantity * purichase_price)) FROM "sales_item_tbl" 
//	where (TO_DATE(date, 'DD-MM-YYYY'))>(CURRENT_DATE-30) and (TO_DATE(date,'DD-MM-YYYY'))<=CURRENT_DATE;
//	@Query(value = "select max(cast(barcode as bigint)) from barcode where LOWER(barcode) LIKE ?4% and company_id=?1  and to_date(created_on, 'DD-MM-YYYY') between to_date(?2, 'DD-MM-YYYY') and to_date(?3, 'DD-MM-YYYY')", nativeQuery = true)
    
	@Query(value="select SUM((rate * quantity) - (quantity * purchase_rate)) from sales_item_tbl where (STR_TO_DATE(created_on, '%d-%m-%Y'))>(CURRENT_DATE-30) and (STR_TO_DATE(created_on,'%d-%m-%Y'))<=CURRENT_DATE and is_delete=0 and user_id=?1",nativeQuery=true)
	public Long countProfit(Long UserID);
	
}