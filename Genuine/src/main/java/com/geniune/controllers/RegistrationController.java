package com.geniune.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	public static final Logger logger = LoggerFactory
			.getLogger(RegistrationController.class.getName());
	@Autowired
	private MyUserRepository myUserRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/register/user")
	public ResponseEntity<String> createUser(@RequestBody MyUser user) {
		logger.trace("Entered: createUser(): ");
		if (myUserRepository.findByUsername(user.getUsername()).isPresent()) {

			return new ResponseEntity<>(
					"User already exists. Try another username.",
					HttpStatus.CONFLICT);
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		myUserRepository.save(user);
		logger.trace("Exit: createUser(): ");
		return new ResponseEntity<>("Registration is successfull :)", HttpStatus.OK);
	}
}
