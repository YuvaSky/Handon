package com.person.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Emp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	private String name;
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Address address;
	
	public Emp(int id, String name, Address address) {
		super();
		this.eid = id;
		this.name = name;
		this.address = address;
	}

	public int getId() {
		return eid;
	}

	public void setId(int id) {
		this.eid = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Emp [id=" + eid + ", name=" + name + ", address=" + address + "]";
	}
		

}
