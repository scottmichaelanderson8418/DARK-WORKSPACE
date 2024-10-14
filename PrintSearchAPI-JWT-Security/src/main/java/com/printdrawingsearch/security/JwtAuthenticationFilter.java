package com.printdrawingsearch.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.printdrawingsearch.service.MyUserDetailService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Filter that checks the JWT token in the Authorization header of each request
 * and sets the authentication context if valid.
 */
@Configuration
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	/** The jwt service. */
	@Autowired
	private JwtService jwtService;

	/** The my user detail service. */
	@Autowired
	private MyUserDetailService myUserDetailService;

	/**
	 * Intercepts incoming HTTP requests to validate JWT tokens and sets the
	 * authentication context if the token is valid.
	 *
	 * @param request     the HTTP request
	 * @param response    the HTTP response
	 * @param filterChain the filter chain
	 * @throws ServletException if an error occurs during the filtering process
	 * @throws IOException      if an I/O error occurs during the filtering process
	 */

	/*
	 * The doFilterInternal method will pass the request, response, and filterchain
	 * objects -- The request object has information about the request by the user
	 * -- The response object has set values to send back to the user -- the
	 * FilterChain is a way to pass along the request and response object to any
	 * other filters in our pipeline -- The FilterChain is implemented using the
	 * ".doFilter" method
	 */

	/*
	 * The doFilterInternal method reads the headers looking for one called
	 * Authorization The constant "HEADER_STRING" = "authorization"
	 * 
	 * TOKEN_PREFIX identifier = "Bearer" - The TOKEN_PREFIX is used as part of the
	 * Authorization Header to help the receiver understand the method of
	 * authorization taking place
	 * 
	 * Lastly, the "doFilterInternal" function is passing the JWT through the helper
	 * function called getAuthentication
	 * 
	 * jwtService.isTokenValid(jwt) method is comparing the JWT against the
	 * encrypted secret key and verifies its authenticity
	 * 
	 * -- If the JWT is verified, then a new UsernamePasswordAuthenticationToken is
	 * generated with the user credentials and authorities
	 * 
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {

		// Get the Authorization header from the request
		String authHeader = request.getHeader("Authorization");

		// If the Authorization header is missing or does not start with "Bearer ",
		// continue the filter chain
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}

		// Extract the JWT token from the Authorization header
		String jwt = authHeader.substring(7);

		// Extract the username from the JWT token
		String username = jwtService.extractUsername(jwt);

		// If username is not null and the authentication context is not already set
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			// Load user details using the username extracted from the token
			UserDetails userDetails = myUserDetailService.loadUserByUsername(username);

			// Validate the token and user details
			if (userDetails != null && jwtService.isTokenValid(jwt)) {

				// Create an authentication token and set the authentication context
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
						username, userDetails.getPassword(), userDetails.getAuthorities());

				// Set additional details for th authentication token
				authenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				// Set the authentication context
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}

		// Continue the filter chain
		filterChain.doFilter(request, response);
	}
}
