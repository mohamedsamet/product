package com.delivery.product.application.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@RequiredArgsConstructor
@Component
public class JwtIssuer {

    private final JwtProperties jwtProperties;

    public String issue(String login, String password) {
        return JWT.create()
                .withSubject(login)
                .withClaim("pass", password)
                .withExpiresAt(Instant.now().plusSeconds(jwtProperties.getExpiration()))
                .sign(Algorithm.HMAC512(jwtProperties.getSecret()));
    }
}
