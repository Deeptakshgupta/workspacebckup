package com.db.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.db.model.Author;
import com.db.repository.AuthorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{

	private final AuthorRepository authorRepository;

	@Override
	public List<Author> getAllAuthors() {
		
		return authorRepository.findAll();
		
	}

	@Override
	public Author getAuthorById(Long id) {
		
		return authorRepository.findById(id).orElse(null);
	}

	@Override
	public void saveAuthor(Author author) {
		
		 authorRepository.save(author);
		
	}

	@Override
	public void deleteAuthor(Long id) {
		// TODO Auto-generated method stub
		authorRepository.deleteById(id);
	}
	
	
}
