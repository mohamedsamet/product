package com.delivery.product.adapter.rest.controller.delivery;

import com.delivery.product.adapter.rest.port.delivery.IDeliveryController;
import com.delivery.product.core.domain.data.delivery.DeliveryRequest;
import com.delivery.product.core.port.in.delivery.IDeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeliveryController implements IDeliveryController {

    private final IDeliveryService deliveryService;

    @Override
    @PostMapping("/delivery")
    public ResponseEntity<Void> createDeliveryController(@RequestBody DeliveryRequest deliveryRequest) {
        deliveryService.process(deliveryRequest);
        return ResponseEntity.ok().build();
    }
}
