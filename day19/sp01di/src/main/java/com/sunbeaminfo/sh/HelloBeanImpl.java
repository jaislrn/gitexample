package com.sunbeaminfo.sh;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class HelloBeanImpl {
	@PostConstruct
	public void init() {
		System.out.println("HelloBeanImpl init() called.");
	}
}

