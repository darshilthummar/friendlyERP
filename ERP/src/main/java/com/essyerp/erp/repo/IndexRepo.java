package com.essyerp.erp.repo;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.essyerp.erp.model.sale.SalesModel;

@Repository
public interface IndexRepo extends JpaRepository<SalesModel, Long>,DataTablesRepository<SalesModel, Long> 
{

	
	
	
	
	


	

	
}