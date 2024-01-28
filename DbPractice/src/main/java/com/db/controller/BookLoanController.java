package com.db.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.db.model.BookLoan;
import com.db.service.BookLoanService;


import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookLoans")
public class BookLoanController {

	private final BookLoanService loanService;
	 @GetMapping
	    public ResponseEntity<List<BookLoan>> getAllLoans() {
		 
		 List<BookLoan> loans = loanService.getAllLoans();
		 if(!loans.isEmpty())
		 	{
			 return new ResponseEntity<>(loans, HttpStatus.OK);
		 	}
		 else
			 	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<BookLoan> getLoanById(@PathVariable Long id) {
	    	BookLoan loan =  loanService.getLoanById(id);
	        if(loan!= null)
	        	return new ResponseEntity<>(loan,HttpStatus.OK);
	        else
	        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @PostMapping
	    public ResponseEntity<Void> saveBookLoan(@RequestBody BookLoan loan) {
   	       loanService.saveLoan(loan);
	        return  new ResponseEntity<>(HttpStatus.CREATED);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteBookLoan(@PathVariable Long id) {
	    	if(loanService.getLoanById(id)!=null)
	    	{
	    		loanService.deleteLoan(id);
	    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    	}
	    	else
	    	{
	    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    	}
	    }
}
