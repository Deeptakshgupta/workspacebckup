package com.db.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.db.model.Book;
import com.db.model.BookLoan;
import com.db.repository.BookLoanRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookLoanServiceImpl implements BookLoanService{

	private final BookLoanRepository loanRepository;

	@Override
	public List<BookLoan> getAllLoans() {
		
		return loanRepository.findAll();
	}

	@Override
	public BookLoan getLoanById(Long id) {
		
		return loanRepository.findById(id).orElse(null);
	}

	@Override
	public void saveLoan(BookLoan bookLoan) {
		
		loanRepository.save(bookLoan);
	}

	@Override
	public void deleteLoan(Long id) {
		
		loanRepository.deleteById(id);
	}
	
	
	
	
}

