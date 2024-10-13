package com.delivery.product.core.port.in.delivery;

import com.delivery.product.core.domain.data.delivery.DeliveryRequest;

public interface IDeliveryService {

    void process(DeliveryRequest deliveryRequest);
}
