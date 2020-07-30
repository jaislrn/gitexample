package sh.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sh.entities.Book;
import sh.models.SelectedBook;
import sh.models.ShoppingCart;
import sh.models.Subject;
import sh.services.BookService;

@Controller
public class BookControllerImpl {
	@Autowired
	private BookService bookService;
	@Autowired
	private ShoppingCart shoppingCart;
	
	@RequestMapping("/getsubjects") // req from client
	public String subjects(Model model) {
		List<String> subjectList = bookService.findSubjects();
		model.addAttribute("subjectList", subjectList);
		
		Subject selectedSubject = new Subject();
		if(subjectList.size() > 0)
			selectedSubject.setSubject(subjectList.get(0));
		model.addAttribute("command", selectedSubject);
		return "subjects"; // viewname
	}

	@RequestMapping("/books") // req from client
	public String books(Subject selectedSubject, Model model) {
		String subject = selectedSubject.getSubject();
		List<Book> bookList = bookService.findBooksBySubject(subject);
		model.addAttribute("bookList", bookList);
		model.addAttribute("command", new SelectedBook());
		return "books"; // viewname
	}


	@RequestMapping("/addcart") // req from client
	public String addToCart(SelectedBook selectedBooks) {
		System.out.println("shopping cart : " + shoppingCart.getClass().getName());
		for (String bookId : selectedBooks.getBook()) {
			int id = Integer.parseInt(bookId);
			shoppingCart.add(id);
		}
		return "forward:getsubjects";
	}

	@RequestMapping("/details") // req from client
	public String bookDetails(@RequestParam("id") int id, Model model) {
		Book b = bookService.findBook(id);
		model.addAttribute("book", b);
		return "details"; // view name
	}
	@RequestMapping("/showcart") // req from client
	public String showCart(Model model) {
		List<Book> bookList = new ArrayList<Book>();
		for (int id : shoppingCart.getCart()) {
			Book b = bookService.findBook(id);
			bookList.add(b);
		}
		model.addAttribute("bookList", bookList);
		return "cart";
	}
}

