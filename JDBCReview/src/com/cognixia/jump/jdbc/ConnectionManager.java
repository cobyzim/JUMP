package com.cognixia.jump.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	// The single connection we will have and create
	private static Connection connection = null;
	
	private static final String URL = "jdbc:mysql://localhost:3306/university?serverTimezone=EST5EDT";
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Root@123";
	
	// Make connection based on URL, USERNAME, and PASSWORD
	// Keep private so that getConnection() manages when connection should be made
	private static void makeConnection() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connected");
		}
		catch (SQLException e) {
			System.out.println("ERROR: could not connect to DB" + e.getMessage());
		}
	}
	
	// Check if connection is null, if so, connection hasn't been made and will call
	// makeConnection() to make connection
	public static Connection getConnection() {
		if (connection == null) {
			makeConnection();
		}
		return connection;
	}
	
	
}
