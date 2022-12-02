package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
	
	List<Car> findByType(String type);
	
	@Query("select c from Car c where c.miles < ?1")
	List<Car> carsWithMaxMiles(Integer miles);

}
