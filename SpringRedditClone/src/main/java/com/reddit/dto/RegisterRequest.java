package com.reddit.dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class RegisterRequest {
    public RegisterRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	//@Email
//    @NotEmpty(message = "Email is required")
    private String email;
//    @NotBlank(message = "Username is required")
    private String username;
//    @NotBlank(message = "Password is required")
    private String password;
    
    
    
    
    
	public RegisterRequest(@Email  String email,
			 String username,
			String password) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "RegisterRequest [email=" + email + ", username=" + username + ", password=" + password + "]";
	}


}