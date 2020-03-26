package com.essyerp.erp.repo;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.essyerp.erp.model.purchase.PurchaseModel;

@Repository
public interface PurchaseRepo extends JpaRepository<PurchaseModel, Long>,DataTablesRepository<PurchaseModel, Long> 
{

}