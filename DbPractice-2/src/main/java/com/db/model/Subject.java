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
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	// many  to many with student
	
//	@ManyToMany
//	@JoinTable(
//			name = "student_enrolled",
//			joinColumns = @JoinColumn (name = "subject_id"),
//			inverseJoinColumns = @JoinColumn(name = "student_id"))
	
	@ManyToMany(mappedBy = "subjects")
	@JsonIgnore
	Set<Student> enrolled_students = new HashSet<>();
	
	
//	@ManyToOne
//	@JoinColumn( name = "subject_fk", referencedColumnName = "id")
//	private Teacher teacher;
}
