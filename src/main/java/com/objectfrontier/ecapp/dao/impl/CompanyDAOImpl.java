package com.objectfrontier.ecapp.dao.impl;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.objectfrontier.ecapp.dao.CompanyDAO;
import com.objectfrontier.ecapp.entity.Company;
@Transactional
@Repository
public class CompanyDAOImpl implements CompanyDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Company getCompanyById(int companyId) {
		return entityManager.find(Company.class, companyId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Company> getAllCompanies() {
		String hql = "FROM Company as comp ORDER BY comp.companyId";
		return (List<Company>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addCompany(Company company) {
		entityManager.persist(company);
	}
	@Override
	public void updateCompany(Company company) {
		Company artcl = getCompanyById(company.getCompanyId());
		artcl.setName(company.getName());
		entityManager.flush();
	}
	@Override
	public void deleteCompany(int companyId) {
		entityManager.remove(getCompanyById(companyId));
	}
	@Override
	public boolean companyExists(String name) {
		String hql = "FROM Company as comp WHERE comp.name = ?";
		int count = entityManager.createQuery(hql).setParameter(1, name).getResultList().size();
		return count > 0 ? true : false;
	}
}
