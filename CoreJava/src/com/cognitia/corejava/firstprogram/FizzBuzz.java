package com.cognitia.corejava.firstprogram;

import java.util.ArrayList;

public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = fizzBuzz(15);
		for (String str : list) {
			System.out.println(str);
		}
	}
	
	public static ArrayList<String> fizzBuzz(int input) {
		ArrayList<String> arrList = new ArrayList<>();
		
		for (int i = 0; i <= input; i++) {
			if (checkForPrime(i)) {
				continue;
			}
	
			if (i == 0) {
				arrList.add("0");
			}
			else if (i % 3 == 0 && i % 5 == 0) {
				arrList.add("FizzBuzz");
			}
			else if (i % 3 == 0) {
				arrList.add("Fizz");
			}
			else if (i % 5 == 0) {
				arrList.add("Buzz");
			}
			else {
				arrList.add(String.valueOf(i));
			}
			
		}
		
	    return arrList;
	}
	
	public static boolean checkForPrime(int num) {
		boolean isPrime = true;
		
		if (num <= 1) {
			isPrime = false;
			return isPrime;
		}
		else {
			for (int i = 2; i <= num/2; i++) {
				if ((num % i) == 0) {
					isPrime = false;
					break;
				}
			}
		}
		
		return isPrime;
		
	}

}
