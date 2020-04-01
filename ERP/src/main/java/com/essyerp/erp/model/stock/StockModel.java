package com.essyerp.erp.model.stock;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.essyerp.erp.model.product.ProductModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
@Table(name="stock_tbl")
public class StockModel 
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@ManyToOne()
@JoinColumn(name = "Product_ID",referencedColumnName = "id",nullable = false)
private ProductModel product;

@Column(name="category")
private String category;

@Column(name="sub_category")
private String subCategory;

@Column(name="qty")
private long qty;


@Column(name="description")
private String description;

@Column(name="is_delete" , columnDefinition = "integer default 0")
private int isdelete;





}