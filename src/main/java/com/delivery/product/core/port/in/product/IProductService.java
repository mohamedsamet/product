package com.delivery.product.core.port.in.product;


import com.delivery.product.core.domain.data.product.ProductRequest;
import com.delivery.product.core.domain.data.product.ProductResponse;

import java.util.UUID;

public interface IProductService {

    ProductResponse getProduct(UUID productPublicId);

    ProductResponse saveProduct(ProductRequest productRequest);
}
