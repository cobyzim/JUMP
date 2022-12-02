package com.cognixia.jump.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "my_car") // rename table in db as my_car instead of car
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String type;

	private int miles;
	
	public Car() {
		this(-1L, "N/A", 0);
	}

	public Car(Long id, String type, int miles) {
		super();
		this.id = id;
		this.type = type;
		this.miles = miles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMiles() {
		return miles;
	}

	public void setMiles(int miles) {
		this.miles = miles;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", type=" + type + ", miles=" + miles + "]";
	}
	
	public String toJson() {

		return "{\"id\" : " + id 
				+ ", \"type\" : \"" + type 
				+ "\"" + ", \"miles\" : " + miles + "}";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, miles, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(id, other.id) && miles == other.miles && Objects.equals(type, other.type);
	}
	
	
}
