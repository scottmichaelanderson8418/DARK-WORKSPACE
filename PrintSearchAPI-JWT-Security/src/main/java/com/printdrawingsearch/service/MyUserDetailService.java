
package com.printdrawingsearch.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.printdrawingsearch.model.MyUser;
import com.printdrawingsearch.repository.MyUserRepository;

/**
 * Service class for managing user details.
 */
@Service
public class MyUserDetailService implements UserDetailsService {

	/** The my user repository. */
	@Autowired
	private MyUserRepository myUserRepository;

	/**
	 * Loads user details by username.
	 * 
	 * @param username the username of the user to load
	 * @return the UserDetails object representing the user
	 * @throws UsernameNotFoundException if the user is not found
	 */

	// 1. The "loadUserByusername" method creates a "user" instance of the
	// MyUserRepository class
	// instance "myUserRepository"
	// 2. The "findByUsername(String username)" method is called and "String
	// username"
	// is passed into the method
	// 3. if "user == null" then the username was not found and spring throws the"
	// UsernameNotFoundException"
	// 4. if the "user" is found, the spring frame work security returns the "user"
	// instance with username, password, and authorities,

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<MyUser> user = myUserRepository.findByUsername(username);
		// If the username is found then an object of the "UserDetails" Interface is
		// created using the username and password
		if (user.isPresent()) {
			var userObj = user.get();
			// uses the "User" class "builder()" method to create a "UserBuiler"
			// the "UserBuilder" has the "username()" and "password()" and "roles()" methods
			// for building and instance of "UserBuilder" class
			// the "UserBuilder" class contains a method called "build()" that returns a
			// "UserDetails" object
			return User.builder().username(userObj.getUsername()).password(userObj.getPassword())
					.roles(getRoles(userObj)).build();

		} else {
			throw new UsernameNotFoundException(username);
		}
	}

	/**
	 * Gets roles for the given user.
	 * 
	 * @param user the user for whom roles are retrieved
	 * @return an array of roles assigned to the user
	 */
	// the getRoles method passes in an instance of "MyUser" class
	private String[] getRoles(MyUser user) {
		// if the user does not have a role set the role = "USER"
		if (user.getRole() == null) {
			// create a new String array containing the role= "USER"
			return new String[] { "USER" };
		}
		// the split() method will separate a string by "," and create a String[] array
		return user.getRole().split(",");
	}
}