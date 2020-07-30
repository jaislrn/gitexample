package demo03;

import java.util.ArrayList;
import java.util.List;

public class AccountImpl {
	private int id;
	private String type;
	private double balance;
	private PersonImpl accHolder;
	private List<TransactionImpl> transactions;
	
	public AccountImpl() {
		transactions = new ArrayList<TransactionImpl>();
	}
	
	public AccountImpl(int id, String type, double balance, PersonImpl accHolder) {
		this.id = id;
		this.type = type;
		this.balance = balance;
		this.accHolder = accHolder;
		transactions = new ArrayList<TransactionImpl>();
	}

	public List<TransactionImpl> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionImpl> transactions) {
		this.transactions = transactions;
	}

	public PersonImpl getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(PersonImpl accHolder) {
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
		this.balance += amount;
	}
	public void withdraw(double amount) {
		this.balance -= amount;
	}

	@Override
	public String toString() {
		return "AccountImpl [id=" + id + ", type=" + type + ", balance=" + balance + ", accHolder=" + accHolder + "]";
	}
}
