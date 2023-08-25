package com.pcp.model;

import org.springframework.security.core.userdetails.User;


// user internally implements UserDetails 
public class UserHelper extends User {

	/**
	 * for handling serialization error
	 */
	private static final long serialVersionUID = 1L;

	public UserHelper(CustomUser user)
	{
	super(
			user.getUsername(),
			user.getPassword(),
			user.getListOfGrantedAuthorities()
			);
	}
}
