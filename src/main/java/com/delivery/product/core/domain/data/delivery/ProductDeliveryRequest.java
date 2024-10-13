package com.delivery.product.core.domain.data.delivery;

import lombok.Value;

import java.util.UUID;

@Value
public class ProductDeliveryRequest {

    UUID productPublicId;

    Float quantity;
}
