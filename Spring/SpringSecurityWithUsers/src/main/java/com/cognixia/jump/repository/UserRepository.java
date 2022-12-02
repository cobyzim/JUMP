package com.cognixia.jump.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	// custom query for finding a user by username.
	// sed when username + password are passed through API request,
	// we'll need a way to look up the user
	public Optional<User> findByUsername(String username);
	
	
	
}
