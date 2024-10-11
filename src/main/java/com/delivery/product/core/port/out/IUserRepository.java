package com.delivery.product.core.port.out;

import com.delivery.product.core.domain.entity.User;

public interface IUserRepository {

    void saveDefaultUser(User user);

}
