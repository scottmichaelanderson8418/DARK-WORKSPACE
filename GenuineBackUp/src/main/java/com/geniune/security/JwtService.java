package com.geniune.security;

import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	// Note: we generate the secret key in the src/text/java classes
	private static final String SECRET = "9179C05047F83F0CF8629483D243C714C863407B970FE3937EEF114FE0CD7F8B7F0D1C510429299ED910CD0381161" +
			"3B285B16E3EE144A846CE40BFBA2929FD1A";

	// this is equal to 30 minutes
	private static final long VALIDITY = TimeUnit.MINUTES.toMillis(30);

	public String extractUsername(String jwt) { // The method takes a JWT (JSON Web Token) as input
												// and returns the username it contains.

		Claims claims = Jwts.parser().verifyWith(generateKey()).build().parseSignedClaims(jwt).getPayload();
		return claims.getSubject();
	}

	private SecretKey generateKey() {
		// this will decode the secret key
		byte[] decodedKey = Base64.getDecoder().decode(SECRET);

		return Keys.hmacShaKeyFor(decodedKey);
	}

	public String generateToken(UserDetails userDetails) {

		Map<String, String> claims = new HashMap<>();

		claims.put("iss", "https://secure.genuinecoder.com");
		// claims.put("name", "https://secure.genuinecoder.com");

		return Jwts.builder().claims(claims).subject(userDetails.getUsername()).issuedAt(Date.from(Instant.now()))
				.expiration(Date.from(Instant.now().plusMillis(VALIDITY))).signWith(generateKey()).compact();

	}

	private Claims getClaims(String jwt) {
		Claims claims = null;

		return claims = Jwts
				// Creates a new parser for JWTs.
				.parser()
				// Secret key is found by "generateKey()" and used for verifying the jwts
				// signature
				.verifyWith(generateKey())
				// Builds the JWT parser.
				.build()
				// Parses the JWT string and validates its signature. Throws an exception if the
				// signature is invalid.
				.parseSignedClaims(jwt)
				// Extracts the payload (body) of the JWT, which typically contains the claims
				// (data) about the user.
				.getPayload();

	}

	public boolean isTokenValid(String jwt) {

		Claims claims = getClaims(jwt);
		boolean valid = false;

		if (Date.from(Instant.now()).before(claims.getExpiration())) {
			valid = true;
		}

		return valid;

	}

}
