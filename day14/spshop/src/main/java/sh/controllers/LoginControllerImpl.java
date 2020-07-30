package sh.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;

import sh.entities.Customer;
import sh.models.Login;
import sh.services.CustomerService;

@Controller
public class LoginControllerImpl {
	@Autowired
	private CustomerService custService;
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("command", new Login());
		return "index";
	}
	
	@RequestMapping("/auth")
	public String authenticate(Login l, HttpSession session) {
		Customer cust = custService.findCustomer(l.getEmail(), l.getPassword());
		if(cust != null) {
			session.setAttribute("cust", cust);
			session.setAttribute("cart", new ArrayList<Integer>()); // empty cart
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
