package com.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
