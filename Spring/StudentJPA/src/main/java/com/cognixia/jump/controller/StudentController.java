package com.cognixia.jump.controller;

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

import com.cognixia.jump.model.Student;
import com.cognixia.jump.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping
	public String addStudent(@RequestBody Student student) {
//		return service.addStudent(student);
		return "studnet " + service.addStudent(student).getName() + " successfully added";
	}

	@GetMapping
	public List<Student> getAllStudents() {
		return service.getAllStudents();
	}
	
	@GetMapping("/id/{id}")
	public Student getStudentByID(@PathVariable Long id) {
		return service.getStudentById(id);
	}
	
	@GetMapping("/major/{major}")
	public List<Student> getStudentsByMajor(@PathVariable String major){
		return service.getStudentsByMajor(major);
	}
	
	@PutMapping()
	public Student updateStudent(@RequestBody Student student) {
		return service.updateStudent(student);
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
		return service.deleteStudent(id);
	}
}
