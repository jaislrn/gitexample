package demo01b;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class PersonImpl {
	private int age;
	private String name;
	private String email;
	private AccountImpl account;
	
	public PersonImpl() {
		this(20, "unknown", "unknown@gmail.com", null);
	}
	
	@Autowired
	public PersonImpl(@Lazy AccountImpl account) {
		this(20, "unknown", "unknown@gmail.com", null);
		this.account = account;
	}

	public PersonImpl(int age, String name, String email, AccountImpl account) {
		this.age = age;
		this.name = name;
		this.email = email;
		this.account = account;
	}

	public AccountImpl getAccount() {
		return account;
	}

	public void setAccount(AccountImpl account) {
		this.account = account;
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




