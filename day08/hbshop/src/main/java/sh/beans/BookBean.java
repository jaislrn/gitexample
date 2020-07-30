package sh.beans;

import sh.daos.BookDao;
import sh.entities.Book;
import sh.util.HbUtil;

public class BookBean {
	private int id;
	private Book book;
	public BookBean() {
		this.id = 0;
		this.book = new Book();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public void fetchBook() {
		try {
			BookDao dao = new BookDao();
			HbUtil.beginTransaction();
			this.book = dao.findById(this.id);
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
		}
	}
}
