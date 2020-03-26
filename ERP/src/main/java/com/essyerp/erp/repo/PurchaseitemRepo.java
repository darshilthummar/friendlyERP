package com.essyerp.erp.repo;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.essyerp.erp.model.purchase.PurchaseitemModel;

@Repository
public interface PurchaseitemRepo extends JpaRepository<PurchaseitemModel, Long>,DataTablesRepository<PurchaseitemModel, Long> 
{

}