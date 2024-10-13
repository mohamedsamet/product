package com.delivery.product.core.business.delivery;

import com.delivery.product.core.port.in.delivery.IDeliveryProcessingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class DeliveryReadScheduler {

    private final IDeliveryProcessingService deliveryProcessingService;
    private final DeliveryQueueManager deliveryQueueManager;

    @Scheduled(fixedRate = 50)
    public void processQueue() {
        while (!deliveryQueueManager.getDeliveryReadQueue().isEmpty()) {
            try {
                UUID request = deliveryQueueManager.getDeliveryReadQueue().poll(20000, TimeUnit.MILLISECONDS);
                if (request != null) {
                    deliveryProcessingService.processDeliveryToOrders(request);
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                log.error("Interruption Exception When trying to Process Delivery Request ", e);
            }
        }
    }
}
