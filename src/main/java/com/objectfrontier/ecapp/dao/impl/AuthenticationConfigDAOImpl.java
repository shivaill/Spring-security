package com.objectfrontier.ecapp.dao.impl;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.objectfrontier.ecapp.dao.AuthenticationConfigDAO;
import com.objectfrontier.ecapp.entity.AuthenticationConfig;
@Transactional
@Repository
public class AuthenticationConfigDAOImpl implements AuthenticationConfigDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public AuthenticationConfig getAuthenticationConfig(int companyId) {
		
		AuthenticationConfig config = null;
		List<?> list = entityManager.createQuery("SELECT a FROM AuthenticationConfig a WHERE company.companyId=?")
				.setParameter(1, companyId).getResultList();
		if(!list.isEmpty()) {
			config = (AuthenticationConfig)list.get(0);
		}
		return config;
	}
}
