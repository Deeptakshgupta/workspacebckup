package com.authentication.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authentication.model.ApplicationUser;

public interface UserRepository extends JpaRepository<ApplicationUser, Integer>{

	Optional<ApplicationUser> findByUsername(String username); 
}
