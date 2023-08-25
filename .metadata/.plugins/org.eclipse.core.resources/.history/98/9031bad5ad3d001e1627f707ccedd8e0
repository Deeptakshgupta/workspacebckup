package com.pcp.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class CustomUser {

	private String username; // username-> client_id 
	private String password;// password-> client_secret
	private Collection<? extends GrantedAuthority> listOfGrantedAuthorities = new ArrayList();
	
	
}
