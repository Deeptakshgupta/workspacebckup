package com.test.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
//@Table(name = "person")
public class Person {

	@Id
//	@Column(name = "person_id")
	private String personId;
	private String personName;
	private String personCity;
	
}
