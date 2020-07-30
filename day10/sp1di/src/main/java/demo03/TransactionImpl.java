package demo03;

public class TransactionImpl {
	private int accId;
	private String type;
	private double amount;

	public TransactionImpl() {
		// TODO Auto-generated constructor stub
	}

	public TransactionImpl(int accId, String type, double amount) {
		this.accId = accId;
		this.type = type;
		this.amount = amount;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TransactionImpl [accId=" + accId + ", type=" + type + ", amount=" + amount + "]";
	}

}
