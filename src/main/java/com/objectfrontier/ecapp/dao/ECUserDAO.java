package com.objectfrontier.ecapp.dao;
import com.objectfrontier.ecapp.entity.ECUser;
public interface ECUserDAO {
	ECUser getActiveUser(String userName);
}