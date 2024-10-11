package com.delivery.product.adapter.repository.jpa;

import com.delivery.product.core.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    @Override
    User save(User user);
}
