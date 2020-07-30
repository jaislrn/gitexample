package sh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	@Column(name="deptno")
	private int deptid;
	// ...
	
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	public Emp(int empid, String name, String job, int deptid) {
		this.empid = empid;
		this.name = name;
		this.job = job;
		this.deptid = deptid;
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
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	@Override
	public String toString() {
		return "Emp [empid=" + empid + ", name=" + name + ", job=" + job + ", deptid=" + deptid + "]";
	}
}
