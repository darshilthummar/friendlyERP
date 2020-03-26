package com.essyerp.erp.repo;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.essyerp.erp.model.Tax.TaxModel;





@Repository
public interface TaxRepo extends JpaRepository<TaxModel, Long>,DataTablesRepository<TaxModel, Long>{

}
