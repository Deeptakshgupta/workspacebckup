package com.reddit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

	private final AuthService authservice;
	private final RefreshTokenService refreshTokenService;
	
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody RegisterRequest regsiterRequest)
	{
		authService.signup(regsiterRequest);
		 return new ResponseEntity<>("User Registration Successful",
	                HttpStatus.OK);
	}
	
	   @GetMapping("accountVerification/{token}")
	   public ResponseEntity<String> verifyAccount (@PathVariable String token)
	   {
		   authService.verifyAccount(token);
	        return new ResponseEntity<>("Account Activated Successfully", OK);
	   }
	
	   @PostMapping("/login")
	    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
		   return authService.login(loginRequest);
	   }
	   @PostMapping("/refresh/token")
	    public AuthenticationResponse refreshTokens(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
	        return authService.refreshToken(refreshTokenRequest);
	    }

	    @PostMapping("/logout")
	    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest) {
	        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
	        return ResponseEntity.status(HttpStatus.OK).body("Refresh Token Deleted Successfully!!");
	    }
	   
}