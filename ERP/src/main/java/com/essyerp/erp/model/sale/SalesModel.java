package com.essyerp.erp.model.sale;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.essyerp.erp.model.customer.CustomerModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
@Table(name="sales_tbl")
public class SalesModel 
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@ManyToOne()
@JoinColumn(name = "customer_id", nullable = false,referencedColumnName = "cid")
private CustomerModel customerModel;


@Column(name="invoice_number",nullable = false)
private int invoiceno;

@Column(name="prefix",nullable = false)
private String prefix;

@Column(name="payment_type",nullable = false)
private String paymenttype;


@Column(name="sales_date",nullable = false)
private String date;


@Column(name="details")
private String details;


@Column(name="grand_total",nullable = false)
private double grandtotal;


@OneToMany(mappedBy = "salesModel", cascade = CascadeType.ALL)
@JsonIgnore
@LazyCollection(LazyCollectionOption.FALSE)
private List<SalesItemModel> salesItemModel;

@Column(name="is_delete" , columnDefinition = "integer default 0")
private int isdelete;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public CustomerModel getCustomerModel() {
	return customerModel;
}

public void setCustomerModel(CustomerModel customerModel) {
	this.customerModel = customerModel;
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

public double getGrandtotal() {
	return grandtotal;
}

public void setGrandtotal(double grandtotal) {
	this.grandtotal = grandtotal;
}

public List<SalesItemModel> getSalesItemModel() {
	return salesItemModel;
}

public void setSalesItemModel(List<SalesItemModel> salesItemModel) {
	this.salesItemModel = salesItemModel;
}

public int getIsdelete() {
	return isdelete;
}

public void setIsdelete(int isdelete) {
	this.isdelete = isdelete;
}

public int getInvoiceno() {
	return invoiceno;
}

public void setInvoiceno(int invoiceno) {
	this.invoiceno = invoiceno;
}




}