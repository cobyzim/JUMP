package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Car;
import com.cognixia.jump.service.CarService;

@RequestMapping("/api")
@RestController
public class CarController {
	
	@Autowired
	CarService service;

	@GetMapping("/car")
	public List<Car> getAllCars() {
		
		return service.getAllCars();
	}

	@GetMapping("/car/{id}")
	public Car getCar(@PathVariable long id) throws ResourceNotFoundException {
		
		return service.getCarById(id);
	}
	
	@GetMapping("/car/type/{type}")
	public List<Car> getCarsByType(@PathVariable String type) {
		
		return service.getCarsOfType(type);
	}
	
	@GetMapping("/car/miles/max/{miles}")
	public List<Car> getCarsByMaxMiles(@PathVariable int miles) {
		
		return service.getCarsOfMaxMiles(miles);
	}
	
	@PostMapping("/add/car")
	public ResponseEntity<Car> createCar(@RequestBody Car car) {
		
		Car added = service.addCar(car);
		
		return new ResponseEntity<>(added, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/car")
	public ResponseEntity<Car> updateCar(@RequestBody Car car) throws ResourceNotFoundException {
		
		Car updated = service.updateCar(car);
		
		return new ResponseEntity<>(updated, HttpStatus.OK);	
	}
	
	@DeleteMapping("/delete/car/{id}")
	public ResponseEntity<Car> removeCar(@PathVariable long id) throws ResourceNotFoundException {
		
		Car deleted = service.deleteCar(id);
		
		return new ResponseEntity<>(deleted, HttpStatus.OK);
	}
	
	
}