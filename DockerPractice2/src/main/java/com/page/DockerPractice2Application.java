package com.page;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerPractice2Application {
	
	@GetMapping("/message")
	public String message()
	{
		return "string message";
	}

	public static void main(String[] args) {
		SpringApplication.run(DockerPractice2Application.class, args);
	}

}
