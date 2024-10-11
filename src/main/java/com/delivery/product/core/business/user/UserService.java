package com.delivery.product.core.business.user;

import com.delivery.product.core.domain.data.UserRequest;
import com.delivery.product.core.domain.entity.User;
import com.delivery.product.core.port.in.user.IDefaultUserBuilder;
import com.delivery.product.core.port.out.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IDefaultUserBuilder {

    private final IUserRepository userRepository;

    @Override
    public void buildDefaultUser(UserRequest userRequest) {
        User user = User.builder()
                .login(userRequest.getLogin())
                .password(userRequest.getPassword())
                .build();

        userRepository.saveDefaultUser(user);
    }
}
