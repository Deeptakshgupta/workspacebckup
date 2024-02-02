package com.page.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping
	public Page<Book> getBooks(
			@RequestParam Optional<Integer>  page,
			@RequestParam Optional<Integer> pageSize,
			@RequestParam Optional<String> sortBy
			)
	{
	
		return bookRepository.findAll(
				PageRequest.of(
						page.orElse(0),			// page number
						pageSize.orElse(5),		// page size
						Sort.Direction.ASC, sortBy.orElse("id")
						)		// PageRequest.of(int page number, int page size, Sort sort)
				
				);
		
	}
}
