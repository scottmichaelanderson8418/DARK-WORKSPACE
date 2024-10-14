package com.geniune.security;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    public static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class.getName());

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MyUserDetailService myUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	    throws ServletException, IOException {
	logger.trace("Entered: doFilterInternal(): ");
	String authHeader = request.getHeader("Authorization");

	if (authHeader == null || !authHeader.startsWith("Bearer ")) {

	    filterChain.doFilter(request, response);

	    return;
	}

	// The length of the bearer + space = 7
	// this will read everything after 7 spaces
	String jwt = authHeader.substring(7);

	// this code will extract the user name from the jwt token
	String username = jwtService.extractUsername(jwt);

	// if authentication is already already null then it is not authenticated
	if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

	    // now we have the userDetails object
	    UserDetails userDetails = myUserDetailService.loadUserByUsername(username);

	    // make sure userDetails is not null
	    if (userDetails != null && jwtService.isTokenValid(jwt)) {

		// We need to create and authenticationToken and then pass that to the
		// authentication

		// Once we validate the token and then mark the context as "logged in"
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
			username, userDetails.getPassword(), userDetails.getAuthorities());

		// this tracks who is logged into the system
		authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	    }
	}
	logger.trace("Exit: doFilterInternal(): ");
	filterChain.doFilter(request, response);
    }
}
