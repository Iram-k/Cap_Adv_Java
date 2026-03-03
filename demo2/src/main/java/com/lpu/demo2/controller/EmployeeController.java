package com.lpu.demo2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lpu.demo2.entity.Employee;
import com.lpu.demo2.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee emp) {
        return service.saveEmployee(emp);
    }

    
    @GetMapping("/getAll")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    
    @GetMapping("/getEmpBId")
    public Employee getEmployeeById(@RequestParam int id) {
        return service.getEmployeeById(id);
    }

    
    @DeleteMapping("/delBId")
    public String deleteEmployee(@RequestParam int id) {
        return service.deleteEmployee(id);
    }

    
    @GetMapping("/search/name")
    public List<Employee> getByName(@RequestParam String name) {
        return service.getByName(name);
    }

    
    @GetMapping("/search/dept")
    public List<Employee> getByDepartment(@RequestParam String department) {
        return service.getByDepartment(department);
    }

    
    @GetMapping("/search/phone")
    public Employee getByPhone(@RequestParam String phone) {
        return service.getByPhone(phone);
    }

    
    @GetMapping("/search/mail")
    public Employee getByEmail(@RequestParam String email) {
        return service.getByEmail(email);
    }
}