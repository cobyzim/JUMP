package com.cognixia.jump.miniproject;

import java.util.Scanner;

public class SeatReservationMain {

	public static void main(String[] args) {
		Seat[][] seats = genSeats(5,5);
		Scanner scanner = new Scanner(System.in);
		
		//Display empty seats grid
		printSeatingGrid(seats);
		
		menuOptions(scanner, seats);
		
	}
	
	//User Choices Method
	public static void menuOptions(Scanner scanner, Seat[][] seats) {
		boolean usrFinished = false;
			
		do {
			printOptions();
				
			int usrChoice = Integer.parseInt(scanner.nextLine());
				
			switch (usrChoice) {
				case 1: 
					System.out.println();
					System.out.println("Which seat do you want to reserve?");
					reserveSeat(seats, scanner);
					
					//Do-While Loop if user wants to continue
					String resp = "";
					do {
						System.out.println("Are you finished reserving seats? (Y/N)");
						resp = scanner.nextLine().toUpperCase();
						
						if (resp.equals("N")) {
							System.out.println();
							System.out.println("Which seat do you want to reserve?");
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
					viewReservedSeats(seats);
					break;
						
				case 3:
					deleteReservation(seats, scanner);
					break;
						
				case 4:
					moveSeats(seats, scanner);
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
		
		int row = returnRow(scanner);
		int col = returnCol(scanner);
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
		boolean bool = true;
		int row = 0;
		do {
			try {
				System.out.println("Row: ");
				row = Integer.parseInt(scanner.nextLine());
				
				if (row != 1 && row != 2 && row != 3 && row != 4 && row !=5) {
					System.out.println("INVALID ROW: Please enter a valid row (1-5)\n");
				}
				else {
					bool = false;
				}
			}
			catch (NumberFormatException e){
				System.out.println("INVALID ROW: Row must be a number between 1 and 5\n");
			}
		}
		while (bool);
		
		return row;
	}
	
	//Column validity check method
	public static int returnCol(Scanner scanner) {
		boolean bool = true;
		int col = 0;
		do {
			try {
				System.out.println("Column: ");
				col = Integer.parseInt(scanner.nextLine());
				
				if (col != 1 && col != 2 && col != 3 && col != 4 && col !=5) {
					System.out.println("INVALID Column: Please enter a valid column (1-5)\n");
				}
				else {
					bool = false;
				}
			}
			catch (NumberFormatException e){
				System.out.println("INVALID COLUMN: Column must be a number between 1 and 5\n");
			}
		}
		while (bool);
		
		return col;
	}
	
	//String validity check method
	public static String returnName(Scanner scanner) {
		System.out.println("Name of person sitting here: ");
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
		int counter = 0;
		for (int row = 0; row < seats.length; row++) {
			for (int col = 0; col < seats[row].length; col++) {
				Seat currSeat = seats[row][col];
				if (currSeat.getName() != null) {
					System.out.printf("%s is sitting in seat row %d, column %d\n", currSeat.getName(), 
							currSeat.getRow(), currSeat.getCol());
				}
				else {
					counter++;
				}
			}
		}
		if (counter == 25) {
			System.out.println("No seats are reserved at the moment.");
		}
	}
	
	//Method to delete a seating reservation
	public static void deleteReservation(Seat[][] seats, Scanner scanner) {
		System.out.println("Who's seat reservation would you like to delete?: ");
		String name = scanner.nextLine();
		
		//Check if that person has a reserved seat
		boolean personFound = false;
		for (int row = 0; row < seats.length; row++) {
			for (int col = 0; col < seats[row].length; col++) {
				Seat currSeat = seats[row][col];
				if (currSeat.getName() != null) {
					if (currSeat.getName().equals(name)) {
						personFound = true;
						currSeat.setName(null);
					}
				}
			}
		}
		
		if (personFound) {
			System.out.printf("%s's seat reservation was deleted", name);
		}
		else {
			System.out.printf("%s does not have a reserved seat", name);
		}
	}
	
	//Method to move seats
	public static void moveSeats(Seat[][] seats, Scanner scanner) {
		if (!findAvailableSeats(seats, scanner)) {
			System.out.println("There are no available seats to move to!");
			return;
		}
		System.out.println("Who's seat would you like to move?: ");
		String name = scanner.nextLine();
		
		boolean personFound = false;
		for (int row = 0; row < seats.length; row++) {
			for (int col = 0; col < seats[row].length; col++) {
				Seat currSeat = seats[row][col];
				if (currSeat.getName() != null) {
					if (currSeat.getName().equals(name)) {
						personFound = true;
						currSeat.setName(null);
					}
				}
			}
		}
		
		if (personFound == true) {
			System.out.println("Okay! Which seat would you like to swap to?: ");
			reserveSeat(seats, scanner);
		}
		else {
			System.out.printf("\n%s has not reserved a seat yet!\n", name);
		}
		
	}
	
	//Method to find available seats
	public static boolean findAvailableSeats(Seat[][] seats, Scanner scanner) {
		boolean isOpenSeats = false;
		for (int row = 0; row < seats.length; row++) {
			for (int col = 0; col < seats[row].length; col++) {
				Seat currSeat = seats[row][col];
				if (currSeat.getName() == null) {
					isOpenSeats = true;
				}
			}
		}
		
		return isOpenSeats;
	}
	
	
	
	
}
