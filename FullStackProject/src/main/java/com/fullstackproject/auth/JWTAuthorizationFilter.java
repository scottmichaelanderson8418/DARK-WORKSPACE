package com.fullstackproject.auth;


import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import static com.fullstackproject.auth.AuthConstants.*;
/*Harry Video Notes:
 * Once you are authenticated you have access to the token and then they
 * will be authorized for access
 * 
 * In a nutshell - the JWT Token that is sent by the client is validated on the server
 * side to ensure that it is a valid token
 * 
 * JWTAuthorizationFilter - validates your JWT token
 * 
 */

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}
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
	 * getAuthentication() method is comparing the JWT against the encrypted secret
	 * key (in the AuthConstants.javafile) and verifies its authenticity
	 * 
	 * -- If the JWT is verified, then a new UsernamePasswordAuthenticationToken is
	 * generated with the user credentials and authorities
	 * 
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String header = req.getHeader(HEADER_STRING);
		if (header == null || !header.startsWith(TOKEN_PREFIX)) {
			chain.doFilter(req, res);
			return;
		}

		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);

	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest Request) {

		String token = Request.getHeader(HEADER_STRING);
		if (token != null) {
			String user = JWT.require(Algorithm.HMAC512(SECRET.getBytes())).build()
					.verify(token.replace(TOKEN_PREFIX, "")).getSubject();

			if (user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
			}
			return null;
		}
		return null;

	}

}
