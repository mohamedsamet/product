package com.delivery.product.core.business.utils;

import com.delivery.product.core.domain.data.product.ProductRequest;
import com.delivery.product.core.domain.data.product.ProductResponse;
import com.delivery.product.core.domain.entity.product.Product;

import java.util.ArrayList;
import java.util.UUID;

public final class ProductMapper {

    public static ProductResponse toProductResponse(Product product) {
        return ProductResponse.builder()
                .productCategory(product.getCategory())
                .name(product.getName())
                .publicId(product.getPublicId())
                .build();
    }

    public static Product toProduct(ProductRequest product) {
        return Product.builder()
                .category(product.getCategory())
                .name(product.getName())
                .inventories(new ArrayList<>())
                .publicId(UUID.randomUUID())
                .build();
    }
}
