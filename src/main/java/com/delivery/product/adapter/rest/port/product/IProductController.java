package com.delivery.product.adapter.rest.port.product;

import com.delivery.product.core.domain.data.product.ProductRequest;
import com.delivery.product.core.domain.data.product.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public interface IProductController {

    ResponseEntity<ProductResponse> getProduct(UUID productPublicId);

    ResponseEntity<ProductResponse> saveProduct(ProductRequest productRequest);
}
