package sh.controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import sh.entities.Book;
import sh.entities.Image;
import sh.services.BookService;

@Controller
public class BookCrudControllerImpl {
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/booklist")
	public String booklist(Model model) {
		List<Book> bookList = bookService.findAllBooks();
		model.addAttribute("bookList", bookList);
		return "booklist";
	}
	
	/*
	@RequestMapping("/download")
	public void dowload(@RequestParam("id") int id, HttpServletResponse resp) throws IOException {
		Image image = bookService.findImage(id);
		if(image != null) {
			resp.setContentType("image/jpg");
			resp.getOutputStream().write(image.getImage());
		}
	}
	*/
	
	@RequestMapping(value="/download", produces = "image/jpg")
	public void dowload(@RequestParam("id") int id, OutputStream out) throws IOException {
		Image image = bookService.findImage(id);
		if(image != null) {
			out.write(image.getImage());
		}
	}
	
	@GetMapping("/upload")
	//@RequestMapping(value="/upload", method = RequestMethod.GET)
	public String upload(@RequestParam("id") int id) {
		return "upload";
	}
	
	@PostMapping("/upload")
	//@RequestMapping(value="/upload", method = RequestMethod.POST)
	public String upload(@RequestParam("id") int id, @RequestParam("imgfile") CommonsMultipartFile imgFile, Model model) {
		byte[] imageBytes = imgFile.getBytes();
		Image image = new Image(id, imageBytes);
		bookService.addImage(image);
		model.addAttribute("message", "Image uploaded successfully");
		return "upload";
	}
	
	
}
