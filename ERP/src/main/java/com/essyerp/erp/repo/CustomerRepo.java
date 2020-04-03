package com.essyerp.erp.repo;

import java.util.List;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.essyerp.erp.model.Tax.TaxModel;
import com.essyerp.erp.model.customer.CustomerModel;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerModel, Long>,DataTablesRepository<CustomerModel, Long> 
{
	
	@Query(value="SELECT * FROM customer_tbl WHERE user_type = ?1 and user_id=?2 and flag=0",nativeQuery=true)
	List<CustomerModel> findData(String supplier,Long UserID);

	@Query(value="SELECT * FROM customer_tbl WHERE user_type= ?1 and user_id=?2 and flag=0",nativeQuery=true)
	List<CustomerModel> findByCuser(String string,Long UserID);
	
	@Query(value="select count(cid) from customer_tbl where flag=0 and user_type=?1 and user_id=?2",nativeQuery=true)
	public Long countContect(String type,Long UserID);
	
	@Query(value="SELECT * FROM customer_tbl WHERE user_id=?1 and flag=0",nativeQuery=true)
	List<CustomerModel> findCustomerData(Long UserID);
}
