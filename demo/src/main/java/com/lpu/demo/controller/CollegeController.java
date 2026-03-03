package com.lpu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lpu.demo.entity.College;
import com.lpu.demo.service.CollegeService;

@RestController
public class CollegeController {

	@Autowired
	private CollegeService service;

	@PostMapping("/college")
	public College save(@RequestBody College college) {
		return service.saveCollege(college);
	}

	@GetMapping("/college/{id}")
	public College getById(@PathVariable int id) {
		return service.findCollegeById(id);
	}

	@GetMapping("/college/all")
	public List<College> getAll() {
		return service.findAllCollege();
	}

	@DeleteMapping("/college/delId")
	public String delete(@RequestParam int id) {
		service.deleteById(id);
		return "college deleted";
	}
}