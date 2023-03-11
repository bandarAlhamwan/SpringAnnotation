package com.SpringCoreAnnotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SpringCoreAnnotations.Controller.PizzaController;
import com.SpringCoreAnnotations.Controller.QualifierController;
import com.SpringCoreAnnotations.Scope.PrototypeBean;
import com.SpringCoreAnnotations.Scope.SingletenBean;
import com.SpringCoreAnnotations.config.ChickenPizza;
import com.SpringCoreAnnotations.lazy.LazyLoader;

@SpringBootApplication
public class SpringCoreAnnotationsApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringCoreAnnotationsApplication.class, args);
		
		PizzaController pizzaController = context.getBean(PizzaController.class); 
		System.out.println( pizzaController.getPizza());
		
		PizzaController bean = (PizzaController) context.getBean("pizzaDemo");
		System.out.println(bean.getPizza());
		System.out.println(bean.getVegPizza());
		
		// if we have inject interface with to implementer classes we use @Qaulifier and @qualifier more Stronger then @primary
		QualifierController qualifier = (QualifierController) context.getBean("qualifierController");
		System.out.println(qualifier.getPizza());
		
		ChickenPizza chickenPizzaBean = context.getBean(ChickenPizza.class);
		System.out.println(chickenPizzaBean.getPizza());
		
		// on-demand
		LazyLoader LazyLoaderBean = context.getBean(LazyLoader.class);
		
		
		System.out.println("--- Bean Scope -----");
		SingletenBean singletonBean1 = context.getBean(SingletenBean.class);
		System.out.println(singletonBean1.hashCode());
		SingletenBean singletonBean2 = context.getBean(SingletenBean.class);
		System.out.println(singletonBean2.hashCode());
		SingletenBean singletonBean3 = context.getBean(SingletenBean.class);
		System.out.println(singletonBean3.hashCode());
		
		PrototypeBean prototype1 = context.getBean(PrototypeBean.class);
		System.out.println(prototype1.hashCode());
		PrototypeBean prototype2 = context.getBean(PrototypeBean.class);
		System.out.println(prototype2.hashCode());
		PrototypeBean prototype3 = context.getBean(PrototypeBean.class);
		System.out.println(prototype3.hashCode());
		System.out.println("--- Bean Scope -----");
		
	}

}
