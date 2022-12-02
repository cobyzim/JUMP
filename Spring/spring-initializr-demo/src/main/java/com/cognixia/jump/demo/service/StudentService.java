package com.cognixia.jump.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognixia.jump.demo.model.Student;

@Service
public class StudentService {
	
	private static List<Student> students = new ArrayList<>();
	private static int idCounter = 1;
	
	static {
		students.add(new Student(idCounter++, "Naruto Uzumaki", LocalDate.of(1997, 10, 10), "Ninjutsu"));
		students.add(new Student(idCounter++, "Spike Spiegel", LocalDate.of(2044, 6, 26), "Bounty Hunter"));
		students.add(new Student(idCounter++, "Sonic The Hedgehog", LocalDate.of(1991, 6, 23), "Speed"));
		students.add(new Student(idCounter++, "Peppa Pig", LocalDate.of(2004, 5, 30), "Ninjutsu"));
		students.add(new Student(idCounter++, "Sharpay Evans", LocalDate.of(1985, 7, 2), "Theater"));
		students.add(new Student(idCounter++, "Dio Brando", LocalDate.of(1868, 4, 4), "Theater"));
	}

	public Student addStudent(Student student) {
		student.setId(idCounter);
		students.add(student);
		return student;
	}

	public List<Student> getAllStudents() {
		return students;
	}
	
	public Student getStudentById(int id) {
		for (Student s : students) {
			if (s.getId() == id) {
				return s;
			}
		}
		return new Student();
	}
}
