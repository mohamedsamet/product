package com.delivery.product.core.business.delivery;

import com.delivery.product.core.domain.data.delivery.DeliveryRequest;
import com.delivery.product.core.port.in.delivery.IDeliveryProcessingService;
import com.delivery.product.core.port.in.delivery.IDeliveryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class DeliveryService implements IDeliveryService {

    private final IDeliveryProcessingService deliveryProcessingService;
    private final DeliveryQueueManager deliveryQueueManager;

    @Override
    public void process(DeliveryRequest deliveryRequest) {
        try {
            deliveryQueueManager.getDeliveryWriteQueue().offer(deliveryRequest, 30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            log.error("Interruption Exception When trying to add Delivery Request To The queue", exception);
        }
    }

    @Scheduled(fixedRate = 50)
    public void processQueue() {
        while (!deliveryQueueManager.getDeliveryWriteQueue().isEmpty()) {
            try {
                DeliveryRequest request = deliveryQueueManager.getDeliveryWriteQueue().poll();
                if (request != null) {
                    deliveryProcessingService.processRequestDelivery(request);
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                log.error("Interruption Exception When trying to Process Delivery Request ", e);
            }
        }
    }
}
