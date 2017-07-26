package com.objectfrontier.ecapp.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.objectfrontier.ecapp.entity.ECUser;

public interface AuthenticationService {
	public ECUser validateUser(String userName, String password);
}
