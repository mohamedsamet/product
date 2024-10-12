package com.delivery.product.core.business.utils;

import com.delivery.product.core.domain.data.warehouse.WarehouseRequest;
import com.delivery.product.core.domain.data.warehouse.WarehouseResponse;
import com.delivery.product.core.domain.entity.warehouse.Warehouse;

import java.util.ArrayList;

public final class WarehouseMapper {

    public static WarehouseResponse toWarehouseResponse(Warehouse warehouse) {
        return WarehouseResponse.builder()
                .location(warehouse.getLocation())
                .publicId(warehouse.getPublicId())
                .build();
    }

    public static Warehouse toWarehouse(WarehouseRequest warehouseRequest) {
        return Warehouse.builder()
                .location(warehouseRequest.getLocation())
                .inventories(new ArrayList<>())
                .build();
    }
}
