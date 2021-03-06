package sh.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="DEPT")
public class Dept {
	@TableGenerator(name = "gen", table = "empsys_idgen", pkColumnName = "entity", valueColumnName = "id", initialValue = 50, allocationSize = 1)
	@GeneratedValue(generator = "gen", strategy = GenerationType.TABLE)
	@Id
	@Column
	private int deptno;
	@Column(name="dname")
	private String name;
	@Column
	private String loc;
	
	public Dept() {
	}

	public Dept(int deptno, String name, String loc) {
		this.deptno = deptno;
		this.name = name;
		this.loc = loc;
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






