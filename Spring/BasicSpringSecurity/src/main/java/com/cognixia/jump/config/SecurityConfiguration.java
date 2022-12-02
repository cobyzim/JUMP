package com.cognixia.jump.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	// Authorization - who are you? (users)
	@Bean
	protected UserDetailsService userDetailsService() {
		// UserDetailsService - helps in finding users
		// Spring Security calls this service to check if username and password 
		// match any users in application
		
		// For this example, we'll create a user details service that manages a set of in-memory users
		
		UserDetails user = User.withDefaultPasswordEncoder()	// security will encode password by default, so we remove that
								.username("user1")				// create user by giving username, password, and role
								.password("pw123")
								.roles("USER")
								.build();
		
		UserDetails admin = User.withDefaultPasswordEncoder()	
								.username("admin1")				
								.password("pw123")
								.roles("ADMIN", "USER", "DEV")
								.build();
		
		UserDetails dev = User.withDefaultPasswordEncoder()	
								.username("dev1")				
								.password("pw123")
								.roles("DEV")
								.build();
		
		return new InMemoryUserDetailsManager(user, admin, dev);
	}
	
	// Authentication - what do you want (which APIs do certain users have access to)
	// Security filters - layers of security (each layer does some security checks)
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// ALWAYS WANT TO LIST ACCESS RULES FROM MOST SPECIFIC TO LEAST SPECIFIC
		
		http.csrf().disable()
			.authorizeRequests()		// here are my rules for who is allowed to access what
			
			.antMatchers("/api/admin").hasRole("ADMIN")			// Only admins can access this API
			.antMatchers("/api/usr").hasRole("USER")
			.antMatchers("/api/dev").hasRole("DEV")
			.antMatchers("/api/book").hasAnyRole("ADMIN", "DEV")
			.antMatchers("/api/all").permitAll()   // anyone, regardless if you're a user, can access it
			.antMatchers(HttpMethod.PUT, "/api/employee/department").hasRole("ADMIN")  // only admin can access put request
			.antMatchers("/api/employee/**").hasRole("USER")    // anything along employee endpoint can be accessed by user
			
			
			.anyRequest().authenticated()       // every API that I don't have an antMatcher for, you have to be a user
												// in order to access it
			
			.and().httpBasic();			// basic authentication (can use plain username + password)
		
		return http.build();
	}

}
