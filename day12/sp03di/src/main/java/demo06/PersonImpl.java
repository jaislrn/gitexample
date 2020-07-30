package demo06;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class PersonImpl {
	private int age;
	private String name;
	private String email;
	
	public PersonImpl() {
	}
	
	public PersonImpl(int age, String name, String email) {
		this.age = age;
		this.name = name;
		this.email = email;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Person.init() called.");
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
}




