package com.foodtruckme.servicios;


import java.security.Key;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenService {
	
	final static Key secret = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	private Date getExpiration(Date date, int tiempo) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, tiempo);
		
		return calendar.getTime();
	}
	
	
	public String generateToken(String userName, int tiempo, String rol) {
		Date exp = getExpiration(new Date(), tiempo);
		
		//return Jwts.builder().setSubject(username).signWith(key).setExpiration(exp).compact();
		return Jwts.builder().setSubject(userName)
				.claim("rol", rol)
				.setExpiration(exp)
				.signWith(secret).compact();
	}
	
	public static boolean validateToken(String token) {
		String prefix = "Bearer";
		try {
			if (token.startsWith(prefix)) {
				token = token.substring(prefix.length()).trim();
			}
			//Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			Claims claims = Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token).getBody();
			
			System.out.println("ID: " + claims.getId());
            System.out.println("Subject: " + claims.getSubject());
            System.out.println("Rol: " + claims.get("rol"));
            System.out.println("Issuer: " + claims.getIssuer());
            System.out.println("Expiration: " + claims.getExpiration());
            
            return true;
		} catch (ExpiredJwtException exp) {
			System.out.println("Expiro el tiempo de validez del token");
			return false;
		} catch (JwtException e) {
			System.out.println("Algo salio mal: "+ e.getMessage());
			return false;
		}
	}
	
}
