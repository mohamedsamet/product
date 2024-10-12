package com.delivery.product.core.port.out;

import com.delivery.product.core.domain.entity.warehouse.Warehouse;

import java.util.Optional;
import java.util.UUID;

public interface IWarehouseRepository {

    Warehouse save(Warehouse warehouse);

    Optional<Warehouse> findByPublicId(UUID warehousePublicId);
}