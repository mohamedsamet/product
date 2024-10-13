package com.delivery.product.adapter.rest.controller.warehouse;

import com.delivery.product.adapter.rest.port.warehouse.IWarehouseController;
import com.delivery.product.core.domain.data.warehouse.WarehouseRequest;
import com.delivery.product.core.domain.data.warehouse.WarehouseResponse;
import com.delivery.product.core.port.in.warehouse.IWarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class WarehouseController implements IWarehouseController {

    private final IWarehouseService warehouseService;

    @Override
    @PostMapping("/warehouse")
    public ResponseEntity<WarehouseResponse> saveWarehouse(@RequestBody WarehouseRequest warehouseRequest) {
        return ResponseEntity.ok(warehouseService.saveWarehouse(warehouseRequest));
    }

    @Override
    @GetMapping("/warehouse/{warehousePublicId}")
    public ResponseEntity<WarehouseResponse> getWarehouse(@PathVariable("warehousePublicId") UUID warehousePublicId) {
        return ResponseEntity.ok(warehouseService.getWarehouseByPublicId(warehousePublicId));
    }
}
