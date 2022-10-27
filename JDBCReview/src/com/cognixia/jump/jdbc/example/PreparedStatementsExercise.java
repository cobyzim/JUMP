package com.cognixia.jump.jdbc.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.cognixia.jump.jdbc.ConnectionManager;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class PreparedStatementsExercise {

	public static void main(String[] args) {
		int creditLowBound = 0;
		int creditHighBound = 0;

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter student standing: ");
		String standing = scanner.nextLine().toLowerCase();
		
		if (standing.equals("freshman")) {
			creditLowBound = 0;
			creditHighBound = 30;
		}
		else if (standing.equals("sophomore")) {
			creditLowBound = 31;
			creditHighBound = 60;
		}
		else if (standing.equals("junior")) {
			creditLowBound = 61;
			creditHighBound = 90;
		}
		else if (standing.equals("senior")) {
			creditLowBound = 91;
			creditHighBound = Integer.MAX_VALUE;
		}
		else {
			System.out.println("Please enter valid standing");
			System.exit(1);
		}
		
		scanner.close();
		
		try {
			Connection conn = ConnectionManager.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM student WHERE credits BETWEEN ? AND ?");
			
			pstmt.setInt(1, creditLowBound);
			pstmt.setInt(2, creditHighBound);
			
			ResultSet rs = pstmt.executeQuery();
			
			//if (credits >= 0 && credits <= 30) {
				while (rs.next()) {
					System.out.println("Name: " + rs.getString("first_name") + " " + rs.getString("last_name")
							+ "     Credits: " + rs.getInt("credits"));
				}
			//}
//			else if (credits > 30 && credits <= 60) {
//				while (rs.next()) {
//					System.out.println("Name: " + rs.getString("first_name") + " " + rs.getString("last_name")
//							+ "     Credits: " + credits);
//				}
//			}
				
			rs.close();
			pstmt.close();
			conn.close();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
