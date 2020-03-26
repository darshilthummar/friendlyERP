package com.essyerp.erp.model.category;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 

@Table(name="category_tbl")

public class CategoryModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="category_name",nullable = false)
	private String categoryname;
	
	private boolean flag;
	
	@OneToMany(mappedBy = "categorymodel",cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
    private List<SubcategoryModel> subcategorymodel;
	
	public List<SubcategoryModel> getSubcategorymodel() {
		return subcategorymodel;
	}
	public void setSubcategorymodel(List<SubcategoryModel> subcategorymodel) {
		this.subcategorymodel = subcategorymodel;
	}
	
	
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
