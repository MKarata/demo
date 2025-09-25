package com.example.demo;

public class User {
	
	private long id;
	private String name;
	private String department;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public User(long l, String name, String department) {
		super();
		this.id = l;
		this.name = name;
		this.department = department;
	}
	
	

}
