package com.delivery.product.core.port.out.product;

import com.delivery.product.core.domain.entity.product.Product;
import lombok.NonNull;

import java.util.Optional;
import java.util.UUID;

public interface IProductRepository {


    Optional<Product> findByName(@NonNull String name);

    Product save(Product product);

    Optional<Product> findByPublicId(UUID productPublicId);

}
