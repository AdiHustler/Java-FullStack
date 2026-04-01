package com.security.JWT.Util;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Component
public class JWTUtil {
	
	private final String SECRET_KEY="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.KMUFsIDTnFmyG3nMiGM6H9FNFUROf3wh7SmqJp-QV30";

	public SecretKey getkey() {
		return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	}
	
	public String createToken(String username) {
		return Jwts.builder()
			.subject(username)
			.issuedAt(new Date(System.currentTimeMillis()))
			.expiration(new Date(System.currentTimeMillis()+1000*60*2))
			.signWith(getkey())
			.compact();
	}
	
	public String getUsername(String token) {
		return Jwts.parser()
				.verifyWith(getkey())
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();
	}
	
	public boolean isTokenExpired(String token) {
		return Jwts.parser()
				.verifyWith(getkey())
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getExpiration()
				.after(new Date());
	}
	
	public boolean validateToken(String user, String token) {
		String username = getUsername(token);
		return user.equals(username)&& isTokenExpired(token);
	}
}
