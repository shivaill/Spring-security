package com.objectfrontier.ecapp.config;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.objectfrontier.ecapp.security.ECAuthenticationProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
		
	@Autowired
    private ECAuthenticationProvider authProvider;
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  
        auth.authenticationProvider(authProvider);
    }
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')").
		antMatchers("/user/**").access("hasRole('ROLE_USER')").
		and().formLogin().  //login configuration
		successHandler(successHandler()).
        failureHandler(failureHandler()).
        usernameParameter("app_username").
        passwordParameter("app_password").
        defaultSuccessUrl("/admin/company/companies").
		and().logout().    //logout configuration
		logoutUrl("/appLogout"). 
		logoutSuccessUrl("/login").
		and().
        exceptionHandling().
          accessDeniedHandler(accessDeniedHandler()).
          authenticationEntryPoint(authenticationEntryPoint()).
		and().
		csrf().disable();
	} 
	
	private AuthenticationSuccessHandler successHandler() {
	    return new AuthenticationSuccessHandler() {
	      @Override
	      public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
	        httpServletResponse.getWriter().append("OK");
	        httpServletResponse.setStatus(200);
	      }
	    };
	  }

	  private AuthenticationFailureHandler failureHandler() {
	    return new AuthenticationFailureHandler() {
	      @Override
	      public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
	        httpServletResponse.getWriter().append("Authentication failure");
	        httpServletResponse.setStatus(401);
	      }
	    };
	  }
	  
	  private AccessDeniedHandler accessDeniedHandler() {
		    return new AccessDeniedHandler() {
		      @Override
		      public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
		        httpServletResponse.getWriter().append("Access denied");
		        httpServletResponse.setStatus(403);
		      }
		    };
		  }

		  private AuthenticationEntryPoint authenticationEntryPoint() {
		    return new AuthenticationEntryPoint() {
		      @Override
		      public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
		        httpServletResponse.getWriter().append("Not authenticated");
		        httpServletResponse.setStatus(401);
		      }
		    };
		  }
}