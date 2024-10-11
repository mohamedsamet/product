package com.delivery.product.application.security.user;

import com.delivery.product.core.domain.data.UserRequest;
import com.delivery.product.core.port.in.user.IDefaultUserBuilder;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DefaultUserLoader {

    private final UserProperties userProperties;
    private final IDefaultUserBuilder userBuilder;

    @PostConstruct
    public void addDefaultUser() {
        userBuilder.buildDefaultUser(UserRequest.builder()
                .login(userProperties.getLogin())
                .password(userProperties.getPwd())
                .build());

    }
}
