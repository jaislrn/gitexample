package demo01d;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class PersonImpl implements InitializingBean, ApplicationContextAware {
	private int age;
	private String name;
	private String email;
	private AccountImpl account;
	
	public PersonImpl() {
		this(20, "unknown", "unknown@gmail.com", null);
	}
	
	public PersonImpl(AccountImpl account) {
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

	private ApplicationContext ctx;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.account = ctx.getBean(AccountImpl.class);
	}	
}




