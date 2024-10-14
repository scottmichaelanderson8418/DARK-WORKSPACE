
package com.workshop.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// Spring will know this is a security configuration class
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	// Provides a default configuration for me.
	// "Everything behind the /login screen"
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		// by customizing the "authorizeHttpRequest" we got rid of the default login we
		// had

		// Note: "CSRF" Cross Site Request Forgery
		// If "CSRF" is enabled all postrequests will be block
		return httpSecurity.csrf(AbstractHttpConfigurer::disable)

				.authorizeHttpRequests(registry -> {
					registry.requestMatchers("/home", "/register/**", "/student/**", "/getAllUsers", "/login")
							.permitAll();
					registry.requestMatchers("/admin/**").hasRole("ADMIN");
					registry.requestMatchers("/user/**").hasRole("USER");

					registry.anyRequest().authenticated();

				}).formLogin(AbstractAuthenticationFilterConfigurer::permitAll).build(); // build the HTTP Security

	}

	@Bean
	public UserDetailsService userDetailsService() {

		UserDetails normalUser = User.builder().username("gc").password("{noop}123").roles("USER").build();
		UserDetails adminUser = User.builder().username("admin").password("{noop}123").roles("ADMIN", "USER").build();
		return new InMemoryUserDetailsManager(normalUser, adminUser);
	}

}
