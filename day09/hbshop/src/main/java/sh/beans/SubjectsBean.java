package sh.beans;

import java.util.ArrayList;
import java.util.List;

import sh.daos.BookDao;
import sh.util.HbUtil;

public class SubjectsBean {
	private List<String> subjects;
	public SubjectsBean() {
		this.subjects = new ArrayList<String>();
	}
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	public void fetchSubjects() {
		BookDao dao = new BookDao();
		this.subjects = dao.findSubjects();
	}
}
