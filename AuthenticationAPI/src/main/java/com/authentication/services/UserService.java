package com.authentication.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authentication.model.ApplicationUser;
import com.authentication.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username)  {
		// TODO Auto-generated method stub
		try {
		
		return userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User with name: "+username+"couldn't be found"));
		
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		
		}

}
