package com.bootRest.entity;

public class Vehicle {

	int id;
	String name;
	int cc;
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
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + ", cc=" + cc + "]";
	}
	public Vehicle(int id, String name, int cc) {
		super();
		this.id = id;
		this.name = name;
		this.cc = cc;
	}
	public Vehicle() {
		super();
	}
	
	
}
