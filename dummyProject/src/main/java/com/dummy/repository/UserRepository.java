package com.dummy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dummy.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	

}
