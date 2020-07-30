package sh.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMP")
public class Emp {
	@Id
	@Column(name="empno")
	private int empid;
	@Column(name="ename")
	private String name;
	@Column
	private String job;
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "deptno") // FK COLUMN
	private Dept dept;
	
	public Emp() {
		this.dept = new Dept();
	}
	public Emp(int empid, String name, String job) {
		this.empid = empid;
		this.name = name;
		this.job = job;
		this.dept = new Dept();
	}
	
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}	
	@Override
	public String toString() {
		return "Emp [empid=" + empid + ", name=" + name + ", job=" + job + ", deptid=" + this.dept.getDeptno() + "]";
	}
}
