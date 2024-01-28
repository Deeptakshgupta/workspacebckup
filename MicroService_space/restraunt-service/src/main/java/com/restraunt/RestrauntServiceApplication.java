package com.restraunt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RestrauntServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestrauntServiceApplication.class, args);
	}

}
