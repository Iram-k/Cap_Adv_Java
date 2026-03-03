package com.lpu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.demo.entity.Student;
import com.lpu.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;

	@PostMapping("/student")
	public Student save(@RequestBody Student student) {
		return service.saveStudent(student);
	}

	@GetMapping("/student/{id}")
	public Student fetchStudentByID(@PathVariable int id) {
		return service.findStudentById(id);
	}

	@DeleteMapping("/student")
	public String deleteStudent(@RequestBody Student student) {
		service.deleteStudent(student);
		return "student delete";
	}

	@GetMapping("/student")
	public List<Student> findStudents() {
		return service.findAllStudent();

	}

	@DeleteMapping("/student/delete")
	public String deleteByID(@RequestParam int id) {
		service.deleteById(id);
		return "student deleted by id";
	}

	// Save all students
	@PostMapping("/student/save")
	public List<Student> saveAllStudents(@RequestBody List<Student> students) {
		return service.saveAllStudent(students);
	}
	//custom query
	

	// URL - http://localhost:8080/student/name/Jomaina
	@GetMapping("/student/name/{name}")
	public List<Student> findByName(@PathVariable String name) {
		return service.findByName(name);
	}

	// URL - http://localhost:8080/student/name-phone?name=Jomaina&phone=7899999
	@GetMapping("/student/name-phone")
	public Student findByNameAndPhone(@RequestParam String name, @RequestParam long phone) {
		return service.findByNameAndPhone(name, phone);
	}

	// URL - http://localhost:8080/student/jpql/Jomaina
	@GetMapping("/student/jpql/{name}")
	public List<Student> getStudentByName(@PathVariable String name) {
		return service.getStudentByName(name);
	}

	// URL - http://localhost:8080/student/native
	@GetMapping("/student/native")
	public List<Student> getAllStudentsNative() {
		return service.getAllStudentsCustom();
	}
}