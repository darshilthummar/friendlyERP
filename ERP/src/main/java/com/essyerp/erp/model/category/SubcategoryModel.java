package com.essyerp.erp.model.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;





@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 

@Table(name="Subcategory_tbl")

public class SubcategoryModel {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="Subcategory_name",nullable = false)
	private String subcategoryname;
	
	private boolean flag;

	@ManyToOne()
    @JoinColumn(name = "category_id", nullable = false,referencedColumnName = "id")
    private CategoryModel categorymodel;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public CategoryModel getCategorymodel() {
		return categorymodel;
	}

	public void setCategorymodel(CategoryModel categorymodel) {
		this.categorymodel = categorymodel;
	}

	
	public String getSubcategoryname() {
		return subcategoryname;
	}

	public void setSubcategoryname(String subcategoryname) {
		this.subcategoryname = subcategoryname;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
	
}
