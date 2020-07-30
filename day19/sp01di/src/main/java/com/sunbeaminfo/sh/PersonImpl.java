package com.sunbeaminfo.sh;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PersonImpl implements Person {
	@Value("${p1.age}")
	private int age;
	@Value("${p1.name}")
	private String name;
	@Value("${p1.email}")	
	private String email;
	
	public PersonImpl() {
	}

	public PersonImpl(int age, String name, String email) {
		this.age = age;
		this.name = name;
		this.email = email;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "PersonImpl [age=" + age + ", name=" + name + ", email=" + email + "]";
	}
	
}




