package com.sunbeam.sh;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GreetingBeanImpl {
	@Value("${app.greeting}")
	private String greet;
	
	@PostConstruct
	public void init() {
		System.out.println("GreetingBeanImpl init() called.");
	}
	
	public void greet(String user) {
		System.out.println(greet + ", " + user);
	}
}
