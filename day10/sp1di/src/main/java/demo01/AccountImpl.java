package demo01;

public class AccountImpl {
	private int id;
	private String type;
	private double balance;
	public AccountImpl() {
		System.out.println("AccountImpl() called.");
	}
	public AccountImpl(int id, String type, double balance) {
		System.out.println("AccountImpl(...) called.");
		this.id = id;
		this.type = type;
		this.balance = balance;
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
