package com.fullstackproject.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstackproject.model.User;
import com.fullstackproject.service.MySQLUserDetailsService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private MySQLUserDetailsService userService;

	@PostMapping("/register")
	public void register(@RequestBody User newUser) {
		userService.Save(newUser);
	}
}
