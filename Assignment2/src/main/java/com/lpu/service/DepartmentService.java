package com.lpu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.DepartmentDao;
import com.lpu.dao.StudentDao;
import com.lpu.entity.Department;
import com.lpu.entity.Student;
@Component
public class DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private StudentDao studentDao;
	
	public void addDepartment(Department department) {
        departmentDao.addDepartment(department);
    }

    public Department getDepartmentById(int id) {
        return departmentDao.getDepartmentById(id);
    }
    public void assignStudentToDepartment(int deptId, Student student) {

        Department department = departmentDao.getDepartmentById(deptId);
        student.setDepartment(department);

        studentDao.addStudent(student);
    }
    public void deleteDepartment(int id) {
    	departmentDao.deleteDepartment(id);
    }

}
