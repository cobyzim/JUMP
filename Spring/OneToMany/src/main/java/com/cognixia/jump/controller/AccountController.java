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
import com.cognixia.jump.repository.AccountRepository;

@RestController
@RequestMapping("/api")
public class AccountController {

	/* autowiring --> dependency injection
	 * 			  --> spring decides how object gets created
	 * 			  --> AccountRepository repo = new AccountRepoClass();*/ 
	@Autowired
	AccountRepository repo;
	
	@GetMapping("/account")
	public List<Account> getAccounts() {
		
		return repo.findAll();
	}

	
	@GetMapping("/account/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable int id) throws ResourceNotFoundException {
		
		Optional<Account> found = repo.findById(id);
		
		if (found.isEmpty()) {
			throw new ResourceNotFoundException("Account", id);
		}
		
		return ResponseEntity.status(200).body(found.get());
	}
	
	@PostMapping("/account")
	public ResponseEntity<?> createAccount(@Valid @RequestBody Account account) {
		
		account.setId(null); // don't reuse any ids that already exist
		
		Account created = repo.save(account);
		
		return ResponseEntity.status(201).body(created);
	}
}
