package com.essyerp.erp.model.Tax;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 

@Table(name="tax_tbl")

public class TaxModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="Tax",nullable = false)
	private String tax;
	
	@Column(name="tax_rate",nullable = false)
	private long taxRate;
	
	
	@Column(name="isdeleted",nullable = false)
	private boolean flag;
	
	@Column(name="user_id",nullable = false)
	private Long userid;
	
	public String getTax() {
		return tax;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public void setTax(String tax) {
		this.tax = tax;
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
	public long getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(long taxRate) {
		this.taxRate = taxRate;
	}
	
	
}
