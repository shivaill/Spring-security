package com.objectfrontier.ecapp.dao.impl;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.objectfrontier.ecapp.dao.ECUserDAO;
import com.objectfrontier.ecapp.entity.ECUser;
@Repository
@Transactional
public class ECUserDAOImpl implements ECUserDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	public ECUser getActiveUser(String userName) {
		ECUser activeUserInfo = new ECUser();
		List<?> list = entityManager.createQuery("SELECT u FROM ECUser u WHERE userName=?")
				.setParameter(1, userName).getResultList();
		if(!list.isEmpty()) {
			activeUserInfo = (ECUser)list.get(0);
		}
		return activeUserInfo;
	}
}