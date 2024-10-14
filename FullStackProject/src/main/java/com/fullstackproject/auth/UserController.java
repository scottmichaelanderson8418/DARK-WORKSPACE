package com.fullstackproject.auth;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private MySQLUserDetailsService userService;
	
	  @GetMapping("/values/values")
	  public ResponseEntity<List<String>> getNames() {
	    List<String> names = new ArrayList<String>();
	    names.add("First");
	    names.add("Second");
	    names.add("Third");
	    return ResponseEntity.ok(names);
	  }
	

	@PostMapping("/register")
	public void register(@RequestBody User newUser) {
		userService.Save(newUser);
	}
}
