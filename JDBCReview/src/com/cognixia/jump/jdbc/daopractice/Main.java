package com.cognixia.jump.jdbc.daopractice;

public class Main {

	public static void main(String[] args) {
		
		ChefDAO chefDAO = new ChefDAOClass();
		
		System.out.println("These are all chefs in database: ");
		
		for (Chef chef : chefDAO.getAllChefs()) {
			System.out.println(chef);
		}
		
		System.out.println("\nThis is the chef with id = 10004");
		System.out.println(chefDAO.getChefById(10004));
		
		System.out.println("\nThis is the chef with name = Linguini");
		System.out.println(chefDAO.getChefByName("Linguini"));
		
		System.out.println("\nThis is the chef with the best dish = Gumbo");
		System.out.println(chefDAO.getChefByName("Gumbo"));

	}

}
