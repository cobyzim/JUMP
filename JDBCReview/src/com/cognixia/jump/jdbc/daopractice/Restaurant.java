package com.cognixia.jump.jdbc.daopractice;

public class Restaurant {
	
	private int rest_id;
	private String rest_name;
	private String signature_dish;
	
	public Restaurant(int rest_id, String rest_name, String signature_dish) {
		super();
		this.rest_id = rest_id;
		this.rest_name = rest_name;
		this.signature_dish = signature_dish;
	}

	public int getRest_id() {
		return rest_id;
	}

	public void setRest_id(int rest_id) {
		this.rest_id = rest_id;
	}

	public String getRest_name() {
		return rest_name;
	}

	public void setRest_name(String rest_name) {
		this.rest_name = rest_name;
	}

	public String getSignature_dish() {
		return signature_dish;
	}

	public void setSignature_dish(String signature_dish) {
		this.signature_dish = signature_dish;
	}
	
	@Override
	public String toString() {
		return "Restaurant [rest_id=" + rest_id + ", rest_name=" + rest_name + ", signature_dish=" + signature_dish + "]";
	}
	
	
}
