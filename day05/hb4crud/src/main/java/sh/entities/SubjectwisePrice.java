package sh.entities;

public class SubjectwisePrice {
	private String subject;
	private double total;
	public SubjectwisePrice() {
	}
	public SubjectwisePrice(String subject, double total) {
		this.subject = subject;
		this.total = total;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "SubjectwisePrice [subject=" + subject + ", total=" + total + "]";
	}	
}
