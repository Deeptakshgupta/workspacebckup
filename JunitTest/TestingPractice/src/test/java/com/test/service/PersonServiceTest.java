package com.test.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.repository.PersonRepository;

@ExtendWith(MockitoExtension.class) // mockito returns references that are required to be closed so we use this annotation so that all refrences gets closed 
class PersonServiceTest {

	// need to create a ,mock for repo as we don't it to be tested with actual data
	@Mock
	private PersonRepository personRepository; //we don't want to test this
	
	private PersonService personService; // this is what we want to testf
	
	
	@BeforeEach
	void setUp()
	{
		this.personService = new PersonService( this.personRepository); 
		// Constructor injection using dummy data provided mockito for testing purpose, so that auto injection doesn't occurs with the actual data
		
	}
	
	@Test
	void getAllPerson()
	{
		personService.getAllPerson();
		
		verify(personRepository).findAll();
	}

}
