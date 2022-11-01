package com.cognixia.jump.jdbc.daopractice;

import java.util.List;

public interface ChefDAO {

	public List<Chef> getAllChefs();
	public Chef getChefById(int chefId);
	public Chef getChefByName(String chefName);
	public Chef getChefByBestDish(String bestDish);
	public boolean addChef(Chef chef);
	public boolean updateChef(Chef chef);
	public boolean deleteChef(int chefId);
	
}
