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
	
/*
	 
	 Spring offer 3 type of configuration
- XML based configuration
- Annotation based configuration
- java based configuration 

@Component annotation tells spring container to automatically create spring bean
@Autowired annotation is used to inject the bean automatically (used {constructor-setterfield} injection)
@Qualifier annotation is used in conjunction with autowired to avoid confusion when we have two or more beans configured for same taype
@Primary Annotation to give higher preference to a bean when there are multiple beans of the same type (same as Qualifier but on class level)

Stereotype annotations
- These annotations are used to create spring beans automatically in the application context(Spring IoC container)
- The main stereotype annotation is @Component
- By using this annotation, spring provides more stereotype meta annotation such as @Service @Repository @Controller

@Lazy annotation by default, spring creates all singleton beans eagerly at the startup/bootstrapping of the application context.
you can load the spring beans lazily (on-demand) using @lazy annotation
@Lazy annotation can used with @Configuration, @Component and @Bean annotation
- Eager intialization is recommended to avoid and detect all possible errors immediately rather than at runtime


----- Spring Bean Scopes -----
@Scope annotation is used to define a scope of the bean. We use @Scope to define the scope of a @Component class or @Bean definition
- singleton : only one instance of the bean is created and shared across the entire application. this is the default scope
prototype : a new instance of the bean is created every time is it  requested
request : 
seasion
application
websocket


	 */

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
