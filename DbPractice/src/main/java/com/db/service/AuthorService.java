package com.db.service;

import java.util.List;

import com.db.model.Author;


public interface AuthorService {

	public List<Author> getAllAuthors();
    public Author getAuthorById(Long id);
    public void saveAuthor(Author author);
    public void deleteAuthor(Long id);
}
