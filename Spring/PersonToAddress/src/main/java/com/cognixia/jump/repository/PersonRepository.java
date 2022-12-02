package com.cognixia.jump.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognixia.jump.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
