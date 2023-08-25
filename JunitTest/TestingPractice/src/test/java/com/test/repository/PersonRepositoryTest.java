package com.test.repository;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest

class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;
	
	@Test
	void testIsPersonExistsById() {
		
		
	Boolean test = personRepository.isPersonExistsById("1");
	System.out.println(test);
	assertThat(test).isTrue();
	}

}
