package com.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AuthConfig {

	@Bean
	public SecurityFilterChain secutiryFilterChain(HttpSecurity http) throws Exception
	{
		return http
				.authorizeHttpRequests()
				.requestMatchers("/auth/register").permitAll()
				.requestMatchers("/auth/token").permitAll()
				.anyRequest()
				.permitAll()
				.and()
				.build();
				
				
	}
	@Bean
	public UserDetailsService userDetailsService()
	{
		return new CustomUserDetailsService();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authenticatinProvider = new DaoAuthenticationProvider();
		authenticatinProvider.setUserDetailsService(userDetailsService());
		authenticatinProvider.setPasswordEncoder(passwordEncoder());
		
		return authenticatinProvider;
		
	}
	
	@Bean
	public AuthenticationManager authenticatioManager(AuthenticationConfiguration config ) throws Exception
	{
		return config.getAuthenticationManager();
	}
}
