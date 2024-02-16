package com.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/test")
public class HomeController {

	@GetMapping()
	public String test()
	{
		log.warn("This is working msg");
		return "test endpoint";
	}
}
