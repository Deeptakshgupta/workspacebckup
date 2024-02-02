package com.db.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.db.model.Book;
import com.db.service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

	private final BookService bookService;
	 @GetMapping
	    public ResponseEntity<List<Book>> getAllBooks() {
		 
		 List<Book> books = bookService.getAllBooks();
	     
		 return ResponseEntity.status(HttpStatus.OK).body(books);
		 
		 
//		 return new ResponseEntity<>(books, HttpStatus.OK);
	        
	        
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
	    	Book book =  bookService.getBookById(id);
	        if(book!= null)
	        	return new ResponseEntity<>(book,HttpStatus.OK);
	        else
	        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    @PostMapping
	    public ResponseEntity<Void> saveBook(@RequestBody Book book) {
	        bookService.saveBook(book);
	        return  new ResponseEntity<>(HttpStatus.CREATED);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
	    	if(bookService.getBookById(id)!=null)
	    	{
	    		bookService.deleteBook(id);
	    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    	}
	    	else
	    	{
	    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    	}
	    }
}
