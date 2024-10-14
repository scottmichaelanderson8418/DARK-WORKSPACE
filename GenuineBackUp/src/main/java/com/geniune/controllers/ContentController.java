package com.geniune.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.geniune.model.MyUser;
import com.geniune.model.MyUserDetailService;
import com.geniune.repositories.MyUserRepository;
import com.geniune.security.JwtService;
import com.geniune.security.LoginForm;

@RestController
public class ContentController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private MyUserDetailService myUserDetailService;

	@Autowired
	private MyUserRepository myUserRepository;

	// accessible by everyone
	@GetMapping("/home")
	public String handleWelcome() {
		return "Welcome to the homepage";
	}

	@GetMapping("/admin/home")
	public String handleAdminHome() {
		return "Welcome to ADMIN home!";
	}

	@GetMapping("/user/home")
	public String handleUserHome() {
		return "Welcome to the user home page :)";
	}

	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody LoginForm loginForm) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginForm.username(),
						loginForm.password()));
		if (authentication.isAuthenticated()) {
			return jwtService
					.generateToken(myUserDetailService.loadUserByUsername(loginForm.username()));
		} else {
			throw new UsernameNotFoundException("Invalid credentials");
		}

	}

	@GetMapping("/admin/getallusers")
	public ResponseEntity<List<MyUser>> getAllUsers() {
		List<MyUser> drawings = myUserRepository.findAll();

		return new ResponseEntity<>(drawings, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) throws NotFoundException {

		myUserRepository.deleteById(id);

		return new ResponseEntity<>("User found and deleted", HttpStatus.OK);

	}
}
