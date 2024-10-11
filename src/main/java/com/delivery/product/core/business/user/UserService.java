package com.delivery.product.core.business.user;

import com.delivery.product.core.domain.data.UserRequest;
import com.delivery.product.core.domain.entity.User;
import com.delivery.product.core.port.in.user.IDefaultUserBuilder;
import com.delivery.product.core.port.in.user.IUserLoader;
import com.delivery.product.core.port.out.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IDefaultUserBuilder, IUserLoader {

    private final IUserRepository userRepository;

    @Override
    public void buildDefaultUser(UserRequest userRequest) {
        User user = User.builder()
                .login(userRequest.getLogin())
                .password(userRequest.getPassword())
                .build();

        userRepository.saveDefaultUser(user);
    }


    @Override
    public Optional<User> getUser(String login) {
        return userRepository.findByLogin(login);
    }
}
