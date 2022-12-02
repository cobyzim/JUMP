package com.cognixia.jump.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Car;
import com.cognixia.jump.repository.CarRepository;

@ExtendWith(MockitoExtension.class)
public class CarServiceTests {

	// mock repository methods
	@Mock
	private CarRepository repo;
	
	// don't want service to autowire the repository
	// telling it to use "mocked" repo and treat repo as a dummy one
	@InjectMocks
	private CarService service;
	
	@Test
	void testGetAllCars() throws Exception {
		
		// ARRANGE
		List<Car> allCars = new ArrayList<>();
		allCars.add(new Car(1L, "Nissan", 2000));
		allCars.add(new Car(2L, "Mazda", 1000));
		
		when(repo.findAll()).thenReturn(allCars);
		
		// ACT
		List<Car> result = service.getAllCars();
		
		// ASSERT
		for (int i = 0; i < allCars.size(); i++) {
			Car expected = allCars.get(i);
			Car actual = result.get(i);
			
			if (!expected.equals(actual)) {
				fail();
			}
		}
	}
	
	@Test
	void testGetCarById() throws Exception {
		
		// ARRANGE
		long id = 1;
		Car car = new Car(id, "Chevrolet", 2000);
		
		when(repo.findById(id)).thenReturn(Optional.of(car));
		
		// ACT
		Car result = service.getCarById(id);
		
		// ASSERT
		// will compare two cars using the overridden equals() method in Car model class
		assertEquals(car, result);
		
	}
	
	@Test
	void testGetCarByIdNotFound() throws Exception {
		
		// ARRANGE
		long id = 1;
		
		when(repo.findById(id)).thenReturn(Optional.empty());
		
		// ACT/ASSERT
		// arg1: what exception you're looking for
		// arg2: the code that will throw the exception
		assertThrows(ResourceNotFoundException.class, () -> {
			service.getCarById(id);
		});
	}
	
	@Test
	void testUpdateCar() throws Exception {
		
		// ARRANGE
		Car car = new Car(1L, "Beamer", 2000);
		
		when(repo.existsById(car.getId())).thenReturn(true);
		when(repo.save(Mockito.any())).thenReturn(car);
		
		Car created = service.updateCar(car);
		
		// ACT/ASSERT
		assertEquals(car, created);
	}
	
	@Test
	void testUpdateCarNotFound() throws Exception {
		
		// ARRANGE
		Car car = new Car(1L, "Beamer", 2000);
		
		when(repo.existsById(car.getId())).thenReturn(false);
		
		// ACT/ASSERT
		assertThrows(ResourceNotFoundException.class, () -> {
			service.updateCar(car);
		});
	}
	
	@Test
	void testDeleteCar() throws Exception {
		
		// ARRANGE
		long id = 1;
		
		Car car = new Car(id, "Mazda", 1000);
		
		when(repo.findById(car.getId())).thenReturn(Optional.of(car));
		
		// ACT
		Car result = service.deleteCar(car.getId());
		
		// ASSERT
		assertEquals(car, result);
	}
	
	@Test
	void testDeleteCarNotFound() throws Exception {
		
		// ARRANGE
		long id = 1;
		
		Car car = new Car(id, "Mazda", 1000);
		
		when(repo.findById(car.getId())).thenReturn(Optional.empty());
		
		// ACT/ASSERT
		assertThrows(ResourceNotFoundException.class, () -> {
			service.deleteCar(car.getId());
		});
		
	}
	
}




















