package com.SpringCoreAnnotations.Scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SingletenBean {
	
	public SingletenBean() {
		System.out.println("SingletenBean ..");
	}
}
