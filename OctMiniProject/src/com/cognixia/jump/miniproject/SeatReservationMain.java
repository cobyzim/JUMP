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
		menuOptions(scanner, seats);
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	//User Choices Helper Method
	public static void menuOptions(Scanner scanner, Seat[][] seats) {
		boolean usrFinished = false;
			
		do {
			printOptions();
				
			int usrChoice = Integer.parseInt(scanner.nextLine());
				
			switch (usrChoice) {
				case 1: 
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
						
					break;
						
				case 2:
					System.out.println("Option 2");
					break;
						
				case 3:
					System.out.println("Option 3");
					break;
						
				case 4:
					System.out.println("Option 4");
					break;
						
				case 5:
					System.out.println("Thank you for using the application!");
					usrFinished = true;
					break;
						
				default:
					System.out.println("Invalid Option, Try again");
					break;
					
			}
		}
		while (usrFinished == false);
	}
	
	//Method to print possible user options
	public static void printOptions() {
		System.out.println("\nPlease choose an option: \n");
		System.out.println("1) Reserve Seats");
		System.out.println("2) View Reserved Seats");
		System.out.println("3) Delete Seat Reservation");
		System.out.println("4) Move Seat");
		System.out.println("5) Save and Exit");
	}
	
	//Initialize 2D array with empty seats
	public static Seat[][] genSeats(int numRows, int numCols) {
		Seat[][] seatGrid = new Seat[numRows][numCols];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				seatGrid[i][j] = new Seat();
			}
		}
		
		return seatGrid;
	}
	
	//Check for empty seat method
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
	
	//Row validity check method
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
	
	//Column validity check method
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
	
	//String validity check method
	public static String returnName(Scanner scanner) {
		String name = scanner.nextLine();
		while (!(name.length() > 0)) {
			System.out.println("INVALID NAME: Name must not be blank");
			System.out.println("Name of person sitting here: ");
			name = scanner.nextLine();
		}
		return name;
	}
	
	//Method for viewing people in seats that are already reserved
	public static void viewReservedSeats(Seat[][] seats) {
		
	}
	
	
	
	
}
