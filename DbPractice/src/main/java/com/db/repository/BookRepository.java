package com.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
