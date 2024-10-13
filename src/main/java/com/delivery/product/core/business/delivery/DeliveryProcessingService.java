package com.delivery.product.core.business.delivery;

import com.delivery.product.core.business.utils.DeliveryMapper;
import com.delivery.product.core.domain.data.delivery.DeliveryRequest;
import com.delivery.product.core.domain.entity.delivery.Delivery;
import com.delivery.product.core.port.in.delivery.IDeliveryProcessingService;
import com.delivery.product.core.port.out.delivery.IDeliveryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class DeliveryProcessingService implements IDeliveryProcessingService {

    private final IDeliveryRepository deliveryRepository;
    private final DeliveryQueueManager deliveryQueueManager;

    @Override
    public void processDelivery(DeliveryRequest deliveryRequest) {
        try {
            Delivery delivery = deliveryRepository.saveAll(Collections.singletonList(
                    DeliveryMapper.toDeliveryParent(deliveryRequest)
            )).getFirst();

            List<Delivery> deliverieSlices = deliveryRequest.getProductDeliveryRequests().stream()
                    .map(productRequest -> DeliveryMapper.toDeliverySlice(productRequest, delivery))
                    .toList();

            deliveryRepository.saveAll(deliverieSlices);
            deliveryQueueManager.getDeliveryReadQueue().offer(delivery.getPublicId(), 30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException exception) {
            log.error("Unable to offer the read queue");
        }

    }

    @Override
    public void processDeliveryToOrders(UUID deliveryPublicId) {
        log.info("process" + deliveryPublicId.toString());
    }
}
