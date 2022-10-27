package com.cognixia.jump.jdbc.example;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cognixia.jump.jdbc.ConnectionManager;

public class ResultSetExample {

	public static void main(String[] args) {
		
		try {
			
			// Create Connection
			Connection conn = ConnectionManager.getConnection();
			
			// Create Statement
			Statement stmt = conn.createStatement();
			
			// Create Result Set
			ResultSet rs = stmt.executeQuery("select * from student");
			
//			while (rs.next()) {
//				String id = rs.getString("last_name");
//				System.out.println("ID: " + id);
//			}
			
			// go to first row of your results
			//rs.first();
			
			// get column values for first row
//			System.out.println("\n\nID: " + rs.getInt(1)); // column number
//			System.out.println("Name: " + rs.getString("first_name") + " " 
//			                   + rs.getString("last_name"));
//			System.out.println("Gender: " + rs.getString("gender"));
//			System.out.println("D.O.B: " + rs.getDate("date_of_birth"));
//			System.out.println("Credits: " + rs.getString("credits"));
			
			
			// print all the records for the department table
			//rs = stmt.executeQuery("select * from department");
			
			// move to first record in result set
			//rs.first();
			
//			System.out.println("\n\nDEPARTMENTS");
//			System.out.println("---------------------------------------");
//			
//			do {
//				int deptID = rs.getInt(1);
//				String deptName = rs.getString(2);
//				String deptPhone = rs.getString(3);
//				
//				System.out.println("ID: " + deptID + " | Name: " + deptName + 
//						" | Phone: " + deptPhone);
//				
//			} while(rs.next());
//			
//			
//			
//			// close
//			rs.close();
//			stmt.close();
//			conn.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
