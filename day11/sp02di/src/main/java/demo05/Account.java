package demo05;

import demo04.Person;

public interface Account {

	int getId();

	void setId(int id);

	String getType();

	void setType(String type);

	double getBalance();

	void setBalance(double balance);

	demo05.Person getAccHolder();

	void setAccHolder(demo05.Person accHolder);

	void deposit(double amount);

	void withdraw(double amount);
	
	Logger getLogger();
	
	void setLogger(Logger logger);

}