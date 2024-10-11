package com.delivery.product.core.business.user;

import com.delivery.product.adapter.encoder.IPwdEncoder;
import com.delivery.product.application.exception.ConflictException;
import com.delivery.product.application.exception.ResourceNotFoundException;
import com.delivery.product.application.security.user.UserPrinciple;
import com.delivery.product.core.domain.data.UserRequest;
import com.delivery.product.core.domain.entity.User;
import com.delivery.product.core.port.in.user.IDefaultUserBuilder;
import com.delivery.product.core.port.in.user.IUserFactory;
import com.delivery.product.core.port.in.user.IUserLoader;
import com.delivery.product.core.port.out.IUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IDefaultUserBuilder, IUserLoader, IUserFactory {

    private final IUserRepository userRepository;
    private final IPwdEncoder encoder;

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

    @Override
    @Transactional
    public UserPrinciple addUser(UserRequest userRequest) {
        Optional<User> existingUser = userRepository.findByLogin(userRequest.getLogin());

        existingUser.ifPresent(user -> {
            throw new ConflictException(String.format("User With Name %s Already Exist", userRequest.getLogin()));
        });

        User newUser = User.builder()
                .login(userRequest.getLogin())
                .password(encoder.getEncoder().encode(userRequest.getPassword()))
                .build();
        User createdUser = userRepository.addUser(newUser);

        return UserPrinciple.builder()
                .userPublicId(createdUser.getPublicId().toString())
                .login(createdUser.getLogin())
                .build();
    }

    @Override
    @Transactional
    public UserPrinciple updateUser(UserRequest userRequest) {
        Optional<User> existingUser = userRepository.findByLogin(userRequest.getLogin());

        if (existingUser.isPresent()) {
            existingUser.get().setPassword(encoder.getEncoder().encode(userRequest.getPassword()));

            return UserPrinciple.builder()
                    .userPublicId(existingUser.get().getPublicId().toString())
                    .login(existingUser.get().getLogin())
                    .build();
        }

        throw new ResourceNotFoundException(String.format("User %s Not Found", userRequest.getLogin()));

    }
}
