package com.delivery.product.core.port.in.user;

import com.delivery.product.core.domain.entity.User;

import java.util.Optional;

public interface IUserLoader {

    Optional<User> getUser(String login);

}
