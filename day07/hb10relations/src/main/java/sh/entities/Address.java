package sh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPADDRESS")
public class Address {
	@Id
	@Column
	private int empid;
	@Column
	private String addr;
	@Column
	private String country;
	
	@OneToOne(mappedBy = "addr")
	private Emp emp;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(int empid, String addr, String country) {
		this.empid = empid;
		this.addr = addr;
		this.country = country;
	}

	
	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [empid=" + empid + ", addr=" + addr + ", country=" + country + "]";
	}
	
}
