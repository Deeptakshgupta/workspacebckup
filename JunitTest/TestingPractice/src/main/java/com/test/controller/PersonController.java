package com.test.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.service.PersonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PersonController {

	private final PersonService personService;	
	@GetMapping("/person")
	public ResponseEntity<?> getAllStudents()
	{
		return ResponseEntity.ok(personService.getAllPerson());
	}
}
