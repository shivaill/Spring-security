package com.objectfrontier.ecapp.entity;
import java.io.Serializable;
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
@Entity
@Table(name="ecapp_company")
public class Company implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COMPANY_ID")
    private int companyId;  
	@Column(name="COMPANY_NAME")
    private String name;
	@ManyToOne(optional=false) 
    @JoinColumn(name="COMPANY_CURRENCY_ID", referencedColumnName="CURRENCY_ID", nullable=false, updatable=false)
	private Currency currency;
	@ManyToOne(optional=false) 
    @JoinColumn(name="COMPANY_LANGUAGE_ID", referencedColumnName="LANGUAGE_ID", nullable=false, updatable=false)
	private Language language;
	@Column(name="COMPANY_LOGO_PATH")
	private String logoPath;
	@Column(name="COMPANY_DATEFORMAT")
	private String dateFormat;
	@Column(name="COMPANY_EXPIRY_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;
	@ManyToOne(optional=true) 
    @JoinColumn(name="CREATED_BY", referencedColumnName="USER_ID", updatable=false)
	private ECUser createdBy;
	@Column(name="CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@ManyToOne(optional=true) 
    @JoinColumn(name="UPDATED_BY", referencedColumnName="USER_ID", updatable=false)
	private ECUser updatedBy;
	@Column(name="UPDATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public String getLogoPath() {
		return logoPath;
	}
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	public String getDateFormat() {
		return dateFormat;
	}
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public ECUser getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(ECUser createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public ECUser getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(ECUser updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
} 