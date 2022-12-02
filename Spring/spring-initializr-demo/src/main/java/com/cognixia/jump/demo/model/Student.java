package com.cognixia.jump.demo.model;

import java.time.LocalDate;

public class Student {
	
	private int id;
	private String name;
	private LocalDate dob;
	private String major;
	
	public Student(int id, String name, LocalDate dob, String major) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.major = major;
	}
	
	public Student() {
		this(-1, "N/A", LocalDate.now(), "N/A");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
