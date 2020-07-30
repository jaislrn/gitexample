package sh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sh.models.Login;

@Controller
public class LoginControllerImpl {
	@RequestMapping("/auth")
	public String authenticate(Login l) {
		boolean success = l.getEmail().contains(l.getPassword());
		if(success)
			return "welcome";
		else
			return "failed";
	}
}
