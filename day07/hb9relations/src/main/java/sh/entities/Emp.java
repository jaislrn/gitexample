package sh.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="EMP")
public class Emp {
	@TableGenerator(name = "gen", table = "empsys_idgen", pkColumnName = "entity", valueColumnName = "id", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "gen", strategy = GenerationType.TABLE)
	@Id
	@Column(name="empno")
	private int empid;
	@Column(name="ename")
	private String name;
	@Column
	private String job;
	
	@ManyToMany
	@JoinTable(name = "EMPMEETING",
		joinColumns = @JoinColumn(name = "empid"),
		inverseJoinColumns = @JoinColumn(name="meetingid")
	)
	private List<Meeting> meetingList;
	
	public Emp() {
		this.meetingList = new ArrayList<Meeting>();
	}
	public Emp(int empid, String name, String job) {
		this.empid = empid;
		this.name = name;
		this.job = job;
		this.meetingList = new ArrayList<Meeting>();
	}
	
	public List<Meeting> getMeetingList() {
		return meetingList;
	}
	public void setMeetingList(List<Meeting> meetingList) {
		this.meetingList = meetingList;
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
		return "Emp [empid=" + empid + ", name=" + name + ", job=" + job + "]";
	}
}
