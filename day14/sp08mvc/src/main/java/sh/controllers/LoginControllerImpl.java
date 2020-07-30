package sh.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sh.models.Login;

@Controller
public class LoginControllerImpl {
//	@RequestMapping("/login")
//	public String login(Model model) {
//		Login obj = new Login("unknown@gmail.com", "");
//		model.addAttribute("lg", obj);
//		return "index";
//	}

//	@RequestMapping("/login")
//	public String login(ModelMap model) {
//		Login obj = new Login("unknown@gmail.com", "");
//		model.addAttribute("lg", obj);
//		return "index";
//	}

//	@RequestMapping("/login")
//	public String login(Map<String, Object> model) {
//		Login obj = new Login("unknown@gmail.com", "");
//		model.put("lg", obj);
//		return "index";
//	}

	@RequestMapping("/login")
	public ModelAndView login() {
		Login obj = new Login("anonymous@gmail.com", "");
		ModelAndView mav = new ModelAndView("index", "lg", obj);
		return mav;
	}

//	@RequestMapping("/auth")
//	public String authenticate(Login l) {
//		boolean success = l.getEmail().contains(l.getPassword());
//		if(success)
//			return "welcome";
//		else
//			return "failed";
//	}

//	@RequestMapping("/auth")
//	public String authenticate(HttpServletRequest req) {
//		String email = req.getParameter("email");
//		String password = req.getParameter("password");
//		boolean success = email.contains(password);
//		if(success)
//			return "welcome";
//		else
//			return "failed";
//	}

//	@RequestMapping("/auth")
//	public String authenticate(@RequestParam("email") String email, @RequestParam("password") String password) {
//		boolean success = email.contains(password);
//		if(success)
//			return "welcome";
//		else
//			return "failed";
//	}

	@RequestMapping("/auth")
	public String authenticate(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session) {
		boolean success = email.contains(password);
		if(success) {
			session.setAttribute("email", email);
			return "welcome";
		} else
			return "failed";
	}

}
