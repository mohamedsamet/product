package com.delivery.product.core.domain.data.product;

import lombok.*;

import java.util.UUID;

@Builder
@Data
public class ProductResponse {

    private UUID publicId;

    private String name;

    private ProductCategory productCategory;

}
