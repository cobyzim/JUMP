package com.cognitia.corejava.firstprogram;

import java.util.Scanner;

public class ReadFromConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter value: ");
		String str = scanner.nextLine();
		
		System.out.println("Your string is: " + str);
		
	}

}
