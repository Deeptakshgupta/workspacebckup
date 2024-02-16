package com.jwt.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

// whenever a request is made this method gets called first
@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtHelper jwtHelper;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String requestHeader = request.getHeader("Authorization");
//		String requestHeader = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNzA4MDY2NDA0LCJleHAiOjE3MDgwODQ0MDR9.Ub4hT9UyV-McimlATMNB4OqBsFuXzJNoBX55qu2LGLMnyW5TTAniSyc4_X_51znby8kVZBrMOrx7cSk8YXUEyQ";
		// we get the Beared token with "Bearer" appended before it

		log.info("Header {}", requestHeader);

		String username = null;
		String token = null;

		// getting the token from "Bearer" appended String
		if (requestHeader != null && requestHeader.startsWith("Bearer")) {
			token = requestHeader.substring(7);
			try {
				username = jwtHelper.getUsernameFromToken(token);
			} catch (IllegalArgumentException e) {
				logger.info(" Illegal Argument while fetching the username !!");
				e.printStackTrace();
			} catch (ExpiredJwtException e) {
				logger.info(" Given jwt token is expired !!");
				e.printStackTrace();
			} catch (MalformedJwtException e) {
				logger.info(" Some change has done in token !! Invalid Token");
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		else
		{
			logger.info("Invalid Header Value !! ");
		}

		// username is retrieved and now authenticate using the token
		if( username!= null && SecurityContextHolder.getContext().getAuthentication()== null)
		{
			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
			Boolean validateToken = jwtHelper.validateToken(token, userDetails);
			
			if(validateToken)
			{
				 UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				 authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				 SecurityContextHolder.getContext().setAuthentication(authentication);
			}
			else {
                logger.info(" Validation fails !!");
            }
		}
		filterChain.doFilter(request, response);
	
	}

}
