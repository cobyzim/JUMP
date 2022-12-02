package com.cognixia.jump.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrements id
	private Integer id;
	
	@NotBlank(message = "Customer name cannot be blank")
	private String name;
	
	// ^ --> start of pattern
	// $ --> end of pattern
	@Pattern(regexp = "^[0-9]{4}$")
	private String pin;
	
	// mappedBy --> customer is linking to the accounts
	// cascade --> if there are changes to customer, will it affect the
	//				accounts they own
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Account> accounts;
	
	public Customer() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", pin=" + pin + ", accounts=" + accounts + "]";
	}
	
}
