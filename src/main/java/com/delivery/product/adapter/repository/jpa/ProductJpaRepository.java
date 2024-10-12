package com.delivery.product.adapter.repository.jpa;

import com.delivery.product.core.domain.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);
    Optional<Product> findByPublicId(UUID publicId);
}
