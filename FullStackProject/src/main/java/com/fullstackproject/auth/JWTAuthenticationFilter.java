package com.fullstackproject.auth;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;
import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.fullstackproject.auth.AuthConstants.*;

/*The JWTFilter is inheriting the methods from "UsernamePasswordAuthenticationFilter class"
 * In order for the "AuthenticationFilter class" to be implemented we must extend that class and 
 * override it's methods
 * 
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	/*
	 * An instance named "authenticationManager" of the AuthenticationManager class
	 * is created and set to private
	 * 
	 */
	private AuthenticationManager authenticationManager;

	/*
	 * "JWTAuthenticationFilter" method is an overloaded constructor
	 * "AuthenticationManager class" instance "authenticationManager" is passed
	 * through the method
	 */
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	/*
	 * We override the "attemptAuthentication" method and pass through
	 * "HttpServletRequest req" and "HttpServletResponse res" The variable returned
	 * by the method is of type "Authentication" "attemptAuthentication" method is
	 * used to authenticate the user and return a populated Authentication object
	 * --- the method is inspecting the request from the user and extracting the
	 * username with password --- the username with password are then passed to the
	 * authenticationManager to be authenticated
	 * 
	 * 
	 * The authentication manager implements the authentication
	 * 
	 */

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {

		/*
		 * The instance "creds" of the "User class" is
		 * 
		 * 
		 * WE are trying to extract the value of our user in the database and convert
		 * that into an instance of the user that we have in our class
		 * 
		 * 
		 */
		try {
			com.fullstackproject.auth.User creds = new ObjectMapper().readValue(req.getInputStream(),
					com.fullstackproject.auth.User.class);
			/*
			 * Then we do an authentication, if the authentication is successfull we return
			 * back an authentication instance
			 * 
			 */
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(),
					creds.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/*
	 * A successfull authentication will generate a JSON Web Token & add that token
	 * as a header on the response The front end application can receive this JWT
	 * and store it for later use
	 * 
	 */

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		String token = JWT.create().withSubject(((User) auth.getPrincipal()).getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).sign(HMAC512(SECRET.getBytes()));
		res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
	}
	/*
	 * If the Authenticaion was unuccessful, the unsuccesfullAuthentication method
	 * will return default action provided by the super class Or you can add a
	 * header or body to the response at this point
	 * 
	 */
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest req, HttpServletResponse res,
			AuthenticationException failed) throws IOException, ServletException {
		super.unsuccessfulAuthentication(req, res, failed);
	}
}
