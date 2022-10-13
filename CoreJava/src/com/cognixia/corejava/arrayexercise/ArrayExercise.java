package com.cognixia.corejava.arrayexercise;

import java.util.Arrays;

public class ArrayExercise {

	public static void main(String[] args) {
		// CHECK IF TWO ARRAYS MATCH
		int[] numArr1 = {1, 3, 5, 0};
		int[] numArr2 = {0, 5, 1, 3};
		
		if (numArr1.length != numArr2.length) {
			System.out.println("Arrays don't match");
		}
		else {
			Arrays.sort(numArr1);
			Arrays.sort(numArr2);
			
			System.out.println("Do Arrays Match: " + checkForMatch(numArr1, numArr2));
		}
		
		
		//FIND MISSING NUMBER IN SEQUENTIAL ARRAY
		int[] numArr = {1, 2, 3, 4, 5, 7, 8, 9, 10};
		int missingNum = findMissingNumber(numArr);
		System.out.println(missingNum);
		
		
	}

	private static int findMissingNumber(int[] numArr) {
		int missingNumber = 0;
		int counter = 1;
		for (int i = 0; i < numArr.length; i++) {
			if (numArr[i] != counter) {
				missingNumber = i + 1;
				return missingNumber;
			}
			counter++;
		}
		
		return 0;
		
	}

	private static boolean checkForMatch(int[] arr1, int[] arr2) {
		boolean matching = true;
		
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				matching = false;
			}
		}
		
		return matching;
	}

}
