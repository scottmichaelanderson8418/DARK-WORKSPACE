package com.geniune.security;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.geniune.model.MyUser;
import com.geniune.repositories.MyUserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {
    public static final Logger logger = LoggerFactory.getLogger(MyUserDetailService.class.getName());
    @Autowired
    private MyUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	logger.trace("Entered: loadUserByUsername(): ");
	Optional<MyUser> user = repository.findByUsername(username);
	if (user.isPresent()) {
	    var userObj = user.get();
	    logger.trace("Exit: loadUserByUsername(): ");
	    return User.builder().username(userObj.getUsername()).password(userObj.getPassword())
		    .roles(getRoles(userObj)).build();

	} else {
	    throw new UsernameNotFoundException(username);
	}

    }

    private String[] getRoles(MyUser user) {
	logger.trace("Entered: getRoles(): ");
	if (user.getRole() == null) {
	    logger.trace("Exit: getRoles(): ");
	    return new String[] { "USER" };
	}
	logger.trace("Exit: getRoles(): ");
	return user.getRole().split(",");
    }
}
