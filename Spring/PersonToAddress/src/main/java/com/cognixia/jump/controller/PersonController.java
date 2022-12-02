package com.cognixia.jump.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Person;
import com.cognixia.jump.repository.PersonRepository;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	PersonRepository service;
	
	@GetMapping
	public ResponseEntity<List<Person>> getpersons(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable Long id){
		return null;
	}
	
	@PostMapping
	public ResponseEntity<?> addPerson(@RequestBody @Valid Person person) {
		return ResponseEntity.status(201).body(service.save(person));
	}
	
	@PutMapping
	public ResponseEntity<?> updatePerson() {
		return null;
	}
	
	@DeleteMapping
	public ResponseEntity<?> deletePerson() {
		return null;
	}

}
