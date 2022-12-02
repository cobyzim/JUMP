package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.exception.ResourceNotFoundException;
import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.Customer;
import com.cognixia.jump.repository.CustomerRepository;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	CustomerRepository repo;
	
	@GetMapping("/customer")
	public List<Customer> getCustomers() {
		
		return repo.findAll();
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable int id) throws ResourceNotFoundException {
		
		Optional<Customer> found = repo.findById(id);
		
		if (found.isEmpty()) {
			throw new ResourceNotFoundException("Customer", id);
		}
		
		return ResponseEntity.status(200).body(found.get());
	}
	
	@PostMapping("/customer")
	public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer) {
		
		customer.setId(null);
		
		// Without this, spring can't create foreign key
		for (Account a : customer.getAccounts()) {
			a.setId(null);
			a.setCustomer(customer);
		}
		
		Customer created = repo.save(customer);
		
		return ResponseEntity.status(201).body(created);
	}
	
}
