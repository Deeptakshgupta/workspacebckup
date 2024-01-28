package com.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.model.BookLoan;

public interface BookLoanRepository extends JpaRepository<BookLoan, Long> {

}
