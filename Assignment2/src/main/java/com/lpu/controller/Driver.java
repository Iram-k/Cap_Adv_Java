package com.lpu.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lpu.entity.Department;
import com.lpu.entity.Student;
import com.lpu.service.DepartmentService;
import com.lpu.service.StudentService;

public class Driver {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		DepartmentService departmentService = context.getBean(DepartmentService.class);

		StudentService studentService = context.getBean(StudentService.class);

		Department dept1 = new Department();
		dept1.setName("Computer Science");
		departmentService.addDepartment(dept1);
		
		Department dept2 = new Department();
		dept2.setName("Robotics");
		departmentService.addDepartment(dept2);
		
		Department dept3 = new Department();
		dept3.setName("Electrical");
		departmentService.addDepartment(dept3);
		
		Department dept4 = new Department();
		dept4.setName("BBA");
		departmentService.addDepartment(dept4);
		
		
		Student student1 = new Student();
		student1.setName("Rahul");
		student1.setEmail("rahul@gmail.com");
		
		Student student2 = new Student();
		student2.setName("Cat");
		student2.setEmail("Cat@gmail.com");
		
		Student student3 = new Student();
		student3.setName("Dog");
		student3.setEmail("Dog@gmail.com");
		
		Student student4 = new Student();
		student4.setName("Elephant");
		student4.setEmail("Elephant@gmail.com");
		
		
		
		
		departmentService.assignStudentToDepartment(dept1.getId(), student1);
		departmentService.assignStudentToDepartment(dept2.getId(), student2);
		departmentService.assignStudentToDepartment(dept1.getId(), student3);
		departmentService.assignStudentToDepartment(dept4.getId(), student4);
		
		Student fetchedStudent = studentService.getStudentById(student1.getId());
		System.out.println(fetchedStudent.getName() + " - " + fetchedStudent.getDepartment().getName());
	}

}
