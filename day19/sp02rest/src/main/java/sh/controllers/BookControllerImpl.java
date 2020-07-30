package sh.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import sh.daos.BookDao;
import sh.entities.Book;

@CrossOrigin
@RestController
public class BookControllerImpl {
	@Autowired
	private BookDao bookDao;
	
	@GetMapping("/rest/subjects")
	public ResponseEntity<List<String>> findSubjects() {
		List<String> result = bookDao.findDistinctSubject();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/rest/{subject}/books")
	public ResponseEntity<List<Book>> findBookBySubject(@PathVariable("subject") String subject) {
		List<Book> result = bookDao.findBySubject(subject);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/rest/books/{id}")
	public ResponseEntity<Book> findBookById(@PathVariable("id") int id) {
		Optional<Book> result = bookDao.findById(id);
		return new ResponseEntity<>(result.orElse(null), HttpStatus.OK);
	}
	
	@GetMapping("/rest/books")
	public ResponseEntity<List<Book>> findBookBySubject() {
		List<Book> result = bookDao.findAll();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
