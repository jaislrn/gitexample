package com.sunbeaminfo.sh;

public interface Account {

	int getId();

	void setId(int id);

	String getType();

	void setType(String type);

	double getBalance();

	void setBalance(double balance);

	Person getAccHolder();

	void setAccHolder(Person accHolder);

	void deposit(double amount);

	void withdraw(double amount);
	
	Logger getLogger();
	
	void setLogger(Logger logger);

}