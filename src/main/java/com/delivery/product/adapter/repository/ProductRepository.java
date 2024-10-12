package com.delivery.product.adapter.repository;

import com.delivery.product.adapter.repository.jpa.ProductJpaRepository;
import com.delivery.product.core.domain.data.product.ProductResponse;
import com.delivery.product.core.domain.entity.product.Product;
import com.delivery.product.core.port.out.product.IProductRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ProductRepository implements IProductRepository {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public Optional<Product> findByName(@NonNull String name) {
        return productJpaRepository.findByName(name);
    }

    @Override
    public Product save(Product product) {
        return productJpaRepository.save(product);
    }

    @Override
    public Optional<Product> findByPublicId(UUID productPublicId) {
        return productJpaRepository.findByPublicId(productPublicId);
    }
}
