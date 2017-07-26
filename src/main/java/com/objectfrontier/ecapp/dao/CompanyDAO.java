package com.objectfrontier.ecapp.dao;
import java.util.List;

import com.objectfrontier.ecapp.entity.Company;
public interface CompanyDAO {
    List<Company> getAllCompanies();
    Company getCompanyById(int companyId);
    void addCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(int companyId);
    boolean companyExists(String name);
}
 