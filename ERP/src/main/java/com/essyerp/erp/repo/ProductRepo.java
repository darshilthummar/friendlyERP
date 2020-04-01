package com.essyerp.erp.repo;

import java.util.List;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.essyerp.erp.model.product.ProductModel;

@Repository
public interface ProductRepo extends JpaRepository<ProductModel, Long>,DataTablesRepository<ProductModel, Long> 
{
	@Query(value="SELECT * FROM product_tbl WHERE supplier_id = ?1",nativeQuery=true)
	List<ProductModel> findData(Long id);

	@Query(value="SELECT product_name FROM product_tbl",nativeQuery=true)
	List<String> findProductname();
	
	@Query(value="select count(id) from product_tbl where is_delete=0",nativeQuery=true)
	public Long countProduct();
}