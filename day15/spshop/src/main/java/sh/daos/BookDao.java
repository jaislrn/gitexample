package sh.daos;

import java.util.List;

import sh.entities.Book;
import sh.entities.Image;

public interface BookDao {

	void addBook(Book b);

	void updateBook(Book b);

	void delBook(Book b);

	Book findBook(int id);

	List<String> findSubjects();

	List<Book> findBooksBySubject(String subject);

	void addImage(Image image);
	
	Image findImage(int id);
	
	List<Book> findAllBooks();
}

