package com.essyerp.erp.repo;

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
}