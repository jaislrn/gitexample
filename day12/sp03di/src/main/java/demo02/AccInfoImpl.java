package demo02;

public class AccInfoImpl {
	private int accId;
	private String name;
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
