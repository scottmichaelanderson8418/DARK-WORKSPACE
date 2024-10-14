package dev.danvega.jwt.demo.controllers;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping
	public String home(Principal principal) {
		return "Hello JWT" + principal.getName();
	}

}

// when you reach the point where self signed JWT are not feasible - for example
// refresh tokens

// Know what a resource server is
// Know what an authorization server is
