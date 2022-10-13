package com.cognixia.jump.miniproject;

import java.util.Scanner;

public class SeatReservationMain {

	public static void main(String[] args) {
		Seat[][] seats = genSeats(5,5);
		Scanner scanner = new Scanner(System.in);
		
		//Start seating loop
		System.out.println("===============" + "\nSEATS" + "\n===============\n");
		System.out.println("    1 2 3 4 5" + "\n   ----------");
		int counter = 1;
		for (int row = 0; row < seats.length; row++) {
			System.out.print(counter + " | ");
			for (int cols = 0; cols < seats[row].length; cols++) {
				if (seatIsEmpty(seats[row][cols])) {
					System.out.print("o ");
				}
				else {
					System.out.print("x ");
				}
			}
			counter++;
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Which seat do you want to reserve?");
		System.out.println("Row: ");
		int row1 = Integer.parseInt(scanner.nextLine());
		//TODO: Add check to make sure provided row is valid
		System.out.println("Column: ");
		int col1 = Integer.parseInt(scanner.nextLine());
		//TODO: Add check to make sure provided row is valid
		System.out.println("Name of person sitting here: ");
		String name1 = scanner.nextLine();
		//TODO: Add check to make sure name is actually a string (not a char or number)
		System.out.println();
		
		seats[row1 - 1][col1 - 1].setRow(row1);
		seats[row1 - 1][col1 - 1].setCol(col1);
		seats[row1 - 1][col1 - 1].setName(name1);
		
		System.out.println("===============" + "\nSEATS" + "\n===============\n");
		System.out.println("    1 2 3 4 5" + "\n   ----------");
		counter = 1;
		for (int row = 0; row < seats.length; row++) {
			System.out.print(counter + " | ");
			for (int cols = 0; cols < seats[row].length; cols++) {
				if (seatIsEmpty(seats[row][cols])) {
					System.out.print("o ");
				}
				else {
					System.out.print("x ");
				}
			}
			counter++;
			System.out.println();
		}
		
		
	}
	
	public static Seat[][] genSeats(int numRows, int numCols) {
		Seat[][] seatGrid = new Seat[numRows][numCols];
		//Have to initialize seats so that the objects aren't null
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				seatGrid[i][j] = new Seat();
			}
		}
		
		return seatGrid;
	}
	
	//Check for empty seat helper method
	public static boolean seatIsEmpty(Seat seat) {
		boolean isEmpty = false;
		if (seat.getName() == null) {
			isEmpty = true;
		}
		
		return isEmpty;
	}
	
	
}
