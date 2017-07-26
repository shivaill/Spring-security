package com.objectfrontier.ecapp.security;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.objectfrontier.ecapp.entity.ECUser;
import com.objectfrontier.ecapp.service.impl.AuthenticationServiceImpl;

@Component
public class ECAuthenticationProvider
  implements AuthenticationProvider {
 
	@Autowired
	private AuthenticationServiceImpl authenticationService;
	
    @Override
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {
  
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        ECUser user = null;
        if ((user = authenticationService.validateUser(name, password)) != null && user.getUserName() != null) {
        	GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName());
            // use the credentials
            // and authenticate against the third-party system
            return new UsernamePasswordAuthenticationToken(
              name, password, Arrays.asList(authority));
        } else {
            return null;
        }
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
          UsernamePasswordAuthenticationToken.class);
    }
}
