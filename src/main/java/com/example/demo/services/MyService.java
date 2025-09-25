package com.example.demo.services;

public class MyService extends MyAbstractClass implements MyInterface{

	
	//All the methods from the abstract and interface should be implemented in parent class
	@Override
	public void dog() {
		System.out.println("dog");
		
	}

	@Override
	public void cat() {
		System.out.println("cat");
		
	}

	@Override
	public void pig() {
		System.out.println("pig");
		
	}
	
	//Add this method to call everything
    public void run() {
        dog();
        cat();
        pig();
    }

}
