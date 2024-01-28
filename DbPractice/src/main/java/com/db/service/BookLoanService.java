package com.db.service;

import java.util.List;

import com.db.model.BookLoan;

public interface BookLoanService {

	public List<BookLoan> getAllLoans();
    public BookLoan getLoanById(Long id);
    public void saveLoan(BookLoan bookLoan);
    public void deleteLoan(Long id);
}
