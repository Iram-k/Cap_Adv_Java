package com.lpu.employeeApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.employeeApp.entity.Company;
import com.lpu.employeeApp.entity.Employee;
import com.lpu.employeeApp.service.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

//	@PostMapping("/company")
//	public Company saveCompany(@RequestBody Company company) {
//		return companyService.saveCompany(company);
//	}
//	
//	@PostMapping("/company1")
//	public Company saveCompany2(@RequestBody Company company) {
//		return companyService.saveCompanyAndMapWithEmployee(company);
//	}
	
	@PostMapping("/company")
	public ResponseEntity<Company> saveCompany( @RequestBody Company company){
		Company body = companyService.saveCompany(company);
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}
	
	
	
	
	@PostMapping("/company2/{cId}")
	public Company saveCompanyWithMapping(@PathVariable int cId, @RequestBody List<Employee> emp) {
		return companyService.saveEmployeeToExistingCompany(cId, emp);
	}
	
	@GetMapping("/divide/{n1}/{n2}")
	public String divide(@PathVariable int n1, @PathVariable int n2) {
		return "result="+n1/n2;
	}
	
	@GetMapping("/company/{id}")
	public Company findCompById(@PathVariable int id) {
		return companyService.findCompanyById(id);
	}
	
	
	
}
