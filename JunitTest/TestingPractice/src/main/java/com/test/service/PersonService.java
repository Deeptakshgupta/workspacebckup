package com.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.model.Person;
import com.test.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {

	private final PersonRepository personRepository;
	
	public List<Person> getAllPerson()
	{
		return personRepository.findAll();
	}
}
