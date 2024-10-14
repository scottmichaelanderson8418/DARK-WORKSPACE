package com.fullstackproject.auth;

import static com.fullstackproject.auth.AuthConstants.SIGN_UP_URL;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;




/*
 * 
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/*Harry Video Notes:
	 * there is an instance of the UserDetailsService. the UserDetailsService is a class that implements 
	 * the UserDetails Interface
	 * - There is a handle to that service that is contained in the WebSecurityConfig
	 * - There is a password encoder
	 * 
	 */
	 
	@Autowired
	private MySQLUserDetailsService mySQLUserDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(mySQLUserDetailsService).passwordEncoder(passwordEncoder());

	}
	/*Harry Video Notes:
	 * 
	 * This "configure()" method is different from Lesson 07. These JWTAuthentication
	 * and JWTAuthorization filters come into play when using JWT tokens
	 * 
	 *  
	 * 
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
		.and().csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
		.anyRequest().authenticated().and()
		.addFilter(new JWTAuthenticationFilter(authenticationManager()))
		.addFilter(new JWTAuthorizationFilter(authenticationManager())).sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}



	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.applyPermitDefaultValues();
		corsConfig.setExposedHeaders(Arrays.asList("Authorization"));
		source.registerCorsConfiguration("/**", corsConfig);
		return source;

	}

}
