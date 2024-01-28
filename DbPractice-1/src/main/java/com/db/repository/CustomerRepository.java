package com.db.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.db.dto.OrderResponse;
import com.db.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	
	//join Query 
	@Query("SELECT new com.db.dto.OrderResponse(c.name , p.productName) FROM Customer c JOIN c.products p")
	public List<OrderResponse> getJonInfo();
}
