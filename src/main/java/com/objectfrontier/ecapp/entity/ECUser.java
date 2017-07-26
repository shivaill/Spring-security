package com.objectfrontier.ecapp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="ecapp_user")
public class ECUser implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="USER_ID")
	private Integer id;
	@Column(name="USER_NAME")
	private String userName;
	@Column(name="USER_PASSWORD")
	private String password;
	@Column(name="USER_FIRSTNAME")	
	private String firstName;
	@Column(name="USER_LASTNAME")	
	private String lastName;
	@Column(name="USER_EMAILID")	
	private String emailId;
	@ManyToOne(optional=false) 
    @JoinColumn(name="USER_COMPANY_ID", referencedColumnName="COMPANY_ID", nullable=false, updatable=false)
	private Company company;
	@ManyToOne(optional=false) 
    @JoinColumn(name="USER_ROLE_ID", referencedColumnName="ROLE_ID", nullable=false, updatable=false)
	private Role role;
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
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
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
