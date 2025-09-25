package com.example.demo.services;

public interface MyInterface {

	//abstract keyword is not mandatory, if add keyword does not cause any error because by 
	// default all the methods are abstract 
	public abstract void dog();

	public void cat();
	
	public void pig();
	
	//concurrent method should be default or static
	public default void cow() {
		System.out.println("cow");
	}


}
