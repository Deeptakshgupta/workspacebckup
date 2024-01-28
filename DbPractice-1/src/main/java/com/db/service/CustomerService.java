package com.db.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.db.dto.OrderResponse;
import com.db.model.Customer;
import com.db.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

	private final CustomerRepository customerRepository;

	public Customer saveOrder(Customer customer) {

		return customerRepository.save(customer);
	}

	

	public List<Customer> findAllOrders() {
		return customerRepository.findAll();
	}



	public List<OrderResponse> getJoinInformation() {
		
		return customerRepository.getJonInfo();
	}

	

	
	
}
