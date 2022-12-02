package com.cognixia.jump.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognixia.jump.model.Student;
import com.cognixia.jump.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student getStudentById(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		if (student.isPresent()) {
			return student.get();
		} else {
			return new Student();
		}
	}

	public List<Student> getStudentsByMajor(String major) {
		// TODO Auto-generated method stub
		return null;
	}

	public Student updateStudent(Student student) {
		return studentRepository.save(null);
	}

	public String deleteStudent(long id) {
		studentRepository.deleteById(id);
		return "Student " + id + " sucessfully Deleted";
	}

}
