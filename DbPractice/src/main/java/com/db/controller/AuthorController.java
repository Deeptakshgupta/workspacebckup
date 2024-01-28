package com.db.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.db.model.Author;
import com.db.model.Book;
import com.db.service.AuthorService;
import com.db.service.BookService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api/authors")
public class AuthorController {

	private final AuthorService authorService;
	
	 @GetMapping
	    public ResponseEntity<List<Author>> getAllAuthors() {
		 
		 List<Author> authors = authorService.getAllAuthors();
		 if(!authors.isEmpty())
	        return new ResponseEntity<>(authors, HttpStatus.OK);
		 else
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }

	    @GetMapping("/{id}")
	    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
	    	Author author =  authorService.getAuthorById(id);
	        if(author!= null)
	        	return new ResponseEntity<>(author,HttpStatus.OK);
	        else
	        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @PostMapping
	    public ResponseEntity<Void> saveAuthor(@RequestBody Author author) {
	    	authorService.saveAuthor(author);
	        return  new ResponseEntity<>(HttpStatus.CREATED);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
	    	if(authorService.getAuthorById(id)!=null)
	    	{
	    		authorService.deleteAuthor(id);
	    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    	}
	    	else
	    	{
	    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    	}
	    }
	 
}
