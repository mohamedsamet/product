package com.delivery.product.adapter.rest.port.delivery;

import com.delivery.product.core.domain.data.delivery.DeliveryRequest;
import org.springframework.http.ResponseEntity;

public interface IDeliveryController {

    ResponseEntity<Void> createDeliveryController(DeliveryRequest deliveryRequest);
}
