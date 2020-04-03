package com.essyerp.erp.model.product;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.essyerp.erp.model.Tax.TaxModel;
import com.essyerp.erp.model.Unit.UnitModel;
import com.essyerp.erp.model.category.CategoryModel;
import com.essyerp.erp.model.category.SubcategoryModel;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;



@Entity

@Table(name="product_tbl")
public class ProductModel 
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(name="product_name",nullable = false)
private String pname;

@Column(name="purchase_price",nullable = false)
private String purchasePrice;

@Column(name="sales_price")
private String salesPrice;

@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "tax", nullable = false,referencedColumnName = "id")
private TaxModel taxmodel;

@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "measurement", nullable = false,referencedColumnName = "id")
private UnitModel unitmodel;



@Column(name="image")
private String image;

@Column(name="description")
private String description;

@Column(name="is_delete" , columnDefinition = "integer default 0")
private int isdelete;

@Column(name="user_id",nullable = false)
private Long userid;

public Long getUserid() {
	return userid;
}

public void setUserid(Long userid) {
	this.userid = userid;
}

@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "category_id", nullable = false,referencedColumnName = "id")

private CategoryModel categorymodel;

@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "subcategory_id", nullable = false,referencedColumnName = "id")

private SubcategoryModel subcategorymodel;





public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getPname() {
	return pname;
}

public void setPname(String pname) {
	this.pname = pname;
}



public CategoryModel getCategorymodel() {
	return categorymodel;
}

public void setCategorymodel(CategoryModel categorymodel) {
	this.categorymodel = categorymodel;
}


public SubcategoryModel getSubcategorymodel() {
	return subcategorymodel;
}

public void setSubcategorymodel(SubcategoryModel subcategorymodel) {
	this.subcategorymodel = subcategorymodel;
}

public String getPurchasePrice() {
	return purchasePrice;
}

public void setPurchasePrice(String purchasePrice) {
	this.purchasePrice = purchasePrice;
}

public String getSalesPrice() {
	return salesPrice;
}

public void setSalesPrice(String salesPrice) {
	this.salesPrice = salesPrice;
}





public TaxModel getTaxmodel() {
	return taxmodel;
}

public void setTaxmodel(TaxModel taxmodel) {
	this.taxmodel = taxmodel;
}

public UnitModel getUnitmodel() {
	return unitmodel;
}

public void setUnitmodel(UnitModel unitmodel) {
	this.unitmodel = unitmodel;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public int getIsdelete() {
	return isdelete;
}

public void setIsdelete(int isdelete) {
	this.isdelete = isdelete;
}


}