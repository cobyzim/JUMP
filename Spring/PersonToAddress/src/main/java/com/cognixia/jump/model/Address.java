package com.cognixia.jump.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "State must be provided")
	@Pattern(regexp = "^[A-Z]{2}$", message = "Must be a State Abbreviation")
	private String state;
	
	@NotBlank(message = "City must be provided")
	@Column(nullable = false, columnDefinition = "varchar(225) default 'N/A'")
	private String city;
	
	@NotBlank(message = "Street must be provided")
	@Column(nullable = false, columnDefinition = "varchar(225) default 'N/A'")
	private String street;
	
	@NotNull(message = "Street Number must be provided")
	@Min(1)
	@Column(nullable = false)
	private int number;
	
	@OneToOne(mappedBy = "address")
	private Person person;
	
	public Address() {
		this(-1L,"NA", "N/A","N/A", 0);
	}

	public Address(Long id,
			@NotBlank(message = "State must be provided") @Pattern(regexp = "^[A-Z]{2}$", message = "Must be a State Abbreviation") String state,
			@NotBlank(message = "City must be provided") String city,
			@NotBlank(message = "Street must be provided") String street,
			@NotBlank(message = "Street Number must be provided") @Min(1) int number) {
		super();
		this.id = id;
		this.state = state;
		this.city = city;
		this.street = street;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

//	public Person getPerson() {
//		return person;
//	}
//
//	public void setPerson(Person person) {
//		this.person = person;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", state=" + state + ", city=" + city + ", street=" + street + ", number=" + number
				+ ", person=" + person + "]";
	}

}
