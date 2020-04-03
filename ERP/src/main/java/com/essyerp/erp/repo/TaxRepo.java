package com.essyerp.erp.repo;

import java.util.List;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.essyerp.erp.model.Tax.TaxModel;
import com.essyerp.erp.model.customer.CustomerModel;

@Repository
public interface TaxRepo extends JpaRepository<TaxModel, Long>,DataTablesRepository<TaxModel, Long>{

	@Query(value="SELECT * FROM tax_tbl WHERE user_id=?1 and isdeleted=0",nativeQuery=true)
	List<TaxModel> findTaxData(Long UserID);
	
	
}
