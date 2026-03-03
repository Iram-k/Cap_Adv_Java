package com.lpu.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.demo.entity.Student;

@RestController // it has Rest API
public class MyController {

	@GetMapping("/hi")
	public String takeReg() {
		return "byeeeeeeee";
	}

	// Method Type -> GET

	// URL -> http://localhost:8080/takeData?id=108&name=Iram
	@GetMapping("/takeData")
	public String takeData(@RequestParam int id, @RequestParam String name) {
		return "ID= " + id + " NAME= " + name;
	}

	// URL -> http://localhost:8080/college?id=108&name=Iram&location=Phagwara
	@GetMapping("/college")
	public String college(@RequestParam int id, @RequestParam String name, @RequestParam String location) {
		return "ID= " + id + " NAME= " + name + " Location=" + location;
	}

	// http://localhost:8080/takeData2/11
	@GetMapping("/takeData2/{id}")
	public String takeData2(@PathVariable int id) {
		return "ID= " + id;
	}

	// http://localhost:8080/takeData3/11/Jumi
	@GetMapping("/takeData3/{id}/{name}")
	public String takeData3(@PathVariable int id, @PathVariable String name) {
		return "ID = " + id + " NAME =" + name;
	}
	
	// http://localhost:8080/student/55/college/88
	@GetMapping("/student/{sId}/college/{cId}")
	public String takeData4(@PathVariable int  sId, @PathVariable int cId) {
		return "StudentID = "+sId+ " CollegeID = "+ cId;
				
	}
	
	//request header -> agr data hide krke dena ho url me
	//it stores meta data
	@GetMapping("/takeData4")
	public String takeData5(@RequestHeader int  id, @RequestHeader String name) {
		return "ID = "+id+ " Name = "+ name;
				
	} 
	
	@GetMapping("/student12") // requestbody it willl take jason object convert to java object
	public String getStudent(@RequestBody Student s) {
		System.out.println(s.getId());
		System.out.println(s.getName());
		System.out.println(s.getPhone());
		return s.getName() + " is Received";
	}
	
	@GetMapping("/student2")
	public Student getStudent2(@RequestBody Student s) {
		return s;
	}
	}
	

