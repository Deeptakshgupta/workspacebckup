package com.pcp.service;


//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pcp.model.CustomUser;
import com.pcp.model.UserHelper; // using instead of userDetails
import com.pcp.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;

	@Override
	public UserHelper loadUserByUsername(String username) throws UsernameNotFoundException {
		 CustomUser userPojo = null;
		try 
		{
			userPojo = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException(username) );
			
			UserHelper userhelper = new UserHelper(userPojo);
			return userhelper;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
	
	
}
