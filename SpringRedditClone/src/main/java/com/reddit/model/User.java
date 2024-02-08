package com.reddit.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

import java.time.Instant;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class User {
    public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long userId, String username,
			 String password,
			String email, Instant created, boolean enabled) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.created = created;
		this.enabled = enabled;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Instant getCreated() {
		return created;
	}
	public void setCreated(Instant created) {
		this.created = created;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
	private String username;
	private String password;
    private String email;
    private Instant created;
    private boolean enabled;
}
