package com.lpu.employeeApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.employeeApp.EmployeeAppApplication;
import com.lpu.employeeApp.dto.EmployeeDto;
import com.lpu.employeeApp.entity.Employee;
import com.lpu.employeeApp.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	    
    @Autowired
    private EmployeeService employeeService;

    
    @PostMapping("/saveEmployee")
	public ResponseEntity<EmployeeDto> saveEmployee(@Valid  @RequestBody EmployeeDto e) {
 		
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(e));
	}
    
    
    @GetMapping("findEmployee/{id}")
	public ResponseEntity<Employee> findEmployee(@PathVariable int id){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(employeeService.findEmployee(id));
	}
    
//    // Save single employee
//    @PostMapping("/employee")
//    public Employee save(@RequestBody Employee employee) {
//        return service.saveEmployee(employee);
//    }
//
//    // Get employee by ID
//    @GetMapping("/employee/{id}")
//    public Employee fetchEmployeeByID(@PathVariable int id) {
//        return service.findEmployeeById(id);
//    }
//
//    // Delete using object
//    @DeleteMapping("/employee")
//    public String deleteEmployee(@RequestBody Employee employee) {
//        service.deleteEmployee(employee);
//        return "employee deleted";
//    }
//
//    // Get all employees
//    @GetMapping("/employee")
//    public List<Employee> findEmployees() {
//        return service.findAllEmployee();
//    }
//    
// // Delete by ID
//    @DeleteMapping("/employee/delete")
//    public String deleteByID(@RequestParam int id) {
//        service.deleteById(id);
//        return "employee deleted by id";
//    }
//
//    // Save all employees
//    @PostMapping("/employee/save")
//    public List<Employee> saveAllEmployees(@RequestBody List<Employee> employees) {
//        return service.saveAllEmployee(employees);
//    }
}
