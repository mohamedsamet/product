package com.delivery.product.application.security.user;

import com.delivery.product.core.domain.entity.User;
import com.delivery.product.core.port.in.user.IUserLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final IUserLoader userLoader;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userLoader.getUser(username)
                .orElseThrow();

        return UserPrinciple.builder()
                .login(username)
                .password(user.getPassword())
                .userPublicId(user.getPublicId().toString())
                .build();
    }
}
