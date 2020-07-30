package sh.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS") 
public class Student {
	@EmbeddedId
	private StdRoll pk;
	@Column
	private String name;
	@Column
	private double marks;

	public Student() {
		this.pk = new StdRoll();
	}

	public Student(StdRoll pk, String name, double marks) {
		this.pk = pk;
		this.name = name;
		this.marks = marks;
	}

	public StdRoll getPk() {
		return pk;
	}

	public void setPk(StdRoll pk) {
		this.pk = pk;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [pk=" + pk + ", name=" + name + ", marks=" + marks + "]";
	}
}
