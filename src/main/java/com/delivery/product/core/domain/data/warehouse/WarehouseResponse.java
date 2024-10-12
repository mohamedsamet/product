package com.delivery.product.core.domain.data.warehouse;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class WarehouseResponse {

    private UUID publicId;

    private String location;

}
