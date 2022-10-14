package com.cognixia.jump.miniproject;

import java.util.Scanner;

public class SeatReservationMain {

	public static void main(String[] args) {
		Seat[][] seats = genSeats(5,5);
		Scanner scanner = new Scanner(System.in);
		
		//Display empty seats grid
		printSeatingGrid(seats);
		
		//TODO: Have an options menu pop up first so people can choose what they want to do
		//TODO: i.e. list the names of the people in a reserved seat: probably do this in a separate do-while
		
		reserveSeat(seats, scanner);
		
		//Do-While Loop if user wants to continue
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
		//Initialize seats so that the objects aren't null
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
	
	//Method to reserve seats based on user input
	public static void reserveSeat(Seat[][] seats, Scanner scanner) {
		System.out.println();
		System.out.println("Which seat do you want to reserve?");
		System.out.println("Row: ");
		
		int row = returnRow(scanner);
		System.out.println("Column: ");
		int col = returnCol(scanner);
		System.out.println("Name of person sitting here: ");
		String name = returnName(scanner);
		System.out.println();

		if (seats[row - 1][col - 1].getName() == null) {
			seats[row - 1][col - 1].setRow(row);
			seats[row - 1][col - 1].setCol(col);
			seats[row - 1][col - 1].setName(name);
		}
		else {
			System.out.println(seats[row - 1][col - 1].getName() + " has already reserved this seat, please pick a different one");
			reserveSeat(seats, scanner);
		}
		
		printSeatingGrid(seats);
		System.out.println();
	}
	
	//Row validity check helper method
	public static int returnRow(Scanner scanner) {
		int row = 0;
		try {
			row = Integer.parseInt(scanner.nextLine());
			while (row != 1 && row != 2 && row != 3 && row != 4 && row !=5) {
				System.out.println("INVALID ROW: Please enter a valid row (1-5)\n");
				System.out.println("Row: ");
				row = Integer.parseInt(scanner.nextLine());
			}
			return row;
		}
		catch (NumberFormatException e){
			while (row != 1 && row != 2 && row != 3 && row != 4 && row !=5) {
				System.out.println("INVALID ROW: Row must be a number between 1 and 5\n");
				System.out.println("Row: ");
				row = Integer.parseInt(scanner.nextLine());
			}
			return row;
		}
	}
	
	//Column validity check helper method
	public static int returnCol(Scanner scanner) {
		int col = 0;
		try {
			col = Integer.parseInt(scanner.nextLine());
			while (col != 1 && col != 2 && col != 3 && col != 4 && col !=5) {
				System.out.println("INVALID COLUMN: Please enter a valid column (1-5)\n");
				System.out.println("Column: ");
				col = Integer.parseInt(scanner.nextLine());
			}
			return col;
		}
		catch (NumberFormatException e) {
			while (col != 1 && col != 2 && col != 3 && col != 4 && col !=5) {
				System.out.println("INVALID COLUMN: Column must be a number between 1 and 5\n");
				System.out.println("Column: ");
				col = Integer.parseInt(scanner.nextLine());
			}
			return col;
		}
	}
	
	//String validity check helper method
	public static String returnName(Scanner scanner) {
		String name = scanner.nextLine();
		while (!(name.length() > 0)) {
			System.out.println("INVALID NAME: Name must not be blank");
			System.out.println("Name of person sitting here: ");
			name = scanner.nextLine();
		}
		return name;
	}
	
}
