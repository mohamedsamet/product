package com.delivery.product.core.port.out;

import com.delivery.product.core.domain.entity.User;

import java.util.Optional;

public interface IUserRepository {

    void saveDefaultUser(User user);

    Optional<User> findByLogin(String login);

    User addUser(User user);

}
