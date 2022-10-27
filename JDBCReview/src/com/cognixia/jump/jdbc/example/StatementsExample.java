package com.cognixia.jump.jdbc.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.cognixia.jump.jdbc.ConnectionManager;

public class StatementsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Connection conn = ConnectionManager.getConnection();
			
			Statement stmt = conn.createStatement();
			System.out.println("Create statement");
			
			//int count = stmt.executeUpdate("update student set credits = 40 where student_id = 10001");
			// count = stmt.executeUpdate("select * from student");
			
			//System.out.println("Statement returned: " + count);
			
			stmt.close();
			conn.close();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
