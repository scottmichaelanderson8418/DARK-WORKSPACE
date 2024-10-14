package edu.cpcc.lab.mypost.service.controller;

import java.util.List;

// import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cpcc.lab.mypost.service.dao.UserRepository;
import edu.cpcc.lab.mypost.service.model.User;
import edu.cpcc.lab.mypost.service.security.UserSecureCredentialsService;

@RestController
@RequestMapping("/myposts/api/users")
public class MyUserController {

	private UserSecureCredentialsService userCredentialService;
	private UserRepository userRepository;

	Logger logger = LoggerFactory.getLogger(MyUserController.class.getName());

	// NOTE: constructor auto wiring...
	@Autowired
	public MyUserController(UserSecureCredentialsService userCredentialService, UserRepository userRepository) {
		this.userCredentialService = userCredentialService;
		this.userRepository = userRepository;
	}

	@PostMapping("/register")
	public void create(@RequestBody User newUser) {

		logger.trace("register() from UserResource: entered...");
		logger.debug("register() from UserResource: entered...");
		logger.error("register() from UserResource: entered...");
		logger.warn("register() from UserResource: entered...");

		this.userCredentialService.save(newUser);

		logger.trace("register() from UserResource: exiting...");
		logger.debug("register() from UserResource: exiting...");
	}

	@GetMapping()
	public List<User> get() {

		logger.trace("UserResource:get(): entered...");
		logger.debug("UserResource:get(): entered...");

		List<User> users = this.userRepository.findAll();

		logger.trace("UserResource:get(): exiting...");
		logger.debug("UserResource:get(): exiting...");

		return users;
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> get(@PathVariable(value = "id") Integer id) {

		logger.trace("UserResource:get(): entered...");
		logger.debug("UserResource:get(): entered...");

		User foundUser = this.userRepository.findById(id).orElse(null);

		if (foundUser == null) {
			return ResponseEntity.notFound().header("Error[User]", "User NOT found with that id").build();
		}
		logger.trace("UserResource:get(): exiting...");
		logger.debug("UserResource:get(): exiting...");

		return ResponseEntity.ok(foundUser);
	}

	@PutMapping()
	public ResponseEntity<User> update(@RequestBody User userToUpdate) {

		logger.trace("UserResource:update(): entered...");
		logger.debug("UserResource:update(): entered...");

		User foundUser = userRepository.findById(userToUpdate.getId()).orElse(null);
		if (foundUser == null) {
			return ResponseEntity.notFound().header("User", "User NOT found with that id").build();
		} else {
			// userRepository.save(userToUpdate); // this will not encrypt the password..
			userCredentialService.save(userToUpdate); // this will encrypt the password..
		}

		logger.trace("UserResource:update(): exited...");
		logger.debug("UserResource:update(): exited...");

		return ResponseEntity.ok(userToUpdate);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<User> delete(@PathVariable(value = "id") Integer id) {

		logger.trace("UserResource:delete(): entered...");
		logger.debug("UserResource:delete(): entered...");

		// Post foundPost = dao.findById(id).orElse(null);
		User foundUser = this.userRepository.findById(id).orElse(null);

		if (foundUser == null) {
			return ResponseEntity.notFound().header("Error [User]", "User NOT found with that id").build();
		} else {
			// dao.delete(foundPost);
			userRepository.delete(foundUser);
		}

		logger.trace("UserResource:delete(): exited...");
		logger.debug("UserResource:delete(): exited...");

		return ResponseEntity.ok().build();
	}

}
