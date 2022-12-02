package com.cognixia.jump.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Car;
import com.cognixia.jump.repository.CarRepository;
import com.cognixia.jump.service.CarService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {

	private static final String STARTING_URI = "http://localhost:8080/api";
	
	@Autowired
	private MockMvc mvc;
	
	// mock method calls for the service
	// mock the creation of this service when it gets autowired in CarController
	@MockBean
	private CarService service;
	
	// when controller tries to autowire service, don't do that
	// we set up the service as a mockbean, so we instead want
	// to mock the creation of that service
	@InjectMocks
	private CarController controller;
	
	@Mock
	private CarRepository repo;
	
	// test that we get back the cars in the table and that we
	// get a 200 status code
	@Test
	void testGetAllCars() throws Exception {
		
		// ARRANGE
		// uri for request
		String uri = STARTING_URI + "/car";
		
		// Make some dummy data the service will return when we call
		// service.getAllCars()
		List<Car> allCars = new ArrayList<Car>();
		allCars.add(new Car(1L, "Toyota", 3000));
		allCars.add(new Car(2L, "Bentley", 2000));
		
		// when service.getAllCars() is called within controller
		// method, method won't actually make calls to DB, but will
		// just return dummy data we set up above
		when(service.getAllCars())
			.thenReturn(allCars);
		
		// ACT/ASSERT
		mvc.perform(get(uri))
			.andExpect(status().isOk())  // check for 200 status code
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))  // check response is json
			.andExpect(jsonPath("$.length()").value(allCars.size()))  // check json array has 2 elements
			.andExpect(jsonPath("$[0].id").value(allCars.get(0).getId())) // check each column value for the cars in list
			.andExpect(jsonPath("$[0].type").value(allCars.get(0).getType()))
			.andExpect(jsonPath("$[0].miles").value(allCars.get(0).getMiles()))
			.andExpect(jsonPath("$[1].id").value(allCars.get(1).getId()))
			.andExpect(jsonPath("$[1].type").value(allCars.get(1).getType()))
			.andExpect(jsonPath("$[1].miles").value(allCars.get(1).getMiles()));   
		
		// verify used to check how many times a method is called during a test
		verify(service, times(1)).getAllCars();
		
	}
	
	@Test
	void testGetCar() throws Exception {
		
		// ARRANGE
		long id = 1;
		String uri = STARTING_URI + "/car/{id}";
		
		Car car = new Car(id, "Bentley", 2000);
		
		when(service.getCarById(id))
			.thenReturn(car);
		
		// ACT/ASSERT
		mvc.perform(get(uri, id))
		    .andExpect(status().isOk())
		    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
		    .andExpect(jsonPath("$.id").value(car.getId()))
		    .andExpect(jsonPath("$.type").value(car.getType()))
		    .andExpect(jsonPath("$.miles").value(car.getMiles()));
		
	}
	
	@Test
	void testGetCarNotFound() throws Exception {
		
		// ARRANGE
		long id = 1;
		String uri = STARTING_URI + "/car/{id}";
		
		when(service.getCarById(id))
			.thenThrow(new ResourceNotFoundException("Car not found"));
		
		// ACT/ASSERT
		mvc.perform(get(uri, id))
		    .andExpect(status().isNotFound());
		
	}
	
	@Test
	void testCreateCar() throws Exception {
		
		// ARRANGE
		String uri = STARTING_URI + "/add/car";
		
		// the car that will be returned back in response
		Car car = new Car(1L, "Bentley", 2000);
		
		// Mockito.any --> when we send car in request, we don't care how it's 
		// formatted or what kind of data it has. Just want to make sure response
		// is formatted correctly
		when(service.addCar(Mockito.any(Car.class))).thenReturn(car);
		
		// ACT/ASSERT
		mvc.perform(post(uri)
				.content(asJsonString(car))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isCreated())
			.andExpect(jsonPath("$.id").value(car.getId()))
			.andExpect(jsonPath("$.type").value(car.getType()))
		    .andExpect(jsonPath("$.miles").value(car.getMiles()));
		
	}
	
	@Test
	void testUpdateCar() throws Exception {
		
		// ARRANGE
		String uri = STARTING_URI + "/update/car";
		
		Car updatedCar = new Car(1L, "Updated Bentley", 2000);
		
		when(service.updateCar(Mockito.any(Car.class))).thenReturn(updatedCar);
		
		// ACT/ASSERT
		mvc.perform(put(uri)
				.content(asJsonString(updatedCar))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id").value(updatedCar.getId()))
			.andExpect(jsonPath("$.type").value(updatedCar.getType()))
		    .andExpect(jsonPath("$.miles").value(updatedCar.getMiles()));
		
	}
	
	@Test
	void testUpdateCarNotFound() throws Exception {
		
		// ARRANGE
		String uri = STARTING_URI + "/update/car";
		
		Car car = new Car(1L, "Mazda", 1000);
		
		when(service.updateCar(Mockito.any(Car.class)))
			.thenThrow(new ResourceNotFoundException("Car not found"));
		
		// ACT/ASSERT
		mvc.perform(put(uri)
				.content(asJsonString(car))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isNotFound());
		
	}
	
	@Test
	void testDeleteCar() throws Exception {
		
		// ARRANGE
		long id = 1;
		String uri = STARTING_URI + "/delete/car/{id}";
		
		Car car = new Car(id, "Bentley", 2000);
		
		when(service.deleteCar(id)).thenReturn(car);
		
		// ACT/ASSERT
		mvc.perform(delete(uri, id))
			.andExpect(status().isOk());
		
	}
	
	@Test
	void testDeleteCarNotFound() throws Exception {
		
		// ARRANGE
		long id = 1;
		String uri = STARTING_URI + "/delete/car/{id}";
		
		when(service.deleteCar(id))
			.thenThrow(new ResourceNotFoundException("Car not found"));
		
		// ACT/ASSERT
		mvc.perform(delete(uri, id))
			.andExpect(status().isNotFound());
	}
	
	
	
	
	
	// Helper method to convert object to a JSON string
	public static String asJsonString(final Object obj) {
		
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} 
		catch (JsonProcessingException e) {
			throw new RuntimeException();
		}
		
	}
	
	
	
	
	
	
	
}
