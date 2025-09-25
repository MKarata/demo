package com.example.demo.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class EmployeeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String location;
	private int pinCode;
	private String empOrder;
	
	
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public void setEmpOrder(String empOrder) {
		this.empOrder = empOrder;
	}
	public String getEmpOrder() {
		return empOrder;
	}
	
	@PrePersist
	public void generateEmpOrder() {
		if(this.empOrder == null) {
			String prefix = "DEMO";
			String date = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyy"));
			String random = generateRandomAlphanumeric(4);
			this.empOrder = prefix + date + random;
		}
	}
	
	
	private String generateRandomAlphanumeric(int length) {
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(alpha.charAt(random.nextInt(alpha.length())));
		}
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", name=" + name + ", location=" + location + ", pinCode=" + pinCode
				+ ", empOrder=" + empOrder + "]";
	}
	
}
