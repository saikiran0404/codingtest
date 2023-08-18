package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.ImagInnovateService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ImagInnovate")
public class ImagInnovateController {

	@Autowired
	ImagInnovateService imagInnovateService;

	@GetMapping("/test")
	public String test() {
		return "Test Success";
	}

	@PostMapping(value = "/createStudent", consumes = "application/json")
	public ResponseEntity<Object> createStudent(@Valid @RequestBody Student student) {
		ResponseEntity<Object> studentStatus = imagInnovateService.saveStudent(student);
		return new ResponseEntity<>(studentStatus, HttpStatus.OK);
	}

//	@PutMapping("/updateStudentMarks1")
//	public Student updateStudentMarks1(@Valid @RequestParam("marks1") int marks1,@RequestParam("marks2") int marks2,@RequestParam("marks3") int marks3,@RequestParam("id") int id) {
//		return imagInnovateService.updateStudentMarksBasedOnId1(marks1, marks2, marks3, id);
//		
//	}

	@PutMapping("/updateStudentMarks")
	public Student updateStudentMarks(@Valid @RequestBody Student student1) {
		return imagInnovateService.updateStudentMarksBasedOnId(student1);

	}

}
