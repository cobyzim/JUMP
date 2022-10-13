package com.cognixia.jump.miniproject;

public class Seat {

	private int row;
	private int col;
	private String name;
	
	//Default no-args constructor
	public Seat() {
		
	}
	
	public Seat(int row, int col, String name) {
		this.row = row;
		this.col = col;
		this.name = name;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
