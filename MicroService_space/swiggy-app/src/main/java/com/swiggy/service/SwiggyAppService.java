package com.swiggy.service;

import org.springframework.stereotype.Service;

import com.swiggy.client.RestrauntServiceClient;
import com.swiggy.dto.OrderResponseDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SwiggyAppService {

	private final RestrauntServiceClient restrauntServiceClient;
	
	public String greeting()
	{
		return "Welcome to swiigy App service ";
	}
	
	public OrderResponseDTO checkOrderStatus(String orderId)
	{
		return restrauntServiceClient.fetchOrderStatus(orderId);
	}
}
