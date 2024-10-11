package com.delivery.product.service.utils;

import org.springframework.security.crypto.password.PasswordEncoder;

public class FakeEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return "fake_pass";
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return false;
    }
}
