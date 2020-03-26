package com.essyerp.erp.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.essyerp.erp.model.country.City;
import com.essyerp.erp.model.country.State;


@Repository

public interface StateRepo extends JpaRepository<State,Long>,DataTablesRepository<State, Long>{
	
	@Query(value="SELECT * FROM states WHERE country_id = ?1",nativeQuery=true)
	List<State> findData(Long country_id);
      

}
