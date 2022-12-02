package com.cognixia.jump.crudexercise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognixia.jump.crudexercise.model.Animal;

@Service
public class AnimalService {
	
	private static List<Animal> animals = new ArrayList<>();
	private static int idCounter = 1;
	
	static {
		animals.add(new Animal(idCounter++, "Lion", "Mammal", "Rawr"));
		animals.add(new Animal(idCounter++, "Tiger", "Mammal", "Rawr"));
		animals.add(new Animal(idCounter++, "Tuna", "Fish", "Bloop"));
		animals.add(new Animal(idCounter++, "Grasshopper", "Insect", "Buzz"));
		animals.add(new Animal(idCounter++, "Salamander", "Amphibian", "Bloop"));
		animals.add(new Animal(idCounter++, "Alligator", "Reptile", "Rawr"));
	}
	
	public Animal addAnimal(Animal animal) {
		animal.setId(idCounter);
		animals.add(animal);
		return animal;
	}
	
	public List<Animal> getAllAnimals() {
		return animals;
	}

}
