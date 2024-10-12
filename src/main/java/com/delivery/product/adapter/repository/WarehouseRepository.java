package com.delivery.product.adapter.repository;

import com.delivery.product.adapter.repository.jpa.ProductJpaRepository;
import com.delivery.product.adapter.repository.jpa.WarehouseJpaRepository;
import com.delivery.product.core.domain.entity.product.Product;
import com.delivery.product.core.domain.entity.warehouse.Warehouse;
import com.delivery.product.core.port.out.IWarehouseRepository;
import com.delivery.product.core.port.out.product.IProductRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class WarehouseRepository implements IWarehouseRepository {

    private final WarehouseJpaRepository warehouseJpaRepository;

    @Override
    public Warehouse save(Warehouse warehouse) {
        return warehouseJpaRepository.save(warehouse);
    }

    @Override
    public Optional<Warehouse> findByPublicId(UUID warehousePublicId) {
        return warehouseJpaRepository.findByPublicId(warehousePublicId);
    }
}
