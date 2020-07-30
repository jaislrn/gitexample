package sh.controllers;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

import sh.entities.Customer;
import sh.models.Login;
import sh.services.CustomerService;

@Controller
public class LoginControllerImpl {
	@Autowired
	private CustomerService custService;
	@RequestMapping("/index")
	public String index(Model model, Locale locale, HttpServletRequest req) {
		ServletContext app = req.getServletContext();
		WebApplicationContext rootAppCtx = WebApplicationContextUtils.findWebApplicationContext(app);
		System.out.println(rootAppCtx);
		WebApplicationContext dsAppCtx = RequestContextUtils.findWebApplicationContext(req);
		System.out.println(dsAppCtx);
		System.out.println("Parent of DispatcherServlet Context : " + dsAppCtx.getParent());
		System.out.println("Parent of Root Context : " + rootAppCtx.getParent());
		
		model.addAttribute("command", new Login());
		System.out.println("Current Locale: " + locale);
		return "index";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("command", new Customer());
		return "register";
	}
	
	
//	@PostMapping("/register")
//	public String register(@Valid @ModelAttribute("command") Customer cust, BindingResult res, Model model) {
//		if(res.hasErrors())
//			return "register";
//		try {
//			custService.addCustomer(cust);
//			model.addAttribute("message", "Customer added successfully.");
//			return "register";
//		} catch (Exception e) {
//			return "forward:error";
//		}
//	}
	
	@ExceptionHandler({RuntimeException.class})
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("command") Customer cust, BindingResult res, Model model) {
		if(res.hasErrors())
			return "register";
		custService.addCustomer(cust);
		model.addAttribute("message", "Customer added successfully.");
		return "register";
	}
	
	@RequestMapping("/auth")
	public String authenticate(Login l, HttpSession session) {
		Customer cust = custService.findCustomer(l.getEmail(), l.getPassword());
		if(cust != null) {
			session.setAttribute("cust", cust);
			if(cust.getName().equals("admin"))
				return "redirect:booklist";
			else
				return "redirect:getsubjects"; // req handler menthod
		}
		return "failed";
	}
	
	@RequestMapping("/logout")
	public String signOut(HttpSession session) {
		session.invalidate();
		return "logout"; // view name
	}
}
