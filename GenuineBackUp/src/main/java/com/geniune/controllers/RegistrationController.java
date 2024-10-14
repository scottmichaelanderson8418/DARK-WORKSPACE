package com.geniune.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.geniune.model.MyUser;
import com.geniune.repositories.MyUserRepository;

@RestController
public class RegistrationController {

	@Autowired
	private MyUserRepository myUserRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/register/user")
	public ResponseEntity<String> createUser(@RequestBody MyUser user) {

		if (myUserRepository.findByUsername(user.getUsername()).isPresent()) {

			return new ResponseEntity<>("User already exists. Try another username.",
					HttpStatus.CONFLICT);
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		myUserRepository.save(user);

		return new ResponseEntity<>("Registration is successfull :)", HttpStatus.OK);
	}
}
