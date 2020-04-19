package com.essyerp.erp.model.sale;

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


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
@Table(name="sales_item_tbl")
public class SalesItemModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	@Column(name="quantity",nullable = false)
	private long quantity;
	

	@Column(name="rate",nullable = false)
	private double rate;
	
	@Column(name="purchase_rate",nullable = false)
	private double purchaseRate;
	
	@Column(name="created_on",length=50)
	private String createdOn;

	@Column(name="total",nullable = false)
	private double total;
	

	@Column(name="is_delete" , columnDefinition = "integer default 0")
	private int isdelete;
	
	@ManyToOne()
	@JoinColumn(name = "Product_ID",referencedColumnName = "id",nullable = false)
	private ProductModel product;
	

	@ManyToOne()
	@JoinColumn(name = "sales_id",referencedColumnName = "id",nullable = false)
	private SalesModel salesModel;

	@Column(name="user_id",nullable = false)
	private Long userid;
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getQuantity() {
		return quantity;
	}


	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public int getIsdelete() {
		return isdelete;
	}


	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}


	public ProductModel getProduct() {
		return product;
	}


	public void setProduct(ProductModel product) {
		this.product = product;
	}


	public SalesModel getSalesModel() {
		return salesModel;
	}


	public void setSalesModel(SalesModel salesModel) {
		this.salesModel = salesModel;
	}


	public double getPurchaseRate() {
		return purchaseRate;
	}


	public void setPurchaseRate(double purchaseRate) {
		this.purchaseRate = purchaseRate;
	}


	public String getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}


	public Long getUserid() {
		return userid;
	}


	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	
	
}