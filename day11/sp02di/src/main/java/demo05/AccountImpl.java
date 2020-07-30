package demo05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class AccountImpl implements Account {
	private int id;
	private String type;
	private double balance;
	//@Autowired(required = false)
	//@Qualifier("p1")
	private Person accHolder;
	//@Autowired
	//@Qualifier("consLogger")
	private Logger logger;
	
	public AccountImpl() {
		this.logger = null;
		this.accHolder = null;
	}
	
	//@Autowired
	public AccountImpl(Person accHolder, ConsoleLoggerImpl logger) {
		this.accHolder = accHolder;
		this.logger = logger;
	}

	public AccountImpl(Person accHolder) {
		this.accHolder = accHolder;
		this.logger = null;
	}
	
	public AccountImpl(ConsoleLoggerImpl logger) {
		this.accHolder = null;
		this.logger = logger;
	}
	
	public AccountImpl(int id, String type, double balance, Person accHolder) {
		this.id = id;
		this.type = type;
		this.balance = balance;
		this.accHolder = accHolder;
	}

	public Person getAccHolder() {
		return accHolder;
	}

	@Autowired
	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		if(logger != null)
			logger.log("deposit() " + amount + " in account " + id);
		this.balance += amount;
	}
	public void withdraw(double amount) {
		if(logger != null)
			logger.log("deposit() " + amount + " in account " + id);
		this.balance -= amount;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@Override
	public String toString() {
		return "AccountImpl [id=" + id + ", type=" + type + ", balance=" + balance + ", accHolder=" + accHolder + "]";
	}
}
