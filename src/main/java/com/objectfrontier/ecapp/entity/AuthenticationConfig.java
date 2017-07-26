package com.objectfrontier.ecapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="ecapp_authentication_config")
public class AuthenticationConfig implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="AUTH_ID")
	private Integer id;
	@Column(name="AUTH_TYPE")
	private String type;
	@Column(name="AUTH_URL")
	private String url;
	@ManyToOne(optional=false) 
    @JoinColumn(name="AUTH_COMPANY_ID", referencedColumnName="COMPANY_ID", nullable=false, updatable=false)
	private Company company;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
}
