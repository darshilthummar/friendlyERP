package com.essyerp.erp.model.purchase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.essyerp.erp.model.product.ProductModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

@Table(name="purchaseitem_tbl")
public class PurchaseitemModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="quantity",nullable = false)
	private long quantity;
	
	@Column(name="rate",nullable = false)
	private double rate;
	
	@Column(name="total",nullable = false)
	private double total;
	
	private boolean flag;
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@ManyToOne()
	@JoinColumn(name = "Product_ID",referencedColumnName = "id",nullable = false)
	private ProductModel product;
	
	@ManyToOne()
	@JoinColumn(name = "purchase_id",referencedColumnName = "id",nullable = false)
	private PurchaseModel purchaseModel;
	
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

	public ProductModel getProduct() {
		return product;
	}

	public void setProduct(ProductModel product) {
		this.product = product;
	}

	public PurchaseModel getPurchaseModel() {
		return purchaseModel;
	}

	public void setPurchaseModel(PurchaseModel purchaseModel) {
		this.purchaseModel = purchaseModel;
	}

	
}
