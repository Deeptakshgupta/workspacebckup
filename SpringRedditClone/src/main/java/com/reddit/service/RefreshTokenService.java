package com.reddit.service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.reddit.exceptions.SpringRedditException;
import com.reddit.model.RefreshToken;
import com.reddit.repository.RefreshTokenRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class RefreshTokenService {

	private final RefreshTokenRepository refreshTokenRepository;

	public RefreshToken generateRefreshToken() {
		RefreshToken refreshToken = new RefreshToken();
		refreshToken.setToken(UUID.randomUUID().toString());
		refreshToken.setCreatedDate(Instant.now());

		return refreshTokenRepository.save(refreshToken);
	}

	public void validateRefreshToken (String token)
	{
        refreshTokenRepository.findByToken(token)
        .orElseThrow(() -> new SpringRedditException("Invalid refresh Token"));
}

	public void deleteRefreshToken(String token) {
		refreshTokenRepository.deleteByToken(token);
	}
}