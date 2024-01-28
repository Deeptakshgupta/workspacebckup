package com.db.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.db.model.Book;
import com.db.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

	private final BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		
		List<Book> books = bookRepository.findAll();
		
		return books;
	}

	@Override
	public Book getBookById(Long id) {
		
		return	bookRepository.findById(id).orElse(null);
	}

	@Override
	public void saveBook(Book book) {
		
		bookRepository.save(book);
	}

	@Override
	public void deleteBook(Long id) {

        bookRepository.deleteById(id);
   
	}


	
	
}
