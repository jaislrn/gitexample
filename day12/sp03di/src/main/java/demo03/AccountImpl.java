package demo03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class AccountImpl {
	@Value("${acc.id}")
	private int id;
	@Value("${acc.type}")
	private String type;
	@Value("${acc.balance}")
	private double balance;
	//@Autowired
	@Value("#{p1}")
	private PersonImpl accHolder;

	public AccountImpl() {
	}
	
	public AccountImpl(PersonImpl accHolder) {
		this(1, "Saving", 1000.00, null);
		this.accHolder = accHolder;
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
		return "AccountImpl [id=" + id + ", type=" + type + ", balance=" + balance + "]";
	}
	
}

