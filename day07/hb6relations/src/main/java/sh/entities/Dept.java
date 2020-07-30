package sh.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="DEPT")
public class Dept {
	@Id
	@Column
	private int deptno;
	@Column(name="dname")
	private String name;
	@Column
	private String loc;
	@OneToMany(mappedBy = "deptid", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH})
	private List<Emp> empList;
	
	public Dept() {
		this.empList = new ArrayList<Emp>();
	}

	public Dept(int deptno, String name, String loc) {
		this.deptno = deptno;
		this.name = name;
		this.loc = loc;
		this.empList = new ArrayList<Emp>();
	}
	
	public List<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", name=" + name + ", loc=" + loc + "]";
	}
	
}
