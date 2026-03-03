package com.lpu.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lpu.demo2.entity.Employee;
import java.util.*;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	List<Employee> findByName(String name);
    List<Employee> findByDepartment(String department);
    Employee findByPhone(String phone);
    Employee findByEmail(String email);

}