package org.example.apigateway.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.example.apigateway.dto.JwtAuthenticationDto;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JWtUtils {

    private final String JWT_SECRET = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkFsZXggTWlraCIsImlhdCI6MTczMjUyMjIyMn0PqZoqxXXmB4dvARBWoQ1FqwwiPSdR7KwT7uGgzhM4";



    public boolean validateJwtToken(String token){
        try{
            Jwts.parser()
                    .verifyWith(getSingInKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return true;
        }catch (ExpiredJwtException e){
            System.out.println("Expired JwtException "+ e.getMessage());
        }catch (UnsupportedJwtException e){
            System.out.println("Unsupported JwtException "+ e.getMessage());
        }catch (MalformedJwtException e){
            System.out.println("Malformed JwtException "+ e.getMessage());
        }catch (SecurityException e){
            System.out.println("Security Exception "+ e.getMessage());
        }catch (Exception e){
            System.out.println("Invalid Token "+ e.getMessage());
        }
        return false;
    }

    public JwtAuthenticationDto generatedAuthToken(String username){
        JwtAuthenticationDto jwtDto = new JwtAuthenticationDto();
        jwtDto.setToken(generateJwtToken(username));
        return jwtDto;
    }


    public String getUsernameFromToken(String token){
        Claims claims = Jwts.parser()
                .verifyWith(getSingInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }

    private String generateJwtToken(String username){
        Date date = Date.from(LocalDateTime.now().plusHours(1).atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .subject(username)
                .expiration(date)
                .signWith(getSingInKey())
                .compact();
    }





    private SecretKey getSingInKey(){
        byte[] keyBytes = Decoders.BASE64.decode(JWT_SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}






