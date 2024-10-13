package com.delivery.product.core.business.delivery;

import com.delivery.product.core.domain.data.delivery.DeliveryRequest;
import com.delivery.product.core.port.in.delivery.IDeliveryProcessingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class DeliveryWriteScheduler {

    private final IDeliveryProcessingService deliveryProcessingService;
    private final DeliveryQueueManager deliveryQueueManager;

    @Value("${app.delivery.polling.timeout}")
    private int pollingTimeout;

    @Scheduled(fixedRateString = "${app.delivery.read.rate}")
    public void processQueue() {
        while (!deliveryQueueManager.getDeliveryWriteQueue().isEmpty()) {
            try {
                DeliveryRequest request = deliveryQueueManager.getDeliveryWriteQueue().poll(pollingTimeout, TimeUnit.MILLISECONDS);
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
