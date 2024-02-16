package com.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.jwt.security.JWTAuthenticationEntryPoint;
import com.jwt.security.JwtAuthenticationFilter;



@Component
public class SecurityConfig {

	@Autowired
	private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private JwtAuthenticationFilter filter;
	
	  @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	        http.csrf(csrf -> csrf.disable())
	                .authorizeRequests().
	                requestMatchers("/test").authenticated().requestMatchers("/auth/login").permitAll()
	                .anyRequest()
	                .authenticated()
	                .and().exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthenticationEntryPoint))
	                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }
}
