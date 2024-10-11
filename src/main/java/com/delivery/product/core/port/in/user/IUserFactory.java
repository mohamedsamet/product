package com.delivery.product.core.port.in.user;

import com.delivery.product.application.security.user.UserPrinciple;
import com.delivery.product.core.domain.data.UserRequest;
import com.delivery.product.core.domain.entity.User;

import java.util.Optional;

public interface IUserFactory {

    UserPrinciple addUser(UserRequest userRequest);
    UserPrinciple updateUser(UserRequest userRequest);
}
