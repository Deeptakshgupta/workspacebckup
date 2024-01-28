package com.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
