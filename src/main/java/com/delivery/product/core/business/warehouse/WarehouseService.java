package com.delivery.product.core.business.warehouse;

import com.delivery.product.application.exception.ResourceNotFoundException;
import com.delivery.product.core.business.utils.ProductMapper;
import com.delivery.product.core.business.utils.WarehouseMapper;
import com.delivery.product.core.domain.data.warehouse.WarehouseRequest;
import com.delivery.product.core.domain.data.warehouse.WarehouseResponse;
import com.delivery.product.core.domain.entity.product.Product;
import com.delivery.product.core.domain.entity.warehouse.Warehouse;
import com.delivery.product.core.port.in.warehouse.IWarehouseService;
import com.delivery.product.core.port.out.IWarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WarehouseService implements IWarehouseService {

    private final IWarehouseRepository warehouseRepository;

    @Override
    @Transactional
    public WarehouseResponse saveWarehouse(WarehouseRequest warehouseRequest) {
        Warehouse warehouseSaved = warehouseRepository.save(WarehouseMapper.toWarehouse(warehouseRequest));
        return WarehouseMapper.toWarehouseResponse(warehouseSaved);
    }

    @Override
    public WarehouseResponse getWarehouseByPublicId(UUID warehousePublicId) {
        Warehouse warehouse = warehouseRepository.findByPublicId(warehousePublicId)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse not found"));

        return WarehouseMapper.toWarehouseResponse(warehouse);
    }
}
