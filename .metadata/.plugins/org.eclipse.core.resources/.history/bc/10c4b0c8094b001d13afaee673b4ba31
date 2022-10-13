package com.cognixia.jump.miniproject;

public class SeatReservationMain {

	public static void main(String[] args) {
		Seat[][] seats = genSeats(5,5);
		
		//Start seating loop
		System.out.println("===============" + "\nSEATS" + "\n===============\n");
		System.out.println("    1 2 3 4 5" + "\n   ----------");
		int counter = 1;
		for (int row = 0; row < seats.length; row++) {
			System.out.print(counter + " | ");
			for (int cols = 0; cols < seats[row].length; cols++) {
				if (seats[row][cols] == null) {
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
		
		return seatGrid;
	}
	

}
