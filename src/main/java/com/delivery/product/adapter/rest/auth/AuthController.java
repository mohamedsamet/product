package com.delivery.product.adapter.rest.auth;

import com.delivery.product.application.security.jwt.JwtIssuer;
import com.delivery.product.application.security.user.UserPrinciple;
import com.delivery.product.core.domain.data.LoginRequest;
import com.delivery.product.core.domain.data.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController implements IAuthController {

    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authManager;

    @Override
    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getLogin(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserPrinciple principle = (UserPrinciple) authentication.getPrincipal();

        String token = jwtIssuer.issue(principle.getLogin(), principle.getPassword());
        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }
}
