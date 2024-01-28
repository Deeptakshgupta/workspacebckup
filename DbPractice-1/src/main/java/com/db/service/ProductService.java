package com.db.service;

import org.springframework.stereotype.Service;

import com.db.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;
	
}
