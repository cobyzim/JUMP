package com.cognixia.jump.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

// Serializable --> objects from this class get serialized (converted
// from object to json)
@Entity
public class Account implements Serializable{

	private static final long serialVersionUID = 1L;

	public static enum AccountType {
		SAVINGS, CHECKING, CREDIT
	}
	
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrements id
	private Integer id;
	
	// @Column --> provide column definitions
	@Min(value = 0)
	@Column(columnDefinition = "integer not null default 0")
	private int balance;
	
	// @Enumerated --> used for enums. We want enum to be stored as string here
	@Enumerated(EnumType.STRING)
	private AccountType type;
	
	// referencedColumnName --> name of PK in customer we are referencing as a FK
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;
	
	// Always create default constructor, it will be used to create the object
	// from the JSON sent in a request
	public Account() {
		
	}

	// Always set up getters/setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}

	// Don't need getCustomer() method
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", balance=" + balance + ", type=" + type + ", customer=" + customer + "]";
	}
	
}
