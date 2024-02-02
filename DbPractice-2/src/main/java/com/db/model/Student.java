package com.db.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	//many to many b/w subject and student
	// have to create a new table and store the relation there

//	@JsonIgnore	 // to ignore the infinite refence problem in these tables where it gets rerenced to each other again and again 
//	@ManyToMany(mappedBy = "enrolled_students")
	
	@ManyToMany
	@JoinTable(
			name = "students_enrolled",
			joinColumns = @JoinColumn(name = "subject_id"),
			inverseJoinColumns = @JoinColumn(name = "student_id")
			)
	Set<Subject> subjects = new HashSet<>();
	
}
