package com.delivery.product.adapter.rest.port.warehouse;

import com.delivery.product.core.domain.data.warehouse.WarehouseRequest;
import com.delivery.product.core.domain.data.warehouse.WarehouseResponse;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface IWarehouseController {

    ResponseEntity<WarehouseResponse> saveWarehouse(WarehouseRequest warehouseRequest);

    ResponseEntity<WarehouseResponse> getWarehouse(UUID warehousePublicId);
}
