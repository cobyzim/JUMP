package com.cognixia.jump.jdbc.daopractice;

public class Chef {
	
	private int chef_id;
	private String name;
	private int rest_id;
	private String best_dish;
	
	public Chef(int chef_id, String name, int rest_id, String best_dish) {
		super();
		this.chef_id = chef_id;
		this.name = name;
		this.rest_id = rest_id;
		this.best_dish = best_dish;
	}

	// No-args constructor
	public Chef() {
	}

	public int getChef_id() {
		return chef_id;
	}

	public void setChef_id(int chef_id) {
		this.chef_id = chef_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRest_id() {
		return rest_id;
	}

	public void setRest_id(int rest_id) {
		this.rest_id = rest_id;
	}

	public String getBest_dish() {
		return best_dish;
	}

	public void setBest_dish(String best_dish) {
		this.best_dish = best_dish;
	}
	
	@Override
	public String toString() {
		return "Chef [chef_id=" + chef_id + ", name=" + name + ", rest_id=" + rest_id + ", best_dish=" + best_dish + "]";
	}
	
	
	
}
