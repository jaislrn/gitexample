package sh.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sh.entities.Book;
import sh.services.BookService;


@CrossOrigin
@RestController
public class BookJTableRestControllerImpl {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping(value="/jtable/books/{id}")
	public Map<String, Object> getById(@PathVariable("id") int id) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			res.put("Result", "OK");
			res.put("Record", bookService.findBook(id));
		}catch (Exception e) {
			res.put("Result", "ERROR");
			res.put("Message", e.getMessage());
		}
		return res;
	}
	
	@PostMapping(value="/jtable/books")
	public Map<String, Object> getBooks() {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			List<Book> list = bookService.findAllBooks();
			res.put("Result", "OK");
			res.put("Records", list);
		}catch (Exception e) {
			res.put("Result", "ERROR");
			res.put("Message", e.getMessage());
		}
		return res;
	}	
	
	@PostMapping(value="/jtable/newbook")
	public Map<String, Object> newBook(Book b) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			bookService.addBook(b);
			res.put("Result", "OK");
			res.put("Record", b);
		}catch (Exception e) {
			res.put("Result", "ERROR");
			res.put("Message", e.getMessage());
		}
		return res;
	}
	
	@PostMapping(value="/jtable/editbook")
	public Map<String, Object> editBook(Book b) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			bookService.updateBook(b);
			res.put("Result", "OK");
		}catch (Exception e) {
			res.put("Result", "ERROR");
			res.put("Message", e.getMessage());
		}
		return res;
	}
	
	@PostMapping(value="/jtable/delbook")
	public Map<String, Object> delBook(@RequestParam("id") int id) {
		Map<String, Object> res = new HashMap<String, Object>();
		try {
			Book b = bookService.findBook(id);
			bookService.delBook(b);
			res.put("Result", "OK");
		}catch (Exception e) {
			res.put("Result", "ERROR");
			res.put("Message", e.getMessage());
		}
		return res;
	}
}
