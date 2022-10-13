package com.cognixia.jump.miniproject;

import java.util.Scanner;

public class SeatReservationMain {

	public static void main(String[] args) {
		Seat[][] seats = genSeats(5,5);
		Scanner scanner = new Scanner(System.in);
		
		//Display empty seats grid
		printSeatingGrid(seats);
		
		reserveSeat(seats, scanner);
		
		
		
		
		
		//Do Loop for if user wants to continue
		String resp = "";
		do {
			System.out.println("Are you finished reserving seats? (Y/N)");
			resp = scanner.nextLine().toUpperCase();
			
			if (resp.equals("N")) {
				reserveSeat(seats, scanner);
			}
			else {
				System.out.println("\nThanks for reserving your seats!\n");
				printSeatingGrid(seats);
			}
			
		}
		while(resp.equals("N"));
		
		
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
	
	
	//Method to print the current seating grid
	public static void printSeatingGrid(Seat[][] seats) {
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
	}
	
	public static void reserveSeat(Seat[][] seats, Scanner scanner) {
		System.out.println();
		System.out.println("Which seat do you want to reserve?");
		System.out.println("Row: ");
		int row = Integer.parseInt(scanner.nextLine());
		//TODO: Add check to make sure provided row is valid
		System.out.println("Column: ");
		int col = Integer.parseInt(scanner.nextLine());
		//TODO: Add check to make sure provided row is valid
		System.out.println("Name of person sitting here: ");
		String name1 = scanner.nextLine();
		//TODO: Add check to make sure name is actually a string (not a char or number)
		System.out.println();
		
		seats[row - 1][col - 1].setRow(row);
		seats[row - 1][col - 1].setCol(col);
		seats[row - 1][col - 1].setName(name1);
		
		printSeatingGrid(seats);
		System.out.println();
	}
	
	
}
