package com.objectfrontier.ecapp.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.objectfrontier.ecapp.dao.AuthenticationConfigDAO;
import com.objectfrontier.ecapp.dao.ECUserDAO;
import com.objectfrontier.ecapp.entity.AuthenticationConfig;
import com.objectfrontier.ecapp.entity.AuthenticationType;
import com.objectfrontier.ecapp.entity.ECUser;
import com.objectfrontier.ecapp.security.util.AuthenticationUtil;
import com.objectfrontier.ecapp.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private ECUserDAO userInfoDAO;
	
	@Autowired
	private AuthenticationConfigDAO authenticationConfigDAO;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Override
	public ECUser validateUser(String userName, String password) {
		ECUser activeUserInfo = userInfoDAO.getActiveUser(userName);
		
		if (!Objects.isNull(activeUserInfo.getCompany())) {
			try {
				AuthenticationConfig config = authenticationConfigDAO.getAuthenticationConfig(activeUserInfo.getCompany().getCompanyId());
				
				if (AuthenticationType.REST_POST.getAuthenticationType().equals(config.getType())) {					
					Integer result = AuthenticationUtil.postAuthentication(config.getUrl(), userName, password);
					if (Objects.isNull(result) || result == 600) {
						activeUserInfo = null;
					}
				}
			} catch (Exception e) {
				activeUserInfo = null;
			}
		} else if(!encoder.matches(password, activeUserInfo.getPassword())) {
			activeUserInfo = null;
		}
		return activeUserInfo;
	}
}

