package com.cognixia.jump.crudexercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.crudexercise.model.Animal;
import com.cognixia.jump.crudexercise.service.AnimalService;

@RestController
@RequestMapping("/api")
public class AnimalController {
	
	@Autowired
	AnimalService service;
	
	@PostMapping
	public Animal addAnimal(@RequestBody Animal animal) {
		return service.addAnimal(animal);
	}
	
	@GetMapping
	public List<Animal> getAllAnimals() {
		return service.getAllAnimals();
	}
	
//	public Animal getAnimalById(@PathVariable int id) {
//		return null;
//	}
//	
//	public Animal getAnimalByName(@PathVariable String name) {
//		return null;
//	}
//	
//	public List<Animal> getAnimalsByGroup(@PathVariable String group) {
//		return null;
//	}
//	
//	public List<Animal> getAnimalsByNoise(@PathVariable String noise) {
//		return null;
//	}
	
}
