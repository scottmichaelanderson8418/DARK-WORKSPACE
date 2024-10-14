package io.javabrains.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

//RestController annotation
@RestController
public class HelloController {

	// GetMapping annotation
	@PutMapping("/hello")
	public String sayBYE() {
		return "BYE";
	}

	// GetMapping annotation
	@GetMapping("/hello")
	public String sayHi() {
		return "Hi";
	}

	// GetMapping annotation
	@GetMapping("/hello/integer")
	public Integer sayHiInt() {
		return 99;
	}

}
