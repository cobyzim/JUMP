package com.cognixia.jump.jdbc.daopractice;

import java.util.List;

public interface RestaurantDao {

	public List<Restaurant> getAllRestaurants();
	public Restaurant getRestaurantById(int restId);
	public Restaurant getRestaurantByName(String restName);
	public Restaurant getRestaurantBySignatureDish(String signatureDish);
	public boolean addRestaurant(Restaurant rest);
	public boolean updateRestaurant(Restaurant rest);
	public boolean deleteRestaurant(int restId);
	
}
