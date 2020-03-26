package com.essyerp.erp.repo;

import java.util.List;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.essyerp.erp.model.Unit.UnitModel;


@Repository
public interface UnitRepo extends JpaRepository<UnitModel, Long>,DataTablesRepository<UnitModel, Long>{

	@Query(value="SELECT unit_name FROM unit_tbl",nativeQuery=true)
	List<String> findData();
	
}
