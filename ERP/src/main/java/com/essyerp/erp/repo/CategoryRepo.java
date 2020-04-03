package com.essyerp.erp.repo;

import java.util.List;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.essyerp.erp.model.category.CategoryModel;


@Repository
public interface CategoryRepo extends JpaRepository<CategoryModel, Long>,DataTablesRepository<CategoryModel, Long>{

	@Query(value="SELECT * FROM category_tbl WHERE user_id=?1 and flag=0",nativeQuery=true)
	List<CategoryModel> findCategoryData(Long UserID);
	
}
