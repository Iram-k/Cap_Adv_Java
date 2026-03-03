package com.lpu.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.demo.entity.Student;
import com.lpu.demo.repository.StudentRepository;

@Service
public class StudentService {
	// business logic
	@Autowired
	private StudentRepository repository;

	public Student saveStudent(Student student) {
		return repository.save(student);
	}

//	public StudentService() {
//	}
//
//	public StudentService(StudentRepository repository) {
//		this.repository = repository;
//	}
	public Student findStudentById(int id) {
//		Optional<Student> optional = repository.findById(id);
//		if(optional.isPresent()) {
//			return optional.get();
//		}
//		return null;

		// OR
		return repository.findById(id).orElse(null); // object hai to object return krega or null
	}

	public void deleteStudent(Student student) {
		repository.delete(student);
//		repository.deleteById(id);
	}

	public List<Student> findAllStudent() {
		return repository.findAll();
	}

	public List<Student> saveAllStudent(List<Student> list) {
		return repository.saveAll(list);
	}

	public void deleteById(int id) {
		repository.deleteById(id);
	}

	public List<Student> findByName(String name) {
		return repository.findByName(name);
	}

	public Student findByNameAndPhone(String name, long phone) {
		return repository.findByNameAndPhone(name, phone);
	}

	public List<Student> getStudentByName(String name) {
		return repository.getStudentByName(name);
	}

	public List<Student> getAllStudentsCustom() {
		return repository.getAllStudents();
	}

}
