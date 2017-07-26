package com.objectfrontier.ecapp.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.objectfrontier.ecapp.entity.Company;

public interface CompanyService {
	 @Secured ({"ROLE_ADMIN", "ROLE_USER"})
     List<Company> getAllCompanies();
	 @Secured ({"ROLE_ADMIN", "ROLE_USER"})
     Company getCompanyById(int companyId);
	 @Secured ({"ROLE_ADMIN"})
     boolean addCompany(Company company);
	 @Secured ({"ROLE_ADMIN"})
     void updateCompany(Company company);
	 @Secured ({"ROLE_ADMIN"})
     void deleteCompany(int companyId);
}
