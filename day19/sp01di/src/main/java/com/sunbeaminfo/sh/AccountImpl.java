package com.sunbeaminfo.sh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AccountImpl implements Account {
	@Value("${acc.id}")
	private int id;
	@Value("${acc.type}")
	private String type;
	@Value("${acc.balance}")
	private double balance;
	@Autowired
	private Person accHolder;
	@Autowired
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
			logger.log("withdraw() " + amount + " in account " + id);
		if(this.balance - amount < 0)
			throw new RuntimeException("Insufficient balance.");
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
