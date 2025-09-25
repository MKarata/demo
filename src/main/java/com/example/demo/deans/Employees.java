package com.example.demo.deans;

import jakarta.persistence.Id;


public class Employees {
//public class Employees implements Comparable<Employees> {
		
		
	@Id
	int id;
    String name;
    double salary;
    
	public Employees(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	//Natural comparing by implementing Comparable in bean class
//	 @Override
//	    public int compareTo(Employees other) {
//	        return Integer.compare(this.id, other.id);
//	    }
	
	  public String getName() {
	        return name;
	  }
	  
	  public int getId() {
	        return id;
	  }
	 
	 @Override 
	    public String toString() {
	        return id + " - " + name + " - " + salary;
	    }

}
