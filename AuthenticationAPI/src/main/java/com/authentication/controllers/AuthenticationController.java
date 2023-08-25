package com.authentication.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.dto.LoginResponseDTO;
import com.authentication.dto.RegistrationDTO;
import com.authentication.model.ApplicationUser;
import com.authentication.services.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService authenticationService;
	
	@GetMapping("/")
	public String getcheck()
	{
		return "auth level check";
	}
	
	@PostMapping("/register")
	public ApplicationUser registerUser(@RequestBody RegistrationDTO user)
	{
			return authenticationService.registerUser(user.getUsername(), user.getPassword());
	}
	
	@PostMapping("/login")
	public LoginResponseDTO loginUser(@RequestBody RegistrationDTO user)
	{
		return authenticationService.loginUser(user.getUsername(),user.getPassword());
	}
}
