package sh.beans;

import java.util.ArrayList;
import java.util.List;

import sh.daos.BookDao;
import sh.entities.Book;
import sh.util.HbUtil;

public class SubjectBooksBean {
	private String subject;
	private List<Book> books;
	public SubjectBooksBean() {
		this.subject = "";
		this.books = new ArrayList<Book>();
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public void fetchBooks() {
		try {
			BookDao dao = new BookDao();
			HbUtil.beginTransaction();
			this.books = dao.findBySubject(this.subject);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
		}
	}
}
