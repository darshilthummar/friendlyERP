package com.essyerp.erp.repo;

import java.util.List;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.essyerp.erp.model.country.City;
import com.essyerp.erp.model.country.State;
import com.essyerp.erp.model.customer.CustomerModel;


@Repository

public interface CityRepo extends JpaRepository<City,Long>,DataTablesRepository<City, Long>{
	
	
	@Query(value="SELECT * FROM cities WHERE state_id = ?1",nativeQuery=true)
	List<City> findData(Long state_id);

}
