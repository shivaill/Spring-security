package com.objectfrontier.ecapp.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.objectfrontier.ecapp.entity.Company;
import com.objectfrontier.ecapp.service.CompanyService;

@Controller
@RequestMapping("/admin/company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	private static final Logger LOG = LoggerFactory.getLogger(CompanyController.class);
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable("id") Integer id) {
		Company company = companyService.getCompanyById(id);
		return new ResponseEntity<Company>(company, HttpStatus.OK);
	}
	@GetMapping("/companies")
	public ResponseEntity<List<Company>> getAllCompanys() {
		LOG.info("getAllCompanys() - started");
		List<Company> list = companyService.getAllCompanies();
		LOG.info("getAllCompanys() - return response code is " + HttpStatus.OK);
		return new ResponseEntity<List<Company>>(list, HttpStatus.OK);
	}
	@PostMapping("/")
	public ResponseEntity<Void> addCompany(@RequestBody Company company, UriComponentsBuilder builder) {
        boolean flag = companyService.addCompany(company);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/company/{id}").buildAndExpand(company.getCompanyId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("/")
	public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
		companyService.updateCompany(company);
		return new ResponseEntity<Company>(company, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCompany(@PathVariable("id") Integer id) {
		companyService.deleteCompany(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 