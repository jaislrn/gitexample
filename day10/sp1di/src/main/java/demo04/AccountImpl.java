package demo04;

public class AccountImpl implements Account {
	private int id;
	private String type;
	private double balance;
	private Logger logger;
	public AccountImpl() {
		this.logger = null;
	}
	public AccountImpl(int id, String type, double balance) {
		this.id = id;
		this.type = type;
		this.balance = balance;
		this.logger = null;
	}

	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	@Override
	public int getId() {
		return id;
	}
	@Override
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String getType() {
		return type;
	}
	@Override
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public double getBalance() {
		return balance;
	}
	@Override
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public void deposit(double amount) {
		if(this.logger != null) {
			String msg = "Deposit Rs. " + amount + "/- into Account " + this.id;
			logger.log(msg);
		}
		this.balance += amount;
	}
	@Override
	public void withdraw(double amount) {
		if(this.logger != null) {
			String msg = "Withdraw Rs. " + amount + "/- from Account " + this.id;
			logger.log(msg);
		}
		this.balance -= amount;
	}
	@Override
	public String toString() {
		return "AccountImpl [id=" + id + ", type=" + type + ", balance=" + balance + "]";
	}
}
