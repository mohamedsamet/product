package com.delivery.product.adapter.rest.auth;

import com.delivery.product.core.domain.data.LoginRequest;
import com.delivery.product.core.domain.data.LoginResponse;

public interface IAuthController {

    LoginResponse login(LoginRequest loginRequest);

}
