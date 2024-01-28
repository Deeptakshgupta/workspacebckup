package com.restraunt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restraunt.dao.RestrauntOrderDAO;
import com.restraunt.dto.OrderResponseDTO;

@Service
public class RestrauntService {

	@Autowired
	private RestrauntOrderDAO orderDAO;

	public String greeting()
	{
		return "Welcome to Swiggy RestrauntService";
	}
	
	public OrderResponseDTO getOrder(String orderId)
	{
		return orderDAO.getOrders(orderId);
	}
}
