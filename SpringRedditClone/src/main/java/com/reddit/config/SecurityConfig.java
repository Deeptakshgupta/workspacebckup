package com.reddit.config;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.web.SecurityFilterChain;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.security.PublicKey;
import java.security.KeyFactory;

import java.util.Base64;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

//    @Value("${jwt.public.key}")
//    RSAPublicKey publicKey;
//
//    @Value("${jwt.private.key}")
//    RSAPrivateKey privateKey;
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity.cors().and()
//                .csrf().disable()
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/api/auth/**")
//                        .permitAll()
//                        .requestMatchers(HttpMethod.GET, "/api/subreddit")
//                        .permitAll()
//                        .requestMatchers(HttpMethod.GET, "/api/posts/")
//                        .permitAll()
//                        .requestMatchers(HttpMethod.GET, "/api/posts/**")
//                        .permitAll()
//                        .requestMatchers("/v2/api-docs",
//                                "/configuration/ui",
//                                "/swagger-resources/**",
//                                "/configuration/security",
//                                "/swagger-ui.html",
//                                "/webjars/**")
//                        .permitAll()
//                        .anyRequest()
//                        .authenticated())
//                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .exceptionHandling(exceptions -> exceptions
//                        .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
//                        .accessDeniedHandler(new BearerTokenAccessDeniedHandler())
//                ).build();
//    }
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    JwtDecoder jwtDecoder() throws Exception {
////    	RSAPublicKey publicKey_local = loadPublicKey();
//        return NimbusJwtDecoder.withPublicKey(this.publicKey).build();
//    }
//
//    @Bean
//    JwtEncoder jwtEncoder() {
//    	
//        JWK jwk = new RSAKey.Builder(this.publicKey).privateKey(this.privateKey).build();
//        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
//        return new NimbusJwtEncoder(jwks);
//    }
//    
////    private RSAPublicKey loadPublicKey() throws Exception {
////        byte[] keyBytes = Files.readAllBytes(Paths.get("app.pub"));
////        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
////        KeyFactory kf = KeyFactory.getInstance("RSA");
////        return (RSAPublicKey) kf.generatePublic(spec);
////    }
}
