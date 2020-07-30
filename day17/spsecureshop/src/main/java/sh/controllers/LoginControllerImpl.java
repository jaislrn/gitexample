package sh.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;

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
import org.springframework.web.context.support.WebApplicationContextUtils;

import sh.entities.Customer;
import sh.models.Login;
import sh.services.CustomerService;

@Controller
public class LoginControllerImpl {
	@Autowired
	private CustomerService custService;
	@RequestMapping("/login")
	public String index(Model model, Locale locale) {
		return "index";
	}
	
	@RequestMapping("/auth")
	public String onAuth(Principal prn, HttpServletRequest req) {
		System.out.println("Principal : " + prn);
		HttpSession session = req.getSession();
		Customer cust = custService.findCustomer(prn.getName());
		session.setAttribute("cust", cust);
		Enumeration<String> en = session.getAttributeNames();
		while (en.hasMoreElements()) {
			String sessionAttr = en.nextElement();
			System.out.println(sessionAttr + " --> " + session.getAttribute(sessionAttr));
		} 
		if(req.isUserInRole("ADMIN"))
			return "redirect:/admin/booklist";
		else
			return "redirect:/customer/getsubjects";		
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("command", new Customer());
		return "register";
	}
	
	@ExceptionHandler({RuntimeException.class})
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("command") Customer cust, BindingResult res, Model model) {
		if(res.hasErrors())
			return "register";
		custService.addCustomer(cust);
		model.addAttribute("message", "Customer added successfully.");
		return "register";
	}
	
	@RequestMapping("/thanks")
	public String signOut(HttpSession session) {
		session.invalidate();
		return "logout"; // view name
	}
}
