package com.db.service;

import java.util.List;

import com.db.model.Book;

public interface BookService {

	public List<Book> getAllBooks();
    public Book getBookById(Long id);
    public void saveBook(Book book);
    public void deleteBook(Long id);
    
	
}
