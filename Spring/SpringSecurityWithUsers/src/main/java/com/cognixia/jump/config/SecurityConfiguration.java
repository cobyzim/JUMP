package com.cognixia.jump.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	protected UserDetailsService userDetailsService() {
		
		
		return userDetailsService;
	}
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/api/user").permitAll()
			.anyRequest().authenticated()    // have to be user to access any APIs
			
			
			.and().httpBasic();
		
		
		
		return http.build();
	}
	
	// Encoder -> used to encode/decode all user passwords
	@Bean
	protected PasswordEncoder encoder() {
		
		// no password encoding
		//return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		//return NoOpPasswordEncoder.getInstance();
		
		return new BCryptPasswordEncoder();
	}

	// load the encoder & user details service that are needed for spring security to do authentication
	@Bean
	protected DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(encoder());

		return authProvider;
	}
	
	
}
