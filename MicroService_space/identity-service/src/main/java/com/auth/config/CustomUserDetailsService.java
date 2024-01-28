package com.auth.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.auth.entity.UserCredential;
import com.auth.repository.UserCredentialRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserCredentialRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UserCredential> credential = userRepo.findByName(username);
		
		return credential.map(CustomUserDetails :: new ).orElseThrow(()-> new UsernameNotFoundException("user not found"));
	}

}
