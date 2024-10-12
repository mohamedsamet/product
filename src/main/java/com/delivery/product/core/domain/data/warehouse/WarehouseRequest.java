package com.delivery.product.core.domain.data.warehouse;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class WarehouseRequest {

    @NonNull
    private String location;

}
