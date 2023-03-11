package com.SpringCoreAnnotations.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.SpringCoreAnnotations.Service.VegPizza;

@Component("pizzaDemo")
public class PizzaController {
	
	// field injection 
	@Autowired 
	VegPizza vegPizza;
	
	
//	// Construct injection
//	@Autowired
//	public PizzaController(VegPizza vegPizza) {
//		this.vegPizza = vegPizza;
//	}
	
//	// Setter injection
//	@Autowired
//	public void setVegPizza(VegPizza vegPizza) {
//		this.vegPizza = vegPizza;
//	}
	
	

	public String getPizza() {
		return "Hot Pizza!";
	}
	

	public String getVegPizza() {
		return vegPizza.getPizza();
	}
}
