package sh.entities;

import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="MEETING")
public class Meeting {
	@TableGenerator(name = "gen", table = "empsys_idgen", pkColumnName = "entity", valueColumnName = "id", initialValue = 10, allocationSize = 1)
	@GeneratedValue(generator = "gen", strategy = GenerationType.TABLE)
	@Id
	@Column(name="id")
	private int meetid;
	@Column
	private String subject;
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date meetDate;
	
	@ManyToMany(mappedBy = "meetingList")
	private List<Emp> empList;
	
	public Meeting() {
		this.empList = new ArrayList<Emp>();
	}

	public Meeting(int meetid, String subject, Date meetDate) {
		this.meetid = meetid;
		this.subject = subject;
		this.meetDate = meetDate;
		this.empList = new ArrayList<Emp>();
	}
	
	

	public List<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}

	public int getMeetid() {
		return meetid;
	}

	public void setMeetid(int meetid) {
		this.meetid = meetid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getMeetDate() {
		return meetDate;
	}

	public void setMeetDate(Date meetDate) {
		this.meetDate = meetDate;
	}

	@Override
	public String toString() {
		return "Meeting [meetid=" + meetid + ", subject=" + subject + ", meetDate=" + meetDate + "]";
	}
}
