package sh.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sh.entities.Book;

public interface BookDao extends JpaRepository<Book, Integer> {
	@Query("select distinct b.subject from Book b")
	public List<String> findDistinctSubject();
	public List<Book> findBySubject(String subject);
}
