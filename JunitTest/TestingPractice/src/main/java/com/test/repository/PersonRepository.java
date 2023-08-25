package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.model.Person;

public interface PersonRepository  extends JpaRepository<Person, String>{

	@Query("""
			select 
				case 
					when count(*) > 0 
					then 
						true 	
					else 
						false 
				end 
			from Person s where s.personId = ?1
			
			""")
	Boolean isPersonExistsById(String id);
	// never use Table name and it's column name in the query use entity class name and it's class variables only
}
