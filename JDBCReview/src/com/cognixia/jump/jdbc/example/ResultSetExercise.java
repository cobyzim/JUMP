package com.cognixia.jump.jdbc.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.cognixia.jump.jdbc.ConnectionManager;

public class ResultSetExercise {

	public static void main(String[] args) {

		try {
			Connection conn = ConnectionManager.getConnection();
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT *, DATE_FORMAT(FROM_DAYS"
					+ "(DATEDIFF(NOW(), date_of_birth)), '%Y') + 0 AS age\n"
					+ "FROM student");
			
			System.out.println("\nSTUDENTS" + "\n----------------------------\n");
			
			
			while (rs.next()) {
				System.out.println("Name: " + rs.getString("first_name")
					+ " " + rs.getString("last_name") + "      " + 
						"Age: " + rs.getInt("age"));
			}
			
			rs.close();
			conn.close();
					
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
