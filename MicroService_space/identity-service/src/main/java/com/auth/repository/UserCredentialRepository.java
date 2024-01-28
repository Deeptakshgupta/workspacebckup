package com.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.entity.UserCredential;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Integer>{

	Optional<UserCredential> findByName(String name);
}
