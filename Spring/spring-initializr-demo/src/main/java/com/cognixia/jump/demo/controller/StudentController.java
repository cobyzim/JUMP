package com.cognixia.jump.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.demo.model.Student;
import com.cognixia.jump.demo.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}
	
	@GetMapping
	public List<Student> getAllStudents() {
		return service.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable int id) {
		return service.getStudentById(id);
	}
	
	@PutMapping
	public Student updateStudent(Student student) {
		return null;
	}
	
	@DeleteMapping
	public String deleteStudent() {
		return null;
	}

}
