package com.delivery.product.core.business.product;

import com.delivery.product.application.exception.ConflictException;
import com.delivery.product.application.exception.ResourceNotFoundException;
import com.delivery.product.core.business.utils.ProductMapper;
import com.delivery.product.core.domain.data.product.ProductRequest;
import com.delivery.product.core.domain.data.product.ProductResponse;
import com.delivery.product.core.domain.entity.product.Product;
import com.delivery.product.core.port.in.product.IProductService;
import com.delivery.product.core.port.out.product.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    @Override
    public ProductResponse getProduct(UUID productPublicId) {
        Product product = productRepository.findByPublicId(productPublicId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        return ProductMapper.toProductResponse(product);
    }

    @Override
    public ProductResponse saveProduct(ProductRequest productRequest) {
        productRepository.findByName(productRequest.getName()).ifPresent(product -> {
            throw new ConflictException("Product name already exist");
        });

        Product productSaved = productRepository.save(ProductMapper.toProduct(productRequest));
        return ProductMapper.toProductResponse(productSaved);
    }
}
