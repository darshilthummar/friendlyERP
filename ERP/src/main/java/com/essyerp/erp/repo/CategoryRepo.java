package com.essyerp.erp.repo;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.essyerp.erp.model.category.CategoryModel;


@Repository
public interface CategoryRepo extends JpaRepository<CategoryModel, Long>,DataTablesRepository<CategoryModel, Long>{

}
