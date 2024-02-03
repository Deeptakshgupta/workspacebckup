package com.page.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

	@GetMapping("/message")
	public String getmessage()
	{
		return "String returned";
	}
	
}
