package com.cognixia.jump.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "student_name", nullable = false)
	private String name;
	
	@Column
	private LocalDate dob;
	
	@Column(columnDefinition = "varchar(100) default 'Undecided'")
	private String major;
	
	public Student() {
		this(-1L, "N/A", LocalDate.now(), "N/A");
	}

	public Student(Long id, String name, LocalDate dob, String major) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.major = major;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dob=" + dob + ", major=" + major + "]";
	}
	
}
