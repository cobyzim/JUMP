package com.cognixia.corejava.studentprogram;

public class StudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student1 = new Student("Coby", "Zimmerman", 24, 3.75);
		
		Student student2 = new Student();
		student2.setFirstName("Chris");
		student2.setLastName("Givin");
		student2.setAge(26);
		student2.setGpa(3.5);
		
		System.out.println(student1.toString() + "\n" + student2.toString());
		
		student1.setGpa(student1.roundGpa());
		
		System.out.println(student1.toString() + "\n" + student2.toString());
	}

}
