package com.montec.apirest.blog.two.app.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.montec.apirest.blog.two.app.exceptions.GlobalException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenProvider {
	
	@Value("${app.jwt-expiration-milliseconds}")
	private int jwtExpirationInMs;
	
	private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	String secretString = Encoders.BASE64.encode(secretKey.getEncoded());
	
	public String generarToken(Authentication authentication) {
		String username = authentication.getName();
		
		Date fechaActual = new Date();
		Date fechaExpiration = new Date(fechaActual.getTime() + jwtExpirationInMs);
		
		String token = Jwts.builder().setSubject(username).setIssuedAt(new Date()).setIssuedAt(fechaExpiration)
				.signWith(secretKey,SignatureAlgorithm.HS512).compact();
		
		return token;
	}
	
	public String obtenerUsernameDelToken(String token) {
		Claims claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
		
		return claims.getSubject();
	}
	
	public boolean validarToken(String token) {
		
		try {
			Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
			return true;
		}catch (MalformedJwtException ex) {
			throw new GlobalException("Token Malformed");
		}catch (ExpiredJwtException ex) {
			throw new GlobalException("Token Expirado");
		}catch (UnsupportedJwtException ex) {
			throw new GlobalException("Token no compatible");
		}catch (IllegalArgumentException ex) {
			throw new GlobalException("IlegalArgumentException");
		}
		
	}
}
