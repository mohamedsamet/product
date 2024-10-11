package com.delivery.product.core.port.in.user;

import com.delivery.product.core.domain.data.UserRequest;

public interface IDefaultUserBuilder {

    void buildDefaultUser(UserRequest userRequest);

}
