package com.delivery.product.core.domain.data.delivery;

import lombok.Getter;
import lombok.Value;

import java.util.List;

@Getter
@Value
public class DeliveryRequest {

    DeliveryCommandType commandType;
    DeliveryMethod method;

    List<ProductDeliveryRequest> productDeliveryRequests;

}
