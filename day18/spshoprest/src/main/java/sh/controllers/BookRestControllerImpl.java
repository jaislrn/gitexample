package sh.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sh.entities.Book;
import sh.services.BookService;

@CrossOrigin
@RestController
public class BookRestControllerImpl {
	@Autowired
	private BookService bookService;

	@GetMapping(value="/rest/books", produces = "application/json")
	public List<Book> getAllBooks() {
		List<Book> list = bookService.findAllBooks();
		return list;
	}

	@GetMapping("/rest/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
		Book b = bookService.findBook(id);
		LinkedMultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();
		ResponseEntity<Book> resp = new ResponseEntity<Book>(b, header, HttpStatus.OK);
		return resp;
	}

	//@RequestMapping(value="/rest/books", method = RequestMethod.POST)
	@PostMapping("/rest/books")
	public Map<String, Object> insertBook(@RequestBody Book b) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			bookService.addBook(b);
			map.put("Status", "OK");
			map.put("Message", "Book Inserted Successfully.");
		}catch (Exception e) {
			map.put("Status", "Failed");
			map.put("Message", e.getMessage());
		}
		return map;
	}
	
	@PutMapping("/rest/books/{id}")
	public Map<String, Object> updatedBook(@PathVariable("id") int id, @RequestBody Book b) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			bookService.updateBook(b);
			map.put("Status", "OK");
			map.put("Message", "Book Updated Successfully.");
		}catch (Exception e) {
			map.put("Status", "Failed");
			map.put("Message", e.getMessage());
		}
		return map;
	}
	
	@DeleteMapping("/rest/books/{id}")
	public Map<String, Object> deleteBook(@PathVariable("id") int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Book b = bookService.findBook(id);
			bookService.delBook(b);
			map.put("Status", "OK");
			map.put("Message", "Book Deleted Successfully.");
		}catch (Exception e) {
			map.put("Status", "Failed");
			map.put("Message", e.getMessage());
		}
		return map;
	}
}

