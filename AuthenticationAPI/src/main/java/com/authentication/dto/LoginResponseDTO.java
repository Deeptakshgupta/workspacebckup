package com.authentication.dto;

import com.authentication.model.ApplicationUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponseDTO {    // I Think we make this as a user and User as DTO 

	private ApplicationUser user;
	private String jwt;
	
	
}
