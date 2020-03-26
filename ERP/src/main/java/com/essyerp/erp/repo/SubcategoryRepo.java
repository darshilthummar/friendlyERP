package com.essyerp.erp.repo;

import java.util.List;


import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.essyerp.erp.model.category.SubcategoryModel;

@Repository
public interface SubcategoryRepo extends JpaRepository<SubcategoryModel, Long>, DataTablesRepository<SubcategoryModel, Long> {

	@Query(value="SELECT * FROM Subcategory_tbl WHERE category_id = ?1",nativeQuery=true)
	List<SubcategoryModel> findData(Long category_id);
	
}
