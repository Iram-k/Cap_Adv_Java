package com.lpu.employeeApp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.employeeApp.dto.EmployeeDto;
import com.lpu.employeeApp.entity.Employee;
import com.lpu.employeeApp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
    private EmployeeRepository repository;
	
	public EmployeeDto saveEmployee(EmployeeDto dto) {
		Employee employee = DTOtoEntity(dto);
		Employee emp = repository.save(employee);
		return entityToDTO(emp);
	}
	public Employee findEmployee(int id) {
		return repository.findById(id).get();
	}   
  	
	
	public Employee DTOtoEntity(EmployeeDto emp) {
		Employee em=new Employee();
		em.setAge(emp.getAge());
		em.setEmail(emp.getEmail());
		em.setName(emp.getName());
		em.setPhone(emp.getPhone());
		return em;
	}
	
	public EmployeeDto entityToDTO(Employee e) {
		EmployeeDto dto=new EmployeeDto();
		dto.setAge(e.getAge());
		dto.setEmail(e.getEmail());
		dto.setName(e.getName()); 
		dto.setPhone(e.getPhone());
		return dto;
	}
//    // Save single employee
//    public Employee saveEmployee(Employee employee) {
//        return repository.save(employee);
//    }

//    // Find by ID
//    public Employee findEmployeeById(int id) {
//        return repository.findById(id).orElse(null);
//    }
//
//    // Delete using object
//    public void deleteEmployee(Employee employee) {
//        repository.delete(employee);
//    }
//
//    // Get all employees
//    public List<Employee> findAllEmployee() {
//        return repository.findAll();
//    }
//
//    // Save multiple employees
//    public List<Employee> saveAllEmployee(List<Employee> list) {
//        return repository.saveAll(list);
//    }
//
//    // Delete by ID
//    public void deleteById(int id) {
//        repository.deleteById(id);
//    }
}
