package com.essyerp.erp.repo;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.essyerp.erp.model.sale.SalesItemModel;

@Repository
public interface SalesItemRepo extends JpaRepository<SalesItemModel, Long>,DataTablesRepository<SalesItemModel, Long> 
{


	

	
}