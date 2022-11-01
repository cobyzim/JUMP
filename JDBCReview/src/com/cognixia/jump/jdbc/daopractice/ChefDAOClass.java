package com.cognixia.jump.jdbc.daopractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cognixia.jump.jdbc.ConnManagerWithProperties;

public class ChefDAOClass implements ChefDAO {
	
	private Connection conn = ConnManagerWithProperties.getConnection();

	@Override
	public List<Chef> getAllChefs() {
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM chef");
			
			List<Chef> chefList = new ArrayList<Chef>();
			
			while(rs.next()) {
				
				int chefId = rs.getInt("chef_id");
				String name = rs.getString("name");
				int restId = rs.getInt("rest_id");
				String bestDish = rs.getString("best_dish");
				
				Chef chef = new Chef(chefId, name, restId, bestDish);
				chefList.add(chef);
			}
			
			return chefList;
		}
		catch(SQLException e) {
			System.out.println("Couldn't retrieve list of chefs from database");
		}
		
		// return null if chefs not found
		return null;
	}

	@Override
	public Chef getChefById(int chefId) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM chef WHERE chef_id = ?");
			pstmt.setInt(1, chefId);
			
			ResultSet rs = pstmt.executeQuery();
			
			Chef chef = new Chef();
			
			while(rs.next()) {
				int id = rs.getInt("chef_id");
				String name = rs.getString("name");
				int restId = rs.getInt("rest_id");
				String bestDish = rs.getString("best_dish");
				
				chef.setChef_id(id);
				chef.setName(name);
				chef.setRest_id(restId);
				chef.setBest_dish(bestDish);
			}
			
			return chef;
		}
		catch(SQLException e) {
			System.out.println("Chef with id = " + chefId + " not found.");
		}
		
		return null;
	}

	@Override
	public Chef getChefByName(String chefName) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM chef WHERE name = ?");
			pstmt.setString(1, chefName);
			
		    ResultSet rs = pstmt.executeQuery();
		    
		    Chef chef = new Chef();
			
			while(rs.next()) {
				int id = rs.getInt("chef_id");
				String name = rs.getString("name");
				int restId = rs.getInt("rest_id");
				String bestDish = rs.getString("best_dish");
				
				chef.setChef_id(id);
				chef.setName(name);
				chef.setRest_id(restId);
				chef.setBest_dish(bestDish);
			}
			
			return chef;
		}
		catch(SQLException e) {
			System.out.println("Chef with name = " + chefName + " not found.");
		}
		
		return null;
	}

	@Override
	public Chef getChefByBestDish(String bestDish) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM chef WHERE best_dish = ?");
			pstmt.setString(1, bestDish);
			
		    ResultSet rs = pstmt.executeQuery();
		    
		    Chef chef = new Chef();
			
			while(rs.next()) {
				int id = rs.getInt("chef_id");
				String name = rs.getString("name");
				int restId = rs.getInt("rest_id");
				String dish = rs.getString("best_dish");
				
				chef.setChef_id(id);
				chef.setName(name);
				chef.setRest_id(restId);
				chef.setBest_dish(dish);
			}
			
			return chef;
		}
		catch(SQLException e) {
			System.out.println("Chef with bestDish = " + bestDish + " not found.");
		}
		return null;
	}

	@Override
	public boolean addChef(Chef chef) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO chef(chef_id, name, rest_id, best_dish)"
					+ "values(?, ?, ?, ?)");
			
			pstmt.setInt(1, chef.getChef_id());
			pstmt.setString(2, chef.getName());
			pstmt.setInt(3, chef.getRest_id());
			pstmt.setString(4, chef.getBest_dish());
			
			int i = pstmt.executeUpdate();
			
			if (i > 0) {
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateChef(Chef chef) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("UPDATE chef SET name = ?, rest_id = ?, "
					+ "best_dish = ? WHERE chef_id = ?");
			
			pstmt.setString(1, chef.getName());
			pstmt.setInt(2, chef.getRest_id());
			pstmt.setString(3, chef.getBest_dish());
			pstmt.setInt(4, chef.getChef_id());
			
			int i = pstmt.executeUpdate();
			
			if (i > 0) {
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteChef(int chefId) {
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM chef WHERE chef_id = ?");
			pstmt.setInt(0, chefId);
			
			int i = pstmt.executeUpdate();
			
			if (i > 0) {
				return true;
			}
		}
		catch(SQLException e) {
			System.out.println("Chef with id = " + chefId + " not found.");
		}
		
		return false;
	}

}
