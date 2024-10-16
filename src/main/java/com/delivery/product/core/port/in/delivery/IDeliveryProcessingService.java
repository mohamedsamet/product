package com.delivery.product.core.port.in.delivery;

import com.delivery.product.core.domain.data.delivery.DeliveryRequest;

import java.util.UUID;

public interface IDeliveryProcessingService {

    void processRequestDelivery(DeliveryRequest deliveryRequest);
    void processDeliveryToOrders();
}
