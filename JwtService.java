package com.sathish.demo.security;
import io.jsonwebtoken.*; import io.jsonwebtoken.security.Keys; import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service; import java.nio.charset.StandardCharsets; import java.util.Date; import javax.crypto.SecretKey;
@Service
public class JwtService {
 @Value("${app.jwt.secret}") private String secret;
 @Value("${app.jwt.expiration-ms}") private long expiration;
 private SecretKey key(){return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));}
 public String generateToken(String username){Date now=new Date(); return Jwts.builder().subject(username).issuedAt(now)
  .expiration(new Date(now.getTime()+expiration)).signWith(key()).compact();}
 public String extractUsername(String token){return Jwts.parser().verifyWith(key()).build().parseSignedClaims(token).getPayload().getSubject();}
 public boolean isValid(String token,String username){try{return username.equals(extractUsername(token));}catch(JwtException|IllegalArgumentException e){return false;}}
}
