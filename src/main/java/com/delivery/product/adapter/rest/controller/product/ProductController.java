package com.delivery.product.adapter.rest.controller.product;

import com.delivery.product.adapter.rest.port.product.IProductController;
import com.delivery.product.core.domain.data.product.ProductRequest;
import com.delivery.product.core.domain.data.product.ProductResponse;
import com.delivery.product.core.port.in.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class ProductController implements IProductController {

    private final IProductService productService;

    @Override
    @GetMapping("/product/{productPublicId}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("productPublicId") UUID productPublicId) {
        return ResponseEntity.ok(productService.getProduct(productPublicId));
    }

    @Override
    @PostMapping("/product")
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productService.saveProduct(productRequest));
    }
}
