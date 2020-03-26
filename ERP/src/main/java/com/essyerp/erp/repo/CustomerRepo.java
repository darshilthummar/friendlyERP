package com.essyerp.erp.repo;

import java.util.List;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.essyerp.erp.model.customer.CustomerModel;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerModel, Long>,DataTablesRepository<CustomerModel, Long> 
{
	
	@Query(value="SELECT * FROM customer_tbl WHERE user_type = ?1",nativeQuery=true)
	List<CustomerModel> findData(String supplier);

	List<CustomerModel> findByCuser(String string);
	
	@Query(value="select count(cid) from customer_tbl where flag=0 and user_type=?1 ",nativeQuery=true)
	public Long countContect(String type);
}
