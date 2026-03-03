package com.lpu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.demo.entity.College;
import com.lpu.demo.entity.Student;
import com.lpu.demo.repository.CollegeRepository;

@Service
public class CollegeService {

	@Autowired
	private CollegeRepository repository;

	public College saveCollege(College college) {

		if (college.getStudents() != null) {
			for (Student s : college.getStudents()) {
				s.setCollege(college);  
			}
		}

		return repository.save(college);
	}

	public College findCollegeById(int id) {
		return repository.findById(id).orElse(null);
	}

	public List<College> findAllCollege() {
		return repository.findAll();
	}

	public void deleteById(int id) {
		repository.deleteById(id);
	}
}