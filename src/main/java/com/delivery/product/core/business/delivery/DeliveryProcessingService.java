package com.delivery.product.core.business.delivery;

import com.delivery.product.application.exception.ResourceNotFoundException;
import com.delivery.product.core.business.utils.DeliveryMapper;
import com.delivery.product.core.domain.data.delivery.DeliveryRequest;
import com.delivery.product.core.domain.entity.delivery.Delivery;
import com.delivery.product.core.port.in.delivery.IDeliveryOrder;
import com.delivery.product.core.port.in.delivery.IDeliveryProcessingService;
import com.delivery.product.core.port.out.delivery.IDeliveryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class DeliveryProcessingService implements IDeliveryProcessingService {

    private final IDeliveryRepository deliveryRepository;
    private final IDeliveryOrder deliveryOrder;

    @Override
    public void processRequestDelivery(DeliveryRequest deliveryRequest) {
        Delivery delivery = deliveryRepository.saveAll(Collections.singletonList(
                DeliveryMapper.toDeliveryParent(deliveryRequest)
        )).getFirst();

        List<Delivery> deliverieSlices = deliveryRequest.getProductDeliveryRequests().stream()
                .map(productRequest -> DeliveryMapper.toDeliverySlice(productRequest, delivery))
                .toList();

        deliveryRepository.saveAll(deliverieSlices);
    }

    @Override
    public void processDeliveryToOrders() {
        log.info(" Start Processing deliveries ");

        List<Delivery> deliveriesBatch = deliveryRepository.findAvailableDeliveries();

        if (!deliveriesBatch.isEmpty()) {
            deliveryOrder.order(deliveriesBatch);
        } else {
            log.info("No Pending deliveries found");

        }

    }
}
