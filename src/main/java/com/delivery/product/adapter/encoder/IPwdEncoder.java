package com.delivery.product.adapter.encoder;

import org.springframework.security.crypto.password.PasswordEncoder;

public interface IPwdEncoder {

    PasswordEncoder getEncoder();

}
