package com.delivery.product.adapter.repository;

import com.delivery.product.adapter.repository.jpa.UserJpaRepository;
import com.delivery.product.core.domain.entity.User;
import com.delivery.product.core.port.out.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepository implements IUserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public void saveDefaultUser(User user) {
        Optional<User> existantUser = userJpaRepository.findByLogin(user.getLogin());

        existantUser.ifPresentOrElse(
                userDefault -> log.info("Default User {} already exist", userDefault.getLogin()),
                () -> userJpaRepository.save(user));
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return userJpaRepository.findByLogin(login);
    }

    @Override
    public User addUser(User user) {
        return userJpaRepository.save(user);
    }
}
