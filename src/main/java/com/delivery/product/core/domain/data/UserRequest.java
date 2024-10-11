package com.delivery.product.core.domain.data;

import com.delivery.product.adapter.validation.ValidPassword;
import io.micrometer.common.lang.NonNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRequest {

    @NonNull
    private String login;

    @NonNull
    @ValidPassword
    private String password;
}
