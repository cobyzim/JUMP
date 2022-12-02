package com.cognixia.jump.crudexercise.model;

public class Animal {
	
	private int id;
	private String name;
	private String group;
	private String noise;
	
	public Animal(int id, String name, String group, String noise) {
		super();
		this.id = id;
		this.name = name;
		this.group = group;
		this.noise = noise;
	}
	
	public Animal() {
		this(-1, "N/A", "N/A", "N/A");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecies() {
		return group;
	}
	public void setSpecies(String group) {
		this.group = group;
	}
	public String getNoise() {
		return noise;
	}
	public void setNoise(String noise) {
		this.noise = noise;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", group=" + group + ", noise=" + noise + "]";
	}

}
