package com.essyerp.erp.model.purchase;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import com.essyerp.erp.model.customer.CustomerModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
//@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="purchase_tbl")
public class PurchaseModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="invoice_number",nullable = false)
	private long invoiceno;
	
	@Column(name="prefix",nullable = false)
	private String prefix;
	
	@Column(name="payment_type",nullable = false)
	private String paymenttype;
	
	@Column(name="date",nullable = false)
	private String date;
	
	@Column(name="details")
	private String details;
	
	@Column(name="purchase_grand_total",nullable = false)
	private double grandtotal;
	
	
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

	@ManyToOne()
	@JoinColumn(name = "Supplier_ID",referencedColumnName = "cid",nullable = false)
	private CustomerModel supplier;

	
    @OneToMany(mappedBy = "purchaseModel",cascade = CascadeType.ALL)
	private List<PurchaseitemModel> purchaseitemModel;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	

	public long getInvoiceno() {
		return invoiceno;
	}

	public void setInvoiceno(long invoiceno) {
		this.invoiceno = invoiceno;
	}

	public double getGrandtotal() {
		return grandtotal;
	}

	public void setGrandtotal(double grandtotal) {
		this.grandtotal = grandtotal;
	}

	public CustomerModel getSupplier() {
		return supplier;
	}

	public void setSupplier(CustomerModel supplier) {
		this.supplier = supplier;
	}

	@JsonIgnore
	public List<PurchaseitemModel> getPurchaseitemModel() {
		return purchaseitemModel;
	}

	@JsonIgnore
	public void setPurchaseitemModel(List<PurchaseitemModel> purchaseitemModel) {
		this.purchaseitemModel = purchaseitemModel;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public int getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}

	
	
}
