package com.lcwd.hotel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	
	// WebFilterChain
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
			
			security.authorizeHttpRequests()
			.anyRequest()
			.authenticated()
			.and()
			.oauth2ResourceServer()
			.jwt();
			// We can give here who will access which API but we will use hasRole like methods.
			return security.build();
			
		}
	
}
