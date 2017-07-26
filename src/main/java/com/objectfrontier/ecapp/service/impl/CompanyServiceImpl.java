package com.objectfrontier.ecapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objectfrontier.ecapp.dao.CompanyDAO;
import com.objectfrontier.ecapp.entity.Company;
import com.objectfrontier.ecapp.service.CompanyService;
@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyDAO companyDAO;
	@Override
	public Company getCompanyById(int companyId) {
		Company obj = companyDAO.getCompanyById(companyId);
		return obj;
	}	
	@Override
	public List<Company> getAllCompanies(){
		return companyDAO.getAllCompanies();
	}
	@Override
	public synchronized boolean addCompany(Company company){
       if (companyDAO.companyExists(company.getName())) {
    	   return false;
       } else {
    	   companyDAO.addCompany(company);
    	   return true;
       }
	}
	@Override
	public void updateCompany(Company company) {
		companyDAO.updateCompany(company);
	}
	@Override
	public void deleteCompany(int companyId) {
		companyDAO.deleteCompany(companyId);
	}
}
