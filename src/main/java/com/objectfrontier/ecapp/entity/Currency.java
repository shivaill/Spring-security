package com.objectfrontier.ecapp.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ecapp_currency")
public class Currency implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CURRENCY_ID")
    private int currencyId;  
	@Column(name="CURRENCY_NAME")
    private String name;
	@Column(name="CURRENCY_ABBREVIATION")	
	private String abbrevition;
	
	public int getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbrevition() {
		return abbrevition;
	}
	public void setAbbrevition(String abbrevition) {
		this.abbrevition = abbrevition;
	}
} 