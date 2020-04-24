package com.essyerp.erp.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.essyerp.erp.model.purchase.PurchaseitemModel;

@Repository
public interface PurchaseitemRepo extends JpaRepository<PurchaseitemModel, Long>,DataTablesRepository<PurchaseitemModel, Long> 
{

	@Modifying
	@Query("delete from PurchaseitemModel  where id in (?1)")	
	void deletePurchaseItem(List<Long> l);
	
	@Query(value="SELECT * FROM purchaseitem_tbl WHERE purchase_id=?1 and flag = 0" ,nativeQuery=true)
	List<PurchaseitemModel> findbypurchaseId(Long id);
	
	
	
	
}