package com.restraunt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restraunt.dto.OrderResponseDTO;
import com.restraunt.service.RestrauntService;

@RestController
@RequestMapping("/restraunt")
public class RestrauntController {

	@Autowired
	private RestrauntService restrauntService;
	
	@GetMapping
	public String greetingMessage()
	{
		return restrauntService.greeting();
	}
	
	@GetMapping("/orders/status/{orderId}")
	public OrderResponseDTO getOrder(@PathVariable String orderId)
	{
		return restrauntService.getOrder(orderId);
	}

	
	
}
