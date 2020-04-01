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
	
}