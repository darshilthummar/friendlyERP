package com.essyerp.erp.model.stock;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.essyerp.erp.model.product.ProductModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
@Table(name="stock_transaction_tbl")
public class StockTransaction 
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@ManyToOne()
@JoinColumn(name = "Product_ID",referencedColumnName = "id",nullable = false)
private ProductModel product;

@Column(name="in_qty")
private long inqty;

@Column(name="out_qty")
private long outqty;

@Column(name="description")
private String description;

@Column(name="is_delete" , columnDefinition = "integer default 0")
private int isdelete;

@Column(name="price")
private double price;

@Column(name="type")
private String type;

@Temporal(TemporalType.DATE)
@Column(name = "transaction_date")
private Date transactionDate;



}