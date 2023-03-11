package com.SpringCoreAnnotations.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.SpringCoreAnnotations.Service.Pizza;

@Component
public class QualifierController {

	@Autowired
	@Qualifier("nonVegPizza")
	private Pizza pizza;

	public String getPizza() {
		return pizza.getPizza();
	}
}
