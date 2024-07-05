package com.proyecto.rest.backend.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtUtils {

    @Value("${security.jwt.key.private}")
    private String privateKey;

    @Value("${jwt.expirationMs}")
    private int jwtExpirationMs;

    //Para crear un Token
    public String createToken(UserDetails userDetails) {
        return JWT.create()
                .withSubject(userDetails.getUsername())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date((new Date()).getTime() + jwtExpirationMs))
                .withClaim("roles", userDetails.getAuthorities().stream()
                        .map(authority -> authority.getAuthority())
                        .collect(Collectors.toList()))
                .sign(Algorithm.HMAC256(privateKey));
    }

    public String getUserNameFromJwtToken(String token) {
        return JWT.require(Algorithm.HMAC256(privateKey)).build().verify(token).getSubject();
    }

    public boolean validateJwtToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256(privateKey)).build().verify(token);
            return true;
        } catch (JWTVerificationException e) {
            // Log the exception message
            return false;
        }
    }

}
