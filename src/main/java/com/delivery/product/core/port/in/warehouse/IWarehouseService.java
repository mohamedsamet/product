package com.delivery.product.core.port.in.warehouse;

import com.delivery.product.core.domain.data.warehouse.WarehouseRequest;
import com.delivery.product.core.domain.data.warehouse.WarehouseResponse;

import java.util.UUID;

public interface IWarehouseService {

    WarehouseResponse saveWarehouse(WarehouseRequest warehouseRequest);

    WarehouseResponse getWarehouseByPublicId(UUID warehousePublicId);
}
