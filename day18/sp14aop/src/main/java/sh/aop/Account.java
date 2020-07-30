package sh.aop;

public interface Account {

	int getAccId();

	void setAccId(int accId);

	String getType();

	void setType(String type);

	double getBalance();

	void setBalance(double balance);

	void deposit(double amount);

	void withdraw(double amount);

}