package com.objectfrontier.ecapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@GetMapping("login")
	public ResponseEntity<String> login() {
		return new ResponseEntity<String>("Login Success", HttpStatus.OK);
	}
	
	@GetMapping("logout")
	public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
		
		return new ResponseEntity<String>("Logout Success", HttpStatus.OK);
	}
} 