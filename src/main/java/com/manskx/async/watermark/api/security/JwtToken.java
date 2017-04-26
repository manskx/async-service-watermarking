package com.manskx.async.watermark.api.security;

import java.util.Date;

import com.manskx.async.watermark.config.Configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtToken {

	// TODO: not completed yet
	public boolean isValidtoken(String jwtToken) {
		boolean valid = false;

		try {
			Jws<Claims> claims = Jwts.parser().setSigningKey(Configuration.key).parseClaimsJws(jwtToken);
			valid = true;
		} catch (Exception e) {
			// invalid token
		}

		return valid;
	}

	public static String generateNewToken(Object object, String subject) {

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		JwtBuilder builder = Jwts.builder().setSubject(subject);
		long expMillis = nowMillis + Configuration.TOKEN_EXPIRATION_MILLIS;
		Date exp = new Date(expMillis);
		builder.setExpiration(exp).setIssuedAt(now);
		String JwtToken = builder.claim("scope", object).signWith(SignatureAlgorithm.HS256, Configuration.key)
				.compact();
		return JwtToken;
	}

	public Object getScopeObject(String jwtToken) {

		Jws<Claims> claims = Jwts.parser().setSigningKey(Configuration.key).parseClaimsJws(jwtToken);

		claims.getBody().get("scope");

		return (Object) claims.getBody().get("scope");
	}
}