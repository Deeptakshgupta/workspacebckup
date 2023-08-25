package com.pcp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcp.model.CustomUser;


public interface UserRepository extends JpaRepository<CustomUser, String> {

	public Optional<CustomUser> findByUsername(String username);
}
