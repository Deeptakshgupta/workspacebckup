package com.dummy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dummy.model.User;
import com.dummy.repository.UserRepository;

import lombok.AllArgsConstructor;



@RestController
@AllArgsConstructor
public class AuthController {

	private final UserRepository userRepository;
	@PostMapping("/saveUser")
	public ResponseEntity<String> saveUser(@RequestBody User user)
	{
		userRepository.save(user);
		return new ResponseEntity<>("Saved",HttpStatus.OK);
	}
}
