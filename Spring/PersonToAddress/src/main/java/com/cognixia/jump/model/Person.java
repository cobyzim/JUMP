package com.cognixia.jump.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Person must have a name")
	@Column(nullable = false)
	private String name;
	
	@NotNull
	@Column(name = "date_of_birth")
	private LocalDate dob;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true)
	private Address address;

	public Person() {
		this(-1L, "N/A", LocalDate.now(), new Address());
	}
	
	public Person(Long id, @NotBlank(message = "Person must have a name") String name, @NotNull LocalDate dob,
			Address address) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", dob=" + dob + ", address=" + address + "]";
	}

}
