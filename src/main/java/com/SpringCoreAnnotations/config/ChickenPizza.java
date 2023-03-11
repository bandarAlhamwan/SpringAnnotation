package com.SpringCoreAnnotations.config;


public class ChickenPizza {

	
	public String getPizza() {
		return "Chicken Pizza";
	}

	public void init() {
		System.out.println("Initializtion Logic");
	}
	
	public void destroy() {
		System.out.println("Destruction Logic");
	}
}
