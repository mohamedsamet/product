package com.delivery.product.adapter.repository.jpa;

import com.delivery.product.core.domain.entity.warehouse.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WarehouseJpaRepository extends JpaRepository<Warehouse, Long> {

    Optional<Warehouse> findByPublicId(UUID publicId);
}
