package com.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import com.gateway.util.JwtUtil;
import com.google.common.net.HttpHeaders;



@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config>{

	@Autowired
	private RouteValidator validator;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	public AuthenticationFilter()
	{
		super(Config.class);
	}
	
	public static class Config
	{
		
	}

	// filter at gateway level
	// exempting some of the endpoints from the authentication checks
	@Override
	public GatewayFilter apply(Config config) {
		// similar to security filter chain
		return ((exchange, chain) -> 
		{
			if(validator.isSecured.test(exchange.getRequest()))
			{
					if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION))
						throw new RuntimeException("missing authorization Header");

					String  authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
					if(authHeader != null && authHeader.startsWith("Bearer "))
						authHeader = authHeader.substring(7);
				try
				{
					// instead of calling JWT from other API using RestTemplate ,
					//implemented own JWT at gateway level only
					
					jwtUtil.validateToken(authHeader);
				}
				catch (Exception e)
				{
					 System.out.println("invalid access...!");
	                    throw new RuntimeException("un authorized access to application");
				}
			}
			return chain.filter(exchange);
		});
	}
	
}
