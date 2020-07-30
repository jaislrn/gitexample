package demo01;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class AccountImpl implements InitializingBean, DisposableBean, BeanFactoryAware, BeanNameAware {
	private int id;
	private String type;
	private double balance;
	private PersonImpl accHolder;
	
	public AccountImpl() {
		System.out.println("AccountImpl() called.");
	}
	
	public AccountImpl(int id, String type, double balance, PersonImpl accHolder) {
		this.id = id;
		this.type = type;
		this.balance = balance;
		this.accHolder = accHolder;
	}

	public PersonImpl getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(PersonImpl accHolder) {
		System.out.println("setAccHolder() called.");
		this.accHolder = accHolder;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		System.out.println("setId() called.");
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		System.out.println("setType() called.");
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		System.out.println("setBalance() called.");
		this.balance = balance;
	}
	public void deposit(double amount) {
		this.balance += amount;
	}
	public void withdraw(double amount) {
		this.balance -= amount;
	}

	@Override
	public String toString() {
		return "AccountImpl [id=" + id + ", type=" + type + ", balance=" + balance + ", accHolder=" + accHolder + "]";
	}
	
	private String beanName;
	@Override
	public void setBeanName(String name) {
		this.beanName = name;
		System.out.println("setBeanName() called " + name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("setBeanFactory() called");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet() called");		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy() called");
	}

	public void accInit() {
		System.out.println("accInit() called");
	}
	public void accDestroy() {
		System.out.println("accDestroy() called");
	}
}

