package com.delivery.product.core.domain.data.product;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class ProductRequest {

    @NonNull
    private String name;

    @NonNull
    private ProductCategory category;

}
