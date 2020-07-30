package sh.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AccountImpl implements Account {
	@Value("${acc.accId}")
	private int accId;
	@Value("${acc.type}")
	private String type;
	@Value("${acc.balance}")
	private double balance;
	
	public AccountImpl() {
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
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
		this.balance += amount;
	}

	public void withdraw(double amount) {
		if(this.balance - amount < 0)
			throw new RuntimeException("Insufficient balance.");
		this.balance -= amount;
	}
	

	public String toString() {
		return String.format("AccountImpl [accId=%s, type=%s, balance=%s]", accId, type, balance);
	}	
}
