package com.lpu.demo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.demo2.entity.Employee;
import com.lpu.demo2.repository.EmployeeRepository;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository repo;
    
    public Employee saveEmployee(Employee emp) {
        return repo.save(emp);
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee getEmployeeById(int id) {
        return repo.findById(id).orElse(null);
    }

    public String deleteEmployee(int id) {
        repo.deleteById(id);
        return "Employee deleted successfully";
    }

    public List<Employee> getByName(String name) {
        return repo.findByName(name);
    }

    public List<Employee> getByDepartment(String department) {
        return repo.findByDepartment(department); 
    }

    public Employee getByPhone(String phone) {
        return repo.findByPhone(phone);
    }

    public Employee getByEmail(String email) {
        return repo.findByEmail(email);
    }
}
	

