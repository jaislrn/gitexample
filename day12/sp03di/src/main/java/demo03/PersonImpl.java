package demo03;

import org.springframework.beans.factory.annotation.Value;

public class PersonImpl {
	@Value("${p.age}")
	private int age;
	@Value("${p.name}")
	private String name;
	@Value("${p.email}")
	private String email;
	
	public PersonImpl() {
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
}




