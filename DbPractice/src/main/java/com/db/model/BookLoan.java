package com.db.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookLoan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loanId;
	
	private LocalDate loanDate;
	private LocalDate returnDate;
	private String status;
		
	@ManyToOne
	@JsonIgnore
	private Book book;
	
}

//{
//	"loanId":"",
//	"loanDate":"",	
//	"returnDate":"",
//	"status":"",
//	"book":{
//		"isbn":"",
//		"titile":"",
//		"description":"",
//		"author":""
//	}
//}

