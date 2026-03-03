package com.lpu.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lpu")//used to give common starting URL
@RestController
public class LpuController {
	@RequestMapping("/m1")//used t handle all type of method(post, get, delete) request
	public String m1() {
		return "";
	}
	
	@PostMapping("/student")
	public String saveStudent() {
		return "Student saved";
	}
	
	@PostMapping("/trainer")
	public String saveTrainer() {
		return "Trainer saved";
	}
	
	@PostMapping("/security")
	public String saveSecurity() {
		return "Security saved";
	}
}
