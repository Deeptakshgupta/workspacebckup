package com.swiggy.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.swiggy.dto.OrderResponseDTO;


@Component
public class RestrauntServiceClient {

	@Autowired
	private RestTemplate restTemplate;
	
	public OrderResponseDTO fetchOrderStatus(String orderId)
	{
		return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/orders/status/" + orderId, OrderResponseDTO.class);
	}
}
