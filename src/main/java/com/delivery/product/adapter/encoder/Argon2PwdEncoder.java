package com.delivery.product.adapter.encoder;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Argon2PwdEncoder implements IPwdEncoder {

    @Override
    public PasswordEncoder getEncoder() {
        int iterations = 2;
        int memory = 16384;
        int parallelism = 1;
        int hashLength = 32;
        int salt = 16;
        return new Argon2PasswordEncoder(salt, hashLength, parallelism, memory, iterations);
    }
}
