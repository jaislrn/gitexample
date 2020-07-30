package sh.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestControllerImpl {
	@GetMapping("/hello")
	public String hello() {
		return "Hello Spring Boot!!";
	}
}

