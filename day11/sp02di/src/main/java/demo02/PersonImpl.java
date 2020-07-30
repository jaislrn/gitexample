package demo02;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;

public class PersonImpl {
	private int age;
	private String name;
	private String email;
	
	public PersonImpl() {
		System.out.println("PersonImpl() called");
	}

	public PersonImpl(int age, String name, String email) {
		this.age = age;
		this.name = name;
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "PersonImpl [age=" + age + ", name=" + name + ", email=" + email + "]";
	}
	
	@PostConstruct
	public void personInit() {
		System.out.println("personInit() called.");
	}
	
	@PreDestroy
	public void personDestroy() {
		System.out.println("personDestroy() called.");
	}
}




