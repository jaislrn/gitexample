package sh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sh.daos.BookDao;
import sh.entities.Book;
import sh.entities.Image;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;

	@Override
	@Transactional
	public void addBook(Book b) {
		bookDao.addBook(b);
	}
	
	@Override
	@Transactional
	public void updateBook(Book b) {
		bookDao.updateBook(b);
	}
	
	@Override
	@Transactional
	public void delBookById(int id) {
		Book b = this.findBook(id);
		bookDao.delBook(b);
	}
	
	@Override
	@Transactional
	public void delBook(Book b) {
		bookDao.delBook(b);
	}
	
	@Override
	@Transactional
	public Book findBook(int id) {
		return bookDao.findBook(id);
	}

	@Override
	@Transactional
	public List<String> findSubjects() {
		return bookDao.findSubjects();
	}

	@Override
	@Transactional
	public List<Book> findBooksBySubject(String subject) {
		return bookDao.findBooksBySubject(subject);
	}
	
	@Override
	@Transactional
	public void addImage(Image image) {
		bookDao.addImage(image);
	}
	
	@Override
	@Transactional
	public Image findImage(int id) {
		return bookDao.findImage(id);
	}
	
	@Override
	@Transactional
	public List<Book> findAllBooks() {
		return bookDao.findAllBooks();
	}
}

