package com.cognixia.corejava.studentprogram;

public class Student {
	
	private String firstName;
	private String lastName;
	private int age;
	private double gpa;
	
	//Default No-args Constructor
	public Student() {
		
	}
	
	public Student(String firstName, String lastName, int age, double gpa) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gpa = gpa;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gpa=" + gpa + "]";
	}
	
	public int roundGpa() {
		return (int) Math.round(gpa);
	}

	

}
