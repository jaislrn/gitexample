package demo03;

import org.springframework.beans.factory.annotation.Value;

public class AccInfoImpl {
	//@Value("#{systemProperties['name']")
	//private String test;
	@Value("#{a1.id}")
	private int accId;
	@Value("#{p1.name}")
	private String name;
	@Value("#{a1.getBalance()}")
	private double balance;
	
	public AccInfoImpl() {
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccInfoImpl [accId=" + accId + ", name=" + name + ", balance=" + balance + "]";
	}
	
}	
